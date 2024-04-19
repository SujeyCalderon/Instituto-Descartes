package com.sujey.instituto.Controllers;

import com.sujey.instituto.App;
import com.sujey.instituto.Models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearRegistroController {

    @FXML
    private Button guardar;

    @FXML
    private Button crear;
    @FXML
    private Button mostrar;
    @FXML
    private TextField tex2;

    @FXML
    private TextField tex3;

    @FXML
    private TextField tex4;
    @FXML
    private TextField tex;

    @FXML
    private TextField tex5;

    @FXML
    private Button offWindow;
    private Student student;

    private BaseDeDatos sql = new SQL();
    private BaseDeDatos mySQL = new MySql();
    private BaseDeDatos hBase = new HBase();
    @FXML
    void initialize() {
    }


    @FXML
    void MouseClickGuardar(MouseEvent event) {
        String nombre = tex.getText();
        String apellidos = tex2.getText();
        String matricula = tex3.getText();
        int edad = Integer.parseInt(tex4.getText());
        String direccion = tex5.getText();

        Student nuevoStudent = new Student(nombre, apellidos, matricula, edad, direccion);

        boolean addMySql = mySQL.saveStudent(nuevoStudent);
        boolean addSQL = sql.saveStudent(nuevoStudent);
        boolean addHBase = hBase.saveStudent(nuevoStudent);

        if (addMySql && addSQL && addHBase) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Estudiante guardado en las tres bases de datos.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo guardar al estudiante");
            alert.showAndWait();
        }

        tex.clear();
        tex2.clear();
        tex3.clear();
        tex4.clear();
        tex5.clear();
    }




    @FXML
    void OnMouseClickedCrear(MouseEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("CREAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
    }

    @FXML
    void OnMouseClickedMostrar(MouseEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mostrarRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("MOSTRAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
