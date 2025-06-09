/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.Detalle_OrdenDAO;
import DAO.OrdenDAO;
import Modelo.Detalle_Orden;
import Modelo.Orden;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class OrdenControlador {
private final OrdenDAO ordenDAO;
    private final Detalle_OrdenDAO detalleOrdenDAO;

    public OrdenControlador() {
        this.ordenDAO = new OrdenDAO();
        this.detalleOrdenDAO = new Detalle_OrdenDAO();
    }

    // Método para crear una nueva orden
    public void crearOrden(Date fecha_orden, List<Detalle_Orden> detalles) {
        try {
            Orden orden = new Orden();
            orden.setFecha_orden(fecha_orden);
            int idOrden = ordenDAO.crearOrden(orden);
            
             if (idOrden == -1) {
                throw new SQLException("No se pudo obtener el ID de la orden.");
            }

            // Asignar el idOrden a cada detalle y guardarlos
            for (Detalle_Orden detalle : detalles) {
                detalle.setIdOrden(idOrden);
                detalleOrdenDAO.crearDetalleOrden(detalle);
            }
            JOptionPane.showMessageDialog(null, "Orden creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las órdenes
    public List<Orden> obtenerTodasOrdenes() {
        try {
            return ordenDAO.leerTodasOrdenes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las órdenes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    

    // Método para actualizar una orden existente
    public void actualizarOrden(int idOrden,Date fecha_orden) {
        try {
            Orden orden = new Orden();
            orden.setIdOrden(idOrden);
            orden.setFecha_orden(fecha_orden);
            ordenDAO.actualizarOrden(orden);
            JOptionPane.showMessageDialog(null, "Orden actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una orden
    public void eliminarOrden(int idOrden) {
        try {
            ordenDAO.eliminarOrden(idOrden);
            JOptionPane.showMessageDialog(null, "Orden eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
