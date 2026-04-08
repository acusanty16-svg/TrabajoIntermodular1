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

public class InventarioTienda {
    @XmlAttribute
    private int idInventarioTienda;
    @XmlElement(name = "Productos")
    private List<Productos> productos;
    @XmlElement(name="Tiendas")
    private List<Tienda> tiendas;
    @XmlAttribute
    private int cantidadStock;
    @XmlAttribute
    private int stockMinimo;

    public InventarioTienda(){
        productos = new ArrayList<>();
        tiendas = new ArrayList<>();
    }
}
