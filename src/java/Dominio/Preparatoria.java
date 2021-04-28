/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Preparatoria{

    
    private int id;
    private String nombre;
    private String clave;
    private String imagen;
    private List<Capturista> capturistas;

    public Preparatoria() {
        this.capturistas= new ArrayList<>();
    }
    
    
    public Preparatoria(int id, String nombre, String clave, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.imagen = imagen;
    }
    public Preparatoria(String nombre, String clave, String imagen) {
        this.nombre = nombre;
        this.clave = clave;
        this.imagen = imagen;
    }

    public Preparatoria(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Capturista> getCapturistas() {
        return capturistas;
    }

    public void setCapturistas(List<Capturista> capturistas) {
        this.capturistas = capturistas;
    }
 

    @Override
    public String toString() {
        return "Dominio.Preparatoria[ id=" + id + " ]";
    }
    
}
