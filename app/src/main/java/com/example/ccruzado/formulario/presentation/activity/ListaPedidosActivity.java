package com.example.ccruzado.formulario.presentation.activity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.ccruzado.formulario.R;
import com.example.ccruzado.formulario.StartApplication;
import com.example.ccruzado.formulario.presentation.adapter.PedidosAdapter;
import com.example.ccruzado.formulario.presentation.base.BaseActivity;
import com.example.ccruzado.formulario.presentation.interfaces.ListaPedidosMVP;
import com.example.ccruzado.formulario.presentation.model.PedidoView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class ListaPedidosActivity extends BaseActivity implements ListaPedidosMVP.View {

    @BindView(R.id.recycleViewList)
    RecyclerView recycleview;

    @BindView(R.id.progress_recycle_pedidos)
    ProgressBar progress_recycle;

    @BindView(R.id.etDNI)
    EditText etdni;

    @Inject
    ListaPedidosMVP.Presenter presenter;

    private Context mContext;
    private PedidosAdapter listaPedidosAdapter;
    public ArrayList<PedidoView> pedidos = new ArrayList<PedidoView>();
    private static final String TAG = ListaPedidosActivity.class.getSimpleName();


    @Override
    protected int getLayoutId() {
        return R.layout.lista_pedidos_layout;
    }

    @Override
    protected void init() {

        this.mContext = getApplicationContext();
        ((StartApplication) getApplication()).getComponent().inject(this);

        listaPedidosAdapter = new PedidosAdapter(pedidos,mContext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.mContext);
        recycleview.setLayoutManager(linearLayout);
        recycleview.setAdapter(listaPedidosAdapter);

/*        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycleview.getContext(),
                linearLayout.getOrientation());
        recycleview.addItemDecoration(dividerItemDecoration);*/

        etdni.addTextChangedListener(watcherDNI);


    }


    private final TextWatcher watcherDNI = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {

            if(es8CaracteresOllenoDePedidos(s)){
                borrarElementosDeLaListaPedidos();
                if(es8Caracteres(s)){
                    presenter.loadData(etdni.getText().toString());
                }
            }

        }
    };

    private boolean es8CaracteresOllenoDePedidos(Editable s) {
        return s.length() == 8 || !pedidos.isEmpty();
    }

    private boolean es8Caracteres(Editable s) {
        return s.length() == 8;
    }


    @Override
    public void ObtenerPedidosPendientesPorDNI(ArrayList<PedidoView> pedidosRecibidos) {

        for (PedidoView registro : pedidosRecibidos) {
            pedidos.add(registro);
        }

        listaPedidosAdapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String value) {

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
    public int cantidadPedidos() {
        return pedidos.size();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        //presenter.loadData();

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        borrarElementosDeLaListaPedidos();
    }


    private void borrarElementosDeLaListaPedidos() {
        pedidos.clear();
        listaPedidosAdapter.notifyDataSetChanged();
    }





}
