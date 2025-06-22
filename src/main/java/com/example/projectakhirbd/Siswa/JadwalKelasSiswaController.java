package com.example.projectakhirbd.Siswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JadwalKelasSiswaController {

    public void handleBackToMenu(ActionEvent actionEvent) {
        System.out.println("Navigating back to main menu...");
        String fxmlPath = "/com/example/projectakhirbd/Siswa/menu-siswa.fxml";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent menuPage = loader.load();

            Stage stage = (Stage) ((javafx.scene.control.Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(menuPage);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal kembali ke menu siswa: " + fxmlPath);
        }
    }

    public void handleTampilkanJadwal(ActionEvent actionEvent) {
        // Logika untuk menampilkan jadwal berdasarkan filter (Kosongkan sementara)
        System.out.println("Tampilkan jadwal berdasarkan filter.");
    }
}