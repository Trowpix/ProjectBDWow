package com.example.projectakhirbd.Siswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSiswaController {

    public Label userNameLabel;
    public TableView jadwalHariIniTable;
    public Label jadwalHariIniLabel;
    public ListView pengumumanListView;
    public Label nilaiRataRataLabel;
    public Label lastUpdateNilaiLabel;

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

    public void showBiodata(ActionEvent actionEvent) {
        // Logika untuk menampilkan biodata
        System.out.println("Navigating to Biodata page...");
        String fxmlPath = "/com/example/projectakhirbd/Siswa/biodata-siswa.fxml";

        try {
            Parent biodataPage = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.getScene().setRoot(biodataPage);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal membuka halaman biodata.");
        }
    }

    public void showJadwalSiswa(ActionEvent actionEvent) {
        // Logika untuk menampilkan jadwal siswa
        System.out.println("Navigating to Jadwal Siswa page...");
        String fxmlPath = "/com/example/projectakhirbd/Siswa/jadwal-siswa.fxml";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent jadwalPage = loader.load();

            // Dapatkan stage dari event source (button)
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            // Pasang tampilan baru ke scene
            Scene scene = new Scene(jadwalPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal membuka halaman jadwal siswa: " + fxmlPath);
        }
    }

    public void showNilaiSiswa(ActionEvent actionEvent) {
        // Logika untuk menampilkan nilai siswa
        System.out.println("Navigating to Nilai Siswa page...");
        String fxmlPath = "/com/example/projectakhirbd/Siswa/nilai-siswa.fxml";

        try {
            Parent nilaiPage = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.getScene().setRoot(nilaiPage);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal membuka halaman nilai siswa.");
        }
    }

}