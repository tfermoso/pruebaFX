package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label lblusuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;

    @FXML
    protected void onHelloButtonClick() {

        System.out.println(txtUsuario.getText());
    }

    @FXML
    protected void onLoginClick(){
        System.out.println("login");
    }
}