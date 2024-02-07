package com.example.demo1;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.Date;

public class TaskController {

    @FXML
    protected TableView tableTask;
    @FXML
    protected TableColumn<Task, LocalDate> createDateColumn;
    @FXML
    protected TableColumn<Task,String> titleColumn;
    @FXML
    protected TableColumn<Task, LocalDate> deadLineColumn;
    @FXML
    protected TableColumn<Task,Boolean> statusColumn;

    private ObservableList<Task> taskObservableList= FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        createDateColumn.setCellValueFactory(cell->new SimpleObjectProperty<>(cell.getValue().getCreate_date()));
        deadLineColumn.setCellValueFactory(cell->cell.getValue().getDeadline());
        titleColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getTitle()));
        statusColumn.setCellValueFactory(cell->new SimpleObjectProperty<>(cell.getValue().getStatus()));
        taskObservableList.addAll(new Task("tarea1","algo",LocalDate.now(),LocalDate.now(),false));
        tableTask.setItems(taskObservableList);
    }

    public TaskController() {

    }
}
