/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.Detalle_OrdenDAO;
import Modelo.Detalle_Orden;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class Detalle_OrdenControlador {

    private final Detalle_OrdenDAO detalleOrdenDAO;

    public Detalle_OrdenControlador() {
        this.detalleOrdenDAO = new Detalle_OrdenDAO();
    }

    // Método para crear un nuevo Detalle de Orden
    public void crearDetalleOrden(int idOrden, int id_producto, LocalDateTime fechaOrden, String estadoOrden) {
        try {
            Detalle_Orden detalle = new Detalle_Orden();
            detalle.setIdOrden(idOrden);
            detalle.setId_producto(id_producto);
            detalle.setFecha_orden(fechaOrden);
            detalle.setEstado_orden(estadoOrden);
            detalleOrdenDAO.crearDetalleOrden(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de Orden creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los detalles de orden
    public List<Detalle_Orden> obtenerTodosDetalleOrden() {
        try {
            return detalleOrdenDAO.leerTodosDetalle_Orden();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un Detalle de Orden existente
    public void actualizarDetalleOrden(int idDetalleOrden, int idOrden, int id_producto, LocalDateTime fechaOrden, String estadoOrden) {
        try {
            Detalle_Orden detalle = new Detalle_Orden();
            detalle.setId_detalle_orden(idDetalleOrden);
            detalle.setIdOrden(idOrden);
            detalle.setId_producto(id_producto);
            detalle.setFecha_orden(fechaOrden);
            detalle.setEstado_orden(estadoOrden);
            detalleOrdenDAO.actualizarDetalleOrden(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de Orden actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un Detalle de Orden
    public void eliminarDetalleOrden(int idDetalleOrden) {
        try {
            detalleOrdenDAO.eliminarDetalleOrden(idDetalleOrden);
            JOptionPane.showMessageDialog(null, "Detalle de Orden eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        Detalle_OrdenControlador controlador = new Detalle_OrdenControlador();


        // Crear un detalle de orden
        controlador.crearDetalleOrden(1, 1, LocalDateTime.of(2025, 4, 29, 10, 0), "Entregado");

        // Leer todos los detalles de orden
        List<Detalle_Orden> detalles = controlador.obtenerTodosDetalleOrden();
        if (detalles != null) {
            System.out.println("Lista de detalles de orden:");
            for (Detalle_Orden d : detalles) {
                System.out.println("ID Detalle Orden: " + d.getId_detalle_orden()
                        + ", ID Orden: " + d.getIdOrden()
                        + ", ID Producto: " + d.getId_producto()
                        + ", Fecha Orden: " + d.getFecha_orden()
                        + ", Estado Orden: " + d.getEstado_orden());
            }
        }

        // Actualizar un detalle de orden (asumiendo que ID 1 existe)
        controlador.actualizarDetalleOrden(1, 1, 2, LocalDateTime.of(2025, 5, 1, 12, 0), "En preparación");

        // Eliminar un detalle de orden
        controlador.eliminarDetalleOrden(1);
    }
}
