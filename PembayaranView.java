package com.mycompany.uas.kasirakademik;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.sql.*;
import javafx.scene.Scene;

public class PembayaranView {
    private VBox view;

    public PembayaranView() {
        Label lblTitle = new Label("💰 Form Pembayaran");

        ComboBox<String> cbJenis = new ComboBox<>();
        cbJenis.getItems().addAll("UKT", "Gaji");
        cbJenis.setPromptText("📌 Pilih Jenis Pembayaran");

        TextField tfNama = new TextField(); 
        tfNama.setPromptText("🧑 Nama Mahasiswa/Dosen");

        TextField tfNominal1 = new TextField(); // tarif atau honor/sks
        TextField tfNominal2 = new TextField(); // kosong atau jumlah SKS
        tfNominal2.setVisible(false);

        Label lblStatus = new Label();
        Button btnSimpan = new Button("💾 Simpan Pembayaran");
        Button btnKembali = new Button("🔙 Kembali ke Dashboard");

        cbJenis.setOnAction(e -> {
            if (cbJenis.getValue().equals("UKT")) {
                tfNominal1.setPromptText("💸 Tarif UKT");
                tfNominal2.setVisible(false);
            } else {
                tfNominal1.setPromptText("💵 Honor per SKS");
                tfNominal2.setPromptText("🔢 Jumlah SKS");
                tfNominal2.setVisible(true);
            }
        });

        btnSimpan.setOnAction(e -> {
            try (Connection conn = Database.connect()) {
                double nominal;
                if (cbJenis.getValue().equals("UKT")) {
                    PembayaranUKT ukt = new PembayaranUKT(tfNama.getText(), Double.parseDouble(tfNominal1.getText()));
                    nominal = ukt.getNominal();
                } else {
                    PembayaranGaji gaji = new PembayaranGaji(tfNama.getText(),
                        Double.parseDouble(tfNominal1.getText()),
                        Integer.parseInt(tfNominal2.getText()));
                    nominal = gaji.getNominal();
                }

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO pembayaran(nama, jenis, nominal) VALUES (?, ?, ?)");
                stmt.setString(1, tfNama.getText());
                stmt.setString(2, cbJenis.getValue().toLowerCase());
                stmt.setDouble(3, nominal);
                stmt.executeUpdate();
                lblStatus.setText("✅ Pembayaran berhasil disimpan.");
            } catch (Exception ex) {
                lblStatus.setText("⚠️ Gagal menyimpan pembayaran.");
                ex.printStackTrace();
            }
        });

        btnKembali.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new DashboardView().getView(), 400, 300)
            );
        });

        view = new VBox(12, lblTitle, cbJenis, tfNama, tfNominal1, tfNominal2, btnSimpan, btnKembali, lblStatus);
        view.setAlignment(Pos.CENTER);
    }

    public VBox getView() {
        return view;
    }
}
