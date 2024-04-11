package org.example.helloapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label name;
    @FXML
    private Button EN;
    @FXML
    private Button FA;
    @FXML
    private Button JP;

    private ResourceBundle bundleEN = ResourceBundle.getBundle("messages", new Locale("en", "US"));
    private ResourceBundle bundleFA = ResourceBundle.getBundle("messages", new Locale("fa", "IR"));
    private ResourceBundle bundleJP = ResourceBundle.getBundle("messages", new Locale("ja", "JP"));


    public void switchToEN() {
        name.setText(bundleEN.getString("name"));
        EN.setText(bundleEN.getString("english"));
        FA.setText(bundleEN.getString("persian"));
        JP.setText(bundleEN.getString("japanese"));
    }

    public void switchToFA() {
        name.setText(bundleFA.getString("name"));
        EN.setText(bundleFA.getString("english"));
        FA.setText(bundleFA.getString("persian"));
        JP.setText(bundleFA.getString("japanese"));
    }

    public void switchToJP() {
        name.setText(bundleJP.getString("name"));
        EN.setText(bundleJP.getString("english"));
        FA.setText(bundleJP.getString("persian"));
        JP.setText(bundleJP.getString("japanese"));
    }
}