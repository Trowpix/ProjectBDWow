package com.example.projectakhirbd.Siswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSiswaController {

    public void handleLogout(ActionEvent actionEvent) {
        String fxmlPath = "/com/example/projectakhirbd/Auth/login-signup.fxml";

        try {
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("User logged out and redirected to login page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load login page: " + fxmlPath);
        }
    }

    public void showBiodata(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Siswa/biodata-siswa.fxml", actionEvent, "Biodata");
    }

    public void showJadwalSiswa(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Siswa/jadwal-siswa.fxml", actionEvent, "Jadwal Kelas");
    }

    public void showNilaiSiswa(ActionEvent actionEvent) {
        navigateToPage("/com/example/projectakhirbd/Siswa/nilai-siswa.fxml", actionEvent, "Nilai Ujian Siswa");
    }

    private void navigateToPage(String fxmlPath, ActionEvent actionEvent, String pageName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent page = loader.load();
            
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(page);

            stage.setScene(scene);
            stage.show();
            System.out.println("Successfully navigated to " + pageName + " page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to navigate to " + pageName + " page: " + fxmlPath);
        }
    }
}