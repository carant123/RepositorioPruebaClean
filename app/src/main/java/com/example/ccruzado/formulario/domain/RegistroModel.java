package com.example.ccruzado.formulario.domain;

import com.example.ccruzado.formulario.data.repository.interfaces.ListaDatosIRepository;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;
import com.example.ccruzado.formulario.presentation.interfaces.ListaDatosMVP;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 23/04/2018.
 */

public class RegistroModel implements ListaDatosMVP.Model {

    private ListaDatosIRepository repositorio;

    public RegistroModel(ListaDatosIRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Observable<ArrayList<RegistroDomain>> registros() {

        return this.repositorio.listaDeDatos();
    }


}
