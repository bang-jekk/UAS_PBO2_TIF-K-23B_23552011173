package com.mycompany.uas.kasirakademik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UasKasirAkademik extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        LoginView login = new LoginView();
        Scene scene = new Scene(login.getView(), 400, 300);
        stage.setTitle("Kasir Akademik");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
