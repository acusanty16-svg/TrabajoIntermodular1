package model.listas;

import model.Ventas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Ventas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaVentas {
    @XmlElement(name = "Venta")
    private List<Ventas> ventas;

    public ListaVentas() {
        ventas = new ArrayList<>();
    }

    public List<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }
}