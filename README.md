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

•	Fitur Login dan Registrasi akun

Sistem ini memiliki antarmuka GUI (Graphical User Interface) berbasis JavaFX, dan seluruh data disimpan di dalam database MySQL. Program dijalankan melalui Command Prompt (CMD) dengan perintah java agar tampilan GUI dapat tampil dan interaktif.
</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Contoh codenya : </p>

```
public class Civitas {
    protected String nama;
    protected String nim;

    public Civitas(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

public class Mahasiswa extends Civitas {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }
}

public class Dosen extends Civitas {
    public Dosen(String nama, String nip) {
        super(nama, nip);
    }
}

```
<p>Jadi penjelasannya Kelas Mahasiswa dan Dosen mewarisi dari kelas Civitas, sehingga bisa menggunakan properti atau metode umum dari induknya.</p>

### 2. Encapsulation
<p>Contoh codenya : </p>

```
public class DataAkademik {
    private StringProperty nama;
    private StringProperty nilai;
    private StringProperty jadwal;

    public DataAkademik(String nama, String nilai, String jadwal) {
        this.nama = new SimpleStringProperty(nama);
        this.nilai = new SimpleStringProperty(nilai);
        this.jadwal = new SimpleStringProperty(jadwal);
    }

    public String getNilai() {
        return nilai.get();
    }

    public void setNilai(String nilai) {
        this.nilai.set(nilai);
    }
}

```
<p>Atribut nama, nilai, dan jadwal disembunyikan dan hanya bisa diakses lewat metode getter dan setter.</p>

### 3. Polymorphism
<p>Contoh codenya : </p>

```
public class Pembayaran {
    protected String nama;

    public Pembayaran(String nama) {
        this.nama = nama;
    }

    public double hitungTagihan() {
        return 0;
    }
}

public class PembayaranUKT extends Pembayaran {
    private double tarif;

    public PembayaranUKT(String nama, double tarif) {
        super(nama);
        this.tarif = tarif;
    }

    @Override
    public double hitungTagihan() {
        return tarif;
    }
}

```
<p>Metode hitungTagihan() didefinisikan di kelas Pembayaran, lalu di-override oleh kelas turunan seperti PembayaranUKT.</p>

### 4. Abstract Class
<p>Contoh codenya : </p>

```
public abstract class Sivitas {
    protected String nama;

    public Sivitas(String nama) {
        this.nama = nama;
    }

    public abstract void tampilkanPeran();
}

public class Mahasiswa extends Sivitas {
    public Mahasiswa(String nama) {
        super(nama);
    }

    @Override
    public void tampilkanPeran() {
        System.out.println(nama + " adalah seorang Mahasiswa.");
    }
}
```
<p>Sivitas adalah kelas abstrak yang tidak bisa dibuat objeknya secara langsung, tetapi memberikan kerangka bagi Mahasiswa dan Dosen.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/bang-jekk/UAS_PBO2_TIF-K-23B_23552011173">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/B3ZI45CzkFM">Youtube</a></li>
</ul>
