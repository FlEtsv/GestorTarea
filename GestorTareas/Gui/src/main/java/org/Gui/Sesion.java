/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

/**
 *
 * @author steve
 */
public class Sesion {
    private static Sesion instancia = null;
    private int resultadoInicioSesion;
    private int idTarea;
    
    private Sesion() {
        // Constructor privado para el patrón Singleton
    }
    
    public static Sesion getInstance() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }
    
    public int getResultadoInicioSesion() {
        return resultadoInicioSesion;
    }
    
    public void setResultadoInicioSesion(int resultadoInicioSesion) {
        this.resultadoInicioSesion = resultadoInicioSesion;
    }
    
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
}
