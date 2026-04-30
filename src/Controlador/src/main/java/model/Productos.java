package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Productos {
    @XmlAttribute
    private int idProducto;
    @XmlAttribute
    private String nombre;
    @XmlAttribute
    private String descripcion;
    @XmlAttribute
    private double precioVenta;
    @XmlAttribute
    private Categoria categoria;
    
}
