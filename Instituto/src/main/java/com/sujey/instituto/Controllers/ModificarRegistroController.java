package com.sujey.instituto.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sujey.instituto.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificarRegistroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button guardar;

    @FXML
    private ListView<Student> listMod;

    @FXML
    private Button offWindow;

    @FXML
    private TextField tex;

    @FXML
    private TextField tex2;

    @FXML
    private TextField tex3;

    @FXML
    private TextField tex4;

    @FXML
    private TextField tex5;

    @FXML
    private Button verButton;

    private Student selectedStudent;

    @FXML
    void OnMouseClickGuardar(MouseEvent event) {
        if (selectedStudent != null) {
            selectedStudent.setNombre(tex.getText());
            selectedStudent.setApellidos(tex2.getText());

            try {
                int edad = Integer.parseInt(tex3.getText());
                selectedStudent.setEdad(edad);
            } catch (NumberFormatException e) {
                System.out.println("La edad debe ser un número entero válido.");
            }

            selectedStudent.setMatricula(tex4.getText());
            selectedStudent.setDireccion(tex5.getText());
            closeWindow();
        }
    }


    @FXML
    void OnMouseClickOffWindow(MouseEvent event) {
        closeWindow();
    }

    private BaseDeDatos hBase = new HBase();
    private BaseDeDatos mySql = new MySql();
    private BaseDeDatos sql = new SQL();

    @FXML
    void onMouseClickedVerButton(MouseEvent event) {
        ObservableList<Student> students = FXCollections.observableArrayList();

        ArrayList<Student> studentsSQL = sql.getEstudiantes();
        if (studentsSQL != null) {
            students.addAll(studentsSQL);
        }

        ArrayList<Student> studentsMySQL = mySql.getEstudiantes();
        if (studentsMySQL != null) {
            students.addAll(studentsMySQL);
        }

        ArrayList<Student> studentsHBase = hBase.getEstudiantes();
        if (studentsHBase != null) {
            students.addAll(studentsHBase);
        }

        listMod.setItems(students);
    }

    @FXML
    void initialize() {
        listMod.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedStudent = newValue;
                tex.setText(selectedStudent.getNombre());
                tex2.setText(selectedStudent.getApellidos());
                tex3.setText(String.valueOf(selectedStudent.getEdad()));
                tex4.setText(selectedStudent.getMatricula());
                tex5.setText(selectedStudent.getDireccion());
            }
        });
    }

    private void closeWindow() {
        offWindow.getScene().getWindow().hide();
    }

}
