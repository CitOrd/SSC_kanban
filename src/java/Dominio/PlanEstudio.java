/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la tabla Planes de estudio de la base de datos
 * @author Citlali Orduño
 */
@Entity
@Table(name= "planesEstudio")
public class PlanEstudio implements Serializable {

    //Atributos
    @Id
    @Column(name= "idPlanEstudio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "titulo")
    private String titulo;
   
            
    @ManyToOne(optional= false)
    @JoinColumn(name= "idPreparatoria")        
    private Preparatoria idPreparatoria;
    
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<RelPlanSem> relSemestres;

    //Constructores
    public PlanEstudio() {
    }

    public PlanEstudio(Long id, String titulo, Preparatoria idPreparatoria, List<RelPlanSem> relSemestres) {
        this.id = id;
        this.titulo = titulo;
        this.idPreparatoria = idPreparatoria;
        this.relSemestres = relSemestres;
    }

    public PlanEstudio(String titulo, Preparatoria idPreparatoria, List<RelPlanSem> relSemestres) {
        this.titulo = titulo;
        this.idPreparatoria = idPreparatoria;
        this.relSemestres = relSemestres;
    }

   
    
    //Metodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Preparatoria getIdPreparatoria() {
        return idPreparatoria;
    }

    public void setIdPreparatoria(Preparatoria idPreparatoria) {
        this.idPreparatoria = idPreparatoria;
    }

    public List<RelPlanSem> getRelSemestres() {
        return relSemestres;
    }

    public void setRelSemestres(List<RelPlanSem> relSemestres) {
        this.relSemestres = relSemestres;
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
        if (!(object instanceof PlanEstudio)) {
            return false;
        }
        PlanEstudio other = (PlanEstudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.PlanEstudio[ id=" + id + " ]";
    }
    
}
