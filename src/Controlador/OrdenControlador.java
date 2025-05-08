/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.OrdenDAO;
import Modelo.Orden;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class OrdenControlador {

       private final OrdenDAO ordenDAO;

    public OrdenControlador() {
        this.ordenDAO = new OrdenDAO();
    }

    // Método para crear una nueva orden
    public void crearOrden(int id_cuenta, LocalDateTime fecha_orden) {
        try {
            Orden orden = new Orden();
            orden.setId_cuenta(id_cuenta);
            orden.getFecha_orden();
            ordenDAO.crearOrden(orden);
            JOptionPane.showMessageDialog(null, "Orden creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las órdenes
    public List<Orden> obtenerTodasOrdenes() {
        try {
            return ordenDAO.obtenerOrdenes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las órdenes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar una orden existente
    public void actualizarOrden(int idOrden, int id_cuenta, LocalDateTime fecha_orden) {
        try {
            Orden orden = new Orden();
            orden.setIdOrden(idOrden);
            orden.setId_cuenta(id_cuenta);
            orden.getFecha_orden();
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

    // Método main para pruebas
    public static void main(String[] args) {
        OrdenControlador controlador = new OrdenControlador();

        // Crear una orden
        controlador.crearOrden(1, LocalDateTime.of(2025, 4, 29, 10, 0));

        // Leer todas las órdenes
        List<Orden> ordenes = controlador.obtenerTodasOrdenes();
        if (ordenes != null) {
            System.out.println("Lista de órdenes:");
            for (Orden o : ordenes) {
                System.out.println("ID Orden: " + o.getIdOrden()
                        + ", ID Cuenta: " + o.getId_cuenta()
                        + ", Fecha Orden: " + o.getFecha_orden());
            }
        }

        // Actualizar una orden (suponiendo que ID 1 existe)
        controlador.actualizarOrden(1, 2, LocalDateTime.of(2025, 5, 1, 12, 0));

        // Eliminar una orden
        controlador.eliminarOrden(1);
    }
}
