/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

/**
 *
 * @author steve
 */
public class SesionUsuario {
    private static SesionUsuario instancia = null;
    private int resultadoInicioSesion;
    
    private SesionUsuario() {
        // Constructor privado para el patrón Singleton
    }
    
    public static SesionUsuario getInstance() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }
    
    public int getResultadoInicioSesion() {
        return resultadoInicioSesion;
    }
    
    public void setResultadoInicioSesion(int resultadoInicioSesion) {
        this.resultadoInicioSesion = resultadoInicioSesion;
    }
}
