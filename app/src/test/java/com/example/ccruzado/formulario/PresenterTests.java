package com.example.ccruzado.formulario;


import android.util.Log;

import com.example.ccruzado.formulario.domain.PedidoModel;
import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.activity.ListaPedidosActivity;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.PedidoView;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaPedidosPresenter;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PresenterTests {

    ListaPedidosMVP.Model mockModel;
    ListaPedidosMVP.View mockView;
    ListaPedidosPresenter presenter;

    PedidoDomain pedido1;
    PedidoDomain pedido2;
    PedidoDomain pedido3;
    PedidoView pedido1view;
    PedidoView pedido2view;
    PedidoView pedido3view;
    ArrayList<PedidoDomain> pedidos;
    ArrayList<PedidoView> pedidosview;
    io.reactivex.Observable<ArrayList<PedidoDomain>> observable;
    PedidoMapper mapper;
    TestScheduler testScheduler;

    @Before
    public void setup() {

        testScheduler = new TestScheduler();
        mockModel = mock(ListaPedidosMVP.Model.class);

        CargaDeInformacion();

        mockView = mock(ListaPedidosMVP.View.class);
        mapper = new PedidoMapper();
        presenter = new ListaPedidosPresenter(mockModel,mapper,testScheduler,testScheduler);
        //presenter = new ListaPedidosPresenter(mockModel,mapper,Schedulers.io(), AndroidSchedulers.mainThread());
        presenter.setView(mockView);

    }

    private void CargaDeInformacion() {

        pedidos = new ArrayList<>();
        pedidosview = new ArrayList<>();

        pedido1 = new PedidoDomain("Sec1","Operacion1","PuntoVenta1");
        pedido2 = new PedidoDomain("Sec2","Operacion2","PuntoVenta2");
        pedido3 = new PedidoDomain("Sec3","Operacion3","PuntoVenta3");

        pedido1view = new PedidoView("Sec1","Operacion1","PuntoVenta1");
        pedido2view = new PedidoView("Sec2","Operacion2","PuntoVenta2");
        pedido3view = new PedidoView("Sec3","Operacion3","PuntoVenta3");

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        pedidosview.add(pedido1view);
        pedidosview.add(pedido2view);
        pedidosview.add(pedido3view);

        observable.fromArray(pedidos);

    }


    @Test
    public void verificar_mockModel_no_es_nulo(){
        assertThat(mockModel, is(IsNull.notNullValue()));
    }

    @Test
    public void verificar_testScheduler_no_es_nulo(){
        assertThat(testScheduler, is(IsNull.notNullValue()));
    }

    @Test
    public void verificar_presenter_no_es_nulo(){
        assertThat(presenter, is(IsNull.notNullValue()));
    }

    @Test
    public void verificar_condicion_no_es_nulo(){
        assertThat(mockModel.obtenerPedidos("Dni").subscribeOn(testScheduler).observeOn(testScheduler), is(IsNull.notNullValue()));
    }


    @Test
    public void verificar_la_interaccion_cuando_llamas_a_la_carga_de_datos() {

        if(mockModel == null){
            Log.d("data","mockModel null");
        }

        if(testScheduler == null){
            Log.d("data","testScheduler null");
        }


        when(mockModel.obtenerPedidos("Dni")
                .subscribeOn(testScheduler).observeOn(testScheduler)).thenReturn(observable);


        //when(mockModel.obtenerPedidos("Dni")).thenReturn(observable);
        presenter.loadData("Dni");
        testScheduler.triggerActions();
        verify(mockModel, times(1)).obtenerPedidos("Dni");

    }


}
