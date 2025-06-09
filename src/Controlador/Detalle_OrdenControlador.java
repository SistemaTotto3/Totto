/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.Detalle_OrdenDAO;
import Modelo.Detalle_Orden;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void crearDetalleOrden(int idOrden, int id_producto,String estado_orden, int cantidad) {
        try {
            Detalle_Orden detalle = new Detalle_Orden();
            detalle.setIdOrden(idOrden);
            detalle.setId_producto(id_producto);
            detalle.setEstado_orden(estado_orden);
            detalle.setCantidad(cantidad);
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
    public void actualizarDetalleOrden(int idDetalleOrden, int idOrden, int id_producto, String estado_orden, int cantidad) {
        try {
            Detalle_Orden detalle = new Detalle_Orden();
            detalle.setId_detalle_orden(idDetalleOrden);
            detalle.setIdOrden(idOrden);
            detalle.setId_producto(id_producto);
            detalle.setEstado_orden(estado_orden);
            detalle.setCantidad(cantidad);
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

 
}
