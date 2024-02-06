package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;

public class UserController {
    @FXML
    private Menu menUser;
    public String datos;

    public void initialize() {
        // Este método se llama automáticamente después de cargar la vista
        //menUser.setText("Lolo");
    }
    @FXML
    protected void mostrar(){

        System.out.println(datos);
    }
}
