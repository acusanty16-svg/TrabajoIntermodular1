package model;

public enum Login {
    PROVEEDOR("Eres un proveedor y solo puedes algunos elementos"),
    CLIENTE("Eres clientes y solo puedes ver algunos elementos"),
    ADMINISTRADOR("Eres admin y puedes ver todos los elementos");

    private final String descripcion;
    Login(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){return descripcion;}
}
