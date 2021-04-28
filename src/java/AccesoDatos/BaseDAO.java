/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import javax.swing.table.DefaultTableModel;

/**
 * Clase abstracta padre con los metodos a usar en clases hijas para acceder a la BD.
 * @author Citlali Orduño
 */
public abstract class BaseDAO<T> {
  
     
    public abstract void agregar(T entidad);
    
    public abstract void eliminar(Long id);
    
    public abstract void actualizar(T entidad);
    
    public abstract DefaultTableModel consultarTodos();
    
    public abstract T buscarPorId(long id);
}
