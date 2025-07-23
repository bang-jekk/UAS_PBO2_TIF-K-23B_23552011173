package com.mycompany.uas.kasirakademik;

import java.util.HashMap;
import java.util.Map;

public class AkademikData {
    private Map<String, Double> dataNilai = new HashMap<>();
    private Map<String, String> dataJadwal = new HashMap<>();

    public void tambahNilai(String nim, double nilai) {
        dataNilai.put(nim, nilai);
    }

    public void tambahJadwal(String nip, String jadwal) {
        dataJadwal.put(nip, jadwal);
    }

    public Double getNilai(String nim) {
        return dataNilai.get(nim);
    }

    public String getJadwal(String nip) {
        return dataJadwal.get(nip);
    }
}
