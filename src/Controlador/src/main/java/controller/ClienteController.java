package controller;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InventarioTienda;
import model.Productos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private TableView<Productos> tablaProductos;

    @FXML
    private TableColumn<Productos, Integer> colUnidades;

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
    private List<Productos> carrito;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new ModeloController();
        carrito = new ArrayList<>();
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        colUnidades.setCellValueFactory(cellData->{
            int idpProducto = cellData.getValue().getIdProducto();
            int stock = controller.getStockProducto(idpProducto);
            return new ReadOnlyIntegerWrapper(stock).asObject();
        });
    }

    private void initGUI() {
        List<Productos> productos = controller.getAllProducts();
        tablaProductos.getItems().addAll(productos);
    }

    private void actions() {
        btnVerCarrito.setOnAction(event -> {
            if (carrito.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Carrito Vacío");
                alert.setContentText("No hay productos en el carrito");
                alert.showAndWait();
                return;
            }

            StringBuilder contenido = new StringBuilder();
            double total = 0;
            Map<Integer, Integer> cantidades = new HashMap<>();
            Map<Integer, Double> precios = new HashMap<>();
            Map<Integer, String> nombres = new HashMap<>();

            for (Productos p : carrito) {
                int id = p.getIdProducto();
                cantidades.put(id, cantidades.getOrDefault(id, 0) + 1);
                precios.put(id, p.getPrecioVenta());
                nombres.put(id, p.getNombre());
            }

            for (int id : cantidades.keySet()) {
                int cantidad = cantidades.get(id);
                double precio = precios.get(id);
                String nombre = nombres.get(id);
                double subtotal = precio * cantidad;

                contenido.append("Producto: ").append(nombre).append("\n");
                contenido.append("Precio: ").append(String.format("%.2f €", precio)).append("\n");
                contenido.append("Cantidad: ").append(cantidad).append("\n");
                contenido.append("Subtotal: ").append(String.format("%.2f €", subtotal)).append("\n");
                contenido.append("────────────────────\n");
                total += subtotal;
            }

            contenido.append("TOTAL: ").append(String.format("%.2f €", total));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carrito de Compras");
            alert.setHeaderText("📦 Tus productos:");
            alert.setContentText(contenido.toString());
            alert.showAndWait();
        });
        btnComprar.setOnAction(event -> {
            Productos seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Selecciona un producto primero");
                alert.showAndWait();
                return;
            }
            int stockEnInventario = controller.getStockProducto(seleccionado.getIdProducto());
            if (stockEnInventario <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No hay stock disponible");
                alert.showAndWait();
                return;
            }
            TextInputDialog dialogo = new TextInputDialog("1");
            dialogo.setTitle("Cantidad");
            dialogo.setHeaderText("Stock disponible: " + stockEnInventario);
            dialogo.setContentText("¿Cuántas unidades quieres añadir?");
            Optional<String> resultado = dialogo.showAndWait();
            if (resultado.isPresent()) {
                try {
                    int cantidad = Integer.parseInt(resultado.get());
                    if (cantidad <= 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("La cantidad debe ser mayor a 0");
                        alert.showAndWait();
                        return;
                    }
                    if (cantidad > stockEnInventario) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("Solo hay " + stockEnInventario + " unidades disponibles");
                        alert.showAndWait();
                        return;
                    }
                    int nuevoStock = stockEnInventario - cantidad;
                    if (nuevoStock <= 0) {
                        controller.eliminarInventario(seleccionado.getIdProducto());
                    } else {
                        controller.actualizarStock(seleccionado.getIdProducto(), nuevoStock);
                    }
                    for (int i = 0; i < cantidad; i++) {
                        carrito.add(seleccionado);
                    }
                    tablaProductos.getItems().clear();
                    initGUI();
                    tablaProductos.refresh();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText(cantidad + " unidad(es) añadidas al carrito");
                    alert.showAndWait();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Ingresa un número válido");
                    alert.showAndWait();
                }
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