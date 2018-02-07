package com.mrabid.bumidesa;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrabid.bumidesa.Adapter.ListProductAdapter;
import com.mrabid.bumidesa.Modal.Product;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    ArrayList<Product> data = new ArrayList<>();
    TextView filter,sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rcy_product_activity);
        sort = (TextView)findViewById(R.id.sort);
        filter = (TextView)findViewById(R.id.filter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setTitle("Nama yang dicari");

        DummyData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(ListProductActivity.this,2));
        recyclerView.setAdapter(new ListProductAdapter(ListProductActivity.this, data));


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ListProductActivity.this);
                dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_filter);
                dialog.setCanceledOnTouchOutside(false);

                toolbar = (Toolbar)dialog.findViewById(R.id.toolbar);

                TextView nameDialog = (TextView)toolbar.findViewById(R.id.tv_nama_dialog);
                nameDialog.setText("Filter");
                ImageView close = (ImageView)toolbar.findViewById(R.id.imgv_close);
                LinearLayout lHigh = (LinearLayout)dialog.findViewById(R.id.lnr_lokasi_dialog_sort);
                LinearLayout lLow = (LinearLayout)dialog.findViewById(R.id.lnr_rating_dialog_sort);
                final CheckBox highest = (CheckBox)dialog.findViewById(R.id.cb_lokasi_dialog_sort);
                final CheckBox lowest = (CheckBox)dialog.findViewById(R.id.cb_rating_dialog_sort);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                lHigh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(lowest.isChecked()){
                            highest.toggle();
                            lowest.toggle();
                        }else{
                            highest.toggle();
                        }

                    }
                });
                lLow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(highest.isChecked()){
                            lowest.toggle();
                            highest.toggle();
                        }else{
                            lowest.toggle();
                        }
                    }
                });
                dialog.show();

            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ListProductActivity.this);
                dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sort);
                dialog.setCanceledOnTouchOutside(false);

                toolbar = (Toolbar)dialog.findViewById(R.id.toolbar);

                TextView nameDialog = (TextView)toolbar.findViewById(R.id.tv_nama_dialog);
                nameDialog.setText("Sort");
                ImageView close = (ImageView)toolbar.findViewById(R.id.imgv_close);
                LinearLayout lHigh = (LinearLayout)dialog.findViewById(R.id.lnr_highest_price_dialog_sort);
                LinearLayout lLow = (LinearLayout)dialog.findViewById(R.id.lnr_lowest_price_dialog_sort);
                final CheckBox highest = (CheckBox)dialog.findViewById(R.id.cb_highest_price_dialog_sort);
                final CheckBox lowest = (CheckBox)dialog.findViewById(R.id.cb_lowest_price_dialog_sort);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                lHigh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(lowest.isChecked()){
                            highest.toggle();
                            lowest.toggle();
                        }else{
                            highest.toggle();
                        }

                    }
                });
                lLow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(highest.isChecked()){
                            lowest.toggle();
                            highest.toggle();
                        }else{
                            lowest.toggle();
                        }
                    }
                });
                dialog.show();

            }
        });
    }
    private void DummyData() {

        for(int i=0;i<7;i++){
            data.add(new Product("image","Bunga mawar kuning","350000",3,"Grace flower store"));
        }
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
