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
    private int fechaVenta;
    private MetodoPago metodoPago;
    private int total;
}
