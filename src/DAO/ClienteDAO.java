/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author COMPHP
 */
public class ClienteDAO {

    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = """
        INSERT INTO Cliente (
            nombre_1, 
            apellido_1, 
            direccion_cliente, 
            telefono_cliente
        ) VALUES (?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre_1());
            stmt.setString(2, cliente.getApellido_1());
            stmt.setString(3, cliente.getDirrecion_cliente());
            stmt.setString(4, cliente.getTelefono_cliente());
            stmt.executeUpdate();
        }
    }

    public List<Cliente> leerTodosClientes() throws SQLException {
        String sql = "SELECT * FROM Cliente ";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre_1(rs.getString("nombre_1"));
                cliente.setApellido_1(rs.getString("apellido_1"));
                cliente.setDirrecion_cliente(rs.getString("direccion_cliente"));
                cliente.setTelefono_cliente(rs.getString("telefono_cliente"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nombre_1 = ?, apellido_1 = ?, direccion_cliente = ?, telefono_cliente= ? WHERE idCliente = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre_1());
            stmt.setString(2, cliente.getApellido_1());
            stmt.setString(3, cliente.getDirrecion_cliente());
            stmt.setString(4, cliente.getTelefono_cliente());
            stmt.setInt(5, cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un cliente
    public void eliminarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

// Método Main
    public static void main(String[] args) {
        try {
            ClienteDAO dao = new ClienteDAO();

            // Actualizar un cliente
            Cliente cliente = new Cliente();
            cliente.setIdCliente(1); // ID existente
            cliente.setNombre_1("Pedro");
            cliente.setApellido_1("Guzman");
            cliente.setDirrecion_cliente("La Gateada");
            cliente.setTelefono_cliente("86758433");
            dao.actualizarCliente(cliente);
            System.out.println("Cliente actualizado.");

            // Leer y mostrar todos los clientes para verificar
            List<Cliente> clientes = dao.leerTodosClientes();
            System.out.println("Lista de clientes:");
            for (Cliente cli : clientes) {
                System.out.println("ID: " + cli.getIdCliente()
                        + ", Nombre: " + cli.getNombre_1() + " " + cli.getApellido_1()
                        + " " + cli.getDirrecion_cliente() + " " + cli.getTelefono_cliente());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }   
}
