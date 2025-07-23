package com.mycompany.uas.kasirakademik;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.sql.*;
import javafx.scene.Scene;

public class AkademikView {
    private VBox view;

    public AkademikView() {
        Label lblTitle = new Label("🎓 Input Data Akademik");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        ComboBox<String> cbTipe = new ComboBox<>();
        cbTipe.getItems().addAll("📘 Nilai Mahasiswa", "📅 Jadwal Dosen");
        cbTipe.setPromptText("🔽 Pilih jenis data akademik");

        TextField tfID = new TextField();
        tfID.setPromptText("🆔 Masukkan NIM / NIP");

        TextField tfIsi1 = new TextField();
        tfIsi1.setPromptText("🔢 Nilai / Hari");

        TextField tfIsi2 = new TextField();
        tfIsi2.setPromptText("⏰ Jam (contoh: 08:00)");
        tfIsi2.setVisible(false); // default sembunyikan

        Label lblStatus = new Label();

        Button btnSimpan = new Button("💾 Simpan");
        Button btnKembali = new Button("🔙 Kembali");

        cbTipe.setOnAction(e -> {
            String tipe = cbTipe.getValue();
            if (tipe != null && tipe.equals("📘 Nilai Mahasiswa")) {
                tfID.setPromptText("🆔 Masukkan NIM");
                tfIsi1.setPromptText("🔢 Nilai");
                tfIsi2.setVisible(false);
            } else {
                tfID.setPromptText("🆔 Masukkan NIP");
                tfIsi1.setPromptText("📆 Hari (Senin, Selasa, ...)");
                tfIsi2.setPromptText("⏰ Jam (08:00)");
                tfIsi2.setVisible(true);
            }
        });

        btnSimpan.setOnAction(e -> {
            try (Connection conn = Database.connect()) {
                if (cbTipe.getValue().contains("Nilai")) {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO nilai VALUES (?, ?, ?)");
                    stmt.setString(1, tfID.getText());
                    stmt.setString(2, "Pemrograman");
                    stmt.setDouble(3, Double.parseDouble(tfIsi1.getText()));
                    stmt.executeUpdate();
                    lblStatus.setText("✅ Nilai berhasil disimpan!");
                } else {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO jadwal VALUES (?, ?, ?)");
                    stmt.setString(1, tfID.getText());
                    stmt.setString(2, tfIsi1.getText());
                    stmt.setString(3, tfIsi2.getText());
                    stmt.executeUpdate();
                    lblStatus.setText("✅ Jadwal berhasil disimpan!");
                }
            } catch (Exception ex) {
                lblStatus.setText("❌ Gagal menyimpan data.");
                ex.printStackTrace();
            }
        });

        btnKembali.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new DashboardView().getView(), 400, 300)
            );
        });

        VBox inputForm = new VBox(10, cbTipe, tfID, tfIsi1, tfIsi2, btnSimpan, btnKembali, lblStatus);
        inputForm.setAlignment(Pos.CENTER);

        view = new VBox(20, lblTitle, inputForm);
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-padding: 20;");
    }

    public VBox getView() {
        return view;
    }
}
