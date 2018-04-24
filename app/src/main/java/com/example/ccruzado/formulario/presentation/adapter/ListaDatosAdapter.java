package com.example.ccruzado.formulario.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ccruzado.formulario.R;
import com.example.ccruzado.formulario.presentation.model.RegistroView;

import java.util.ArrayList;


/**
 * Created by Carlos on 24/02/2018.
 */

public class ListaDatosAdapter extends RecyclerView.Adapter<ListaDatosAdapter.AdapterViewHolder> {

    private ArrayList<RegistroView> data;
    private Context context;

    public ListaDatosAdapter(ArrayList<RegistroView> data, Context context) {
        this.data = data;
        this.context = context;
    }

/*    public void setStrings(MultipleResourceView data) {
        this.data = data;
        notifyDataSetChanged();
    }*/


    @Override
    public ListaDatosAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyvleview_item_layout,parent,false);
        return new ListaDatosAdapter.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaDatosAdapter.AdapterViewHolder holder, int position) {
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

        TextView datavalue;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            datavalue = itemView.findViewById(R.id.textViewData);
        }

        public void binHolder(RegistroView data) {
            datavalue.setText("TotalPages: " + data.getNombre());
        }
    }
}

