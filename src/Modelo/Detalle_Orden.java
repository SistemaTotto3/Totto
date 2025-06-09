/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author yuri guevara
 */
public class Detalle_Orden {

    private int id_detalle_orden;
    private int idOrden; //Relacion con orden
    private int id_producto; //Relacion con producto
    private String estado_orden;
    private int cantidad;

    public Detalle_Orden(int id_detalle_orden, int idOrden, int id_producto, String estado_orden, int cantidad) {
        this.id_detalle_orden = id_detalle_orden;
        this.idOrden = idOrden;
        this.id_producto = id_producto;
        this.estado_orden = estado_orden;
        this.cantidad = cantidad;
    }

    public Detalle_Orden() {
    }

    public int getId_detalle_orden() {
        return id_detalle_orden;
    }

    public void setId_detalle_orden(int id_detalle_orden) {
        this.id_detalle_orden = id_detalle_orden;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}