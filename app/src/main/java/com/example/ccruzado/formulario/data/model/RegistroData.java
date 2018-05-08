package com.example.ccruzado.formulario.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ccruzado on 23/04/2018.
 */

@Entity(tableName = "Registro")
public class RegistroData {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "numero")
    private Integer numero;

    @Ignore
    public RegistroData() {
    }

    public RegistroData(Integer id, String nombre, Integer numero) {
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
