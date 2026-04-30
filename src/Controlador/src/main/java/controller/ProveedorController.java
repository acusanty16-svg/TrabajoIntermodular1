package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InventarioTienda;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProveedorController implements Initializable {

    @FXML
    private TableView<InventarioTienda> tablaInventario;

    @FXML
    private TableColumn<InventarioTienda, Integer> colId;

    @FXML
    private TableColumn<InventarioTienda, String> colProducto;

    @FXML
    private TableColumn<InventarioTienda, Integer> colStock;

    @FXML
    private TableColumn<InventarioTienda, Integer> colStockMinimo;

    @FXML
    private TextField txtStock;

    @FXML
    private Button btnActualizarStock;

    @FXML
    private Button btnActualizar,btnVolver;

    private ModeloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new ModeloController();
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idInventarioTienda"));
        colProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("cantidadStock"));
        colStockMinimo.setCellValueFactory(new PropertyValueFactory<>("stockMinimo"));
    }

    private void initGUI() {
        List<InventarioTienda> inventario = controller.getAllInventarioTienda();
        tablaInventario.getItems().addAll(inventario);
    }

    private void actions() {

        btnActualizarStock.setOnAction(event -> {
            InventarioTienda seleccionado = tablaInventario.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Selecciona un producto de la tabla primero");
                alert.showAndWait();
                return;
            }
            if (txtStock.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Ingresa el nuevo stock");
                alert.showAndWait();
                return;
            }
            try {
                int nuevoStock = Integer.parseInt(txtStock.getText());
                if (nuevoStock < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("El stock no puede ser negativo");
                    alert.showAndWait();
                    return;
                }
                seleccionado.setCantidadStock(nuevoStock);
                controller.updateStockInventario(seleccionado);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Éxito");
                alert.setContentText("Stock actualizado correctamente");
                alert.showAndWait();
                txtStock.clear();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Ingresa un número válido");
                alert.showAndWait();
            }
        });
        btnActualizar.setOnAction(event -> {
            tablaInventario.getItems().clear();
            initGUI();
            System.out.println("Tabla actualizada");
        });
        btnVolver.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/controlador/login-view.fxml")
                );
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("TechManage - Login");
                stage.show();
                ((Stage) btnVolver.getScene().getWindow()).close();
            } catch (IOException e) {
                System.out.println("Error al cargar login");
            }
        });
    }
}