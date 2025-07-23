package com.mycompany.uas.kasirakademik;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.Pos;

import java.sql.*;

public class LoginView {
    private VBox view;

    public LoginView() {
        Label lblTitle = new Label("🔐 Login Kasir Akademik");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("👤 Username");
        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("🔑 Password");

        Button btnLogin = new Button("✅ Masuk");
        Button btnRegister = new Button("📝 Daftar");

        Label lblStatus = new Label();

        btnLogin.setOnAction(e -> {
            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                stmt.setString(1, tfUsername.getText());
                stmt.setString(2, pfPassword.getText());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    UasKasirAkademik.primaryStage.setScene(
                        new Scene(new DashboardView().getView(), 1400, 1200)
                    );
                } else {
                    lblStatus.setText("❌ Login gagal!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnRegister.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new RegisterView().getView(), 400, 300)
            );
        });

        view = new VBox(12, lblTitle, tfUsername, pfPassword, btnLogin, btnRegister, lblStatus);
        view.setAlignment(Pos.CENTER);
    }

    public VBox getView() {
        return view;
    }
}
