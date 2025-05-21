/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Categoria;
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
public class CategoriaDAO {
     public void crearCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (nombre_categoria)VALUES (?)";
        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre_categoria());
            stmt.executeUpdate();
        }
    }

    // Método para leer todas las categorías
    public List<Categoria> leerTodasCategorias() throws SQLException {
        String sql = "SELECT * FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre_categoria(rs.getString("nombre_categoria"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    // Método para actualizar una categoría
    public void actualizarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categoria SET nombre_categoria = ? WHERE id_categoria = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre_categoria());
            stmt.setInt(2, categoria.getId_categoria());
            stmt.executeUpdate();
        }
    }

// Método para eliminar una categoría
    public void eliminarCategoria(int idCategoria) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE id_categoria = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            CategoriaDAO dao = new CategoriaDAO();

            // Actualizar una categoría
            Categoria categoria = new Categoria();
            categoria.setId_categoria(1); // ID existente
            categoria.setNombre_categoria("Ultra");
            dao.actualizarCategoria(categoria);
            System.out.println("Categoría actualizada.");

            // Leer y mostrar todas las categorías para verificar
            List<Categoria> categorias = dao.leerTodasCategorias();
            System.out.println("\nLista de categorías:");
            for (Categoria cat : categorias) {
                System.out.println("id_categoria: " + cat.getId_categoria()
                        + ", nombre_categoria: " + cat.getNombre_categoria());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
