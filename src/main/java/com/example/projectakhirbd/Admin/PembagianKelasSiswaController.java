package com.example.projectakhirbd.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class PembagianKelasSiswaController {
    public void handleSearchSiswaBaru(ActionEvent actionEvent) {
    }

    public void handleTetapkanKelasSiswaBaru(ActionEvent actionEvent) {
    }

    public void handleNaikKelasMassal(ActionEvent actionEvent) {
    }

    public void handleSimpanPerubahanKelas(ActionEvent actionEvent) {
    }

    public void handleSimpanWaliKelas(ActionEvent actionEvent) {
    }

    public void loadSiswaByKelasLama(ActionEvent actionEvent) {
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