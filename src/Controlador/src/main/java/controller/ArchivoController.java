package controller;

import model.DetalleVenta;
import model.InventarioTienda;
import model.ProductosProveedores;
import model.Techmanage;

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
}
