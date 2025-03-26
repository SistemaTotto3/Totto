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
    private  Insumo insumo; //Relacion con Insumo
    private Producto producto; //Relacion con producto
    private double cantidad_insumo;

    public Detalle_Insumo(int id_detalle_insumo, Insumo insumo, Producto producto, double cantidad_insumo) {
        this.id_detalle_insumo = id_detalle_insumo;
        this.insumo = insumo;
        this.producto = producto;
        this.cantidad_insumo = cantidad_insumo;
    }

    public Detalle_Insumo() {
    }

    public int getId_detalle_insumo() {
        return id_detalle_insumo;
    }

    public void setId_detalle_insumo(int id_detalle_insumo) {
        this.id_detalle_insumo = id_detalle_insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad_insumo() {
        return cantidad_insumo;
    }

    public void setCantidad_insumo(double cantidad_insumo) {
        this.cantidad_insumo = cantidad_insumo;
    }
    
    
    
}
