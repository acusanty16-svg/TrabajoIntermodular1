package model.listas;

import model.Proveedores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Proveedores")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaProveedores {
    @XmlElement(name = "Proveedor")
    private List<Proveedores> proveedores;

    public ListaProveedores() {
        proveedores = new ArrayList<>();
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }
}