package com.mrabid.bumidesa.Modal;

/**
 * Created by Mr Abid on 1/16/2018.
 */

public class Barang {
    private int id;
    private String image;
    private String kategori;
    private String nama;
    private String harga;
    private float rating;

    public Barang(int id, String image, String kategori, String nama, String harga, float rating) {
        this.id = id;
        this.image = image;
        this.kategori = kategori;
        this.nama = nama;
        this.harga = harga;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
