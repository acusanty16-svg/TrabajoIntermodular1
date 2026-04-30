package model.listas;

import model.Tienda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Tiendas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaTiendas {
    @XmlElement(name = "Tienda")
    private List<Tienda> tiendas;

    public ListaTiendas() {
        tiendas = new ArrayList<>();
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }
}