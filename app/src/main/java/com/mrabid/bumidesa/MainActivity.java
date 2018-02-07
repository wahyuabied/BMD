package com.mrabid.bumidesa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mrabid.bumidesa.Fragment.HomeFragment;
import com.mrabid.bumidesa.Fragment.PengaturanFragment;
import com.mrabid.bumidesa.Fragment.ProductFragment;
import com.mrabid.bumidesa.Fragment.ProfilFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    BottomBar bottombar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottombar = (BottomBar)findViewById(R.id.bottom_bar);
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            Fragment fragment = null;
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId == R.id.home){
                    fragment = new HomeFragment();
                }else if(tabId == R.id.product){
                    fragment = new ProductFragment();
                }else if(tabId == R.id.profil){
                    fragment = new ProfilFragment();
                }else if(tabId == R.id.lainnya){
                    fragment = new PengaturanFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frm_activity_main,fragment)
                        .commit();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
