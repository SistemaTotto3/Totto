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
    private int idOrden; //Relacion con orden
    private int idCliente; //Relacion con cliente
    private Date fecha_cuenta;
    private float total_cuenta;
    private String estado_cuenta;

    public Cuenta(int id_cuenta, int idOrden, int idCliente, Date fecha_cuenta, float total_cuenta, String estado_cuenta) {
        this.id_cuenta = id_cuenta;
        this.idOrden = idOrden;
        this.idCliente = idCliente;
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

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
