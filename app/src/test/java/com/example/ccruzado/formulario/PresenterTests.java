package com.example.ccruzado.formulario;


import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.PedidoView;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.presentation.presenter.ListaPedidosPresenter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterTests {

    ListaPedidosMVP.Model mockModel;
    ListaPedidosMVP.View mockView;
    ListaPedidosPresenter presenter;
    PedidoView pedido1;
    PedidoView pedido2;
    PedidoView pedido3;
    ArrayList<PedidoView> pedidos;
    PedidoMapper mapper;

    @Before
    public void setup() {

        mockModel = mock(ListaPedidosMVP.Model.class);

        pedidos = new ArrayList<>();

        pedido1 = new PedidoView("Sec1","Operacion1","PuntoVenta1");
        pedido2 = new PedidoView("Sec2","Operacion2","PuntoVenta2");
        pedido3 = new PedidoView("Sec3","Operacion3","PuntoVenta3");

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        mockView = mock(ListaPedidosMVP.View.class);
        mapper = new PedidoMapper();
        presenter = new ListaPedidosPresenter(mockModel,mapper);
        presenter.setView(mockView);

    }


    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {


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
