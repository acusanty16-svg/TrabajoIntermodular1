# TechManage 1.0 - Evidencias del Proyecto

## Información General

| Campo | Descripción |
|-------|-------------|
| **Proyecto** | TechManage 1.0 |
| **Aplicación** | Sistema de gestión para tienda de componentes informáticos |
| **Tecnología** | Java + JavaFX + MySQL + JAXB + Maven |
| **Repositorio** | https://github.com/acusanty16-svg/TrabajoIntermodular1 |
| **Estado** | Fase 5 completada |

---

## Historial de Desarrollo

### Fase 1: Inicialización del Proyecto

**Fecha:** 2026-03-12

**Actividades realizadas:**
- Creación del repositorio Git local
- Enlace con repositorio remoto en GitHub
- Commit inicial con README.md, modulos.txt y seguimiento.txt
- Definición inicial del proyecto en README.md

**Archivos creados:**
- `README.md` - Definición del proyecto
- `modulos.txt` - Descripción de módulos
- `seguimiento.txt` - Control de comandos Git

**Estado:** ✅ Completada

---

### Fase 2: Diseño de la Base de Datos

**Fecha:** 2026-04-06

**Actividades realizadas:**
- Revisión y mejora del archivo `analisis_datos.md`
- Añadida entidad DETALLE_VENTA
- Actualización del diagrama ER con DETALLE_VENTA
- Actualización del modelo relacional
- Eliminación de id_proveedor de INVENTARIO_TIENDA
- Creación de tablas en phpMyAdmin local:
  - productos, proveedores, productos_proveedores
  - tienda, inventario_tienda, clientes, ventas, detalle_venta
- Exportación de script SQL a `sql/modelajeSql/techmanage.sql`
- Inserción de datos de ejemplo

**Datos insertados:**
- 3 tiendas
- 4 proveedores
- 10 productos
- 11 relaciones productos_proveedores
- 18 registros de inventario
- 8 clientes
- 6 ventas
- 10 detalles de venta

**Archivos creados:**
- `docs/sistemas/analisis_datos.md`
- `docs/sistemas/diagrama_ER.drawio`
- `docs/sistemas/modelo_relacional.drawio`
- `sql/modelajeSql/techmanage.sql`

**Estado:** ✅ Completada

---

### Fase 3: Programación Java (Conexión y Métodos)

**Fecha:** 2026-04-07

**Actividades realizadas:**
- Implementación de ConexionSQL.java (conexión JDBC a MySQL)
- Implementación de ModeloController.java con métodos getAll():
  - getAllProducts() - lista de Productos
  - getAllProveedores() - lista de Proveedores
  - getAllClientes() - lista de Clientes
  - getAllTienda() - lista de Tiendas
  - getAllVentas() - lista de Ventas
- Corrección de errores en getAllVentas()
- Decisión de diseño: métodos directos en ModeloController

**Archivos creados:**
- `src/Controlador/src/main/java/controller/ConexionSQL.java`
- `src/Controlador/src/main/java/controller/ModeloController.java`

**Comando Git:**
```
git add . && git commit -m "Fase 3: Implementación conexión JDBC y métodos getAll()" && git push
```

**Estado:** ✅ Completada

---

### Fase 4: Generación de XML con JAXB

**Fecha:** 2026-04-08

**Actividades realizadas:**
- Implementación de modelos JAXB para exportación XML:
  - InventarioTienda.java - List<Productos>, List<Tienda>
  - ProductosProveedores.java - List<Productos>, List<Proveedores>
  - DetalleVenta.java - List<Ventas>, List<Productos>
  - Techmanage.java - clase raíz @XmlRootElement
- ModeloController.java:
  - getAllInventarioTienda() - relaciona inventario con productos y tiendas
  - getAllDetalleVenta() - lista de detalles
- Main.java: implementación simple con ArchivoController
- ArchivoController: generarTechManageXML() con JAXB Marshaller
- Resultado: Techmanage.xml generado correctamente

**Archivos creados:**
- `src/Controlador/src/main/java/model/InventarioTienda.java`
- `src/Controlador/src/main/java/model/ProductosProveedores.java`
- `src/Controlador/src/main/java/model/DetalleVenta.java`
- `src/Controlador/src/main/java/model/Techmanage.java`
- `src/Controlador/src/main/java/controller/ArchivoController.java`
- `src/Controlador/src/main/java/Main.java`
- `src/Controlador/src/main/java/files/Techmanage.xml`

