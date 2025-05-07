/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author yuri guevara
 */
public class Orden {

    private int idOrden;
    private int id_cuenta; //Relacion con cuenta
    private LocalDateTime fecha_orden;
    private List<Detalle_Orden> detalle;

    public Orden(int idOrden, int id_cuenta, LocalDateTime fecha_orden, List<Detalle_Orden> detalle) {
        this.idOrden = idOrden;
        this.id_cuenta = id_cuenta;
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

    public LocalDateTime getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(LocalDateTime fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public List<Detalle_Orden> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle_Orden> detalle) {
        this.detalle = detalle;
    }
  
}
