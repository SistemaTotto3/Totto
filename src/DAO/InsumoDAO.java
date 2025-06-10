/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Insumo;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author COMPHP
 */
public class InsumoDAO {

    public void crearInsumo(Insumo insumo) throws SQLException {
        String sql = """
        INSERT INTO Insumo (
            fecha_insumo, 
            total_insumo
        ) VALUES (?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setTimestamp(1,new java.sql.Timestamp(insumo.getFecha_insumo().getTime()));
            stmt.setFloat(2, insumo.getTotal_insumo());
            stmt.executeUpdate();
        }
    }

    public List<Insumo> leerTodosInsumos() throws SQLException {
        String sql = "SELECT * FROM Insumo";
        List<Insumo> insumos = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Insumo insumo = new Insumo();
                insumo.setId_insumo(rs.getInt("id_insumo"));
                insumo.setFecha_insumo(rs.getTimestamp("fecha_insumo"));
                insumo.setTotal_insumo(rs.getFloat("total_insumo"));
                insumos.add(insumo);
            }
        }
        return insumos;
    }

    public void actualizarInsumo(Insumo insumo) throws SQLException {
        String sql = "UPDATE Insumo SET fecha_insumo = ?, total_insumo = ? WHERE id_insumo = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setTimestamp(1,new java.sql.Timestamp(insumo.getFecha_insumo().getTime()));
            stmt.setFloat(2, insumo.getTotal_insumo());
            stmt.setInt(3, insumo.getId_insumo());
            stmt.executeUpdate();
        }
    }

    public void eliminarInsumo(int idInsumo) throws SQLException {
        String sql = "DELETE FROM Insumo WHERE id_insumo = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idInsumo);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            InsumoDAO dao = new InsumoDAO();

            // Actualizar un insumo
            Insumo insumo = new Insumo();
            insumo.setId_insumo(1); // ID existente
            insumo.setFecha_insumo(new java.util.Date());
            insumo.setTotal_insumo(0.75f);
            dao.actualizarInsumo(insumo);
            System.out.println("Insumo actualizado.");

            // Leer y mostrar todos los insumos para verificar
            List<Insumo> insumos = dao.leerTodosInsumos();
            System.out.println("Lista de insumos:");
            for (Insumo ins : insumos) {
                System.out.println("ID: " + ins.getId_insumo()
                        + ", Fecha: " + ins.getFecha_insumo()
                        + ", Precio: " + ins.getTotal_insumo());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
     

  
}
