package controller;

import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloController {
    public List<Productos> getAllProducts(){
        List<Productos> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Productos");
            while(rs.next()){
                String catString = rs.getString("categoria");
                Categoria cat = null;
                if (catString != null) {
                    String enumValue = catString.toUpperCase().replace(" ", "_");
                    cat = Categoria.valueOf(enumValue);
                }
                Productos p = new Productos(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getLong("precio_venta"),
                        cat);
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Proveedores> getAllProveedores(){
        List<Proveedores> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Proveedores");
            while(rs.next()) {
                Proveedores p = new Proveedores(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("contacto")
                );
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Clientes> getAllClientes(){
        List<Clientes> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Clientes");
            while(rs.next()){
                Clientes cliente = new Clientes(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("dni")
                );
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Tienda> getAllTienda(){
        List<Tienda> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Tienda");
            while(rs.next()){
                Tienda tienda = new Tienda(
                        rs.getInt("id_tienda"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                lista.add(tienda);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Ventas> getAllVentas(){
        List<Ventas> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Ventas");
            while(rs.next()){
                String metodoString = rs.getString("metodo_pago");
                MetodoPago metodoPago = null;
                if (metodoString != null) {
                    String enumValue = metodoString.toUpperCase().replace(" ", "_");
                    metodoPago = MetodoPago.valueOf(enumValue);
                }
                int idCliente = 0;
                if (rs.getObject("id_cliente")!=null){
                    idCliente = rs.getInt("id_cliente");
                }
                Ventas ventas = new Ventas(
                        rs.getInt("id_ventas"),
                        idCliente,
                        rs.getInt("id_tienda"),
                        rs.getString("fecha_venta"),
                        metodoPago,
                        rs.getDouble("total")
                );
                lista.add(ventas);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<InventarioTienda> getAllInventarioTienda() {
        List<Productos> todosLosProductos = getAllProducts();
        List<Tienda> todasLasTiendas = getAllTienda();
        List<InventarioTienda> lista = new ArrayList<>();
        Connection conexion = ConexionSQL.getConnection();
        Statement stm = null;
        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("Select * from inventario_tienda");
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                int idTienda = rs.getInt("id_tienda");

                Productos producto = todosLosProductos.stream()
                        .filter(item->item.getIdProducto()==idProducto)
                        .findFirst().orElse(null);
                Tienda tienda = todasLasTiendas.stream()
                        .filter(item->item.getIdTienda()==idTienda)
                        .findFirst().orElse(null);
                InventarioTienda inv = new InventarioTienda();
                inv.setIdInventarioTienda(rs.getInt("id_inventario"));
                inv.setProductos(List.of(producto));
                inv.setTiendas(List.of(tienda));
                inv.setCantidadStock(rs.getInt("cantidad_stock"));
                inv.setStockMinimo(rs.getInt("stock_minimo"));

                lista.add(inv);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
    public List<DetalleVenta> getAllDetalleVenta(){
        List<Ventas> todasLasVentas = getAllVentas();
        List<Productos> todosLosProductos = getAllProducts();
        List<DetalleVenta> lista = new ArrayList<>();

        Connection conexion = ConexionSQL.getConnection();
        Statement stm = null;
        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("Select * from detalle_venta");

            while(rs.next()){
                int idVenta = rs.getInt("id_venta");
                int idProducto = rs.getInt("id_producto");

                Ventas venta = todasLasVentas.stream()
                        .filter(item->item.getIdVentas()==idVenta)
                        .findFirst().orElse(null);
                Productos producto = todosLosProductos.stream()
                        .filter(item->item.getIdProducto()==idProducto)
                        .findFirst().orElse(null);

                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalle(rs.getInt("id_detalle"));
                detalle.setVentas(List.of(venta));
                detalle.setProductos(List.of(producto));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setSubtotal(rs.getDouble("total"));

                lista.add(detalle);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<ProductosProveedores> getAllProProvee(){
        List<Productos> todosLosProductos = getAllProducts();
        List<Proveedores> todosLosProveedores = getAllProveedores();
        List<ProductosProveedores> lista = new ArrayList<>();

        Connection conexion = ConexionSQL.getConnection();
        Statement stm = null;
        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("Select * from productos_proveedores");
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                int idProveedor = rs.getInt("id_proveedor");

                Productos producto = todosLosProductos.stream()
                        .filter(item->item.getIdProducto()==idProducto)
                        .findFirst().orElse(null);
                Proveedores proveedor = todosLosProveedores.stream()
                        .filter(item->item.getIdProveedor()==idProveedor)
                        .findFirst().orElse(null);
                ProductosProveedores pp = new ProductosProveedores();
                pp.setIdPp(rs.getInt("id_pp"));
                pp.setProveedores(List.of(proveedor));
                pp.setProductos(List.of(producto));
                pp.setPrecioCompra(rs.getDouble("precio_compra"));
                pp.setFechaInicio(rs.getString("fecha_inicio"));

                lista.add(pp);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
