package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    protected TableColumn<Person, String> name;
    @FXML
    protected TableColumn<Person, String> surname;
    @FXML
    protected TableColumn<Person, Integer> age;

    @FXML
    protected TextField txtName;
    @FXML
    protected TextField txtSurname;
    @FXML
    protected TextField txtAge;

    private ObservableList<Person> personas;

    @FXML
    protected void close() {
        System.out.println("Cerrar ventana");
    }

    @FXML
    protected void btnPulsar() {
        System.out.println(dpFecha.getValue());
        System.out.println(txtDatos.getText());
    }

    @FXML
    protected void btnTraerDatos() {
        personas = FXCollections.observableArrayList(
                new Person("Juan", "Pérez", 34),
                new Person("María", "González", 33),
                new Person("Pedro", "Martínez", 35)
        );

        personas.addAll(new Person("Juan","Perez",56));


        table.setItems(personas);
    }


    @FXML
    public void initialize() {


// Asignar los datos a las columnas
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        surname.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        age.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

    }


    public void btnAddPerson(ActionEvent actionEvent) {
        Person person=new Person(txtName.getText(),txtSurname.getText(),Integer.parseInt(txtAge.getText()));
        personas.addAll(person);
        table.setItems(personas);
    }
}
