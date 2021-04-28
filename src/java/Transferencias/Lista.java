/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencias;

import java.util.List;

/**
 *
 * @author Citlali Orduño
 */
public class Lista<E> {
     private String tituloTabla;
    private List<E> lista;

    
    public Lista() {
    }

    public String getTituloTabla() {
        return tituloTabla;
    }

    public void setTituloTabla(String tituloTabla) {
        this.tituloTabla = tituloTabla;
    }

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }
}
