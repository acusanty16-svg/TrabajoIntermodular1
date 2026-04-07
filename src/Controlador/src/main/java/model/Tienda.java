package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {
    private int idTienda;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

}