**Comando Git:**
```
git add . && git commit -m "Fase 3/4: XML generado con JAXB y errores corregidos" && git push
```

**Estado:** ✅ Completada

---

### Fase 5: Interfaz Gráfica JavaFX

**Fecha:** 2026-04-30

**Actividades realizadas:**
- Configuración de JavaFX en pom.xml:
  - Dependencias: javafx-controls, javafx-fxml (24.0.1)
  - Plugin: javafx-maven-plugin (0.0.8)
- Creación de estructura de carpetas:
  - src/main/java/view/ (vistas FXML)
  - src/main/java/controllerfx/ (controllers JavaFX)
  - src/main/resources/org/example/controlador/ (FXMLs)
- Eliminación de module-info.java (conflictos con JAXB)
- Creación de vistas FXML:
  - login-view.fxml - Formulario de login
  - admin-view.fxml - Panel de admin con tabla CRUD
  - client-view.fxml - Panel de cliente
  - proveedor-view.fxml - Panel de proveedor
- Implementación de controllers JavaFX:
  - TechmanageFX.java - Application principal
  - LoginController.java - Validación de usuarios
  - AdminController.java - CRUD completo de productos
  - ClienteController.java - Ver productos
  - ProveedorController.java - Ver inventario
- Creación de Login.txt con 20 usuarios
- Implementación de enum Login.java
- Métodos CRUD en ModeloController.java:
  - insertProducto() - Insertar producto
  - updateProducto() - Actualizar producto
  - deleteProducto() - Eliminar producto
- Sistema de selección en AdminController:
  - Listener que auto-llena TextFields
  - Botones habilita/deshabilita según selección

**Errores corregidos:**
- Error JAXB: "package javax.xml.bind.annotation not visible" → Eliminado module-info.java
- Error FXML: "Location is not set" → Ruta correcta "/org/example/controlador/"
- Error enum MySQL: "Data truncated for category" → Mayúsculas
- NumberFormatException: TextFields vacíos → Listener de selección

**Archivos creados:**
- `src/Controlador/pom.xml` (actualizado)
- `src/Controlador/src/main/java/TechmanageFX.java`
- `src/Controlador/src/main/java/controller/LoginController.java`
- `src/Controlador/src/main/java/controller/AdminController.java`
- `src/Controlador/src/main/java/controller/ClienteController.java`
- `src/Controlador/src/main/java/controller/ProveedorController.java`
- `src/Controlador/src/main/java/data/DataSet.java`
- `src/Controlador/src/main/java/model/Login.java`
- `src/Controlador/src/main/java/model/Administrador.java`
- `src/Controlador/src/main/java/files/Login.txt`
- `src/Controlador/src/main/resources/org/example/controlador/login-view.fxml`
- `src/Controlador/src/main/resources/org/example/controlador/admin-view.fxml`
- `src/Controlador/src/main/resources/org/example/controlador/client-view.fxml`
- `src/Controlador/src/main/resources/org/example/controlador/proveedor-view.fxml`
- Wrapper classes: ListaClientes, ListaProductos, ListaProveedores, ListaTiendas, ListaVentas

**Comando Git:**
```
git add . && git commit -m "Fase 5: Implementación JavaFX con interfaz gráfica" && git push
```

**Estado:** ✅ Completada

---

### Fase 6: Consultas SQL Avanzadas

**Fecha:** 2026-05-01

**Actividades realizadas:**
- Implementación de consultas JOIN (multitabla):
  - 1. Ventas con datos de cliente y tienda
  - 2. Detalle de ventas con productos
  - 3. Inventario por tienda con productos
  - 4. Productos con proveedores y precios de compra
  - 5. Ventas completas con todos los datos
  - 6. Productos con mejor margen por proveedor
- Implementación de consultas de búsqueda y filtros:
  - 7. Buscar cliente por nombre (LIKE)
  - 8. Buscar producto por nombre
  - 9. Productos sin stock
  - 10. Stock bajo mínimo
  - 11. Ventas por rango de fechas
  - 12. Ventas por método de pago
- Implementación de consultas de estadísticas y agregados:
  - 13. Top clientes por compras (suma total)
  - 14. Tienda con más ventas
  - 15. Productos más vendidos (por cantidad)
  - 16. Proveedores de un producto
  - 17. Gasto total por proveedor
  - 18. Total de ventas por tienda
  - 19. Promedio de venta
  - 20. Cantidad total de productos vendidos
  - 21. Inventario total por producto
- Actualización de comentarios del archivo SQL a español

