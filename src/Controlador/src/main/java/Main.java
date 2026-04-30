import controller.ArchivoController;

public class Main {
    public static void main(String[] args) {
        ArchivoController archivoController = new ArchivoController();

        archivoController.generarTechManageXML();
        archivoController.generarClientesXML();
        archivoController.generarProductosXML();
        archivoController.generarProveedoresXML();
        archivoController.generarTiendasXML();
        archivoController.generarVentasXML();
    }
}
