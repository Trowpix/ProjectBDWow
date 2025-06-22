package com.example.projectakhirbd.Siswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BiodataSiswaController {

    public void handleBackToMenu(ActionEvent actionEvent) {
        // Logika untuk kembali ke menu utama.
        String fxmlPath = "/com/example/projectakhirbd/Siswa/menu-siswa.fxml";

        try {
            Parent menuPage = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.getScene().setRoot(menuPage);
            System.out.println("Berhasil kembali ke menu utama.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal membuka halaman menu utama: " + fxmlPath);
        }
    }
}