package com.example.projectakhirbd.Guru;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JadwalGuruMengajarController {
    public void handleTampilkanJadwal(ActionEvent actionEvent) {
    }

    public void handleBackToMenu(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/projectakhirbd/Guru/menu-guru.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}