package com.example.ccruzado.formulario.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ccruzado.formulario.R;
import com.example.ccruzado.formulario.presentation.model.PedidoView;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosAdapter.AdapterViewHolder> {

    private ArrayList<PedidoView> data;
    private Context context;

    public PedidosAdapter(ArrayList<PedidoView> data, Context context) {
        this.data = data;
        this.context = context;
    }

/*    public void setStrings(MultipleResourceView data) {
        this.data = data;
        notifyDataSetChanged();
    }*/


    @Override
    public PedidosAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingresar_dni_item_layout,parent,false);
        return new PedidosAdapter.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PedidosAdapter.AdapterViewHolder holder, int position) {
        holder.binHolder(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void clearItem () {
        data = null;
        notifyDataSetChanged();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        TextView sec;
        TextView operacion;
        TextView puntodeventa;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            sec = itemView.findViewById(R.id.tvSec);
            operacion = itemView.findViewById(R.id.tvOperacion);
            puntodeventa = itemView.findViewById(R.id.tvPuntoDeVenta);
        }

        public void binHolder(PedidoView data) {
            sec.setText("SEC: " + data.getSec());
            operacion.setText("Operacion: " + data.getOperacion());
            puntodeventa.setText("Punto de Venta: " + data.getPuntodeventa());
        }
    }
}
