package com.mrabid.bumidesa.Modal;

import java.util.ArrayList;

/**
 * Created by Mr Abid on 1/16/2018.
 */

public class BanyakBarang {
    private String kategori;
    private ArrayList<Barang> dataBarang= new ArrayList<>();

    public BanyakBarang(String kategori, ArrayList<Barang> dataBarang) {
        this.kategori = kategori;
        this.dataBarang = dataBarang;
    }

    public BanyakBarang() {
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public ArrayList<Barang> getDataBarang() {
        return dataBarang;
    }

    public void setDataBarang(ArrayList<Barang> dataBarang) {
        this.dataBarang = dataBarang;
    }
}
