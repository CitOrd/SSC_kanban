/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.List;
/**
 *
 * @author 
 */
public class Alumno{

   
    
    private Long id;
    private String nombre;
    private Preparatoria preparatoria;
    private List<Calificacion> calificaciones;       

    public Alumno() {
    }

    public Alumno(Long id, String nombre, Preparatoria preparatoria, List<Calificacion> calificaciones) {
        this.id = id;
        this.nombre = nombre;
        this.preparatoria = preparatoria;
        this.calificaciones = calificaciones;
    }

    public Alumno(String nombre, Preparatoria preparatoria) {
        this.nombre = nombre;
        this.preparatoria = preparatoria;
    }

    public Alumno(String nombre, Preparatoria preparatoria, List<Calificacion> calificaciones) {
        this.nombre = nombre;
        this.preparatoria = preparatoria;
        this.calificaciones = calificaciones;
    }
            
    
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Preparatoria getPreparatoria() {
        return preparatoria;
    }

    public void setPreparatoria(Preparatoria preparatoria) {
        this.preparatoria = preparatoria;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Alumno[ id=" + id + " ]";
    }
    
}
