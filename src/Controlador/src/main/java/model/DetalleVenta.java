package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    private int idDetalle;
    private int idVenta;
    private int idProductos;
    private int cantidad;
    private double precio;
    private double total;

}
