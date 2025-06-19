package com.example.projectakhirbd.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.example.projectakhirbd.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSignUpController {

    @FXML
    private TextField usernameField, signUpUsernameField, signUpEmailField;
    @FXML
    private PasswordField passwordField, signUpPasswordField, signUpConfirmPasswordField;
    @FXML
    private ComboBox<String> roleComboBox, signUpRoleComboBox;
    @FXML
    private Label loginMessageLabel, signUpMessageLabel;
    @FXML
    private VBox signInForm, signUpForm;

    public void showSignUpForm(ActionEvent actionEvent) {
        signInForm.setVisible(false);
        signInForm.setManaged(false);
        signUpForm.setVisible(true);
        signUpForm.setManaged(true);
    }

    public void showLogInForm(ActionEvent actionEvent) {
        signUpForm.setVisible(false);
        signUpForm.setManaged(false);
        signInForm.setVisible(true);
        signInForm.setManaged(true);
    }

    public void handleSignUp(ActionEvent actionEvent) {
        String username = signUpUsernameField.getText();
        String email = signUpEmailField.getText();
        String password = signUpPasswordField.getText();
        String confirmPassword = signUpConfirmPasswordField.getText();
        String role = signUpRoleComboBox.getValue();

        // Input validation
        if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank() || role == null) {
            signUpMessageLabel.setText("All fields, including role, are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            signUpMessageLabel.setText("Passwords do not match.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Check if username or email already exists
            String checkUserQuery = "SELECT * FROM users WHERE username = ? OR email = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkUserQuery);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                signUpMessageLabel.setText("User with the same username or email already exists.");
            } else {

                String insertUserQuery = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertUserQuery);
                insertStmt.setString(1, username);
                insertStmt.setString(2, email);
                insertStmt.setString(3, password);
                insertStmt.setString(4, role);
                insertStmt.executeUpdate();

                signUpMessageLabel.setText("Account created successfully as " + role + ".");
                showLogInForm(actionEvent);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            signUpMessageLabel.setText("Failed to create an account. Please try again.");
        }
    }

    public void handleLogIn(ActionEvent actionEvent) {
        String usernameOrEmail = usernameField.getText();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();

        if (usernameOrEmail.isBlank() || password.isBlank() || role == null) {
            loginMessageLabel.setText("Username/Email, Password, and Role are required.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String loginQuery = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ? AND role = ?";
            PreparedStatement loginStmt = connection.prepareStatement(loginQuery);
            loginStmt.setString(1, usernameOrEmail);
            loginStmt.setString(2, usernameOrEmail);
            loginStmt.setString(3, password);
            loginStmt.setString(4, role);
            ResultSet rs = loginStmt.executeQuery();

            if (rs.next()) {
                loginMessageLabel.setText("Login successful. Welcome, " + role + "!");
                redirectUserBasedOnRole(role);
            } else {
                loginMessageLabel.setText("Invalid username/email, password, or role.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Login failed. Please try again.");
        }
    }

    public void handleForgotPassword(ActionEvent actionEvent) {
        // Simple alert for now
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forgot Password");
        alert.setHeaderText("Password recovery instructions.");
        alert.setContentText("Please contact the administrator to reset your password.");
        alert.showAndWait();
    }

    private void redirectUserBasedOnRole(String role) {
        switch (role) {
            case "Guru":
                System.out.println("Redirect to Guru Menu");
                break;
            case "Siswa":
                System.out.println("Redirect to Siswa Menu");
                break;
            case "Admin":
                System.out.println("Redirect to Admin Menu");
                break;
            default:
                System.out.println("Unknown role, no redirection.");
                break;
        }
    }
}