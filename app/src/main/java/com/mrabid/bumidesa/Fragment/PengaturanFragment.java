package com.mrabid.bumidesa.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mrabid.bumidesa.R;
import com.mrabid.bumidesa.SyaratdanKetentuanActivity;
import com.mrabid.bumidesa.UbahKataSandiActivity;

public class PengaturanFragment extends Fragment {

    RelativeLayout pengaturan,syaratKetentuan;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pengaturan = (RelativeLayout)getActivity().findViewById(R.id.rlt_kata_sandi_pengaturan_fragment);
        syaratKetentuan = (RelativeLayout)getActivity().findViewById(R.id.rlt_syarat_ketentuan_pengaturan_fragment);

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UbahKataSandiActivity.class));
            }
        });

        syaratKetentuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SyaratdanKetentuanActivity.class));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pengaturan, container, false);
    }
}
