package com.example.ccruzado.formulario.di.module;

import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.data.repository.ListaPedidosRepository;
import com.example.ccruzado.formulario.data.repository.interfaces.ListaPedidosIRepository;
import com.example.ccruzado.formulario.domain.PedidoModel;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaPedidosPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ListaPedidosModule {

    @Provides
    public ListaPedidosMVP.Presenter providerPresenter(ListaPedidosMVP.Model model, PedidoMapper mapper){
        return new ListaPedidosPresenter(model, mapper);
    }

    @Provides
    public ListaPedidosMVP.Model providerModel(ListaPedidosIRepository repository){
        return new PedidoModel(repository);
    }

    @Singleton
    @Provides
    public ListaPedidosIRepository provideRepo(ApiRestService apiRestService, com.example.ccruzado.formulario.data.model.mapper.PedidoMapper mapper) {
        return new ListaPedidosRepository(apiRestService,mapper);
    }


}
