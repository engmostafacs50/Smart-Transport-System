package com.smarttransport.controller;

import com.smarttransport.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label userNameLabel;
    @FXML private Label userIdLabel;
    @FXML private Label balanceLabel;
    @FXML private Label cardTypeLabel;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
    
        User current = User.getCurrentUser();
        
        if (current != null) {
            userNameLabel.setText(current.get_name());
            userIdLabel.setText("ID: " + current.get_id());
            balanceLabel.setText("100.00 EGP");
            cardTypeLabel.setText("Regular Pass");
        }
    }

    @FXML
    private void handleStartTrip() {
        statusLabel.setText("Checking balance and starting trip...");
        statusLabel.setStyle("-fx-text-fill: #2980b9;");
        // remaining logic 
    }

    @FXML
    private void handleLogout() {
        System.out.println("Logging out...");
    }
}