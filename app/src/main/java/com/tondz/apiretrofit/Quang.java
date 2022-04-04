package com.tondz.apiretrofit;

public class Quang {
    private String nghien,co,toi;
    private int pcl;

    public String getNghien() {
        return nghien;
    }

    public void setNghien(String nghien) {
        this.nghien = nghien;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getToi() {
        return toi;
    }

    public void setToi(String toi) {
        this.toi = toi;
    }

    public int getPcl() {
        return pcl;
    }

    public void setPcl(int pcl) {
        this.pcl = pcl;
    }

    public Quang(String nghien, String co, String toi, int pcl) {
        this.nghien = nghien;
        this.co = co;
        this.toi = toi;
        this.pcl = pcl;
    }

    @Override
    public String toString() {
        return "Quang{" +
                "nghien='" + nghien + '\'' +
                ", co='" + co + '\'' +
                ", toi='" + toi + '\'' +
                ", pcl=" + pcl +
                '}';
    }
}
