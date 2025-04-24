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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COMPHP
 */
public class ProductoDAO {

    public void crearProducto(Producto producto) throws SQLException {
        String sql = """
        INSERT INTO Producto (
            nombre_producto, 
            precio_costo, 
            precio_venta
        ) VALUES (?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_producto());
            stmt.setFloat(2, producto.getPrecio_costo());
            stmt.setFloat(3, producto.getPrecio_venta());
            stmt.executeUpdate();
        }
    }

    public List<Producto> leerTodosProductos() throws SQLException {
        String sql = "SELECT * FROM Producto";
        List<Producto> productos = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setPrecio_costo(rs.getFloat("precio_costo"));
                producto.setPrecio_venta(rs.getFloat("id_categoria"));
                productos.add(producto);
            }
        }
        return productos;
    }
// ProductoDAO
// Métodos para Actualizar y Eliminar
// Método para actualizar un producto

    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET nombre_producto = ?, precio_costo = ?, precio_venta = ? WHERE id_producto = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre_producto());
            stmt.setFloat(2, producto.getPrecio_costo());
            stmt.setFloat(3, producto.getPrecio_venta());
            stmt.setInt(4, producto.getId_producto());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un producto
    public void eliminarProducto(int idProducto) throws SQLException {
        String sql = "DELETE FROM Producto WHERE id_producto = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
        }
    }

// Método Main
    public static void main(String[] args) {
        try {
            ProductoDAO dao = new ProductoDAO();

            // Actualizar un producto
            Producto producto = new Producto();
            producto.setId_producto(1); // ID existente
            producto.setNombre_producto("Hamburguesa Actualizada");
            producto.setPrecio_costo(30);
            producto.setPrecio_venta(90);
            dao.actualizarProducto(producto);
            System.out.println("Producto actualizado.");

            // Leer y mostrar todos los productos para verificar
            List<Producto> productos = dao.leerTodosProductos();
            System.out.println("Lista de productos:");
            for (Producto prod : productos) {
                System.out.println("ID: " + prod.getId_producto()
                        + ", Nombre: " + prod.getNombre_producto()
                        + ", Descripción: " + prod.getPrecio_costo()
                        + ", Categoría ID: " + prod.getPrecio_venta());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
