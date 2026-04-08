package model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data

@XmlRootElement(name="Techmanage")
public class Techmanage {
    @XmlElement(name="Venta con Productos")
    private List<DetalleVenta> ventaConProductos;
    @XmlElement(name="Inventario con Stock")
    private List<InventarioTienda> InventarioConStock;
    @XmlElement(name="Productos con Proveedores")
    private List<ProductosProveedores> productosConProveedores;


}
