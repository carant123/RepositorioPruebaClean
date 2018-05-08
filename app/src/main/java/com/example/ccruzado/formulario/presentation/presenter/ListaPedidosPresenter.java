package com.example.ccruzado.formulario.presentation.presenter;

import com.example.ccruzado.formulario.domain.model.PedidoDomain;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.mapper.PedidoMapper;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ListaPedidosPresenter implements ListaPedidosMVP.Presenter {

    private ListaPedidosMVP.Model model;
    private ListaPedidosMVP.View view;

    private CompositeDisposable compositeDisposable;
    private DisposableObserver disposableObserver;
    private DisposableObserver<ArrayList<PedidoDomain>> disposableObserver_model;
    private Observable<ArrayList<PedidoDomain>> observable;
    private PedidoMapper mapper;


    public ListaPedidosPresenter(ListaPedidosMVP.Model model, PedidoMapper mapper) {
        this.model = model;
        this.mapper = mapper;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadData(String Dni) {
        view.showLoading();

        observable = model.obtenerPedidos(Dni)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        disposableObserver_model = new DisposableObserver<ArrayList<PedidoDomain>>() {

            @Override
            public void onNext(ArrayList<PedidoDomain> listaRegistroDomain) {
                if (view != null) {

                    view.ObtenerPedidosPendientesPorDNI(mapper.reverseMap(listaRegistroDomain));
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
    public void setView(ListaPedidosMVP.View view) {
        this.view = view;
    }



}
