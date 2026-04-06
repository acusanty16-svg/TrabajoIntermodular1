package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioTienda {
    private int idInventarioTienda;
    private int idProductos;
    private int idTienda;
    private int cantidadStock;
    private int stockMinimo;
}
