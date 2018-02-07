package com.mrabid.bumidesa.Modal;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class Transaksi {
    private String image;
    private String name;
    private String date;
    private String harga;
    private String jumlah;
    private String status;

    public Transaksi(String image, String name, String date, String harga, String jumlah, String status) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.harga = harga;
        this.jumlah = jumlah;
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
