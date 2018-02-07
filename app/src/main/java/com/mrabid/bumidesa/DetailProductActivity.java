package com.mrabid.bumidesa;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrabid.bumidesa.Adapter.SliderDetailProductAdapter;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class DetailProductActivity extends AppCompatActivity {

    ViewPager viewPager;
    private static final int GALERY_REQUEST1 = 6666;
    private static final int GALERY_REQUEST2 = 6667;
    TextView statusFile1, statusFile2;
    SliderDetailProductAdapter sliderDetailProductAdapter;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    String[] image_resources = new String[3];
    Button chooseFile1, chooseFile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        viewPager = (ViewPager) findViewById(R.id.vp_detail_product_activity);
        sliderDotspanel = (LinearLayout) findViewById(R.id.lnr_detail_product_activity);
        chooseFile1 = (Button) findViewById(R.id.btn_uplaod_gambar1_detail_product_activity);
        chooseFile2 = (Button) findViewById(R.id.btn_uplaod_gambar2_detail_product_activity);
        statusFile1 = (TextView) findViewById(R.id.tv_status_upload_gambar1_detail_product_activity);
        statusFile2 = (TextView) findViewById(R.id.tv_status_upload_gambar2_detail_product_activity);

        chooseFile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK).setType("image/*"), GALERY_REQUEST1);
            }
        });

        chooseFile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK).setType("image/*"), GALERY_REQUEST2);
            }
        });
        setSlider();

    }

    public void setSlider() {
        sliderDetailProductAdapter = new SliderDetailProductAdapter(DetailProductActivity.this, image_resources);
        viewPager.setAdapter(sliderDetailProductAdapter);
        dotscount = sliderDetailProductAdapter.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(DetailProductActivity.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(DetailProductActivity.this.getApplicationContext(), R.drawable.nonactivedot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(DetailProductActivity.this.getApplicationContext(), R.drawable.activedot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(DetailProductActivity.this.getApplicationContext(), R.drawable.nonactivedot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(DetailProductActivity.this.getApplicationContext(), R.drawable.activedot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            if (requestCode == GALERY_REQUEST1 && data != null){

                final Uri Selected_Image_Uri = data.getData();
                final String Selected_Image_Path = GetImagePath_FromUri(Selected_Image_Uri);
                Uri selectedImage = data.getData();
                try {
                    InputStream fileInputStream = getApplicationContext().getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                statusFile1.setText("Ready for Upload");
            }
            else if(requestCode == GALERY_REQUEST2 && data != null) {
                Uri selectedImage = data.getData();
                try {
                    InputStream fileInputStream = getApplicationContext().getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                statusFile1.setText("Ready for Upload");
            }
        }
    }

    private final String GetImagePath_FromUri(Uri uri) {
        final String[] Projection = { MediaStore.Images.Media.DATA };
        final Cursor mCursor = managedQuery(uri, Projection, null, null, null);
        final int column_index = mCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        mCursor.moveToFirst();
        return mCursor.getString(column_index);
    }

}

