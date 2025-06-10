/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.InsumoDAO;
import DAO.Detalle_InsumoDAO;
import Modelo.Detalle_Insumo;
import Modelo.Insumo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author HP 17-CN0
 */
public class InsumoControlador {

    private final InsumoDAO insumoDAO;

    public InsumoControlador() {
        this.insumoDAO = new InsumoDAO();
    }

    // Método para crear un nuevo insumo
    public void crearInsumo(Date fecha_insumo, float total_insumo,  List<Detalle_Insumo> detalles) {
        try {
            Insumo insumo = new Insumo();
            insumo.setFecha_insumo(fecha_insumo);
            insumo.setTotal_insumo(total_insumo);
            insumoDAO.crearInsumo(insumo);
            JOptionPane.showMessageDialog(null, "Insumo creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los insumos
    public List<Insumo> obtenerTodosInsumos() {
        try {
            return insumoDAO.leerTodosInsumos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los insumos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un insumo existente
    public void actualizarInsumo(int id_insumo, Date fecha_insumo, float total_insumo) {
        try {
            Insumo insumo = new Insumo();
            insumo.setId_insumo(id_insumo);
            insumo.setFecha_insumo(fecha_insumo);
            insumo.setTotal_insumo(total_insumo);
            insumoDAO.actualizarInsumo(insumo);
            JOptionPane.showMessageDialog(null, "Insumo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un insumo
    public void eliminarInsumo(int idInsumo) {
        try {
            insumoDAO.eliminarInsumo(idInsumo);
            JOptionPane.showMessageDialog(null, "Insumo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el insumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        InsumoControlador controlador = new InsumoControlador();

        // Leer todos los insumos
        List<Insumo> insumos = controlador.obtenerTodosInsumos();
        if (insumos != null) {
            System.out.println("Lista de insumos:");
            for (Insumo i : insumos) {
                System.out.println("ID: " + i.getId_insumo()
                        + ", Fecha: " + i.getFecha_insumo()
                        + ", Precio: " + i.getTotal_insumo());
            }
        }

        // Eliminar un insumo
        controlador.eliminarInsumo(1);
    }
}
