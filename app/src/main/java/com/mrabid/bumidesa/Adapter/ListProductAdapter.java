package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Product;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {

    Context context;
    List<Product> listProduct = new ArrayList<>();

    public ListProductAdapter(Context context, List<Product> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @Override
    public ListProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_product,null));
    }

    @Override
    public void onBindViewHolder(final ListProductAdapter.ViewHolder holder, int position) {
        final Product p = listProduct.get(position);
        holder.image.setImageResource(R.drawable.img_background_slider);
        holder.nama.setText(p.getName()+"");
        holder.harga.setText("Rp"+p.getHarga()+"");
        holder.toko.setText(p.getToko()+"");
        holder.ratingBar.setRating(p.getRating());
        holder.ratingBar.setNumStars((int) p.getRating());

    }

    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nama,harga,toko;
        RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.img_product);
            nama = (TextView)itemView.findViewById(R.id.tv_name_product_list_product);
            harga = (TextView)itemView.findViewById(R.id.tv_price_product_list_product);
            toko =(TextView)itemView.findViewById(R.id.tv_nama_toko_list_product);
            ratingBar = (RatingBar)itemView.findViewById(R.id.rating_list_product);

        }
    }
}
