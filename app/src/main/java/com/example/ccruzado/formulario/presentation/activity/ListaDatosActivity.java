package com.example.ccruzado.formulario.presentation.activity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ccruzado.formulario.R;
import com.example.ccruzado.formulario.StartApplication;
import com.example.ccruzado.formulario.presentation.adapter.ListaDatosAdapter;
import com.example.ccruzado.formulario.presentation.base.BaseActivity;
import com.example.ccruzado.formulario.presentation.interfaces.ListaDatosMVP;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ccruzado on 23/04/2018.
 */

public class ListaDatosActivity extends BaseActivity implements ListaDatosMVP.View{


    @BindView(R.id.recycleViewList) RecyclerView recycleview;

    @BindView(R.id.progress_recycle) ProgressBar progress_recycle;

    @Inject
    ListaDatosMVP.Presenter presenter;

    private Context mContext;
    private ListaDatosAdapter listaDatosAdapter;
    private ArrayList<RegistroView> registros = new ArrayList<RegistroView>();
    private static final String TAG = ListaDatosActivity.class.getSimpleName();



    @Override
    protected int getLayoutId() {
        return R.layout.recycleview_layout;
    }

    @Override
    protected void init() {

        this.mContext = getApplicationContext();
        ((StartApplication) getApplication()).getComponent().inject(this);

        listaDatosAdapter = new ListaDatosAdapter(registros,mContext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.mContext);
        recycleview.setLayoutManager(linearLayout);
        recycleview.setAdapter(listaDatosAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycleview.getContext(),
                linearLayout.getOrientation());
        recycleview.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void ObtenerInformacionDeRegistros(ArrayList<RegistroView> registrosRecibidos) {
        registros = registrosRecibidos;
        listaDatosAdapter.notifyItemInserted(registros.size() - 1);
    }

    @Override
    public void Error(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT);
    }

    @Override
    public void showLoading() {
        recycleview.setVisibility(View.GONE);
        progress_recycle.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        recycleview.setVisibility(View.VISIBLE);
        progress_recycle.setVisibility(View.GONE);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        registros.clear();
        listaDatosAdapter.notifyDataSetChanged();
    }
}
