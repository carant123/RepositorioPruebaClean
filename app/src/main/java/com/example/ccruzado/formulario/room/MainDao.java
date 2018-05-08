package com.example.ccruzado.formulario.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ccruzado.formulario.data.model.RegistroData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


@Dao
public interface MainDao {

    @Query("SELECT * FROM Registro")
    public List<RegistroData> getUsuarios();
    //public Observable<ArrayList<RegistroData>> getUsuarios();

    @Insert
    public void insert(RegistroData registro);

    @Delete
    public void delete(RegistroData registro);

    @Query("DELETE FROM Registro")
    public void deleteAll();

}