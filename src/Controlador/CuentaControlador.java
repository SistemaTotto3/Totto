/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yuri guevara
 */
public class CuentaControlador {

    private final CuentaDAO cuentaDAO;

    public CuentaControlador() {
        this.cuentaDAO = new CuentaDAO();
    }

    // Método para crear una nueva cuenta
    public void crearCuenta(int idOrden, int idCliente, java.sql.Date fecha_cuenta, float total_cuenta, String estado_cuenta) {
        try {
            Cuenta cuenta = new Cuenta();
            cuenta.setIdOrden(idOrden);
            cuenta.setIdCliente(idCliente);
            cuenta.setFecha_cuenta(fecha_cuenta);
            cuenta.setTotal_cuenta(total_cuenta);
            cuenta.setEstado_cuenta(estado_cuenta);
            cuentaDAO.crearCuenta(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la cuenta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las cuentas
    public List<Cuenta> obtenerTodasCuentas() {
        try {
            return cuentaDAO.leerTodasCuenta();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las cuentas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar una cuenta existente
    public void actualizarCuenta(int id_cuenta, int idOrden, int idCliente, java.sql.Date fecha_cuenta, float total_cuenta, String estado_cuenta) {
        try {
            Cuenta cuenta = new Cuenta();
            cuenta.setId_cuenta(id_cuenta);
            cuenta.setIdOrden(idOrden);
            cuenta.setIdCliente(idCliente);
            cuenta.setFecha_cuenta(fecha_cuenta);
            cuenta.setTotal_cuenta(total_cuenta);
            cuenta.setEstado_cuenta(estado_cuenta);
            cuentaDAO.actualizarCuenta(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cuenta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una cuenta
    public void eliminarCuenta(int idCuenta) {
        try {
            cuentaDAO.eliminarCuenta(idCuenta);
            JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la cuenta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        CuentaControlador controlador = new CuentaControlador();

        // Crear una cuenta
        controlador.crearCuenta(1, 1, java.sql.Date.valueOf("2025-04-29"), 500.0f, "Activa");

        // Leer todas las cuentas
        List<Cuenta> cuentas = controlador.obtenerTodasCuentas();
        if (cuentas != null) {
            System.out.println("Lista de cuentas:");
            for (Cuenta c : cuentas) {
                System.out.println("ID: " + c.getId_cuenta()
                        + ", idOrden: " + c.getIdOrden()
                        + ", idCliente: " + c.getIdCliente()
                        + ", fecha_cuenta: " + c.getFecha_cuenta()
                        + ", total_cuenta: " + c.getTotal_cuenta()
                        + ", estado_cuenta: " + c.getEstado_cuenta());
            }
        }

        // Actualizar una cuenta (suponiendo que ID 1 existe)
        controlador.actualizarCuenta(1, 2, 2, java.sql.Date.valueOf("2025-05-01"), 700.0f, "Cerrada");

        // Eliminar una cuenta
        controlador.eliminarCuenta(1);
    }

}
