package com.mrabid.bumidesa.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.mrabid.bumidesa.EditDetailProfilActivity;
import com.mrabid.bumidesa.KeranjangActivity;
import com.mrabid.bumidesa.PesanProfilActivity;
import com.mrabid.bumidesa.R;
import com.mrabid.bumidesa.TransaksiActivity;
import com.mrabid.bumidesa.VendorActivity;
import com.mrabid.bumidesa.WhislistActivity;

public class ProfilFragment extends Fragment {

    RelativeLayout pesan,keranjang,whislist,vendor,transaksi;
    Button edit;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pesan = (RelativeLayout)getActivity().findViewById(R.id.rlt_pesan_profil_fragment);
        edit = (Button)getActivity().findViewById(R.id.btn_edit_email_fragment_profil);
        keranjang =(RelativeLayout)getActivity().findViewById(R.id.rlt_keranjang_belanja_profil_fragment);
        whislist = (RelativeLayout)getActivity().findViewById(R.id.rlt_whislist_profil_fragment);
        vendor = (RelativeLayout)getActivity().findViewById(R.id.rlt_list_vendor_profil_fragment);
        transaksi = (RelativeLayout)getActivity().findViewById(R.id.rlt_list_transaksi_profil_fragment);

        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Out(KeranjangActivity.class);
            }
        });
        vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Out(VendorActivity.class);
            }
        });
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Out(TransaksiActivity.class);
            }
        });
        whislist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Out(WhislistActivity.class);
            }
        });
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Out(PesanProfilActivity.class);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Out(EditDetailProfilActivity.class);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }


    public void Out(Class x){
        startActivity(new Intent(getActivity(),x));
    }
}
