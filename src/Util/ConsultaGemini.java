/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import okhttp3.*;
import org.json.JSONObject;

/**
 *
 * @author yuri guevara
 */
public class ConsultaGemini {
    
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";
    private static final String API_KEY = "AIzaSyBMS6M8DMFmdCN2G7Ih4jgk5bbFsEH98mc"; // Reemplaza con tu clave de API de Gemini
    
    public String generarConsultaSQL(String consultaNatural, String esquemaBD) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String prompt = """
            Genera una consulta SQL válida para una base de datos MySQL con las siguientes tablas y relaciones:
            %s
            Instrucciones:
            - Usa solo las columnas listadas en cada tabla.
            - Respeta el orden de los atributos de cada tabla según el esquemade la base de datos.
            - Asegúrate de que los JOINs sean correctos y utilicen las claves foráneas especificadas.
            - Si se solicita información de múltiples tablas, usa JOINs explícitos.
            - No generes subconsultas complejas ni funciones avanzadas a menos que sean explícitamente solicitadas.
            - Devuelve la consulta SQL en una sola línea, sin saltos de línea, comillas triples, ni formato adicional.
            Pregunta del usuario: "%s"
            """.formatted(esquemaBD, consultaNatural);

        JSONObject json = new JSONObject();
        json.put("contents", new JSONObject().put("parts", new JSONObject().put("text", prompt)));
        json.put("generationConfig", new JSONObject().put("response_mime_type", "text/plain"));

        RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(API_URL + "?key=" + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Error en la solicitud a Gemini: " + response.code());
            }
            String respuesta = response.body().string();
            return new JSONObject(respuesta).getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
        }
    }
    
    public String obtenerEsquemaBD() {
        return """
            Tabla: Insumo (
            id_insumo INT AUTO_INCREMENT PRIMARY KEY,
            nombre_insumo VARCHAR(50),
            precio_insumo FLOAT
            )
            Tabla:  Detalle_Insumo (
            id_detalle_insumo INT AUTO_INCREMENT PRIMARY KEY,
            id_insumo INT,
            id_producto INT,
            cantidad_insumo DECIMAL (10,2)
            )
            Tabla: Cliente (
            idCliente INT AUTO_INCREMENT PRIMARY KEY,
            nombre_1 VARCHAR(50),
            apellido_1 VARCHAR(50),
            direccion_cliente VARCHAR(50),
            telefono_cliente VARCHAR(15)
            )
            Tabla: Categoria (
            id_categoria INT AUTO_INCREMENT PRIMARY KEY,
            nombre_categoria VARCHAR(50)
            )
            Tabla: Producto (
            id_producto INT AUTO_INCREMENT PRIMARY KEY,
            id_categoria INT,
            nombre_producto VARCHAR(50),
            precio_costo FLOAT,
            precio_venta FLOAT,
            existencia INT
            )
            Tabla: Orden (
            idOrden INT AUTO_INCREMENT PRIMARY KEY,
            id_cuenta INT,
            fecha_orden DATETIME
            ) 
            Tabla: Detalle_Orden (
            id_detalle_orden INT AUTO_INCREMENT PRIMARY KEY,
            idOrden INT,
            id_producto INT,
            fecha_orden DATETIME,
            estado_orden VARCHAR(50)
            )
            Tabla: Cuenta (
            id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
            idOrden INT,
            idCliente INT,
            fecha_cuenta DATETIME,
            total_cuenta FLOAT,
            estado_cuenta VARCHAR (15)
            )
            Relaciones:
            - Detalle_Insumo.id_insumo -> Insumo.id_insumo
            - Detalle_Insumo.id_producto -> Producto.id_producto
            - Detalle_orden.id_producto -> Producto.id_producto
            - Detalle_orden.idOrden -> Orden.idOrden
            - Cuenta.idCliente -> Cliente.idCliente
            - Orden.id_cuenta -> Cuenta.id_cuenta
            - Producto.id_categoria -> Categoria.id_categoria
            """;    
    }                      
    
     // Validación de consultas SQL
    public boolean esConsultaSegura(String sql) {
        String consulta = sql.toLowerCase().trim();
        return consulta.startsWith("select") &&
               !consulta.contains("drop") &&
               !consulta.contains("update") &&
               !consulta.contains("insert");
    }
    
}
