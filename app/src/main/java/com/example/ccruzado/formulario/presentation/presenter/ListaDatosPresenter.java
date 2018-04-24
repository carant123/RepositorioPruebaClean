package com.example.ccruzado.formulario.presentation.presenter;

import com.example.ccruzado.formulario.domain.model.RegistroDomain;
import com.example.ccruzado.formulario.presentation.interfaces.ListaDatosMVP;
import com.example.ccruzado.formulario.presentation.model.mapper.RegistroMapper;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ccruzado on 23/04/2018.
 */

public class ListaDatosPresenter implements ListaDatosMVP.Presenter {

    private ListaDatosMVP.Model model;
    private ListaDatosMVP.View view;

    private CompositeDisposable compositeDisposable;
    private DisposableObserver disposableObserver;
    private DisposableObserver<ArrayList<RegistroDomain>> disposableObserver_model;
    private Observable<ArrayList<RegistroDomain>> observable;
    private RegistroMapper mapper;

    public ListaDatosPresenter(ListaDatosMVP.Model model, RegistroMapper mapper) {
        this.model = model;
        this.mapper = mapper;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadData() {

        view.showLoading();

        observable = model.registros()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        disposableObserver_model = new DisposableObserver<ArrayList<RegistroDomain>>() {

            @Override
            public void onNext(ArrayList<RegistroDomain> listaRegistroDomain) {
                if (view != null) {

                    view.ObtenerInformacionDeRegistros(mapper.reverseMap(listaRegistroDomain));
                    view.hideLoading();
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (view != null) {
                    view.Error("No hay valores");
                    view.hideLoading();
                }
            }

            @Override
            public void onComplete() {

            }
        };

        disposableObserver = observable.subscribeWith(disposableObserver_model);
        compositeDisposable.add(disposableObserver);




    }

    @Override
    public void rxUnsubscribe() {

        if (!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }

    }

    @Override
    public void setView(ListaDatosMVP.View view) {
        this.view = view;
    }




}
