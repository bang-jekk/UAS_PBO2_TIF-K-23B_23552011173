package com.mycompany.uas.kasirakademik;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.sql.*;

public class InputDataView {
    private VBox view;

    public InputDataView() {
        Label lblTitle = new Label("🧾 Input Data Civitas Akademik");
        lblTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> cbTipe = new ComboBox<>();
        cbTipe.getItems().addAll("👨‍🎓 Mahasiswa", "👨‍🏫 Dosen");
        cbTipe.setPromptText("🎓 Pilih Tipe Civitas");

        TextField tfId = new TextField();
        tfId.setPromptText("🆔 ID Civitas");

        TextField tfNama = new TextField();
        tfNama.setPromptText("🧑 Nama Lengkap");

        TextField tfProdi = new TextField();
        tfProdi.setPromptText("🏫 Program Studi");

        TextField tfSpesifik = new TextField(); // IPK atau Jabatan

        cbTipe.setOnAction(e -> {
            if (cbTipe.getValue().contains("Mahasiswa")) {
                tfSpesifik.setPromptText("📈 IPK");
            } else {
                tfSpesifik.setPromptText("💼 Jabatan");
            }
        });

        Button btnSimpan = new Button("💾 Simpan Data");
        btnSimpan.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        btnSimpan.setOnAction(e -> {
            try (Connection conn = Database.connect()) {
                if (cbTipe.getValue().contains("Mahasiswa")) {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO mahasiswa VALUES (?, ?, ?, ?)");
                    stmt.setString(1, tfId.getText());
                    stmt.setString(2, tfNama.getText());
                    stmt.setString(3, tfProdi.getText());
                    stmt.setDouble(4, Double.parseDouble(tfSpesifik.getText()));
                    stmt.executeUpdate();
                    lblStatus.setText("✅ Data Mahasiswa berhasil disimpan!");
                } else {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO dosen VALUES (?, ?, ?, ?)");
                    stmt.setString(1, tfId.getText());
                    stmt.setString(2, tfNama.getText());
                    stmt.setString(3, tfProdi.getText());
                    stmt.setString(4, tfSpesifik.getText());
                    stmt.executeUpdate();
                    lblStatus.setText("✅ Data Dosen berhasil disimpan!");
                }
            } catch (Exception ex) {
                lblStatus.setText("❌ Gagal menyimpan data!");
                ex.printStackTrace();
            }
        });

        Button btnKembali = new Button("🔙 Kembali");
        btnKembali.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        btnKembali.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new DashboardView().getView(), 400, 400)
            );
        });

        lblStatus = new Label("");
        lblStatus.setStyle("-fx-font-size: 12px; -fx-text-fill: #555;");

        VBox form = new VBox(10, cbTipe, tfId, tfNama, tfProdi, tfSpesifik);
        form.setAlignment(Pos.CENTER);

        HBox buttons = new HBox(20, btnSimpan, btnKembali);
        buttons.setAlignment(Pos.CENTER);

        view = new VBox(15, lblTitle, form, buttons, lblStatus);
        view.setStyle("-fx-padding: 20;");
        view.setAlignment(Pos.CENTER);
    }

    private Label lblStatus;

    public VBox getView() {
        return view;
    }
}
