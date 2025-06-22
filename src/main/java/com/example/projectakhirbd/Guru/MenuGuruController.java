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
        navigateToPage("/com/example/projectakhirbd/Guru/guru-jadwal-mengajar.fxml", actionEvent, "Jadwal Mengajar");
    }

    public void showInputNilai(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Guru/guru-input-nilai.fxml", actionEvent, "Input Nilai");
    }

    public void showCetakRapor(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Guru/cetak-rapor.fxml", actionEvent, "Cetak Rapor");
    }

    public void showDaftarSiswaKelasWali(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Guru/daftar-siswa-kelas.fxml", actionEvent, "Daftar Siswa Kelas Wali");
    }

    private void navigateToPage(String fxmlPath, ActionEvent actionEvent, String pageName) {
        try {
            // Muat file FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent page = loader.load();

            // Ganti scene saat ini dengan halaman baru
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(page));
            stage.show();

            System.out.println("Successfully navigated to " + pageName + " page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to navigate to " + pageName + " page: " + fxmlPath);
        }
    }
}