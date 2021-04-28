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
public class Capturista{

    

    private Long id;
    private String nombre;
    private String usuario;
    private String contraseña;
    private Preparatoria idPreparatoria;

    public Capturista() {
    }

    public Capturista(Long id, String nombre, String usuario, String contraseña, Preparatoria idPreparatoria) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.idPreparatoria = idPreparatoria;
    }

    public Capturista(String nombre, String usuario, String contraseña, Preparatoria idPreparatoria) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.idPreparatoria = idPreparatoria;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Preparatoria getIdPreparatoria() {
        return idPreparatoria;
    }

    public void setIdPreparatoria(Preparatoria idPreparatoria) {
        this.idPreparatoria = idPreparatoria;
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
        if (!(object instanceof Capturista)) {
            return false;
        }
        Capturista other = (Capturista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Capturista[ id=" + id + " ]";
    }
    
}
