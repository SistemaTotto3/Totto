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
/**
 *
 * @author COMPHP
 */
public class ClienteDAO {
    public void crearCliente(Cliente cliente) throws SQLException {
    String sql = """
        INSERT INTO Clientes (
            nombre_1, 
            apellido_1, 
            direccion_cliente, 
            telefono_cliente
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, cliente.getNombre_1());
        stmt.setString(2, cliente.getApellido_1());
        stmt.setString(3, cliente.getDirrecion_cliente());
        stmt.setString(4, cliente.getTelefono_cliente());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        ClienteDAO DAO = new ClienteDAO();
        Cliente c1 = new Cliente();
        c1.setNombre_1("Juan");
        c1.setApellido_1("Carlos");
        c1.setDirrecion_cliente("Calle 123, Ciudad");
        c1.setTelefono_cliente("12345678");
        DAO.crearCliente(c1);
        System.out.println("Cliente creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}
