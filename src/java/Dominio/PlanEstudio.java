/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 * Clase que representa la tabla Planes de estudio de la base de datos
 *
 * @author Citlali Orduño
 */
public class PlanEstudio{

    //Atributos
    private int id;
    private String titulo;
    private Preparatoria idPreparatoria;

    //Constructores
    public PlanEstudio() {
    }

    public PlanEstudio(int id, String titulo, Preparatoria idPreparatoria) {
        this.id = id;
        this.titulo = titulo;
        this.idPreparatoria = idPreparatoria;
    }

    public PlanEstudio(String titulo, Preparatoria idPreparatoria) {
        this.titulo = titulo;
        this.idPreparatoria = idPreparatoria;
    }

    //Metodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "PlanEstudio{" + "id=" + id + ", titulo=" + titulo + ", idPreparatoria=" + idPreparatoria + '}';
    }

    

}
