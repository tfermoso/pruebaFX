package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserController {
    @FXML
    protected Menu menuFile;
    @FXML
    protected MenuItem mnClose;
    @FXML
    protected TextField txtDatos;
    @FXML
    protected DatePicker dpFecha;
    @FXML
    protected TableView<Person> table;
    @FXML
    protected TableColumn<Person,String> name;
    @FXML
    protected TableColumn<Person,String> surname;
    @FXML
    protected TableColumn<Person,Integer> age;


    @FXML
    protected void close(){
        System.out.println("Cerrar ventana");
    }
    @FXML
    protected void btnPulsar(){
        System.out.println(dpFecha.getValue());
        System.out.println(txtDatos.getText());
    }
    @FXML
    protected void btnTraerDatos(){
        ObservableList<Persona> personas = FXCollections.observableArrayList(
                new Persona("Juan", "Pérez"),
                new Persona("María", "González"),
                new Persona("Pedro", "Martínez")
        );

// Asignar los datos a las columnas
        name.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        surname.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        table.setItems(personas);
    }
}
