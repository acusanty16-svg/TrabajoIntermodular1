package model;

public enum MetodoPago {
    TARJETA("Introduzca la tarjeta para pagar"),
    EFECTIVO("Digite el total a pagar");

    private final String modoPago;
     MetodoPago(String modoPago){
        this.modoPago = modoPago;
    }
    public String getModoPago() {
        return modoPago;
    }
}
