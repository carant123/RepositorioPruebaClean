package com.example.ccruzado.formulario.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ccruzado.formulario.data.model.RegistroData;

@Database(entities = {RegistroData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MainDao mainDao();

}