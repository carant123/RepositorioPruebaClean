package com.example.ccruzado.formulario.data.model.mapper;


import com.example.ccruzado.formulario.data.model.RegistroData;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ccruzado on 21/03/2018.
 */

public class RegistroMapper extends Mapper<ArrayList<RegistroDomain>,ArrayList<RegistroData>> {

    @Inject
    public RegistroMapper() {
    }

    @Override
    public ArrayList<RegistroData> map(ArrayList<RegistroDomain> values) {

        RegistroData registroView;
        ArrayList<RegistroData> returnValues = new ArrayList<>(values.size());
        for (RegistroDomain value : values) {

            registroView = new RegistroData();
            registroView.setId(value.getId());
            registroView.setNombre(value.getNombre());
            registroView.setNumero(value.getNumero());
            returnValues.add(registroView);

        }
        return returnValues;

    }


    @Override
    public ArrayList<RegistroDomain> reverseMap(ArrayList<RegistroData> values) {

        RegistroDomain registroView;
        ArrayList<RegistroDomain> returnValues = new ArrayList<>(values.size());
        for (RegistroData value : values) {

            registroView = new RegistroDomain();
            registroView.setId(value.getId());
            registroView.setNombre(value.getNombre());
            registroView.setNumero(value.getNumero());
            returnValues.add(registroView);

        }
        return returnValues;

    }




/*    @Inject
    public RegistroMapper() {
    }

    @Override
    public RegistroData map(RegistroDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RegistroDomain reverseMap(RegistroData value) {

        RegistroDomain resgistroDomain = new RegistroDomain();
        resgistroDomain.setId(value.getId());
        resgistroDomain.setNombre(value.getNombre());
        resgistroDomain.setNumero(value.getNumero());

        return resgistroDomain;
    }*/

}
