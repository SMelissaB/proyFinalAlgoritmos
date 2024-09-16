/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyfinalalgoritmos;

/**
 *
 * @author melis
 */
public class Persona {
    int id;
    String codigo;
    String nombre;
    String especialidad;
    String estado; //desarrollador activo o inactivo;

    public Persona() {
    }

    public Persona(int id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Persona(int id, String codigo, String nombre, String especialidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
        return codigo + " - " + nombre;  // Esto es lo que se mostrará en el JComboBox
    }
    
    public String toStringComplete() {
        return  codigo + " - " + nombre + " - " + especialidad ;
    }
    
 
    
    
    
}
