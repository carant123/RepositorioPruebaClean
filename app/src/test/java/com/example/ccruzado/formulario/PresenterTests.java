package com.example.ccruzado.formulario;


import android.util.Log;

import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.activity.ListaPedidosActivity;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.PedidoView;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaPedidosPresenter;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.Callable;


import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import rx.android.plugins.RxAndroidSchedulersHook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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


/*
    @Rule
    public RxSchedulersOverrideRule schedulersOverrideRule = new RxSchedulersOverrideRule();
*/


    @Before
    public void setup() {

        testScheduler = new TestScheduler();
        mockModel = mock(ListaPedidosMVP.Model.class);

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

        mockView = mock(ListaPedidosMVP.View.class);
        //mockView = mock(ListaPedidosActivity.class);
        mapper = new PedidoMapper();
        //presenter = new ListaPedidosPresenter(mockModel,mapper,Schedulers.io(), AndroidSchedulers.mainThread());
        presenter = new ListaPedidosPresenter(mockModel,mapper,testScheduler, testScheduler);
        presenter.setView(mockView);
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
    public void verificar_la_interaccion_cuando_llamas_a_la_carga_de_datos2() {

        when(mockModel.obtenerPedidos("Dni")).thenReturn(observable.fromArray(pedidos));
        when(mockView.cantidadPedidos()).thenReturn(3);
        presenter.loadData("Dni");
        verify(mockModel, times(1)).obtenerPedidos("Dni");
        junit.framework.Assert.assertEquals(mockView.cantidadPedidos(),3);

    }




    @Test
    public void verificar_la_interaccion_cuando_llamas_a_la_carga_de_datos() {

        //observable.fromArray(pedidos);
        if(mockModel == null){
            Log.d("data","mockModel null");
        }

        if(testScheduler == null){
            Log.d("data","testScheduler null");
        }

        when(mockModel.obtenerPedidos(Mockito.eq("Dni"))).thenReturn(io.reactivex.Observable.just(pedidos));

        presenter.loadData("Dni");

        //verify model interactions
        verify(mockModel, times(1)).obtenerPedidos("Dni");
        //verify view interactions
        //verify(mockView, times(1)).hideLoading();

/*        when(mockModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        //verify model interactions
        verify(mockModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();*/

    }


}
