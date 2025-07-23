package com.mycompany.uas.kasirakademik;

public abstract class Sivitas {
    protected String nama;
    protected String id;

    public Sivitas(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public abstract void tampilkanInfo();
}
