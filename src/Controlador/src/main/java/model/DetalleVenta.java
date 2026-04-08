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

public class DetalleVenta {
    @XmlAttribute
    private int idDetalle;
    @XmlElement(name="Ventas")
    private List<Ventas> ventas;
    @XmlElement(name="Productos")
    private List<Productos> productos;
    @XmlAttribute
    private int cantidad;
    @XmlAttribute
    private double precio;
    @XmlAttribute
    private double subtotal;

    public DetalleVenta(){
        ventas = new ArrayList<>();
        productos = new ArrayList<>();
    }
}
