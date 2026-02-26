package com.smarttransport.controller;

import com.smarttransport.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField nameField;
    @FXML private TextField idField;

    @FXML
    private void handleLogin() {
        String name = nameField.getText();
        String id = idField.getText();

        if (!name.isEmpty() && !id.isEmpty()) {
            // حفظ البيانات في الـ static variable
            User.setCurrentUser(new User(name, id));
            
            // الانتقال لصفحة الـ Dashboard
            goToDashboard();
        }
    }

    private void goToDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/smarttransport/view/Dashboard.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}