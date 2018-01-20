package com.mrabid.bumidesa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrabid.bumidesa.Adapter.ListVerticalAdapter;
import com.mrabid.bumidesa.Modal.BanyakBarang;
import com.mrabid.bumidesa.Modal.Barang;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<BanyakBarang> data = new ArrayList<>();
    Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView)getActivity().findViewById(R.id.rcy_vertical_home_fragment);
        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        createDummyData();


        recyclerView.setHasFixedSize(true);
        ListVerticalAdapter adapter = new ListVerticalAdapter(getActivity(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            BanyakBarang dm = new BanyakBarang();
            dm.setKategori("Section"+i);
            ArrayList<Barang> singleItem = new ArrayList<Barang>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new Barang(1,"image","Bunga","Mawar Mia","10.000",3));
            }
            dm.setDataBarang(singleItem);
            data.add(dm);
        }
    }
}