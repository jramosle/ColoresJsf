package com.colores.jsf.uniminuto.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jramos
 */
public class ColoresBean {

    private String nombre;
    private Integer telefono;

    /**
     * Constructor bean.
     */
    public ColoresBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que contiene las validaciones necesarias para retornar el color 
     * equivalente a la pagina donde se debe redirigir. 
     * 
     * @return Color 
     */
    public String comprobar() {

        //Color de retorno equivale a la llave del mapa.
        String color = "";

        //Contiene los colores con sus respectivos equivalentes.
        Map<String, String> colores = new HashMap<>();
        colores.put("amarillo", "0,1,2");
        colores.put("azul", "3,4,5");
        colores.put("rojo", "6,7,8,9");

        //Se obtiene el ultimo elemento de la cadena.
        String numero = getTelefono().toString().substring(getTelefono().toString().length() - 1);

        //Recorrido del mapa.
        for (Map.Entry<String, String> entry : colores.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            //Validación si dentro de los valores de cada llave del mapa se encuentra el ultimo digito.
            if (new ArrayList<>(Arrays.asList(value.split(","))).contains(numero)) {

                //Se asigna el valor de la llave cuando el numero se encuentra en el array.
                color = key;

            }
        }

        return color;
    }

}
