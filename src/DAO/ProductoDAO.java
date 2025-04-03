/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Producto;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author COMPHP
 */
public class ProductoDAO {
   public void crearProducto(Producto producto) throws SQLException {
    String sql = """
        INSERT INTO Productos (
            nombre_producto, 
            precio_costo, 
            precio_venta 
        ) VALUES (?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, producto.getNombre_producto());
        stmt.setFloat(2, producto.getPrecio_costo());
        stmt.setFloat(3, producto.getPrecio_venta());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        ProductoDAO dao = new ProductoDAO();
        Producto p1 = new Producto();
        p1.setNombre_producto("Hamburguesas");
        p1.setPrecio_costo(200);
        p1.setPrecio_venta(400);
        dao.crearProducto(p1);
        System.out.println("Producto creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } 
}
}
