package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Whislist;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class ListWhislistAdapter extends RecyclerView.Adapter<ListWhislistAdapter.ViewHolder> {

    Context context;
    List<Whislist> listWhislist = new ArrayList<>();

    public ListWhislistAdapter(Context context, List<Whislist> listWhislist) {
        this.context = context;
        this.listWhislist = listWhislist;
    }

    @Override
    public ListWhislistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_whislist,null));
    }

    @Override
    public void onBindViewHolder(final ListWhislistAdapter.ViewHolder holder, int position) {
        final Whislist p = listWhislist.get(position);
        holder.image.setImageResource(R.drawable.img_flower);
        holder.nama.setText(p.getName()+"");
        holder.harga.setText("Rp"+p.getHarga()+"");
        holder.toko.setText(p.getToko()+"");
        holder.ratingBar.setRating(p.getRating());
        holder.ratingBar.setNumStars((int) p.getRating());

    }

    public int getItemCount() {
        return listWhislist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nama,harga,toko;
        RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.img_whislist);
            nama = (TextView)itemView.findViewById(R.id.tv_name_whislist_list_whislist);
            harga = (TextView)itemView.findViewById(R.id.tv_price_whislist_list_whislist);
            toko =(TextView)itemView.findViewById(R.id.tv_nama_toko_list_whislist);
            ratingBar = (RatingBar)itemView.findViewById(R.id.rating_list_whislist);

        }
    }
}
