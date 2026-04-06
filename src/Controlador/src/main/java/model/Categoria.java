package model;

public enum Categoria {
    DISPONIBLE("Tenemos unidades disponibles a la venta"),
    SIN_STOCK("Lastimosamente, no tenemos elementos, pero ya llegaran");
    private final String stockDisponible;
    Categoria(String descripcion){
        this.stockDisponible=descripcion;
    }
    public String getdescripcion(){
        return stockDisponible;
    }
}
