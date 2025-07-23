package com.mycompany.uas.kasirakademik;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DashboardView {
    private VBox view;

    public DashboardView() {
        Label lblTitle = new Label("🎓 Selamat Datang di Kasir Akademik!");
        lblTitle.setFont(Font.font("Arial", 22));
        lblTitle.setTextFill(Color.DARKBLUE);

        // Gaya tombol umum
        String btnStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; "
                        + "-fx-background-radius: 10; -fx-padding: 10 20 10 20;";

        Button btnInputData = new Button("📚 Input Data Civitas");
        btnInputData.setStyle(btnStyle);
        btnInputData.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new InputDataView().getView(), 500, 450)
            );
        });

        Button btnPembayaran = new Button("💸 Pembayaran");
        btnPembayaran.setStyle(btnStyle);
        btnPembayaran.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new PembayaranView().getView(), 500, 450)
            );
        });

        Button btnAkademik = new Button("📝 Data Akademik");
        btnAkademik.setStyle(btnStyle);
        btnAkademik.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new AkademikView().getView(), 500, 450)
            );
        });

        Button btnKeluar = new Button("❌ Keluar");
        btnKeluar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 14px; "
                         + "-fx-background-radius: 10; -fx-padding: 10 20 10 20;");
        btnKeluar.setOnAction(e -> {
            UasKasirAkademik.primaryStage.setScene(
                new Scene(new LoginView().getView(), 400, 300)
            );
        });

        VBox buttonsBox = new VBox(10, btnInputData, btnPembayaran, btnAkademik, btnKeluar);
        buttonsBox.setAlignment(Pos.CENTER);

        view = new VBox(30, lblTitle, buttonsBox);
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(30));
        view.setStyle("-fx-background-color: #f0f8ff;");
    }

    public VBox getView() {
        return view;
    }
}
