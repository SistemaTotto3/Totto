/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
/**
 *
 * @author yuri guevara
 */
public class Cuenta {
    private int id_cuenta;
    private Orden orden; //Relacion con orden
    private Cliente cliente; //Relacion con cliente
    private Date fecha_cuenta;
    private float total_cuenta;
    private String estado_cuenta;

    public Cuenta(int id_cuenta, Orden orden, Cliente cliente, Date fecha_cuenta, float total_cuenta, String estado_cuenta) {
        this.id_cuenta = id_cuenta;
        this.orden = orden;
        this.cliente = cliente;
        this.fecha_cuenta = fecha_cuenta;
        this.total_cuenta = total_cuenta;
        this.estado_cuenta = estado_cuenta;
    }

    public Cuenta() {
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha_cuenta() {
        return fecha_cuenta;
    }

    public void setFecha_cuenta(Date fecha_cuenta) {
        this.fecha_cuenta = fecha_cuenta;
    }

    public float getTotal_cuenta() {
        return total_cuenta;
    }

    public void setTotal_cuenta(float total_cuenta) {
        this.total_cuenta = total_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }
    
    
    
}
