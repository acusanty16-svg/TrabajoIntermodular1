package model.listas;

import model.Clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Clientes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaClientes {
    @XmlElement(name = "Cliente")
    private List<Clientes> clientes;

    public ListaClientes() {
        clientes = new ArrayList<>();
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
}