/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CategoriaDAO;
import Modelo.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class CategoriaControlador {

    private final CategoriaDAO categoriaDAO;

    public CategoriaControlador() {
        this.categoriaDAO = new CategoriaDAO();

    }

// Método para crear una nueva categoría
    public void crearCategoria(String nombre_categoria) {
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre_categoria(nombre_categoria);
            categoriaDAO.crearCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Categoría creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las categorías
    public List<Categoria> obtenerTodasCategorias() {
        try {
            return categoriaDAO.leerTodasCategorias();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar una categoría existente
    public void actualizarCategoria(int id_categoria, String nombre_categoria) {
        try {
            Categoria categoria = new Categoria();
            categoria.setId_categoria(id_categoria);
            categoria.setNombre_categoria(nombre_categoria);
            categoriaDAO.actualizarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Categoría actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una categoría
    public void eliminarCategoria(int id) {
        try {
            categoriaDAO.eliminarCategoria(id);
            JOptionPane.showMessageDialog(null, "Categoría eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CategoriaControlador controlador = new CategoriaControlador();
        // Probar crear categoría
        controlador.crearCategoria("ExtraMAX");
        // Probar leer categorías
        List<Categoria> categorias = controlador.obtenerTodasCategorias();
        for (Categoria cat : categorias) {
            System.out.println("ID: " + cat.getId_categoria()+ ", Nombre: " + cat.getNombre_categoria());
        }
    }

}
