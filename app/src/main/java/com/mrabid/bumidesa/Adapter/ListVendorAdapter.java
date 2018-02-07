package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Vendor;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class ListVendorAdapter extends RecyclerView.Adapter<ListVendorAdapter.ViewHolder> {

    Context context;
    List<Vendor> listVendor = new ArrayList<>();

    public ListVendorAdapter(Context context, List<Vendor> listVendor) {
        this.context = context;
        this.listVendor = listVendor;
    }

    @Override
    public ListVendorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_vendor,null));
    }

    @Override
    public void onBindViewHolder(final ListVendorAdapter.ViewHolder holder, int position) {
        final Vendor p = listVendor.get(position);
        holder.image.setImageResource(R.drawable.img_contoh);
        holder.nama.setText(p.getNama()+"");
        holder.toko.setText(p.getToko()+"");

    }

    public int getItemCount() {
        return listVendor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView nama,toko;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (CircleImageView) itemView.findViewById(R.id.imgc_list_vendor);
            nama = (TextView)itemView.findViewById(R.id.tv_nama_list_vendor);
            toko =(TextView)itemView.findViewById(R.id.tv_nama_toko_list_vendor);

        }
    }
}
