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

    private int idOrden;
    private int id_cuenta; //Relacion con cuenta
    private Date fecha_orden;
    private List<Detalle_Orden> detalle;

    public Orden(int id_orden, int idCuenta, Date fecha_orden, List<Detalle_Orden> detalle) {
        this.idOrden = id_orden;
        this.id_cuenta = idCuenta;
        this.fecha_orden = fecha_orden;
        this.detalle = detalle;
    }

    public Orden() {
    }

    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
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

    
    public java.sql.Date getFechaOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
