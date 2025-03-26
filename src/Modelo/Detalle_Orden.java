/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
/**
 *
 * @author yuri guevara
 */
public class Detalle_Orden {
    private int id_detalle_orden;
    private Orden orden; //Relacion con orden
    private Producto producto; //Relacion con producto
    private Date fecha_orden;
    private String estado_orden;
    
    
    
}
