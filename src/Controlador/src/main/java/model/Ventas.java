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
public class Ventas {
    @XmlAttribute
    private int idVentas;
    @XmlAttribute
    private int idCliente;
    @XmlAttribute
    private int idTienda;
    @XmlAttribute
    private String fechaVenta;
    @XmlAttribute
    private MetodoPago metodoPago;
    @XmlAttribute
    private double total;
}
