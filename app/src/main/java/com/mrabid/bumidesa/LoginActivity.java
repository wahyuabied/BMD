package com.mrabid.bumidesa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mrabid.bumidesa.Helper.SharedPref;
import com.mrabid.bumidesa.Helper.Url;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView lupaPassword,daftar;
    EditText email,password;
    Button login;
    JSONObject jObject ;
    ProgressDialog progressDialog;
    String status,message,hash;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        sharedPref = new SharedPref(LoginActivity.this);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        lupaPassword = (TextView)findViewById(R.id.tv_lupa_password_login_activity);
        login = (Button)findViewById(R.id.btn_login_login_activity);
        daftar = (TextView)findViewById(R.id.tv_daftar_login_activity);
        email = (EditText)findViewById(R.id.edt_email_login_activity);
        password = (EditText)findViewById(R.id.edt_password_login_activity);
        progressDialog=new ProgressDialog(LoginActivity.this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestOtk(Url.RequestOtk,jObject);

            }
        });

        lupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,LupaPasswordActivity.class));
            }
        });
    }



    public void RequestOtk(String url, final JSONObject json){
        jObject = new JSONObject();
        try {
            jObject.put("email", email.getText().toString());
        } catch (JSONException e) {
            Log.d("emailE",e+"");
        }

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressDialog.dismiss();
                        try {
                            status = response.getString("errorMsg").toString();
                            message = response.getString("technicalMsg").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("otkE",e.toString());
                        }
                        if(status.equalsIgnoreCase("Success")){
                            Log.d("response", response.toString());
                            try {
                                String otk = response.getString("otk");
                                SignIn(Url.Login,otk);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(LoginActivity.this, "Otk berhasil didapatkan", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "Silahkan ulangi lagi", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Jika Gagal Mendapat Data Dari Server
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Silahkan ulangi lagi", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }
    public void SignIn(String url,String otks){
        jObject = new JSONObject();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest mm = MessageDigest.getInstance("SHA-256");
            String text= password.getText().toString();
            md.update(text.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            String hex = String.format("%064x",new BigInteger(1,digest));
            hex = hex + otks;
            mm.update(hex.getBytes(StandardCharsets.UTF_8));
            byte[] digest2 = mm.digest();
            hash = String.format("%064x",new BigInteger(1,digest2));
            Log.d("hex",hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            jObject.put("email",email.getText().toString());
            jObject.put("password",hash);
            jObject.put("source","WEB");
        } catch (JSONException e) {
            Log.d("jE",e+"");
        }


        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, jObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressDialog.dismiss();
                        try {
                            status = response.getString("errorMsg").toString();
                            message = response.getString("technicalMsg").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Responses",e.toString());
                        }
                        if(status.equalsIgnoreCase("Success")){
                            Log.d("response", response.toString());
                            Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            sharedPref.saveData("login","berhasil");
                            try{
                                String name = response.getString("name");
                                sharedPref.saveData("name",name);
                                Toast.makeText(LoginActivity.this, "Welcome "+name, Toast.LENGTH_SHORT).show();
                            }catch (Exception e){
                            }

                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            Log.d("Response",message);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Jika Gagal Mendapat Data Dari Server
                progressDialog.dismiss();
                Log.d("Silahkan coba lagi", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json;charset-utf8");
                return headers;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
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
