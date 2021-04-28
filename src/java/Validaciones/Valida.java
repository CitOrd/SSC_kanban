/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Citlali Orduño
 */
public class Valida {
     /**
     * 
     * @param texto
     * @return 
     */
    public boolean cadenaVacia(String texto){
        CharSequence cadena= texto;
        
       //Define una expresion regulaar para una cadena vacia
       String cadena2= "^\\s*$";
       
       //Compila la expresion regular a un patrón
       Pattern patron= Pattern.compile(cadena2);
       
       //Crea un comparador para comparar la cadena contra el patrón
       Matcher matcher= patron.matcher(cadena);
       
       //Si la cadena se ajusta al patrón 
       if(matcher.matches()){
           return true;
       }
       return false;
    }
    
    /**
     * 
     * @param longMax
     * @param texto
     * @return 
     */
    public boolean validaCadena(int longMax, String texto){
        CharSequence cadena= texto.trim();
        
        String cadena2 = "^\\w{1," + longMax + "}$";
        
         //Compila la expresion regular a un patrón
       Pattern patron= Pattern.compile(cadena2);
       
       //Crea un comparador para comparar la cadena contra el patrón
       Matcher matcher= patron.matcher(cadena);
       
       //Si la cadena se ajusta al patrón 
       if(matcher.matches()){
           return true;
       }
       return false;
    }
    
    public boolean validaClave(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una clave
        String reCadena = "^[A-Z]{3}[0-9]{4}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }

        return false;
    }
    
     public boolean validaEntero(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una cadena con puros digitos
        String reCadena = "^\\d+$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }

        return false;
    }
     
     
    public boolean validaEnteroMaxDigitos(int numDigitos, String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una cadena con cuando mucho
        // numDigitos
        String reCadena = "^\\d{1," + numDigitos + "}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }

        return false;
    }
    
    
    public boolean validaEnteroRango(int min, int max, String s) {
        // Convierte la cadena a un entero
        int n = Integer.parseInt(s);

        // Si la cadena no está en el rango dado
        if (n < min || n > max) {
            return false;
        }

        return true;
    }
    
     public boolean validaFecha(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una fecha
        String reCadena = "^(([0-2]?\\d)|([3][0-1]))\\/(([0]?\\d)|([1][0-2]))\\/\\d{4}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }

        return false;
    }
    
     public boolean validaEmail(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una dirección de correo electrónico
        String reCadena = "^([\\-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena, Pattern.CASE_INSENSITIVE);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }

        return false;
    }
}
