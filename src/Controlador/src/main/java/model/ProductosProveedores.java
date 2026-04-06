package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosProveedores {
    private int idPp;
    private int idProducto;
    private int idProveedor;
    private long precioCompra;
    private int fecha;

}
