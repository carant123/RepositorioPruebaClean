package com.example.ccruzado.formulario.di.module;

import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.data.repository.ListaPedidosRepository;
import com.example.ccruzado.formulario.data.repository.interfaces.ListaPedidosIRepository;
import com.example.ccruzado.formulario.domain.PedidoModel;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaPedidosPresenter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class ListaPedidosModule {

    @Provides
    public ListaPedidosMVP.Presenter providerPresenter(ListaPedidosMVP.Model model,
                                                       PedidoMapper mapper,
                                                       @Named("executor_thread") Scheduler backgroundScheduler,
                                                       @Named("ui_thread") Scheduler mainScheduler){

        return new ListaPedidosPresenter(model, mapper, backgroundScheduler, mainScheduler);
    }

    @Provides
    public ListaPedidosMVP.Model providerModel(ListaPedidosIRepository repository){
        return new PedidoModel(repository);
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }


    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }


    @Singleton
    @Provides
    public ListaPedidosIRepository provideRepo(ApiRestService apiRestService, com.example.ccruzado.formulario.data.model.mapper.PedidoMapper mapper) {
        return new ListaPedidosRepository(apiRestService,mapper);
    }


}
