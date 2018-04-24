package com.example.ccruzado.formulario.presentation.interfaces;

import com.example.ccruzado.formulario.domain.model.RegistroDomain;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 23/04/2018.
 */

public interface ListaDatosMVP {

    interface View {

        void ObtenerInformacionDeRegistros(ArrayList<RegistroView> registros);
        void Error(String value);
        void showLoading();
        void hideLoading();
    }

    interface Presenter{

        void loadData();
        void rxUnsubscribe();
        void setView(ListaDatosMVP.View view);
    }

    interface Model{
        Observable<ArrayList<RegistroDomain>> registros();
    }


}
