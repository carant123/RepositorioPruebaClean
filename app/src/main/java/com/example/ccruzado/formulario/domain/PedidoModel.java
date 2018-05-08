package com.example.ccruzado.formulario.domain;

import com.example.ccruzado.formulario.data.repository.interfaces.ListaPedidosIRepository;
import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;

import java.util.ArrayList;

import io.reactivex.Observable;

public class PedidoModel implements ListaPedidosMVP.Model {

    private ListaPedidosIRepository repositorio;


    public PedidoModel(ListaPedidosIRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Observable<ArrayList<PedidoDomain>> obtenerPedidos(String dni) {
        return repositorio.listaDePedidosLocales(dni);
    }



}
