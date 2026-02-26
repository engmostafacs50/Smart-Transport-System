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
        // 1. التأكد من وجود الملف
        var resource = getClass().getResource("/com/smarttransport/view/Dashboard.fxml");
        if (resource == null) {
            System.err.println("خطأ: ملف Dashboard.fxml غير موجود في المسار المحدد!");
            return;
        }

        Parent root = FXMLLoader.load(resource);
        Stage stage = (Stage) nameField.getScene().getWindow();
        
        // 2. تصميم Scene جديد (ممكن نحدد الحجم هنا عشان نضمن ظهوره)
        Scene dashboardScene = new Scene(root);
        stage.setScene(dashboardScene);
        stage.centerOnScreen(); // عشان الواجهة تظهر في نص الشاشة
        stage.show();
        
    } catch (Exception e) {
        System.err.println("حصلت مشكلة وأنا بفتح الداشبورد:");
        e.printStackTrace(); 
    }
}
}