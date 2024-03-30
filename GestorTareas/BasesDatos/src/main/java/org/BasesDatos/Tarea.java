/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.BasesDatos;

import java.time.LocalDate;

/**
 *
 * @author steve
 */
public class Tarea {
    private int id;
    private int usuario_id;
    private String titulo;
    private String descripcion;
    private String estado;
    private LocalDate fecha_creacion;
    private LocalDate  fecha_limite;
    /*
        public Tarea( int usuario_id, String titulo, String descripcion, String estado, LocalDate fecha_limite) {
        this.usuario_id = usuario_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha_limite = fecha_limite;
    }
*/
    public Tarea(){} 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFecha_creacion(){
    return fecha_creacion;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }


}

