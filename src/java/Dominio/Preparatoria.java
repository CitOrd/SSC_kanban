/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Citlali Orduño
 */
@Table(name = "preparatorias")
@Entity
public class Preparatoria implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPreparatoria")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="clave")
    private String clave;
    @Column(name="idPreparatoria")
    private byte[] imagen;
    
    @OneToMany(mappedBy = "capturista", cascade = CascadeType.ALL)
    private List<Capturista> capturistas;

    public Preparatoria() {
        this.capturistas= new ArrayList<>();
    }
    
    
    public Preparatoria(Integer id, String nombre, String clave, byte[] imagen) {
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
}
