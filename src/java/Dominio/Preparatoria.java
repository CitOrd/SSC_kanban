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

    
    private Long id;
    private String nombre;
    private String clave;
    private Blob imagen;
    private List<Capturista> capturistas;

    public Preparatoria() {
        this.capturistas= new ArrayList<>();
    }
    
    
    public Preparatoria(Long id, String nombre, String clave, Blob imagen) {
        this.id = id;
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

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Capturista> getCapturistas() {
        return capturistas;
    }

    public void setCapturistas(List<Capturista> capturistas) {
        this.capturistas = capturistas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preparatoria)) {
            return false;
        }
        Preparatoria other = (Preparatoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Preparatoria[ id=" + id + " ]";
    }

    public void setId(int id) {       
      this.id = (long) id;
    }
    
}
