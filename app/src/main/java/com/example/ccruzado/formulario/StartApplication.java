package com.example.ccruzado.formulario;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.ccruzado.formulario.data.model.RegistroData;
import com.example.ccruzado.formulario.di.component.ApplicationComponent;
import com.example.ccruzado.formulario.di.component.DaggerApplicationComponent;
import com.example.ccruzado.formulario.di.module.ApplicationModule;
import com.example.ccruzado.formulario.di.module.ListaDatosModule;
import com.example.ccruzado.formulario.di.module.NetModule;
import com.example.ccruzado.formulario.di.module.RepositoryModule;
import com.example.ccruzado.formulario.room.AppDatabase;


/**
 * Created by ccruzado on 14/03/2018.
 */

public class StartApplication extends Application {

    private static StartApplication sInstance;
    private static ApplicationComponent appComponent;

    private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        initializeDatabaseRoom();
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

    private void initializeDatabaseRoom(){

/*        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "MainDatabase")
                .build();

        db.mainDao().deleteAll();

        RegistroData data = new RegistroData();
        data.setNombre("Carlos");
        data.setNumero(123);

        db.mainDao().insert(data);
        db.mainDao().insert(data);*/


    }

    public AppDatabase Database(){
        return db;
    }

    public static ApplicationComponent getComponent(){
        return appComponent;
    }




}
