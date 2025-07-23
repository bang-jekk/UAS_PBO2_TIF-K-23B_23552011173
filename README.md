# Final Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama : Zainuddin Muhammad Zakiy</li>
  <li>NIM : 23552011173</li>
  <li>Studi Kasus : Kasus 3</li>
</ul>

## Judul Studi Kasus
<p>Kasir Akademik</p>

## Penjelasan Studi Kasus
<p>Program Kasir Akademik adalah sistem berbasis Javafx yang digunakan untuk membantu staf administrasi kampus dalam mengelola pembayaran kuliah mahasiswa. Sistem ini mencakup fitur :

•	Input dan menampilkan data mahasiswa

•	Pencatatan tagihan kuliah per semester

•	Transaksi pembayaran tagihan

•	Menampilkan sisa tagihan yang belum lunas

•	Melihat laporan transaksi pembayaran

Semuanya dijalankan di run lewat cmd pakai Javafx agar tampilan GUI nya muncul ke trigger, dan datanya disimpan di MySQL.
</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Contoh codenya : </p>

```
public abstract class Sivitas {
    protected String nama;
    protected String nim;
    public abstract void tampilkanInfo();
}
public class Mahasiswa extends Sivitas {
    private int id;
    
    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mahasiswa: " + nama + " (" + nim + ")");
    }
```
<p>Jadi penjelasannya kita bikin class umum namanya Sivitas, isinya data kayak nama dan nim. Terus ada class Mahasiswa yang neruskan (inherit) dari Sivitas.
Jadi, Mahasiswa itu anaknya Sivitas. Dia nurun semua atribut dari ortunya.</p>

### 2. Encapsulation
<p>Contoh codenya : </p>

```
public class JadwalKuliah {
    private String hari;
    private String mataKuliah;

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }
}
```
<p>Contohnya di data jadwal atau nilai, kita sembunyikan atribut-atributnya (dibuat private), trus kita aksesnya lewat getter & setter.
Tujuannya biar data tida bisa diubah-ubah sembarangan. Harus lewat "pintu resmi" (getter/setter).</p>

### 3. Polymorphism
<p>Contoh codenya : </p>

```
public abstract class Pembayaran {
    public abstract double hitungTagihan();
}

public class TagihanKuliah extends Pembayaran {
    private double total;
    private double diskon;

    @Override
    public double hitungTagihan() {
        return total - diskon;
    }
}
```
<p>Kita punya method hitungTagihan() di class Pembayaran. Nah, setiap class turunannya bisa punya cara hitung yang berbeda-beda.
Jadi methodnya sama, tapi cara kerjanya beda jugga. Fleksibel pisan buat kondisi yang beda-beda.</p>

### 4. Abstract
<p>Contoh codenya : </p>

```
public abstract class Sivitas {
    protected String nama;
    protected String nim;

    public abstract void tampilkanInfo();
}
```
<p>Sivitas itu kita bikin sebagai abstract class. Artinya dia ga bisa langsung dipakai, tapi harus diturunin dulu.
Kayak blueprint. Cuma kerangka dasarnya ajah, baru bisa dipakai kalau diwariskan sama class lain kayak Mahasiswa.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/bang-jekk/UAS_PBO2_TIF-K-23B_23552011173">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/OfNJSry8BSs">Youtube</a></li>
</ul>