**Archivos actualizados:**
- `sql/modelajeSql/techmanage.sql` - Añadidas 21 queries con comentarios en español

**Estado:** ✅ Completada

---

## Estado Final del Proyecto

| Fase | Estado | Fecha |
|------|--------|-------|
| Fase 1 - Repositorio | ✅ Completada | 2026-03-12 |
| Fase 2 - Diseño BD | ✅ Completada | 2026-04-06 |
| Fase 3 - Programación | ✅ Completada | 2026-04-07 |
| Fase 4 - XML | ✅ Completada | 2026-04-08 |
| Fase 5 - JavaFX | ✅ Completada | 2026-04-30 |
| Fase 6 - Consultas SQL | ✅ Completada | 2026-05-01 |

---

## Usuarios del Sistema

**Total:** 20 usuarios

| Tipo | Usuarios | Contraseña |
|------|----------|------------|
| ADMINISTRADOR | admin1 - admin7 | admin123 - admin789 |
| CLIENTE | cliente1 - cliente7 | cliente123 - cliente789 |
| PROVEEDOR | proveedor1 - proveedor6 | proveedor123 - proveedor689 |

---

## Tecnologías Utilizadas

| Tecnología | Uso |
|------------|-----|
| Java 17+ | Lenguaje de programación |
| JavaFX 24.0.1 | Interfaz gráfica |
| Maven | Gestión de dependencias |
| MySQL | Base de datos |
| JDBC | Conexión a base de datos |
| JAXB | Serialización XML |
| Git | Control de versiones |
| phpMyAdmin | Administración de MySQL |
| GitHub | Repositorio remoto |

---

## Estructura del Proyecto

```
TrabajoIntermodular1/
├── sql/
│   ├── modelajeSql/
│   │   └── techmanage.sql          # Script SQL completo con 21 consultas
│   └── documentacion/
│       ├── analisis_datos.md
│       └── diagrama_ER.drawio
├── src/
│   └── Controlador/
│       ├── pom.xml                  # Maven con JavaFX, JAXB, MySQL
│       └── src/main/
│           ├── java/
│           │   ├── Main.java
│           │   ├── TechmanageFX.java
│           │   ├── controller/
│           │   │   ├── ConexionSQL.java
│           │   │   ├── ModeloController.java
│           │   │   ├── LoginController.java
│           │   │   ├── AdminController.java
│           │   │   ├── ClienteController.java
│           │   │   ├── ProveedorController.java
│           │   │   └── ArchivoController.java
│           │   ├── model/
│           │   │   ├── Productos.java, Clientes.java, Proveedores.java
│           │   │   ├── Ventas.java, Tienda.java, Categoria.java
│           │   │   ├── InventarioTienda.java, DetalleVenta.java
│           │   │   ├── ProductosProveedores.java, Techmanage.java
│           │   │   ├── Login.java, MetodoPago.java
│           │   │   └── listas/ (ListaClientes, ListaProductos, etc.)
│           │   ├── data/
│           │   │   └── DataSet.java
│           │   └── Launcher.java
│           └── resources/
│               └── org/example/controlador/
│                   ├── login-view.fxml
│                   ├── admin-view.fxml
│                   ├── client-view.fxml
│                   └── proveedor-view.fxml
├── docs/
│   ├── sistemas/
│   │   ├── evidencias/
│   │   │   └── evidencias.md
│   │   └── informe_tecnico.md
│   └── empleabilidad/
│       └── (documentos de empleabilidad)
└── README.md
```

---

## Consultas SQL Incluidas

### Consultas JOIN (6)
1. Ventas + Cliente + Tienda
2. DetalleVenta + Productos + Ventas
3. Inventario + Productos + Tienda
4. Productos + ProductosProveedores + Proveedores
5. Ventas completas (todos los datos)
6. Productos con mejor margen

### Consultas de Búsqueda (6)
7. Buscar cliente por nombre
8. Buscar producto por nombre
9. Productos sin stock
10. Stock bajo mínimo
11. Ventas por fecha
12. Ventas por método de pago

### Consultas de Estadísticas (9)
13. Top clientes por compras
14. Tienda con más ventas
15. Productos más vendidos
16. Proveedores por producto
17. Gasto por proveedor
18. Total ventas por tienda
19. Promedio de venta
20. Total productos vendidos
21. Inventario total por producto

---

**Documento generado:** 2026-04-30
**Última actualización:** 2026-05-01 - Fase 6 completada (Consultas SQL)