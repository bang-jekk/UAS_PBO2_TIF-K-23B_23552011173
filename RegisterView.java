package com.mycompany.uas.kasirakademik;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import java.sql.*;

public class RegisterView {
    private VBox view;

    public RegisterView() {
        Label lblTitle = new Label("📝 Registrasi Pengguna Baru");
        lblTitle.setFont(new Font("Arial", 18));

        Label lblUsername = new Label("👤 Username:");
        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Masukkan username");

        Label lblPassword = new Label("🔒 Password:");
        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("Masukkan password");

        Label lblRole = new Label("🎓 Pilih Peran:");
        ComboBox<String> cbRole = new ComboBox<>();
        cbRole.getItems().addAll("mahasiswa", "dosen");
        cbRole.setPromptText("Pilih salah satu");

        Button btnRegister = new Button("✅ Daftar");
        Button btnBack = new Button("↩️ Kembali");

        Label lblStatus = new Label("");

        btnRegister.setOnAction(e -> {
            try (Connection conn = Database.connect()) {
                if (tfUsername.getText().isEmpty() || pfPassword.getText().isEmpty() || cbRole.getValue() == null) {
                    lblStatus.setText("⚠️ Lengkapi semua data!");
                    return;
                }

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(username, password, role) VALUES (?, ?, ?)");
                stmt.setString(1, tfUsername.getText());
                stmt.setString(2, pfPassword.getText());
                stmt.setString(3, cbRole.getValue());
                stmt.executeUpdate();

                lblStatus.setText("🎉 Registrasi berhasil!");
            } catch (Exception ex) {
                lblStatus.setText("❌ Gagal registrasi!");
                ex.printStackTrace();
            }
        });

        btnBack.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new LoginView().getView(), 400, 300)
            );
        });

        VBox form = new VBox(5,
            lblUsername, tfUsername,
            lblPassword, pfPassword,
            lblRole, cbRole
        );
        form.setAlignment(Pos.CENTER_LEFT);

        HBox buttons = new HBox(10, btnRegister, btnBack);
        buttons.setAlignment(Pos.CENTER);

        view = new VBox(15, lblTitle, form, buttons, lblStatus);
        view.setAlignment(Pos.CENTER);
        view.setPrefWidth(400);
    }

    public VBox getView() {
        return view;
    }
}
