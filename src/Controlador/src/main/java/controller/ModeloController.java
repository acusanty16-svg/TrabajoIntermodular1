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
                Integer idCliente = null;
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
}
