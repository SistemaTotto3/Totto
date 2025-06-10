/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.Detalle_InsumoDAO;
import Modelo.Detalle_Insumo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 17-CN0
 */
public class Detalle_InsumoControlador {

    private final Detalle_InsumoDAO detalleInsumoDAO;

    public Detalle_InsumoControlador() {
        this.detalleInsumoDAO = new Detalle_InsumoDAO();
    }

    public void crearDetalleInsumo(int id_insumo, int id_producto,String nombre_insumo, float cantidad_insumo, float precio_insumo) {
        try {
            Detalle_Insumo detalle = new Detalle_Insumo();
            detalle.setId_insumo(id_insumo);
            detalle.setId_producto(id_producto);
            detalle.setNombre_insumo(nombre_insumo);
            detalle.setCantidad_insumo(cantidad_insumo);
            detalle.setPrecio_insumo(precio_insumo);
            detalleInsumoDAO.crearDetalleInsumo(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de Insumo creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Detalle_Insumo> obtenerTodosDetalleInsumo() {
        try {
            return detalleInsumoDAO.leerTodosDetalle_Insumo();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void actualizarDetalleInsumo(int id_detalle_insumo, int id_insumo, int id_producto, String nombre_insumo, float cantidad_insumo, float precio_insumo) {
        try {
            Detalle_Insumo detalle = new Detalle_Insumo();
            detalle.setId_detalle_insumo(id_detalle_insumo);
            detalle.setId_insumo(id_insumo);
            detalle.setId_producto(id_producto);
            detalle.setNombre_insumo(nombre_insumo);
            detalle.setCantidad_insumo(cantidad_insumo);
            detalle.setPrecio_insumo(precio_insumo);
            detalleInsumoDAO.actualizarDetalleInsumo(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de Insumo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarDetalleInsumo(int idDetalleInsumo) {
        try {
            detalleInsumoDAO.eliminarDetalleInsumo(idDetalleInsumo);
            JOptionPane.showMessageDialog(null, "Detalle de Insumo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Detalle_InsumoControlador controlador = new Detalle_InsumoControlador();

        try {
            // Crear un detalle de insumo
            controlador.crearDetalleInsumo(1, 1,"Tomate", 1.50f, 33.22f);

            // Leer todos los detalles de insumo
            List<Detalle_Insumo> detalles = controlador.obtenerTodosDetalleInsumo();
            if (detalles != null) {
                System.out.println("Lista de detalles de insumo:");
                for (Detalle_Insumo d : detalles) {
                    System.out.println("ID Detalle Insumo: " + d.getId_detalle_insumo()
                            + ", ID Insumo: " + d.getId_insumo()
                            + ", ID Producto: " + d.getId_producto()
                            + ", Nombre: "+ d.getNombre_insumo()
                            + ", Cantidad Insumo: " + d.getCantidad_insumo());
                }
            }

            // Actualizar un detalle de insumo
            controlador.actualizarDetalleInsumo(1, 1, 2,"Tomate", 2.50f, 35.50f);

            // Eliminar un detalle de insumo
            controlador.eliminarDetalleInsumo(1);
        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
