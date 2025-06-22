package com.example.projectakhirbd.Guru;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuGuruController {

    public void handleLogout(ActionEvent actionEvent) {
        String fxmlPath = "/com/example/projectakhirbd/Auth/login-signup.fxml"; // Path ke halaman login

        try {
            // Dapatkan stage utama
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            // Muat ulang halaman login
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Setel scene dengan halaman login
            stage.setScene(new Scene(root));
            stage.show();

            // Opsional: Tampilkan pesan di konsol (untuk debugging)
            System.out.println("User logged out and redirected to login page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load login page: " + fxmlPath);
        }
    }

    public void showJadwalMengajar(ActionEvent actionEvent) {
    }

    public void showInputNilai(ActionEvent actionEvent) {
    }

    public void showCetakRapor(ActionEvent actionEvent) {
    }

    public void showDaftarSiswaKelasWali(ActionEvent actionEvent) {

    }
}