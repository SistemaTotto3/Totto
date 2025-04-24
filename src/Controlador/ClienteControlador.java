/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ClienteDAO;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPHP
 */
public class ClienteControlador {

    private final ClienteDAO clienteDAO;

    public ClienteControlador() {
        this.clienteDAO = new ClienteDAO();
    }

    // Método para crear un nuevo cliente
    public void crearCliente(String nombre_1, String apellido_1, String direccion_cliente,
            String  telefono_cliente) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre_1(nombre_1);
            cliente.setApellido_1(apellido_1);
            cliente.setDirrecion_cliente(direccion_cliente);
            cliente.setTelefono_cliente(telefono_cliente);
            clienteDAO.crearCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosClientes() {
        try {
            return clienteDAO.leerTodosClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un cliente existente
    public void actualizarCliente(int id_cliente, String nombre_1, String apellido_1, String direccion_cliente,
            String telefono_cliente) {
        try {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(id_cliente);
            cliente.setNombre_1(nombre_1);
            cliente.setApellido_1(apellido_1);
            cliente.setDirrecion_cliente(direccion_cliente);
            cliente.setTelefono_cliente(telefono_cliente);
            clienteDAO.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un cliente
    public void eliminarCliente(int id_cliente) {
        try {
            clienteDAO.eliminarCliente(id_cliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        ClienteControlador controlador = new ClienteControlador();

        // Crear un cliente
        controlador.crearCliente("Juan", "Antonio", "la gateada", "12345678");

        // Leer todos los clientes
        List<Cliente> clientes = controlador.obtenerTodosClientes();
        if (clientes != null) {
            System.out.println("Lista de clientes:");
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente()
                        + ", Nombre: " + c.getNombre_1() + " " + c.getApellido_1()
                        + ", direccion_cliente: " + c.getDirrecion_cliente()+ ", telefono_cliente:"+ c.getTelefono_cliente());
            }
        }

        // Actualizar un cliente (suponiendo que ID 1 existe)
        controlador.actualizarCliente(1, "Juan", "Manuel",  "Calle 456", "87654321");

        // Eliminar un cliente
        controlador.eliminarCliente(1);
    }
}
