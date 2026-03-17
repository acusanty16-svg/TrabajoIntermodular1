# Análisis de Datos - TechManage 1.0

## 1. Información que maneja mi aplicacion.

### Funcionalidades del sistema:

Pensando un poco en algunas problematicas que afectan al sector de gestion entre supervisores o encargados de diferentes tiendas y he creado esta aplicacion para solventar ciertos problemas en este sector. Las entidades que he podido recolectar han sido estas:
-Inventario: (porque los encargados manejarian stocks inmensos en algunos casos y seria prudente tener control de ellos)
-Clientes: (Tener clientela permitira tener un mejor control de ganancias futuras...)
-Ventas: (Así como es importante saber cuanto se invierte en productos, asimismo en cuanto ganamos)
-Proveedores: (Sin ellos no tendriamos los mejores precios para comercializar)

---

## 2. Entidades Identificadas

### ENTIDAD: PRODUCTOS

| Atributo       | Tipo          | Descripción                |
| -------------- | ------------- | -------------------------- |
| id_producto    | INT (PK)      | Identificador único        |
| nombre         | VARCHAR(100)  | Nombre del producto        |
| descripcion    | TEXT          | Descripción del producto   |
| precio_venta   | DECIMAL(10,2) | Precio de venta al cliente |
| categoria      | VARCHAR(50)   | Categoría del producto     |
| fecha_creacion | DATETIME      | Fecha de alta              |

---

### ENTIDAD: PROVEEDORES

| Atributo     | Tipo         | Descripción          |
| ------------ | ------------ | -------------------- |
| id_proveedor | INT (PK)     | Identificador único  |
| nombre       | VARCHAR(100) | Nombre de la empresa |
| email        | VARCHAR(100) | Correo electrónico   |
| telefono     | VARCHAR(20)  | Teléfono de contacto |
| direccion    | VARCHAR(200) | Dirección fiscal     |
| contacto     | VARCHAR(100) | Persona de contacto  |

---

### ENTIDAD: PRODUCTOS_PROVEEDORES (Tabla Intermedia)

| Atributo      | Tipo          | Descripción                   |
| ------------- | ------------- | ----------------------------- |
| id_pp         | INT (PK)      | Identificador único           |
| id_producto   | INT (FK)      | Producto                      |
| id_proveedor  | INT (FK)      | Proveedor                     |
| precio_compra | DECIMAL(10,2) | Precio de compra al proveedor |
| fecha_inicio  | DATE          | Fecha inicio relación         |

---

### ENTIDAD: TIENDA

| Atributo  | Tipo         | Descripción         |
| --------- | ------------ | ------------------- |
| id_tienda | INT (PK)     | Identificador único |
| nombre    | VARCHAR(100) | Nombre de la tienda |
| direccion | VARCHAR(200) | Dirección           |
| telefono  | VARCHAR(20)  | Teléfono            |
| email     | VARCHAR(100) | Correo electrónico  |

---

### ENTIDAD: INVENTARIO_TIENDA (tabla intermedia)

| Atributo             | Tipo     | Descripción            |
| -------------------- | -------- | ---------------------- |
| id_inventario        | INT (PK) | Identificador único    |
| id_producto          | INT (FK) | Producto               |
| id_tienda            | INT (FK) | Tienda                 |
| cantidad_stock       | INT      | Stock actual           |
| stock_minimo         | INT      | Stock mínimo de alerta |
| ultima_actualizacion | DATETIME | Última actualización   |

---

### ENTIDAD: CLIENTES

| Atributo       | Tipo         | Descripción          |
| -------------- | ------------ | -------------------- |
| id_cliente     | INT (PK)     | Identificador único  |
| nombre         | VARCHAR(100) | Nombre completo      |
| email          | VARCHAR(100) | Correo electrónico   |
| telefono       | VARCHAR(20)  | Teléfono de contacto |
| direccion      | VARCHAR(200) | Dirección            |
| dni            | VARCHAR(20)  | DNI/NIF del cliente  |
| fecha_registro | DATETIME     | Fecha de alta        |

---

### ENTIDAD: VENTAS

| Atributo    | Tipo          | Descripción                   |
| ----------- | ------------- | ----------------------------- |
| id_venta    | INT (PK)      | Identificador único           |
| id_cliente  | INT (FK)      | Cliente que compra (opcional) |
| id_tienda   | INT (FK)      | Tienda donde se hace la venta |
| fecha_venta | DATETIME      | Fecha de la venta             |
| total       | DECIMAL(10,2) | Importe total                 |
| metodo_pago | VARCHAR(50)   | Efectivo, tarjeta, etc.       |

---

## 3. Relaciones

| Relación                | Tipo | Descripción                                  |
| ----------------------- | ---- | -------------------------------------------- |
| Productos - Proveedores | N:M  | Tabla intermedia productos_proveedores       |
| Productos - Tienda      | N:M  | Tabla intermedia inventario_tienda           |
| Ventas - Clientes       | N:1  | Una venta puede ser de un cliente (opcional) |
| Ventas - Tienda         | N:1  | Cada venta pertenece a una tienda            |

---

### Explicacion de relaciones

#### Productos - Proveedores (N:M)

Un producto puede comprarse a varios proveedores(esto es un caso hipotetico porque cada proveedor debería tener su propia marca, pero bueno para el ejemplo nos vale) y un proveedor puede vendernos varios productos. La tabla que se ha creado es: "productos_Proveedores" y se guardará la fecha de la relacion comercial y el precio de compra

#### Productos - Tienda (N:M)

Un mismo producto puede estar disponible en varias tiendas y varias tiendas pueden tener el mismo producto(es un caso hipotetico porque la unicidad de cada producto es importante para gestionar el stock. Sin embargo con este metodo cada tienda puede tener unicidad entonces para una franquicia quizás hay que plantear otra metodología pero para varias tiendas independientes esta muy bien). La tabla que se ha creado es: "inventario_tienda"

#### Ventas - Clientes (N:1)

Un cliente puede realizar múltiples ventas a lo largo del tiempo, pero cada venta pertenece a un único cliente.

#### Ventas - Tienda (N:1)

Cada venta se realiza en una tienda concreta. Una tienda puede tener muchas ventas registradas. Esta relación permite saber dónde se realizó cada transacción.
