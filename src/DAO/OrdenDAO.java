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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author COMPHP
 */
public class OrdenDAO {

    // Crear
    public void crearOrden(Orden orden) throws SQLException {
        String sql = "INSERT INTO Orden (id_cuenta, fecha_orden) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orden.getId_cuenta());
            stmt.setTimestamp(2,java.sql.Timestamp.valueOf(orden.getFecha_orden()));
            stmt.executeUpdate();
        }
    }

    // Leer
    public List<Orden> obtenerOrdenes() throws SQLException {
        List<Orden> ordenes = new ArrayList<>();
        String sql = "SELECT * FROM Orden";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setId_cuenta(rs.getInt("id_cuenta"));
                orden.setFecha_orden(rs.getObject("fecha_orden", LocalDateTime.class));
                ordenes.add(orden);
            }
        }
        return ordenes;
    }

    // Actualizar
    public void actualizarOrden(Orden orden) throws SQLException {
        String sql = "UPDATE Orden SET id_cuenta = ?, fecha_orden = ? WHERE idOrden = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orden.getId_cuenta());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(orden.getFecha_orden()));
            stmt.setInt(3, orden.getIdOrden());
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
            orden.setId_cuenta(1);
            orden.setFecha_orden(LocalDateTime.now());
            dao.actualizarOrden(orden);
            System.out.println("Orden actualizada.");
            List<Orden> ordenes = dao.obtenerOrdenes();
            System.out.println("Lista de ordenes:");
            for (Orden ord : ordenes) {
                System.out.println("idOrden: " + ord.getIdOrden()
                        + ", id_cuenta: " + ord.getId_cuenta()
                        + ", fecha_orden: " + ord.getFecha_orden());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
