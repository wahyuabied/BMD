package com.mrabid.bumidesa;

import android.app.ProgressDialog;
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
import com.mrabid.bumidesa.Helper.Url;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AktivasiAkunActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText emailE,aktivasiE;
    String email;
    TextView resent;
    Button aktivasi;
    ProgressDialog progressDialog ;
    String status,message;
    JSONObject jObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivasi_akun);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        emailE = (EditText)findViewById(R.id.edt_email_aktivasi_akun_activity);
        aktivasiE = (EditText)findViewById(R.id.edt_kode_aktivasi_akun_activity);
        resent = (TextView)findViewById(R.id.tv_resent_aktivasi_akun_activity);
        aktivasi = (Button)findViewById(R.id.btn_aktivasi_akun_activity);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Aktivasi Akun");

        progressDialog = new ProgressDialog(AktivasiAkunActivity.this);

        try{
            email = getIntent().getStringExtra("email");
            if(email!=null)
                emailE.setText(email);
            else
                emailE.setText("");
        }catch (Exception e) {
            emailE.setText("");
        }

        aktivasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailE.getText().toString().equalsIgnoreCase("")||aktivasiE.getText().toString().equalsIgnoreCase(""))
                    Toast.makeText(AktivasiAkunActivity.this, "Isi kolomnya terlebih dahulu", Toast.LENGTH_SHORT).show();
                else
                    Aktivation(Url.AktivasiAkun);
            }
        });

        resent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResentAktivasi(Url.ResentAktivasiAkun, jObject);
            }
        });
    }

    private void ResentAktivasi(String url, final JSONObject json) {
        jObject = new JSONObject();
        try {
            jObject.put("email", emailE.getText().toString());
        } catch (JSONException e) {
            Log.d("Response",e+"");
        }

        Log.d("email",emailE.getText().toString());

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(AktivasiAkunActivity.this, "Kode berhasil dikirim kembali", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Log.d("responseResent", response.toString());
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

    private void Aktivation(String url) {
        jObject = new JSONObject();
        try {
            jObject.put("email", emailE.getText()+"");
            jObject.put("actvFrom","MOBILE");
            jObject.put("actvKey",aktivasiE.getText()+"");
        } catch (JSONException e) {
            Log.d("Response",e+"");
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
                            Log.d("Response",e.toString());
                        }
                        if(status.equalsIgnoreCase("Success")){
                            Log.d("responseAktivation", response.toString());
                            Toast.makeText(AktivasiAkunActivity.this, "Akun berhasil diaktifkan", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AktivasiAkunActivity.this, message, Toast.LENGTH_SHORT).show();
                        }

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
