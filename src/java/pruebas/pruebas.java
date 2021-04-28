/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import AccesoDatos.PreparatoriaDAO;
import Dominio.Preparatoria;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;

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
        PreparatoriaDAO prepadao = new PreparatoriaDAO();
        prepa.setClave("cara");
        prepa.setNombre("COBACH");
        prepa.setResponsable("Morkecho");
        prepa.setImagen("C:\\Users\\alexis\\Desktop\\cato.jpg");
        
        prepadao.agregar(prepa);
        
    }
    
}
