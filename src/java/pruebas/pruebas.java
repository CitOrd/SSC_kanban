/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import AccesoDatos.PreparatoriaDAO;
import Control.PreparatoriaControl;
import Dominio.Preparatoria;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 *
 * @author alexis
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Preparatoria prepa = new Preparatoria();
        Preparatoria prepa2 = new Preparatoria();
        PreparatoriaDAO prepadao = new PreparatoriaDAO();
        PreparatoriaControl prepadao2 = new PreparatoriaControl();
        prepa.setClave("cara35");
        prepa.setNombre("COBACH");
        prepa.setResponsable("Morkecho");
        prepa.setImagen("C:\\Users\\alexis\\Desktop\\tea.jpg");

        prepa2.setId(1);
        prepadao2.agregar(prepa);
        System.out.println(prepadao.buscarPorId(prepa2.getId()));
//        ArrayList<Preparatoria> lista;
//        lista = prepadao.consultar();
//        for (Preparatoria preparatoria : lista) {
//            System.out.println(preparatoria);
//        }
    }

}
