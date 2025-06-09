/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Detalle_Orden;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDateTime;

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
            estado_orden,
            cantidad
        ) VALUES (?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdOrden());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setString(3, detalle.getEstado_orden());
            stmt.setInt(4, detalle.getCantidad());
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
                detalle.setEstado_orden(rs.getString("estado_orden"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }

    public void actualizarDetalleOrden(Detalle_Orden detalle) throws SQLException {
        String sql = "UPDATE Detalle_Orden SET idOrden = ?, id_producto = ?,estado_orden= ?, cantidad= ? WHERE id_detalle_orden = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdOrden());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setString(3, detalle.getEstado_orden());
            stmt.setInt(4, detalle.getId_detalle_orden());
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

}
