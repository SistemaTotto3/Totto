/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author yuri guevara
 */
public class Cliente {
    private int id_cliente;
    private String nombre_1;
    private String apellido_1;
    private String dirrecion_cliente;
    private String telefono_cliente;   

    public Cliente(int id_cliente, String nombre_1, String apellido_1, String dirrecion_cliente, String telefono_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_1 = nombre_1;
        this.apellido_1 = apellido_1;
        this.dirrecion_cliente = dirrecion_cliente;
        this.telefono_cliente = telefono_cliente;
    }

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getDirrecion_cliente() {
        return dirrecion_cliente;
    }

    public void setDirrecion_cliente(String dirrecion_cliente) {
        this.dirrecion_cliente = dirrecion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }
    
}
