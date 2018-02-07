package com.mrabid.bumidesa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mrabid.bumidesa.Adapter.ListTransaksiAdapter;
import com.mrabid.bumidesa.Modal.Transaksi;

import java.util.ArrayList;

public class TransaksiActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Transaksi> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rcy_transaksi_activity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setTitle("List Transaksi");

        DummyData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(TransaksiActivity.this));
        recyclerView.setAdapter(new ListTransaksiAdapter(TransaksiActivity.this, data));

    }

    private void DummyData() {
        data.add(new Transaksi("Mia","Bunga Raflesia","12-Dec-2017","415000","1","Waiting Complete Payment"));

        for(int i =0;i<4;i++){
            data.add(new Transaksi("Mia","Bunga Raflesia","12-Dec-2017","415000","1","Complete"));
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
