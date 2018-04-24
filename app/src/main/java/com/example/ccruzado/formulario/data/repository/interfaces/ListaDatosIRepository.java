package com.example.ccruzado.formulario.data.repository.interfaces;



import com.example.ccruzado.formulario.domain.model.RegistroDomain;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 23/04/2018.
 */

public interface ListaDatosIRepository {

    Observable<ArrayList<RegistroDomain>> listaDeDatos();

    Observable<ArrayList<RegistroDomain>> obtenerListaDeDatosDeMemoria();

    Observable<ArrayList<RegistroDomain>> obtenerListaDeDatosDelWebservice();
}
