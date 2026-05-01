package controller;

import data.DataSet;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Login;


public class LoginController implements Initializable {
    @FXML
    private Button btnIngresar;

    @FXML
    private TextField editLogin;

    @FXML
    private TextField editPass;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        btnIngresar.setOnAction(event->{
            ArchivoController archivoController = new ArchivoController();
            archivoController.generarTechManageXML();
            archivoController.generarClientesXML();
            archivoController.generarProductosXML();
            archivoController.generarProveedoresXML();
            archivoController.generarTiendasXML();
            archivoController.generarVentasXML();

            String usuario = editLogin.getText();
            String password = editPass.getText();

            DataSet dataSet = new DataSet();
            Login tipo = dataSet.getLogin(usuario,password);
            if (tipo == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Usuario o contraseña incorrectas");
            }else{
                try{
                    Stage stage = new Stage();
                    String vista="";

                    switch (tipo){
                        case ADMINISTRADOR -> {
                            vista = "admin-view.fxml";
                            break;
                        }
                        case CLIENTE -> {
                            vista = "client-view.fxml";
                            break;
                        }
                        case PROVEEDOR -> {
                            vista ="proveedor-view.fxml";
                        }
                    }
                    FXMLLoader loader = new FXMLLoader(
                            LoginController.class.getResource("/org/example/controlador/"+vista)
                    );
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.show();
                    ((Stage)btnIngresar.getScene().getWindow()).close();
                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("No se pudo cargar la vista");
                    alert.show();
                }
            }

        });


    }

}

