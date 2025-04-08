/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Cuenta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author COMPHP
 */
public class CuentaDAO {
    
    public void crearCuenta(Cuenta cuenta) throws SQLException {
        String sql = """
        INSERT INTO Cuenta (
            id_cuenta, 
            idOrden, 
            idCliente,
            fecha_cuenta, 
            total_cuenta,
            estado_cuenta
        ) VALUES (?, ?, ?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, cuenta.getId_cuenta());
            stmt.setInt(2, cuenta.getIdOrden());
            stmt.setInt(3, cuenta.getIdCliente());
            stmt.setTimestamp(4, new java.sql.Timestamp(cuenta.getFecha_cuenta().getTime()));
            stmt.setFloat(5, cuenta.getTotal_cuenta());
            stmt.setString(6, cuenta.getEstado_cuenta());
            stmt.executeUpdate();
        }
    }
    
    
    public List<Cuenta> leerTodasCuenta() throws SQLException {
        String sql = "SELECT * FROM Cuenta";
        List<Cuenta> cuentas = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId_cuenta(rs.getInt("id_cuenta"));
                cuenta.setIdOrden(rs.getInt("idOrden"));
                cuenta.setIdCliente(rs.getInt("idCliente"));
                cuenta.setFecha_cuenta(rs.getTimestamp("fecha_cuenta"));
                cuenta.setTotal_cuenta(rs.getFloat("total_cuenta"));
                cuenta.setEstado_cuenta(rs.getString("estado_cuenta"));
                cuentas.add(cuenta);
            }
        }
        return cuentas;
    }
    
    public static void main(String[] args) {
        try {
            CuentaDAO dao = new CuentaDAO();
            List<Cuenta> cuentas = dao. leerTodasCuenta();
            System.out.println("Lista de ventas:");
            for (Cuenta cuen : cuentas) {
                System.out.println("Cuenta ID: " + cuen.getId_cuenta()
                        + ", Orden ID: " + cuen.getIdOrden()
                        + ", Cliente ID: " + cuen.getIdCliente()
                        + ", Fecha: " + cuen.getFecha_cuenta()
                        + ", Total: " + cuen.getTotal_cuenta()
                        + ", Estado:" + cuen.getEstado_cuenta());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
