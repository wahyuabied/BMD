package com.mrabid.bumidesa.Adapter;

/**
 * Created by Mr Abid on 1/16/2018.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.BanyakBarang;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 1/16/2018.
 */

public class ListVerticalAdapter extends RecyclerView.Adapter<ListVerticalAdapter.ViewHolder> {
    Context context;
    List<BanyakBarang> listBarang = new ArrayList<>();
    RecyclerView horizontalList;

    public ListVerticalAdapter(Context context, List<BanyakBarang> listBarang) {
        this.context = context;
        this.listBarang = listBarang;
    }

    @Override
    public ListVerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_vertical_home,null));
    }

    @Override
    public void onBindViewHolder(ListVerticalAdapter.ViewHolder holder, int position) {
        final String kategori_adapter = listBarang.get(position).getKategori();
        ArrayList banyakBarang = listBarang.get(position).getDataBarang();

        holder.kategori.setText(""+kategori_adapter);

        ListHorizontalAdapter listHorizontalAdapter = new ListHorizontalAdapter(context,banyakBarang);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(listHorizontalAdapter);

    }

    public int getItemCount() {
        return listBarang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView kategori;
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            kategori = (TextView)itemView.findViewById(R.id.tv_kategori_barang_list_vertical_home);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.rcy_list_vertical_home);

        }
    }
}


