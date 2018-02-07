package com.mrabid.bumidesa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mrabid.bumidesa.Helper.SharedPref;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    TextView loginDisini;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPref = new SharedPref(SplashScreenActivity.this);

        if (sharedPref.loadData("login").equalsIgnoreCase("berhasil")) {
            startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
            Toast.makeText(SplashScreenActivity.this, "Welcome "+sharedPref.loadData("name"), Toast.LENGTH_SHORT).show();
        }else{

        }


        loginDisini = (TextView)findViewById(R.id.tv_login_disini);

        loginDisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
            }
        });
    }
}