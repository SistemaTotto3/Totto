/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Detalle_Insumo;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author COMPHP
 */
public class Detalle_InsumoDAO {

    
    public void crearDetalleInsumo(Detalle_Insumo detalle) throws SQLException {
        String sql = """
        INSERT INTO  Detalle_Insumo (
            id_insumo, 
            id_producto,
            nombre_insumo,
            cantidad_insumo
            precio_insumo
        ) VALUES (?, ?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId_insumo());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setString(3, detalle.getNombre_insumo());
            stmt.setDouble(4, detalle.getCantidad_insumo());
            stmt.setFloat(5, detalle.getPrecio_insumo());
            stmt.executeUpdate();
        }
    }
   
    
    public List<Detalle_Insumo> leerTodosDetalle_Insumo() throws SQLException {
        String sql = "SELECT * FROM Detalle_Insumo ";
        List<Detalle_Insumo> detalles = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Detalle_Insumo detalle = new Detalle_Insumo();
                detalle.setId_detalle_insumo(rs.getInt("id_detalle_insumo"));
                detalle.setId_insumo(rs.getInt("id_insumo"));
                detalle.setId_producto(rs.getInt("id_producto"));
                detalle.setNombre_insumo(rs.getString("nombre_insumo"));
                detalle.setCantidad_insumo(rs.getFloat("cantidad_insumo"));
                detalle.setPrecio_insumo(rs.getFloat("precio_insumo"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }
    
    public void actualizarDetalleInsumo(Detalle_Insumo detalle) throws SQLException {
        String sql = "UPDATE Detalle_Insumo SET id_insumo = ?, id_producto = ?, cantidad_insumo = ? WHERE id_detalle_insumo = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId_insumo());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setString(3, detalle.getNombre_insumo());
            stmt.setDouble(4, detalle.getCantidad_insumo());
            stmt.setFloat(5, detalle.getPrecio_insumo());
            stmt.setInt(6, detalle.getId_detalle_insumo());
            stmt.executeUpdate();
        }
    }
    
    // Método para eliminar un cliente
    public void eliminarDetalleInsumo(int idDetalleInsumo) throws SQLException {
        String sql = "DELETE FROM Detalle_Insumo WHERE id_detalle_insumo = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalleInsumo);
            stmt.executeUpdate();
        }
    }
    
    // Método Main
    public static void main(String[] args) {
        try {
            Detalle_InsumoDAO dao = new Detalle_InsumoDAO();

            // Actualizar un cliente
            Detalle_Insumo detalle = new Detalle_Insumo();
            detalle.setId_detalle_insumo(1); // ID existente
            detalle.setId_insumo(2);
            detalle.setId_producto(3);
            detalle.setNombre_insumo("Tomate");
            detalle.setCantidad_insumo(5);
            detalle.setPrecio_insumo(200.0f);
            dao.actualizarDetalleInsumo(detalle);
            System.out.println("Detalle_Insumo actualizado.");

            // Leer y mostrar todos los clientes para verificar
            List<Detalle_Insumo> detalles = dao.leerTodosDetalle_Insumo();
            System.out.println("Lista de detalles_Insumo:");
            for (Detalle_Insumo det : detalles) {
                System.out.println("id_detalle_insumo: " + det.getId_detalle_insumo()
                        + ", id_insumo: " + det.getId_insumo()+ "id_producto " + det.getId_producto()
                        + ", nombre_insumo: " + det.getNombre_insumo()
                        +  " cantidad_insumo" + det.getCantidad_insumo()
                        + ", precio_insumo:" + det.getPrecio_insumo());

            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
