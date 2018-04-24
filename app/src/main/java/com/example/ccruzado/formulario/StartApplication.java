package com.example.ccruzado.formulario;

import android.app.Application;

import com.example.ccruzado.formulario.di.component.ApplicationComponent;
import com.example.ccruzado.formulario.di.component.DaggerApplicationComponent;
import com.example.ccruzado.formulario.di.module.ApplicationModule;
import com.example.ccruzado.formulario.di.module.ListaDatosModule;
import com.example.ccruzado.formulario.di.module.NetModule;
import com.example.ccruzado.formulario.di.module.RepositoryModule;


/**
 * Created by ccruzado on 14/03/2018.
 */

public class StartApplication extends Application {

    private static StartApplication sInstance;
    private static ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    public static synchronized StartApplication getInstance() {
        return sInstance;
    }


    private void initializeInjector() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .listaDatosModule(new ListaDatosModule())
                .build();

    }

    public static ApplicationComponent getComponent(){
        return appComponent;
    }




}
