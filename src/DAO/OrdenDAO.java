/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Orden;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
/**
 *
 * @author COMPHP
 */
public class OrdenDAO {

    // Crear
     // Crear
    public int crearOrden(Orden orden) throws SQLException {
        String sql = "INSERT INTO Orden (fecha_orden) VALUES (?)"; 
        int generatedId = -1;
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1,new java.sql.Timestamp(orden.getFecha_orden().getTime()));
            stmt.executeUpdate();
            
            // Obtener el ID generado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        }
        return generatedId;
    }

    
    
    
    // Leer
    public List<Orden> leerTodasOrdenes() throws SQLException {
        List<Orden> ordenes = new ArrayList<>();
        String sql = "SELECT * FROM Orden";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFecha_orden(rs.getTimestamp("fecha_orden"));
                ordenes.add(orden);
            }
        }
        return ordenes;
    }

    // Actualizar
    public void actualizarOrden(Orden orden) throws SQLException {
        String sql = "UPDATE Orden SET fecha_orden = ? WHERE idOrden = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(orden.getFecha_orden().getTime()));
            stmt.setInt(2, orden.getIdOrden());
            stmt.executeUpdate();
        }
    }

    // Eliminar
    public void eliminarOrden(int idOrden) throws SQLException {
        String sql = "DELETE FROM Orden WHERE idOrden = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idOrden);
            stmt.executeUpdate();
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        try {
            OrdenDAO dao = new OrdenDAO();
            Orden orden = new Orden();
            orden.setIdOrden(1); // ID existente
            orden.setFecha_orden( new java.util.Date());
            dao.actualizarOrden(orden);
            System.out.println("Orden actualizada.");
            List<Orden> ordenes = dao.leerTodasOrdenes();
            System.out.println("Lista de ordenes:");
            for (Orden ord : ordenes) {
                System.out.println("idOrden: " + ord.getIdOrden()
                        + ", fecha_orden: " + ord.getFecha_orden());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
