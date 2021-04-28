/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author 
 */
public class Materia{

    //atributos
    private Long id;
    private String titulo;
    private int clave;
    private Semestre idSemestre;

    
    //constructores
    public Materia() {
    }

    public Materia(String titulo, int clave, Semestre idSemestre) {
        this.titulo = titulo;
        this.clave = clave;
        this.idSemestre = idSemestre;
    }

    public Materia(Long id, String titulo, int clave, Semestre idSemestre) {
        this.id = id;
        this.titulo = titulo;
        this.clave = clave;
        this.idSemestre = idSemestre;
    }
    
    //metodos
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

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
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
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Materia[ id=" + id + " ]";
    }
    
}
