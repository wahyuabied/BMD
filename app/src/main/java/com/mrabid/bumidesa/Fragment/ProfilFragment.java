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
import com.mrabid.bumidesa.PesanProfilActivity;
import com.mrabid.bumidesa.R;

public class ProfilFragment extends Fragment {

    RelativeLayout pesan;
    Button edit;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pesan = (RelativeLayout)getActivity().findViewById(R.id.rlt_pesan_profil_fragment);
        edit = (Button)getActivity().findViewById(R.id.btn_edit_email_fragment_profil);

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
