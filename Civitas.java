package com.mycompany.uas.kasirakademik;

public class Civitas extends Sivitas {
    protected String prodi;

    public Civitas(String nama, String id, String prodi) {
        super(nama, id);
        this.prodi = prodi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", ID: " + id + ", Prodi: " + prodi);
    }
}
