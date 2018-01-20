package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.bumidesa.Modal.Pesan;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mr Abid on 1/17/2018.
 */

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ViewHolder> {
    Context context;
    List<Pesan> listPesan = new ArrayList<>();

    public PesanAdapter(Context context, List<Pesan> listPesan) {
        this.context = context;
        this.listPesan = listPesan;
    }

    @Override
    public PesanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pesan,null));
    }

    @Override
    public void onBindViewHolder(PesanAdapter.ViewHolder holder, int position) {
        final Pesan p = listPesan.get(position);
        holder.nama.setText(""+p.getNama());
        holder.subject.setText(""+p.getSubject());
        holder.tanggal.setText(""+p.getTanggal());
        holder.pesan.setText(""+p.getIsi());
        if(p.isRead()==false){
            holder.unread.setVisibility(View.VISIBLE);
            holder.readed.setVisibility(View.INVISIBLE);
        }else{
            holder.unread.setVisibility(View.INVISIBLE);
            holder.readed.setVisibility(View.VISIBLE);
        }
    }

    public int getItemCount() {
        return listPesan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama,tanggal,subject,pesan;
        ImageView unread;
        Button readed;
        CircleImageView profil;

        public ViewHolder(View itemView) {
            super(itemView);

                nama = (TextView)itemView.findViewById(R.id.tv_nama_list_pesan);
                tanggal = (TextView)itemView.findViewById(R.id.tv_tanggal_list_pesan);
                subject = (TextView)itemView.findViewById(R.id.tv_subject_list_pesan);
                pesan = (TextView)itemView.findViewById(R.id.tv_isi_list_pesan);
                unread = (ImageView) itemView.findViewById(R.id.imgv_read_identifier_list_pesan);
                readed = (Button)itemView.findViewById(R.id.btn_identifier_list_pesan);
                profil = (CircleImageView)itemView.findViewById(R.id.circle_profil_list_pesan);

        }
    }
}


