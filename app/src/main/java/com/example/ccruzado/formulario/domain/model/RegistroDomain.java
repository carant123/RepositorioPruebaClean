package com.example.ccruzado.formulario.domain.model;

/**
 * Created by ccruzado on 23/04/2018.
 */

public class RegistroDomain {

    private Integer id;
    private String nombre;
    private Integer numero;

    public RegistroDomain() {
    }

    public RegistroDomain(Integer id, String nombre, Integer numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


}
