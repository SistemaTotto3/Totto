/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
import java.util.Date;
/**
 *
 * @author yuri guevara
 */
public class Orden {
    private int id_orden;
    private Cuenta cuenta; //Relacion con cuenta
    private Date fecha_orden;
    private List<Detalle_Orden> detalle;

    public Orden(int id_orden, Cuenta cuenta, Date fecha_orden, List<Detalle_Orden> detalle) {
        this.id_orden = id_orden;
        this.cuenta = cuenta;
        this.fecha_orden = fecha_orden;
        this.detalle = detalle;
    }

    public Orden() {
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public List<Detalle_Orden> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle_Orden> detalle) {
        this.detalle = detalle;
    }
    
    
    
}
