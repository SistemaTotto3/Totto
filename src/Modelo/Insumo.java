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
public class Insumo {

    private int id_insumo;
    private Date fecha_insumo;
    private float total_insumo;
    private List<Detalle_Insumo> detalles;

    public Insumo() {
    }

    public Insumo(int id_insumo, Date fecha_insumo, float total_insumo, List<Detalle_Insumo> detalles) {
        this.id_insumo = id_insumo;
        this.fecha_insumo = fecha_insumo;
        this.total_insumo = total_insumo;
        this.detalles = detalles;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public Date getFecha_insumo() {
        return fecha_insumo;
    }

    public void setFecha_insumo(Date fecha_insumo) {
        this.fecha_insumo = fecha_insumo;
    }

    public float getTotal_insumo() {
        return total_insumo;
    }

    public void setTotal_insumo(float total_insumo) {
        this.total_insumo = total_insumo;
    }

    public List<Detalle_Insumo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_Insumo> detalles) {
        this.detalles = detalles;
    }

    

}
