package com.example.ccruzado.formulario.data.api;

import com.example.ccruzado.formulario.data.model.RegistroData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ccruzado on 23/04/2018.
 */

public interface ApiRestService {

    @GET("api/Datos/GetDatos")
    Observable<ArrayList<RegistroData>> listMultiple();

}
