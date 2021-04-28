/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.PreparatoriaDAO;
import Dominio.Preparatoria;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class PreparatoriaControl extends BaseControl<Preparatoria> {

    PreparatoriaDAO prepDao;

    public PreparatoriaControl(PreparatoriaDAO prepDao) {
        this.prepDao = new PreparatoriaDAO();
    }

    @Override
    public void agregar(Preparatoria preparatoria) {
        if (preparatoria != null) {
            this.prepDao.agregar(preparatoria);
            System.out.println("Se agregó la preparatoria");
        } else {
            System.out.println("No se agregó");
        }

    }

    @Override
    public void eliminar(Preparatoria preparatoria) {
        if (preparatoria != null) {
            this.prepDao.eliminar(preparatoria);
            System.out.println("Se eliminó la preparatoria");
        } else {
            System.out.println("No se eliminó la preparatoria");
        }
    }

    @Override
    public void actualizar(Preparatoria preparatoria) {
        if (preparatoria != null) {
            this.prepDao.actualizar(preparatoria);
            System.out.println("Se actualizó la preparatoria");
        } else {
            System.out.println("No se actualizó la preparatoria");
        }
    }

    @Override
    public ArrayList<Preparatoria> consultar() {

        System.out.println("Se encontraron las preparatorias");
        return this.prepDao.consultar();

    }

    @Override
    public Preparatoria buscarPorId(int id) {
        if (id != 0) {
            return this.prepDao.buscarPorId(id);
        } else {
            System.out.println("No se pudo consultar la preparatoria");
            return null;
        }
    }

}
