package org.example.helloapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FXController {
    @FXML
    private Label selectLanguage;
    @FXML
    private ComboBox<String> languageComboBox;
    @FXML
    private Label firstName;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private Label lastName;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private Label email;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button submitButton;

    public void changeLanguage() {
        String selectedLanguage = languageComboBox.getValue();
        switch (selectedLanguage) {
            case "English":
                selectLanguage.setText("Select Language");
                firstName.setText("First Name");
                lastName.setText("Last Name");
                email.setText("Email");
                submitButton.setText("Submit");
                break;
            case "Persian":
                selectLanguage.setText("زبان را انتخاب کنید");
                firstName.setText("نام");
                lastName.setText("نام خانوادگی");
                email.setText("ایمیل");
                submitButton.setText("ارسال");
                break;
            case "Japanese":
                selectLanguage.setText("言語を選択");
                firstName.setText("名前");
                lastName.setText("苗字");
                email.setText("Eメール");
                submitButton.setText("提出");
                break;
        }
    }

    public void submit() {
        if (firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()) {
            System.out.println("All fields must be filled!");
        } else {
            Connection conn = MysqlConn.getConnection();
            if (conn != null) {
                String selectedLanguage = languageComboBox.getValue();
                String table;
                switch (selectedLanguage) {
                    case "English":
                        table = "employee_en";
                        break;
                    case "Persian":
                        table = "employee_fa";
                        break;
                    case "Japanese":
                        table = "employee_ja";
                        break;
                    default:
                        table = "employee_en";
                        break;
                }
                String sql = "INSERT INTO " + table + " (first_name, last_name, email) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, firstNameTextField.getText());
                    pstmt.setString(2, lastNameTextField.getText());
                    pstmt.setString(3, emailTextField.getText());
                    pstmt.executeUpdate();
                    System.out.println("Record inserted successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to connect to the database.");
            }
        }
    }


}
