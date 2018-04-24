package com.example.ccruzado.formulario.di.module;

import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.data.repository.ListaDatosRepository;
import com.example.ccruzado.formulario.data.repository.interfaces.ListaDatosIRepository;
import com.example.ccruzado.formulario.domain.RegistroModel;
import com.example.ccruzado.formulario.presentation.interfaces.ListaDatosMVP;
import com.example.ccruzado.formulario.presentation.model.mapper.RegistroMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaDatosPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ccruzado on 23/04/2018.
 */

@Module
public class ListaDatosModule {

    @Provides
    public ListaDatosMVP.Presenter providerPresenter(ListaDatosMVP.Model model, RegistroMapper mapper){
        return new ListaDatosPresenter(model, mapper);
    }

    @Provides
    public ListaDatosMVP.Model providerModel(ListaDatosIRepository repository){
        return new RegistroModel(repository);
    }


    @Singleton
    @Provides
    public ListaDatosIRepository provideRepo(ApiRestService apiRestService, com.example.ccruzado.formulario.data.model.mapper.RegistroMapper mapper) {
        return new ListaDatosRepository(apiRestService,mapper);
    }

}
