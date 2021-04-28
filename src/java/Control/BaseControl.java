/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public abstract class BaseControl<T> {
    
    public abstract void agregar(T entidad);

    public abstract void eliminar(T entidad);

    public abstract void actualizar(T entidad);

    public abstract ArrayList<T> consultar();

    public abstract T buscarPorId(int id);

}
