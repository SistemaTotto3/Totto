/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ProductoDAO;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class ProductoControlador {

    private final ProductoDAO productoDAO;

    public ProductoControlador() {
        this.productoDAO = new ProductoDAO();
    }

    // Método para crear un nuevo producto
    public void crearProducto(String nombre_producto, float precio_costo, float precio_venta,int existencia) {
        try {
            Producto producto = new Producto();
            producto.setNombre_producto(nombre_producto);
            producto.setPrecio_costo(precio_costo);
            producto.setPrecio_venta(precio_venta);
            producto.setExistencia(existencia);
            productoDAO.crearProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosProductos() {
        try {
            return productoDAO.leerTodosProductos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(int id_producto, String nombre_producto, float precio_costo, float precio_venta, int existencia) {
        try {
            Producto producto = new Producto();
            producto.setId_producto(id_producto);
            producto.setNombre_producto(nombre_producto);
            producto.setPrecio_costo(precio_costo);
            producto.setPrecio_venta(precio_venta);
             producto.setExistencia(existencia);
            productoDAO.actualizarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(int id_producto) {
        try {
            productoDAO.eliminarProducto(id_producto);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        ProductoControlador controlador = new ProductoControlador();

        // Crear un producto
        controlador.crearProducto("Hamburguesas",200, 1500,2);

        // Leer todos los productos
        List<Producto> productos = controlador.obtenerTodosProductos();
        if (productos != null) {
            System.out.println("Lista de productos:");
            for (Producto p : productos) {
                System.out.println("ID: " + p.getId_producto()
                        + ", nombre_producto: " + p.getNombre_producto()
                        + ", precio_costo: " + p.getPrecio_costo()+ ", precio_venta:"+ p.getPrecio_venta()+ "existencia:"+p.getExistencia());
            }
        }

        // Actualizar un producto (suponiendo que ID 1 existe)
        controlador.actualizarProducto(1, "Hamburguesas simple", 250, 500,7);

        // Eliminar un producto
        controlador.eliminarProducto(1);
    }
}
