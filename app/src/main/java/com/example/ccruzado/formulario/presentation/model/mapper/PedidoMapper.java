package com.example.ccruzado.formulario.presentation.model.mapper;

import com.example.ccruzado.formulario.data.model.PedidoData;
import com.example.ccruzado.formulario.data.model.mapper.Mapper;
import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.model.PedidoView;

import java.util.ArrayList;

import javax.inject.Inject;

public class PedidoMapper extends Mapper<ArrayList<PedidoView>,ArrayList<PedidoDomain>> {

    @Inject
    public PedidoMapper() {
    }

    @Override
    public ArrayList<PedidoDomain> map(ArrayList<PedidoView> values) {

        PedidoDomain pedidoDomain;
        ArrayList<PedidoDomain> returnValues = new ArrayList<>(values.size());
        for (PedidoView value : values) {

            pedidoDomain = new PedidoDomain();
            pedidoDomain.setSec(value.getSec());
            pedidoDomain.setOperacion(value.getOperacion());
            pedidoDomain.setPuntodeventa(value.getPuntodeventa());
            returnValues.add(pedidoDomain);

        }
        return returnValues;

    }


    @Override
    public ArrayList<PedidoView> reverseMap(ArrayList<PedidoDomain> values) {

        PedidoView pedidoView;
        ArrayList<PedidoView> returnValues = new ArrayList<>(values.size());
        for (PedidoDomain value : values) {

            pedidoView = new PedidoView();
            pedidoView.setSec(value.getSec());
            pedidoView.setOperacion(value.getOperacion());
            pedidoView.setPuntodeventa(value.getPuntodeventa());
            returnValues.add(pedidoView);

        }
        return returnValues;

    }

}
