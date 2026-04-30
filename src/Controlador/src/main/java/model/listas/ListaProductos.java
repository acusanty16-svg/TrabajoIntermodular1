package model.listas;

import model.Productos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Productos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaProductos {
    @XmlElement(name = "Producto")
    private List<Productos> productos;

    public ListaProductos() {
        productos = new ArrayList<>();
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
}