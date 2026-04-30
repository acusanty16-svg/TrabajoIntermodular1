package controller;

import model.*;
import model.listas.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class ArchivoController {
    public void generarTechManageXML(){
        ModeloController controller = new ModeloController();
        List<InventarioTienda> inventario = controller.getAllInventarioTienda();
        List<DetalleVenta> detalleVenta = controller.getAllDetalleVenta();
        List<ProductosProveedores> pp = controller.getAllProProvee();

        Techmanage techmanage = new Techmanage();
        techmanage.setInventarioConStock(inventario);
        techmanage.setVentaConProductos(detalleVenta);
        techmanage.setProductosConProveedores(pp);

        try {
            JAXBContext context = JAXBContext.newInstance(Techmanage.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Techmanage.xml");
            marshaller.marshal(techmanage, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarClientesXML(){
        ModeloController controller = new ModeloController();
        List<Clientes> lista = controller.getAllClientes();
        
        ListaClientes clientes = new ListaClientes();
        clientes.setClientes(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(ListaClientes.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Clientes.xml");
            marshaller.marshal(clientes, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarProductosXML(){
        ModeloController controller = new ModeloController();
        List<Productos> lista = controller.getAllProducts();
        
        ListaProductos productos = new ListaProductos();
        productos.setProductos(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(ListaProductos.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Productos.xml");
            marshaller.marshal(productos, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarProveedoresXML(){
        ModeloController controller = new ModeloController();
        List<Proveedores> lista = controller.getAllProveedores();
        
        ListaProveedores proveedores = new ListaProveedores();
        proveedores.setProveedores(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(ListaProveedores.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Proveedores.xml");
            marshaller.marshal(proveedores, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarTiendasXML(){
        ModeloController controller = new ModeloController();
        List<Tienda> lista = controller.getAllTienda();
        
        ListaTiendas tiendas = new ListaTiendas();
        tiendas.setTiendas(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(ListaTiendas.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Tiendas.xml");
            marshaller.marshal(tiendas, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarVentasXML(){
        ModeloController controller = new ModeloController();
        List<Ventas> lista = controller.getAllVentas();
        
        ListaVentas ventas = new ListaVentas();
        ventas.setVentas(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(ListaVentas.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/main/java/files/Ventas.xml");
            marshaller.marshal(ventas, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
