package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Transaksi;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class ListTransaksiAdapter extends RecyclerView.Adapter<ListTransaksiAdapter.ViewHolder> {

    Context context;
    List<Transaksi> listTransaksi = new ArrayList<>();

    public ListTransaksiAdapter(Context context, List<Transaksi> listTransaksi) {
        this.context = context;
        this.listTransaksi = listTransaksi;
    }

    @Override
    public ListTransaksiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_transaksi,null));
    }

    @Override
    public void onBindViewHolder(final ListTransaksiAdapter.ViewHolder holder, int position) {
        final Transaksi p = listTransaksi.get(position);
        holder.tanggal.setText(p.getDate()+"");
        holder.nama.setText(p.getName()+"");
        holder.harga.setText("Rp."+p.getHarga()+"");
        holder.jumlah.setText("Jumlah barang "+p.getJumlah());
        if(p.getStatus().toString().equalsIgnoreCase("Waiting Complete Payment")){
            holder.status.setTextColor(context.getResources().getColor(R.color.colorSplash));
        }else{
            holder.status.setTextColor(context.getResources().getColor(R.color.colorButtonSplash));
        }
        holder.status.setText(p.getStatus()+"");


    }

    public int getItemCount() {
        return listTransaksi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView jumlah,nama,tanggal,harga,status;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            tanggal = (TextView)itemView.findViewById(R.id.tv_tanggal_list_transaksi);
            harga = (TextView)itemView.findViewById(R.id.tv_harga_list_transaksi);
            status =  (TextView)itemView.findViewById(R.id.tv_status_list_transaksi);
            nama = (TextView)itemView.findViewById(R.id.tv_nama_list_transaksi);
            jumlah = (TextView)itemView.findViewById(R.id.tv_jumlah_list_transaksi);
            image = (ImageView) itemView.findViewById(R.id.imgv_list_transaksi);

        }
    }
}
