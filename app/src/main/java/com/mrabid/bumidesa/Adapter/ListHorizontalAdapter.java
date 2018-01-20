package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mrabid.bumidesa.DetailProductActivity;
import com.mrabid.bumidesa.Modal.Barang;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 1/16/2018.
 */

public class ListHorizontalAdapter extends RecyclerView.Adapter<ListHorizontalAdapter.ViewHolder> {
    Context context;
    List<Barang> listBarang = new ArrayList<>();

    public ListHorizontalAdapter(Context context, List<Barang> listBarang) {
        this.context = context;
        this.listBarang = listBarang;
    }

    @Override
    public ListHorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_horizontal_home,null));
    }

    @Override
    public void onBindViewHolder(ListHorizontalAdapter.ViewHolder holder, int position) {
        final Barang p = listBarang.get(position);
        holder.nama.setText(""+p.getNama());
        holder.harga.setText(""+p.getHarga());
        holder.rating.setRating(Float.parseFloat(p.getRating()+""));
        holder.image.setImageResource(R.drawable.img_flower);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailProductActivity.class));
            }
        });
    }

    public int getItemCount() {
        return listBarang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        

        TextView nama,harga;
        RatingBar rating;
        LinearLayout linear;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.tv_nama_list_horizontal_home);
            harga = (TextView)itemView.findViewById(R.id.tv_harga_list_horizontal_home);
            rating = (RatingBar)itemView.findViewById(R.id.rb_rating_list_horizontal_home);
            linear = (LinearLayout)itemView.findViewById(R.id.lnr_list_horizontal_home);
            image = (ImageView)itemView.findViewById(R.id.imgv_list_horizontal_home);

        }
    }
}

