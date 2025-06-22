package com.example.projectakhirbd.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class InputDataSiswaController {
    public void handleSimpan(ActionEvent actionEvent) {
    }

    public void handleEdit(ActionEvent actionEvent) {
    }

    public void handleHapus(ActionEvent actionEvent) {
    }

    public void handleBersihkan(ActionEvent actionEvent) {
    }

    public void handleSearch(ActionEvent actionEvent) {
    }

    public void handleBackToMenu(ActionEvent actionEvent) {
        loadMenuAdmin(actionEvent);
    }

    private void loadMenuAdmin(ActionEvent actionEvent) {
        String fxmlPath = "/com/example/projectakhirbd/Admin/menu-admin.fxml"; // Path FXML Menu Admin

        try {
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Navigasi kembali ke Menu Admin.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Tidak dapat memuat halaman: " + fxmlPath);
        }
    }
}