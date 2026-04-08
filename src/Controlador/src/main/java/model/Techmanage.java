package model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data

@XmlRootElement(name="Techmanage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Techmanage {
    @XmlElement(name="Venta_con_Productos")
    private List<DetalleVenta> ventaConProductos;
    @XmlElement(name="Inventario_con_Stock")
    private List<InventarioTienda> inventarioConStock;
    @XmlElement(name="Productos_con_Proveedores")
    private List<ProductosProveedores> productosConProveedores;

    public Techmanage (){
        ventaConProductos = new ArrayList<>();
        inventarioConStock = new ArrayList<>();
        productosConProveedores = new ArrayList<>();
    }

}
