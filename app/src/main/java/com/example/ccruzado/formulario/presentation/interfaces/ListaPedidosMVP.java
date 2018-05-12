package com.example.ccruzado.formulario.presentation.interfaces;

import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.model.PedidoView;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface ListaPedidosMVP {

    interface View {

        void ObtenerPedidosPendientesPorDNI(ArrayList<PedidoView> pedidos);
        void Error(String value);
        void showLoading();
        void hideLoading();
        int cantidadPedidos();
    }

    interface Presenter {

        void loadData(String dni);
        void rxUnsubscribe();
        void setView(ListaPedidosMVP.View view);
    }

    interface Model {
        Observable<ArrayList<PedidoDomain>> obtenerPedidos(String Dni);
    }


}
