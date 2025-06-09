/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
import java.util.List;


/**
 *
 * @author yuri guevara
 */
public class Orden {

    private int idOrden;
    private Date fecha_orden;
    private List<Detalle_Orden> detalles;

    public Orden() {
    }

    public Orden(int idOrden, Date fecha_orden, List<Detalle_Orden> detalle) {
        this.idOrden = idOrden;
        this.fecha_orden = fecha_orden;
        this.detalles = detalle;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public List<Detalle_Orden> getDetalle() {
        return detalles;
    }

    public void setDetalle(List<Detalle_Orden> detalle) {
        this.detalles = detalle;
    }

      
}
