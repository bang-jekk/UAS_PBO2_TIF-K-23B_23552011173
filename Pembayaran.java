package com.mycompany.uas.kasirakademik;

public class Pembayaran {
    protected String nama;
    protected double nominal;

    public Pembayaran(String nama) {
        this.nama = nama;
    }

    public double hitungTagihan() {
        return 0;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public double getNominal() {
        return nominal;
    }
}

class PembayaranUKT extends Pembayaran {
    private double tarif;

    public PembayaranUKT(String nama, double tarif) {
        super(nama);
        this.tarif = tarif;
        setNominal(hitungTagihan());
    }

    @Override
    public double hitungTagihan() {
        return tarif;
    }
}

class PembayaranGaji extends Pembayaran {
    private double honorPerSKS;
    private int jumlahSKS;

    public PembayaranGaji(String nama, double honorPerSKS, int jumlahSKS) {
        super(nama);
        this.honorPerSKS = honorPerSKS;
        this.jumlahSKS = jumlahSKS;
        setNominal(hitungTagihan());
    }

    @Override
    public double hitungTagihan() {
        return honorPerSKS * jumlahSKS;
    }
}

