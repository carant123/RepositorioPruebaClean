package com.example.ccruzado.formulario.data.repository.interfaces;

import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface ListaPedidosIRepository {

    Observable<ArrayList<PedidoDomain>> listaDePedidos();

    Observable<ArrayList<PedidoDomain>> listaDePedidosLocales(String dni);

    Observable<ArrayList<PedidoDomain>> obtenerListaDePedidosDeMemoria();

    Observable<ArrayList<PedidoDomain>> obtenerListaDePedidosDelWebservice();


}
