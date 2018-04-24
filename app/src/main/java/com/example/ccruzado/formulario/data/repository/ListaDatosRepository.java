package com.example.ccruzado.formulario.data.repository;

import android.util.Log;

import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.data.model.RegistroData;
import com.example.ccruzado.formulario.data.model.mapper.RegistroMapper;
import com.example.ccruzado.formulario.data.repository.interfaces.ListaDatosIRepository;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by ccruzado on 23/04/2018.
 */

public class ListaDatosRepository implements ListaDatosIRepository {

    ApiRestService apiRestService;

    private ArrayList<RegistroDomain> registros;
    private long timestamp;
    private static final long STALE_MS = 10 * 1000; // Data is stale after 20 seconds
    private RegistroMapper registroMapper;

    public ListaDatosRepository(ApiRestService apiRestService, RegistroMapper registroMapper) {
        this.apiRestService = apiRestService;
        this.registroMapper = registroMapper;
        registros = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<ArrayList<RegistroDomain>> listaDeDatos() {
        return obtenerListaDeDatosDeMemoria().switchIfEmpty(obtenerListaDeDatosDelWebservice());
    }

    @Override
    public Observable<ArrayList<RegistroDomain>> obtenerListaDeDatosDeMemoria() {

        if (isUpToDate()) {
            //return Observable.fromIterable(registros);
            return Observable.fromArray(registros);
        } else {
            timestamp = System.currentTimeMillis();
            registros.clear();
            return Observable.empty();
        }

    }

    @Override
    public Observable<ArrayList<RegistroDomain>> obtenerListaDeDatosDelWebservice() {

        Observable<ArrayList<RegistroDomain>> registrosObservable =
                apiRestService.listMultiple().map(new Function< ArrayList<RegistroData> , ArrayList<RegistroDomain>>() {
                    @Override
                    public ArrayList<RegistroDomain> apply(ArrayList<RegistroData> registrosData) throws Exception {
                        return registroMapper.reverseMap(registrosData);
                    }
                });


        return registrosObservable.doOnNext(new Consumer<ArrayList<RegistroDomain>>() {
            @Override
            public void accept(ArrayList<RegistroDomain> registrosDomain) throws Exception {
                //registros.add(registrosDomain);
                Log.d("dataInfo", "cantidad " + registrosDomain.size());
                registros = registrosDomain;
            }
        });

    }




}
