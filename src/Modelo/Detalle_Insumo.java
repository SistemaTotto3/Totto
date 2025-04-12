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
    private int idInsumo; //Relacion con Insumo
    private int idProducto; //Relacion con producto
    private double cantidad_insumo;

    public Detalle_Insumo(int id_detalle_insumo, int idInsumo, int idProducto, double cantidad_insumo) {
        this.id_detalle_insumo = id_detalle_insumo;
        this.idInsumo = idInsumo;
        this.idProducto = idProducto;
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

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getCantidad_insumo() {
        return cantidad_insumo;
    }

    public void setCantidad_insumo(double cantidad_insumo) {
        this.cantidad_insumo = cantidad_insumo;
    }

}
