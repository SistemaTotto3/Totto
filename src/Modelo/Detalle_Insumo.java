/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author yuri guevara
 */
public class Detalle_Insumo {

     private int id_detalle_insumo;
    private int id_insumo; //Relacion con Insumo
    private int id_producto; //Relacion con producto
    private String nombre_insumo;
    private float cantidad_insumo;
    private float precio_insumo;

    public Detalle_Insumo() {
    }

    public Detalle_Insumo(int id_detalle_insumo, int id_insumo, int id_producto, String nombre_insumo, float cantidad_insumo, float precio_insumo) {
        this.id_detalle_insumo = id_detalle_insumo;
        this.id_insumo = id_insumo;
        this.id_producto = id_producto;
        this.nombre_insumo = nombre_insumo;
        this.cantidad_insumo = cantidad_insumo;
        this.precio_insumo = precio_insumo;
    }

    public int getId_detalle_insumo() {
        return id_detalle_insumo;
    }

    public void setId_detalle_insumo(int id_detalle_insumo) {
        this.id_detalle_insumo = id_detalle_insumo;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public float getCantidad_insumo() {
        return cantidad_insumo;
    }

    public void setCantidad_insumo(float cantidad_insumo) {
        this.cantidad_insumo = cantidad_insumo;
    }

    public float getPrecio_insumo() {
        return precio_insumo;
    }

    public void setPrecio_insumo(float precio_insumo) {
        this.precio_insumo = precio_insumo;
    }

    
    
}
