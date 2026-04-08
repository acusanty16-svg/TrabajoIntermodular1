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
public class Proveedores {
    @XmlAttribute
    private int idProveedor;
    @XmlAttribute
    private String nombre;
    @XmlAttribute
    private String email;
    @XmlAttribute
    private String telefono;
    @XmlAttribute
    private String direccion;
    @XmlAttribute
    private String contacto;
}
