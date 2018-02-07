package com.mrabid.bumidesa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mrabid.bumidesa.Adapter.ListVendorAdapter;
import com.mrabid.bumidesa.Modal.Vendor;

import java.util.ArrayList;

public class VendorActivity extends AppCompatActivity {


    Toolbar toolbar;
    ImageView back;
    ArrayList<Vendor> data = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rcy_vendor_activity);
        back = (ImageView)toolbar.findViewById(R.id.imgv_back_toolbar_vendor);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        DummyData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(VendorActivity.this));
        recyclerView.setAdapter(new ListVendorAdapter(VendorActivity.this, data));
    }

    private void DummyData() {
        for(int i=0;i<5;i++){
            data.add(new Vendor("Wahyu Abid","Toko Mia","Toko Mia"));
        }
    }
}
