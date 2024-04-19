package com.sujey.instituto.Controllers;

import com.sujey.instituto.App;
import com.sujey.instituto.Models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    @FXML
    private PasswordField contraseñaUsuario;

    @FXML
    private Button ingresarUsuario;

    @FXML
    private TextField nombreUsuario;
    Usuario usuario = new Usuario();

    @FXML
    private Button offWindow;

    @FXML
    void OnMouseClickedIngresarUsuario(MouseEvent event) {
        String nombreUsu = nombreUsuario.getText();
        String contrasena = contraseñaUsuario.getText();
        if (nombreUsu.equals(usuario.getUsuario()) && contrasena.equals(usuario.getContra())) {
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
    }

    @FXML
    void OnMouseClickedoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}

