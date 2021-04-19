/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Citlali Orduño
 */
@Entity
public class Calificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAlumno")
    private Alumno idAlumno;
    @JoinColumn(name = "idMateria")
    @OneToOne(optional = false)
    private Materia idMateria;
    @Column(name = "puntaje")
    private int puntaje;

    public Calificacion() {
    }

    public Calificacion(Alumno idAlumno, Materia idMateria, int puntaje) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.puntaje = puntaje;
    }

    public Calificacion(Long id, Alumno idAlumno, Materia idMateria, int puntaje) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.puntaje = puntaje;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Calificacion[ id=" + id + " ]";
    }

}
