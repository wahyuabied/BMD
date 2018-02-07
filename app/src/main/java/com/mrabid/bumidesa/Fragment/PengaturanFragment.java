package com.mrabid.bumidesa.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mrabid.bumidesa.AboutUsActivity;
import com.mrabid.bumidesa.FaqActivity;
import com.mrabid.bumidesa.Helper.SharedPref;
import com.mrabid.bumidesa.R;
import com.mrabid.bumidesa.SplashScreenActivity;
import com.mrabid.bumidesa.SyaratdanKetentuanActivity;
import com.mrabid.bumidesa.UbahKataSandiActivity;

public class PengaturanFragment extends Fragment {

    RelativeLayout pengaturan,syaratKetentuan,aboutUs,faq;
    LinearLayout logout;
    SharedPref sharedPref;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        pengaturan = (RelativeLayout)getActivity().findViewById(R.id.rlt_kata_sandi_pengaturan_fragment);
        syaratKetentuan = (RelativeLayout)getActivity().findViewById(R.id.rlt_syarat_ketentuan_pengaturan_fragment);
        aboutUs = (RelativeLayout)getActivity().findViewById(R.id.rlt_tentang_kami_pengaturan_fragment);
        faq = (RelativeLayout)getActivity().findViewById(R.id.rlt_faq_pengaturan_fragment);
        logout = (LinearLayout) getActivity().findViewById(R.id.rlt_logout_pengaturan_fragment);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SplashScreenActivity.class));
                sharedPref.saveData("login","");
                sharedPref.saveData("name","");
                getActivity().finish();
            }
        });

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UbahKataSandiActivity.class));
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FaqActivity.class));
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutUsActivity.class));
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
