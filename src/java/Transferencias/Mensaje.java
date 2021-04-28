/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencias;

/**
 *
 * @author Citlali Orduño
 */
public class Mensaje {

 private String mensaje;
    private String claseMensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String claseMensaje) {
        this.mensaje = mensaje;
        this.claseMensaje = claseMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getClaseMensaje() {
        return claseMensaje;
    }

    public void setClaseMensaje(String claseMensaje) {
        this.claseMensaje = claseMensaje;
    }    
}
