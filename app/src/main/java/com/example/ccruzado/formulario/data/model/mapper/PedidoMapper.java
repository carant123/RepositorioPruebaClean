package com.example.ccruzado.formulario.data.model.mapper;

import com.example.ccruzado.formulario.data.model.PedidoData;
import com.example.ccruzado.formulario.domain.model.PedidoDomain;

import java.util.ArrayList;

import javax.inject.Inject;

public class PedidoMapper extends Mapper<ArrayList<PedidoDomain>,ArrayList<PedidoData>> {

    @Inject
    public PedidoMapper() {
    }

    @Override
    public ArrayList<PedidoData> map(ArrayList<PedidoDomain> values) {

        PedidoData pedidoData;
        ArrayList<PedidoData> returnValues = new ArrayList<>(values.size());
        for (PedidoDomain value : values) {

            pedidoData = new PedidoData();
            pedidoData.setSec(value.getSec());
            pedidoData.setOperacion(value.getOperacion());
            pedidoData.setPuntodeventa(value.getPuntodeventa());
            returnValues.add(pedidoData);

        }
        return returnValues;

    }


    @Override
    public ArrayList<PedidoDomain> reverseMap(ArrayList<PedidoData> values) {

        PedidoDomain pedidoDomain;
        ArrayList<PedidoDomain> returnValues = new ArrayList<>(values.size());
        for (PedidoData value : values) {

            pedidoDomain = new PedidoDomain();
            pedidoDomain.setSec(value.getSec());
            pedidoDomain.setOperacion(value.getOperacion());
            pedidoDomain.setPuntodeventa(value.getPuntodeventa());
            returnValues.add(pedidoDomain);

        }
        return returnValues;

    }

}
