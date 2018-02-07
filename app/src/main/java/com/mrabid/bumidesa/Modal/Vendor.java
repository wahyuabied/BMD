package com.mrabid.bumidesa.Modal;

/**
 * Created by Mr Abid on 2/1/2018.
 */

public class Vendor {
    private String nama;
    private String image;
    private String toko;

    public Vendor(String nama, String image, String toko) {
        this.nama = nama;
        this.image = image;
        this.toko = toko;
    }

    public Vendor() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }
}
