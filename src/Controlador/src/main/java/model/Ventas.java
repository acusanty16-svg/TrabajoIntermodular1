package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ventas {
    private int idVentas;
    private int idCliente;
    private int idTienda;
    private String fechaVenta;
    private MetodoPago metodoPago;
    private double total;
}
