package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Barang;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class ListKeranjangAdapter extends RecyclerView.Adapter<ListKeranjangAdapter.ViewHolder> {

    Context context;
    List<Barang> listPesan = new ArrayList<>();

    public ListKeranjangAdapter(Context context, List<Barang> listPesan) {
        this.context = context;
        this.listPesan = listPesan;
    }

    @Override
    public ListKeranjangAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_keranjang,null));
    }

    @Override
    public void onBindViewHolder(final ListKeranjangAdapter.ViewHolder holder, int position) {
        final Barang p = listPesan.get(position);
        holder.jumlah.setText("1");
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ju = holder.jumlah.getText().toString();
                holder.jumlah.setText(Integer.parseInt(ju)+1+"");
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ju = holder.jumlah.getText().toString();
                if(Integer.parseInt(ju)-1<0){
                    holder.jumlah.setText(0+"");
                }else{
                    holder.jumlah.setText(Integer.parseInt(ju)-1+"");
                }

            }
        });


    }

    public int getItemCount() {
        return listPesan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView jumlah;
        ImageView add,remove;

        public ViewHolder(View itemView) {
            super(itemView);

            jumlah = (TextView)itemView.findViewById(R.id.tv_jumlah_list_keranjang);
            add = (ImageView) itemView.findViewById(R.id.img_add_list_keranjang);
            remove = (ImageView) itemView.findViewById(R.id.img_remove_list_keranjang);

        }
    }
}
