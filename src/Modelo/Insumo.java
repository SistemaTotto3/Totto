/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author yuri guevara
 */
public class Insumo {

    private int id_insumo;
    private String nombre_insumo;
    private float precio_insumo;
    private List<Detalle_Insumo> detalles;

    public Insumo(int id_insumo, String nombre_insumo, float precio_insumo, List<Detalle_Insumo> detalles) {
        this.id_insumo = id_insumo;
        this.nombre_insumo = nombre_insumo;
        this.precio_insumo = precio_insumo;
        this.detalles = detalles;
    }

    public Insumo() {
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public float getPrecio_insumo() {
        return precio_insumo;
    }

    public void setPrecio_insumo(float precio_insumo) {
        this.precio_insumo = precio_insumo;
    }

    public List<Detalle_Insumo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_Insumo> detalles) {
        this.detalles = detalles;
    }

}
