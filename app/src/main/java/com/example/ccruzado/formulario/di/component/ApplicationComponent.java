package com.example.ccruzado.formulario.di.component;


import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.di.module.ApplicationModule;
import com.example.ccruzado.formulario.di.module.ListaDatosModule;
import com.example.ccruzado.formulario.di.module.ListaPedidosModule;
import com.example.ccruzado.formulario.di.module.NetModule;
import com.example.ccruzado.formulario.di.module.RepositoryModule;
import com.example.ccruzado.formulario.presentation.activity.ListaDatosActivity;
import com.example.ccruzado.formulario.presentation.activity.ListaPedidosActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ccruzado on 14/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class,
        NetModule.class,
        RepositoryModule.class,
        ListaDatosModule.class,
        ListaPedidosModule.class})
public interface ApplicationComponent {


    void inject(ListaDatosActivity listaDatosActivity);

    void inject(ListaPedidosActivity listaPedidosActivity);

    ApiRestService getApiService();
}
