package com.mrabid.bumidesa.Modal;

/**
 * Created by Mr Abid on 1/17/2018.
 */

public class Pesan {
    private int id;
    private boolean read;
    public String imagePesan;
    public String nama;
    public String tanggal;
    public String subject;
    public String isi;

    public Pesan(int id, boolean read, String imagePesan, String nama, String tanggal, String subject, String isi) {
        this.id = id;
        this.read = read;
        this.imagePesan = imagePesan;
        this.nama = nama;
        this.tanggal = tanggal;
        this.subject = subject;
        this.isi = isi;
    }

    public Pesan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getImagePesan() {
        return imagePesan;
    }

    public void setImagePesan(String imagePesan) {
        this.imagePesan = imagePesan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
