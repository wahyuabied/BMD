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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mrabid.bumidesa.Helper.Url;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button daftar;
    ProgressDialog progressDialog;
    EditText name,email,phone,password,alamat,password2;
    Button register;
    final JSONObject jObject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        daftar = (Button)findViewById(R.id.btn_daftar_register_activity);
        name = (EditText)findViewById(R.id.edt_nama_lengkap_login_activity);
        email = (EditText)findViewById(R.id.edt_email_login_activity);
        phone = (EditText)findViewById(R.id.edt_telepon_login_activity);
        password = (EditText)findViewById(R.id.edt_password_login_activity);
        password2 = (EditText)findViewById(R.id.edt_ulangi_password_login_activity);
        alamat = (EditText)findViewById(R.id.edt_addres_login_activity);
        register = (Button)findViewById(R.id.btn_daftar_register_activity);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");

        progressDialog=new ProgressDialog(RegisterActivity.this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equalsIgnoreCase(password2.getText().toString())){
                    VolleyRawPOST(Url.Register, jObject);
                }else{
                    Toast.makeText(RegisterActivity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void VolleyRawPOST(String url, final JSONObject json) {

        try {
            jObject.put("name", name.getText().toString());
            jObject.put("email", email.getText().toString());
            jObject.put("phone", phone.getText().toString());
            jObject.put("password", password.getText().toString());
            jObject.put("address", alamat.getText().toString());
            jObject.put("cityId", "3276");
            jObject.put("postalCode", "12345");
            jObject.put("source", "MOBILE");
            jObject.put("urlActv", "http://google.com");
            jObject.put("referenceCode"," ");
        } catch (JSONException e) {
            Log.d("Response",e+"");
        }

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(RegisterActivity.this, "Register telah berhasil", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Log.d("response", response.toString());
                        Intent i = new Intent(RegisterActivity.this,AktivasiAkunActivity.class);
                        i.putExtra("email",email.getText()+"");
                        startActivity(i);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Jika Gagal Mendapat Data Dari Server
                progressDialog.dismiss();
                Log.d("error", error.toString());
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
