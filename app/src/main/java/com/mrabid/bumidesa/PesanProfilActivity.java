package com.mrabid.bumidesa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mrabid.bumidesa.Adapter.PesanAdapter;
import com.mrabid.bumidesa.Modal.Pesan;

import java.util.ArrayList;

public class PesanProfilActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    ArrayList<Pesan> dataPesan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_profil);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rcy_pesan_profil_activity);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pesan");

        DummyData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(PesanProfilActivity.this));
        recyclerView.setAdapter(new PesanAdapter(PesanProfilActivity.this, dataPesan));

    }

    public void DummyData(){
        for(int i=0;i<5;i++){
            dataPesan.add(new Pesan(i,false,"jajaja","Sutono","30-02-2019,19:00","Pesan Penting","Saya ingin beli mawar hitam 20 batang"));
        }
        dataPesan.add(new Pesan(5,true,"jajaja","Sutono","30-02-2019,19:00","Pesan Penting","Saya ingin beli mawar hitam 20 batang"));
    }

    @Override
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
