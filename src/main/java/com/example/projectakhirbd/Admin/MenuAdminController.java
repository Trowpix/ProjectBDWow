package com.example.projectakhirbd.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdminController {

    public void handleLogout(ActionEvent actionEvent) {
        String fxmlPath = "/com/example/projectakhirbd/Auth/login-signup.fxml";

        try {
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("User logged out and redirected to login page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load login page: " + fxmlPath);
        }
    }

    public void showManajemenSiswa(ActionEvent actionEvent) {
        loadPage(actionEvent, "/com/example/projectakhirbd/Admin/admin-atur-data-siswa.fxml");
    }

    public void showManajemenJadwal(ActionEvent actionEvent) {
        loadPage(actionEvent, "/com/example/projectakhirbd/Admin/admin-atur-jadwal-siswa.fxml");
    }

    public void showPembagianKelas(ActionEvent actionEvent) {
        loadPage(actionEvent, "/com/example/projectakhirbd/Admin/admin-pembagian-kelas.fxml");
    }

    public void showLaporanSiswa(ActionEvent actionEvent) {
        loadPage(actionEvent, "/com/example/projectakhirbd/Admin/admin-laporan-siswa.fxml");
    }

    private void loadPage(ActionEvent actionEvent, String fxmlPath) {
        try {
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Loaded page: " + fxmlPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load page: " + fxmlPath);
        }
    }
}