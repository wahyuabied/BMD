package com.mrabid.bumidesa.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mrabid.bumidesa.Adapter.ListProductAdapter;
import com.mrabid.bumidesa.ListProductActivity;
import com.mrabid.bumidesa.Modal.Product;
import com.mrabid.bumidesa.R;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Product> data = new ArrayList<>();
    Toolbar toolbar;
    EditText searchE;
    TextView search,cancel;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.rcy_list_product);
        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        searchE = (EditText)toolbar.findViewById(R.id.edt_search_toolbar_product);
        search =  (TextView) toolbar.findViewById(R.id.tv_search_toolbar_product);
        cancel =  (TextView) toolbar.findViewById(R.id.tv_cancel_toolbar_product);

        searchE.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    search.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.INVISIBLE);
                }else{
                    search.setVisibility(View.INVISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ListProductActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchE.clearFocus();searchE.setFocusable(false);
            }
        });

        DummyData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(new ListProductAdapter(getActivity(), data));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    private void DummyData() {

        for(int i=0;i<7;i++){
            data.add(new Product("image","Bunga mawar kuning","350000",3,"Grace flower store"));
        }
    }
}
