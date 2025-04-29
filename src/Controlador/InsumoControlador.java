/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.InsumoDAO;
import Modelo.Insumo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

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
    public void crearInsumo(String nombreInsumo, float precioInsumo) {
        try {
            Insumo insumo = new Insumo();
            insumo.setNombre_insumo(nombreInsumo);
            insumo.setPrecio_insumo(precioInsumo);
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
    public void actualizarInsumo(int idInsumo, String nombreInsumo, float precioInsumo) {
        try {
            Insumo insumo = new Insumo();
            insumo.setId_insumo(idInsumo);
            insumo.setNombre_insumo(nombreInsumo);
            insumo.setPrecio_insumo(precioInsumo);
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

        // Crear un insumo
        controlador.crearInsumo("Pan blanco", 0.55f);

        // Leer todos los insumos
        List<Insumo> insumos = controlador.obtenerTodosInsumos();
        if (insumos != null) {
            System.out.println("Lista de insumos:");
            for (Insumo i : insumos) {
                System.out.println("ID: " + i.getId_insumo()
                        + ", Nombre: " + i.getNombre_insumo()
                        + ", Precio: " + i.getPrecio_insumo());
            }
        }

        // Actualizar un insumo (suponiendo que ID 1 existe)
        controlador.actualizarInsumo(1, "Pan blanco", 0.60f);

        // Eliminar un insumo
        controlador.eliminarInsumo(1);
    }
}
