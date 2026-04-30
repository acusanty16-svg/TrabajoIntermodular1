package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Categoria;
import model.Productos;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TableView<Productos> tablaProductos;

    @FXML
    private TableColumn<Productos, Integer> colId;

    @FXML
    private TableColumn<Productos, String> colNombre;

    @FXML
    private TableColumn<Productos, Double> colPrecio;

    @FXML
    private TableColumn<Productos, Integer> colStock;

    @FXML
    private TableColumn<Productos, String> colCategoria;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtCategoria;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnVolver;

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
        colStock.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    }

    private void initGUI() {
        tablaProductos.getItems().clear();
        List<Productos> productos = controller.getAllProducts();
        tablaProductos.getItems().addAll(productos);
        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(String.valueOf(newSelection.getIdProducto()));
                txtNombre.setText(newSelection.getNombre());
                txtDescripcion.setText(newSelection.getDescripcion());
                txtPrecio.setText(String.valueOf(newSelection.getPrecioVenta()));
                txtCategoria.setText(newSelection.getCategoria().name());
                configurarBotones(newSelection);
            }else{
                vaciarCampos();
                configurarBotones(null);
            }
        });
    }

    private void actions() {
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
                configurarBotones(null);
                ((Stage) btnVolver.getScene().getWindow()).close();
            } catch (IOException e) {
                System.out.println("Error al cargar login");
            }
        });
        btnAgregar.setOnAction(event -> {
            btnAgregar.setDisable(true);
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                    txtPrecio.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Por favor, complete todos los campos requeridos");
                alert.show();
                btnAgregar.setDisable(false);
                return;
            }else{
                int idIngresado = Integer.parseInt(txtId.getText());
                boolean existeId = tablaProductos.getItems().stream()
                        .anyMatch(item->item.getIdProducto()==idIngresado);
            if (existeId) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("El ID " + idIngresado + " ya está registrado");
                    alert.show();
                    btnAgregar.setDisable(false);
                }else{
                    int id = 0;
                    String nombre = txtNombre.getText();
                    String descripcion = txtDescripcion.getText();
                    Double precio = Double.valueOf(txtPrecio.getText());
                    Categoria categoria = Categoria.valueOf(txtCategoria.getText().toUpperCase());
                    Productos nuevo = new Productos(id,nombre,descripcion,precio,categoria);
                    controller.insertProducto(nuevo);
                    vaciarCampos();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Exito");
                    alert.setContentText("El producto se ha agregado correctamente. Quieres agregar otro producto?");
                    alert.getButtonTypes().add(ButtonType.CLOSE);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        vaciarCampos();
                        btnAgregar.setDisable(false);
                    }
                btnAgregar.setDisable(false);
                }
            }
        });
        btnEditar.setOnAction(event -> {
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                    txtPrecio.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Por favor, complete todos los campos requeridos");
                alert.show();
                return;
            }
            int idIngresado = Integer.parseInt(txtId.getText());
            boolean existeId = tablaProductos.getItems().stream()
                    .anyMatch(item->item.getIdProducto()==idIngresado);
            if (!existeId) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("El ID " + idIngresado + " no está registrado");
                alert.show();
            }else{
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                Double precio = Double.valueOf(txtPrecio.getText());
                Categoria categoria = Categoria.valueOf(txtCategoria.getText().toUpperCase());
                Productos nuevo = new Productos(id,nombre,descripcion,precio,categoria);
                controller.updateProducto(nuevo);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar");
                alert.setContentText("El producto se ha editado correctamente, deberas actualizar");
                alert.show();
                vaciarCampos();
                configurarBotones(null);
            }

        });
        btnEliminar.setOnAction(event -> {
            if (txtId.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Por favor, ingrese el ID del producto a eliminar");
                alert.show();
                return;
            }
            int idIngresado = Integer.parseInt(txtId.getText());
            boolean existeId = tablaProductos.getItems().stream()
                    .anyMatch(item->item.getIdProducto()==idIngresado);
            if (existeId) {
            controller.deleteProducto(idIngresado);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exito");
            alert.setContentText("El producto se ha borrado correctamente, deberas actualizar");
            alert.show();
            configurarBotones(null);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("El id del usuario no se encuentra registrado");
                alert.show();
                vaciarCampos();
                configurarBotones(null);
            }
        });
        btnActualizar.setOnAction(event -> {
            tablaProductos.getItems().clear();
            initGUI();
            System.out.println("Tabla actualizada");
            configurarBotones(null);
        });
        configurarBotones(null);
        ArchivoController archivoController = new ArchivoController();
        archivoController.generarClientesXML();
        archivoController.generarProductosXML();
        archivoController.generarTechManageXML();
        archivoController.generarProveedoresXML();
        archivoController.generarTiendasXML();
        archivoController.generarVentasXML();
        vaciarCampos();
    }

    private void vaciarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
        txtCategoria.clear();
        tablaProductos.getSelectionModel().clearSelection();
        configurarBotones(null);
    }
    private void configurarBotones(Productos seleccionados) {
        boolean haySeleccion = seleccionados != null;

        btnEditar.setDisable(!haySeleccion);
        btnEliminar.setDisable(!haySeleccion);
        btnAgregar.setDisable(haySeleccion);
    }
}