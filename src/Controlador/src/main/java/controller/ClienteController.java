package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Productos;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private TableView<Productos> tablaProductos;

    @FXML
    private TableColumn<Productos, Integer> colId;

    @FXML
    private TableColumn<Productos, String> colNombre;

    @FXML
    private TableColumn<Productos, Double> colPrecio;

    @FXML
    private TableColumn<Productos, String> colDescripcion;

    @FXML
    private Button btnVerCarrito;

    @FXML
    private Button btnComprar,btnVolver;

    private ModeloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new ModeloController();
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    private void initGUI() {
        List<Productos> productos = controller.getAllProducts();
        tablaProductos.getItems().addAll(productos);
    }

    private void actions() {
        btnVerCarrito.setOnAction(event -> {
            System.out.println("Ver Carrito clicked");
        });
        btnComprar.setOnAction(event -> {
            Productos seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                System.out.println("Añadido al carrito: " + seleccionado.getNombre());
            } else {
                System.out.println("Selecciona un producto primero");
            }
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