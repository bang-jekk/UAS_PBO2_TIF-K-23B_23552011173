package com.mycompany.uas.kasirakademik;

public class Dosen extends Civitas {
    private String jabatan;

    public Dosen(String nama, String id, String prodi, String jabatan) {
        super(nama, id, prodi);
        this.jabatan = jabatan;
    }
}
