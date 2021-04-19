/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la relacion entre plan de estudio y semestre
 * @author Citlali Orduño
 */
@Entity
@Table(name= "relPlanSemestre")
public class RelPlanSem implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPlanEstudio")
    private PlanEstudio idPlanEstudio;
     @ManyToOne(optional = false)
    @JoinColumn(name = "idSemestre")
    private  Semestre idSemestre;

     
     //constructores
    public RelPlanSem() {
    }

    public RelPlanSem(PlanEstudio idPlanEstudio, Semestre idSemestre) {
        this.idPlanEstudio = idPlanEstudio;
        this.idSemestre = idSemestre;
    }

    public RelPlanSem(Long id, PlanEstudio idPlanEstudio, Semestre idSemestre) {
        this.id = id;
        this.idPlanEstudio = idPlanEstudio;
        this.idSemestre = idSemestre;
    }

    //metodos get y set
    public PlanEstudio getIdPlanEstudio() {
        return idPlanEstudio;
    }

    public void setIdPlanEstudio(PlanEstudio idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof RelPlanSem)) {
            return false;
        }
        RelPlanSem other = (RelPlanSem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.RelPlanSem[ id=" + id + " ]";
    }
    
}
