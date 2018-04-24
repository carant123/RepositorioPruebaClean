package com.example.ccruzado.formulario.presentation.model.mapper;


import com.example.ccruzado.formulario.data.model.mapper.Mapper;
import com.example.ccruzado.formulario.domain.model.RegistroDomain;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ccruzado on 21/03/2018.
 */

public class RegistroMapper extends Mapper<ArrayList<RegistroView>,ArrayList<RegistroDomain>> {






    @Inject
    public RegistroMapper() {

    }

    @Override
    public ArrayList<RegistroDomain> map(ArrayList<RegistroView> values) {

        RegistroDomain registroView;
        ArrayList<RegistroDomain> returnValues = new ArrayList<>(values.size());
        for (RegistroView value : values) {

            registroView = new RegistroDomain();
            registroView.setId(value.getId());
            registroView.setNombre(value.getNombre());
            registroView.setNumero(value.getNumero());
            returnValues.add(registroView);

        }
        return returnValues;

    }

    @Override
    public ArrayList<RegistroView> reverseMap(ArrayList<RegistroDomain> values) {

        RegistroView registroView;
        ArrayList<RegistroView> returnValues = new ArrayList<>(values.size());
        for (RegistroDomain value : values) {

            registroView = new RegistroView();
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
    public RegistroDomain map(RegistroView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RegistroView reverseMap(RegistroDomain value) {

        RegistroView multipleResourceView = new RegistroView();
        multipleResourceView.setId(value.getId());
        multipleResourceView.setNombre(value.getNombre());
        multipleResourceView.setNumero(value.getNumero());

        return multipleResourceView;
    }*/



}
