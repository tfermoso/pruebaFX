package com.example.demo1;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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
    @FXML
    protected TextField txtTitle;
    @FXML
    protected TextArea txtDescription;
    @FXML
    protected DatePicker dpdeadLine;
    @FXML
    protected CheckBox ckstatus;
    @FXML
    protected Button btnEdit;
    @FXML
    protected Button btnAdd;


    private ObservableList<Task> taskObservableList= FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        createDateColumn.setCellValueFactory(cell->new SimpleObjectProperty<>(cell.getValue().getCreate_date()));
        deadLineColumn.setCellValueFactory(cell->cell.getValue().getDeadline());
        titleColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getTitle()));
        statusColumn.setCellValueFactory(cell->new SimpleObjectProperty<>(cell.getValue().getStatus()));
        /*tableTask.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()==1){
                    Task task= (Task) tableTask.getSelectionModel().getSelectedItem();
                    System.out.println(task.getTitle());
                }
            }
        });
         */
        tableTask.setOnMouseClicked(e->{
            if(e.getClickCount()==1){
                Task task= (Task) tableTask.getSelectionModel().getSelectedItem();
                txtTitle.setText(task.getTitle());
                txtDescription.setText(task.getDescription());
                dpdeadLine.setValue(task.deadLine());
                ckstatus.setSelected(task.getStatus());
                btnEdit.setVisible(true);
                btnAdd.setVisible(false);
                txtTitle.setDisable(true);
            }
        });
    }

    public TaskController() {

    }

    public void btnAddTask(ActionEvent actionEvent) {
        Task task=new Task();
        task.setTitle(txtTitle.getText());
        task.setDescription(txtDescription.getText());
        task.setCreate_date(LocalDate.now());
        task.setDeadline(dpdeadLine.getValue());
        task.setStatus(false);
        taskObservableList.addAll(task);
        tableTask.setItems(taskObservableList);
        txtTitle.clear();
        txtDescription.clear();
        dpdeadLine.setValue(null);


    }

    public void btnEditTask(ActionEvent actionEvent) {
            String title = txtTitle.getText();
            for (Task task : taskObservableList){
                if(task.getTitle().equals(title)){
                    task.setDescription(txtDescription.getText());
                    task.setStatus(ckstatus.isSelected());
                    task.setDeadline(dpdeadLine.getValue());
                    break;
                }
            }
            tableTask.refresh();
    }
}
