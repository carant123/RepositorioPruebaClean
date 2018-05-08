package com.example.ccruzado.formulario.data.repository;

import android.util.Log;

import com.example.ccruzado.formulario.data.api.ApiRestService;
import com.example.ccruzado.formulario.data.model.PedidoData;
import com.example.ccruzado.formulario.data.model.RegistroData;
import com.example.ccruzado.formulario.data.model.mapper.PedidoMapper;
import com.example.ccruzado.formulario.data.repository.interfaces.ListaPedidosIRepository;
import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class ListaPedidosRepository implements ListaPedidosIRepository{

    ApiRestService apiRestService;

    private ArrayList<PedidoDomain> pedidos;
    private long timestamp;
    private static final long STALE_MS = 10 * 1000; // Data is stale after 20 seconds
    private PedidoMapper pedidoMapper;

    public ListaPedidosRepository(ApiRestService apiRestService, PedidoMapper registroMapper) {
        this.apiRestService = apiRestService;
        this.pedidoMapper = registroMapper;
        pedidos = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }




    @Override
    public Observable<ArrayList<PedidoDomain>> listaDePedidos() {
        return obtenerListaDePedidosDeMemoria().switchIfEmpty(obtenerListaDePedidosDelWebservice());
    }

    @Override
    public Observable<ArrayList<PedidoDomain>> listaDePedidosLocales(String Dni) {

        PedidoDomain data1 = new PedidoDomain();
        data1.setSec("Sec1");
        data1.setOperacion("Operacion1");
        data1.setPuntodeventa("PuntoVenta1");

        PedidoDomain data2 = new PedidoDomain();
        data2.setSec("Sec2");
        data2.setOperacion("Operacion2");
        data2.setPuntodeventa("PuntoVenta2");

        PedidoDomain data3 = new PedidoDomain();
        data3.setSec("Sec3");
        data3.setOperacion("Operacion3");
        data3.setPuntodeventa("PuntoVenta3");

        ArrayList<PedidoDomain> pedidoslocales = new ArrayList<>();
        pedidoslocales.add(data1);
        pedidoslocales.add(data2);
        pedidoslocales.add(data3);

        return Observable.fromArray(pedidoslocales);
    }

    @Override
    public Observable<ArrayList<PedidoDomain>> obtenerListaDePedidosDeMemoria() {
        if (isUpToDate()) {
            //return Observable.fromIterable(registros);
            return Observable.fromArray(pedidos);
        } else {
            timestamp = System.currentTimeMillis();
            pedidos.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<ArrayList<PedidoDomain>> obtenerListaDePedidosDelWebservice() {

        Observable<ArrayList<PedidoDomain>> registrosObservable =
                apiRestService.listPedidos().map(new Function< ArrayList<PedidoData> , ArrayList<PedidoDomain>>() {
                    @Override
                    public ArrayList<PedidoDomain> apply(ArrayList<PedidoData> pedidosData) throws Exception {
                        return pedidoMapper.reverseMap(pedidosData);
                    }
                });


        return registrosObservable.doOnNext(new Consumer<ArrayList<PedidoDomain>>() {
            @Override
            public void accept(ArrayList<PedidoDomain> pedidosDomain) throws Exception {
                //registros.add(registrosDomain);
                Log.d("dataInfo", "cantidad " + pedidosDomain.size());
                pedidos = pedidosDomain;
            }
        });

    }


}
