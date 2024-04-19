package com.sujey.instituto.Controllers;

import com.sujey.instituto.App;
import com.sujey.instituto.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MostrarRegistroController {

    @FXML
    private Button crear;

    @FXML
    private ListView<Student> listaEstudiantes;

    @FXML
    private Button modificar;

    @FXML
    private Button mostrar;

    @FXML
    private Button offWindow;

    @FXML
    private Button ver;


    private BaseDeDatos hBase = new HBase();
    private BaseDeDatos mySql = new MySql();
    private BaseDeDatos sql = new SQL();



    public void initialize() {

    }


    @FXML
    void OnMouseClickedVer(MouseEvent event) {
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

        listaEstudiantes.setItems(students);
    }

    @FXML
    void OnMouseClickedModificar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("CREAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedCrear(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("CREAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mostrarRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MostrarRegistroController controller = fxmlLoader.getController();
            controller.initialize();
            Stage callAgregar = new Stage();
            callAgregar.setTitle("MOSTRAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
