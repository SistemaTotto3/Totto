/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Detalle_Orden;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author COMPHP
 */
public class Detalle_OrdenDAO {

    public void crearDetalleOrden(Detalle_Orden detalle) throws SQLException {
        String sql = """
        INSERT INTO  Detalle_Orden (
            idOrden, 
            id_producto, 
            fecha_orden, 
            estado_orden
        ) VALUES (?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdOrden());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setDate(3, new java.sql.Date(detalle.getFecha_orden().getTime()));
            stmt.setString(4, detalle.getEstado_orden());
            stmt.executeUpdate();
        }
    }

    public List<Detalle_Orden> leerTodosDetalle_Orden() throws SQLException {
        String sql = "SELECT * FROM Detalle_Orden ";
        List<Detalle_Orden> detalles = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Detalle_Orden detalle = new Detalle_Orden();
                detalle.setId_detalle_orden(rs.getInt("id_detalle_orden"));
                detalle.setIdOrden(rs.getInt("idOrden"));
                detalle.setId_producto(rs.getInt("id_producto"));
                detalle.setFecha_orden(rs.getDate("fecha_orden"));
                detalle.setEstado_orden(rs.getString("estado_orden"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }

    public void actualizarDetalleOrden(Detalle_Orden detalle) throws SQLException {
        String sql = "UPDATE Detalle_Orden SET idOrden = ?, id_producto = ?, fecha_orden = ?, estado_orden= ? WHERE id_detalle_orden = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdOrden());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setDate(3, new java.sql.Date(detalle.getFecha_orden().getTime()));
            stmt.setString(4, detalle.getEstado_orden());
            stmt.setInt(5, detalle.getId_detalle_orden());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un cliente
    public void eliminarDetalleOrden(int idDetalleOrden) throws SQLException {
        String sql = "DELETE FROM Detalle_Orden WHERE id_detalle_orden = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalleOrden);
            stmt.executeUpdate();
        }
    }

// Método Main
    public static void main(String[] args) {
        try {
            Detalle_OrdenDAO dao = new Detalle_OrdenDAO();

            // Actualizar un cliente
            Detalle_Orden detalle = new Detalle_Orden();
            detalle.setId_detalle_orden(1); // ID existente
            detalle.setIdOrden(2);
            detalle.setId_producto(3);
            detalle.setFecha_orden(new java.util.Date());
            
            detalle.setEstado_orden("Activa");
            dao.actualizarDetalleOrden(detalle);
            System.out.println("Detalle_Orden actualizado.");

            // Leer y mostrar todos los clientes para verificar
            List<Detalle_Orden> detalles = dao.leerTodosDetalle_Orden();
            System.out.println("Lista de detalles_orden:");
            for (Detalle_Orden det : detalles) {
                System.out.println("id_detalle_orden: " + det.getId_detalle_orden()
                        + ", idOrden: " + det.getIdOrden() + "id_producto " + det.getId_producto()
                        + " fecha_orden" + det.getFecha_orden() + " estado_orden" + det.getEstado_orden());

            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
