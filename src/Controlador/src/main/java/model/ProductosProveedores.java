package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class ProductosProveedores {
    @XmlAttribute
    private int idPp;
    @XmlElement(name = "Proveedores")
    private List<Proveedores> proveedores;
    @XmlElement(name = "Productos")
    private List<Productos> productos;
    @XmlAttribute
    private double precioCompra;
    @XmlAttribute
    private String fechaInicio;

    public ProductosProveedores(){
        proveedores = new ArrayList<>();
        productos = new ArrayList<>();
    }
}
