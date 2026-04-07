package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {
    private int idCliente;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String dni;
}
