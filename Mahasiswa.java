package com.mycompany.uas.kasirakademik;

public class Mahasiswa extends Civitas {
    private double ipk;

    public Mahasiswa(String nama, String id, String prodi, double ipk) {
        super(nama, id, prodi);
        this.ipk = ipk;
    }
}
