/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.List;

/**
 * Clase que representa la tabla Semestre en la base de datos
 * @author Citlali Orduño
 */
public class Semestre{

    //atributos
    private Long id;
    private int numSemestre;
    private List<Materia> materias;

    //constructores
    public Semestre() {
    }

    public Semestre(int numSemestre, List<Materia> materias) {
        this.numSemestre = numSemestre;
        this.materias = materias;
    }

    public Semestre(Long id, int numSemestre, List<Materia> materias) {
        this.id = id;
        this.numSemestre = numSemestre;
        this.materias = materias;
    }
    
    //Metodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumSemestre() {
        return numSemestre;
    }

    public void setNumSemestre(int numSemestre) {
        this.numSemestre = numSemestre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
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
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Semestre[ id=" + id + " ]";
    }
    
}
