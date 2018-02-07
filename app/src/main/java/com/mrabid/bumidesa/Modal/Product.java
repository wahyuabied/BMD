package com.mrabid.bumidesa.Modal;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class Product {
    private String image;
    private String name;
    private String harga;
    private float rating;
    private String toko;

    public Product(String image, String name, String harga, float rating, String toko) {
        this.image = image;
        this.name = name;
        this.harga = harga;
        this.rating = rating;
        this.toko = toko;
    }

    public Product() {
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

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }
}
