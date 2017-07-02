package com.example.rihaf.diabetesdietexpert;

/**
 * Created by rihaf on 12/15/2016.
 */
public class DataProvider {

    private Double tb;
    private Double bb;
    private Double imt;
    private String kategori;
    private Integer umur;
    private String jk;
    private String aktivitas;

    public Double getTb() {
        return tb;
    }

    public void setTb(Double tb) {
        this.tb = tb;
    }

    public Double getBb() {
        return bb;
    }

    public void setBb(Double bb) {
        this.bb = bb;
    }

    public Double getImt() {
        return imt;
    }

    public void setImt(Double imt) {
        this.imt = imt;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

    public DataProvider(Double tb, Double bb, Double imt, String  kategori, Integer umur, String jk, String aktivitas)
    {
        this.tb =tb;
        this.bb =bb;
        this.imt =imt;
        this.kategori =kategori;
        this.umur =umur;

        this.jk =jk;
        this.aktivitas =aktivitas;
    }
}
