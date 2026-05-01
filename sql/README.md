# SQL - Base de Datos - TechManage 1.0
**Asignatura:** Bases de Datos
**Proyecto:** TechManage 1.0 - Sistema de gestión para tienda de componentes informáticos
---

## 📁 Contenido
Este directorio contiene toda la documentación y scripts SQL del proyecto.
---


## 📁 documentacion
**Carpeta:** `documentacion/`
**Contenido:** Documentación relacionada con el **diagrama E/R**  y el **modelo relacional**
sql/
|── documentacion/
            └── analisis_datos
            └── diagrama_ER

-`Analisis de Datos:` se encarga basicamente de ejemplificar el modelo relacional con sus respectivas
Entidades, Atributos, Claves primarias, Claves foráneas, Relaciones y Cardinalidades
-`Diagrama_ER:` como su nombre indica se ha efectuado la entidad relacion de cada elemento dentro
de la base de datos con la herramienta **draw.io** como un apoyo visual.
---


## 📁 modelajeSql
**Carpeta:** `modelajeSql/`
**Contenido:** Scripts SQL del modelo de datos del proyecto.
**Archivos:**
- `techmanage.sql` - Script principal con todas las tablas
- Sentencias CREATE TABLE
- Sentencias INSERT para datos de ejemplo
- Índices y relaciones
- Consultas con Join
- Consultas de búsqueda y filtros para agilizar busqueda o mencionar algo en especifico
- Consultas de estadisticas y agregados
**Base de datos:** `techmanage`
**Tablas creadas:**
- `productos` - Catálogo de productos
- `proveedores` - Datos de proveedores
- `productos_proveedores` - Relación muchos a muchos
- `tienda` - Información de tiendas
- `inventario_tienda` - Stock por tienda
- `clientes` - Datos de clientes
- `ventas` - Registro de ventas
- `detalle_venta` - Líneas de venta
---


## Estructura de la Base de Datos
**Motor:** MySQL (phpMyAdmin)
**Esquema:**
```
CLIENTES (1) ←----→ (N) VENTAS
                          ↓
                    DETALLE_VENTA (N)
                          ↓
PRODUCTOS (N) ←----→ (N) PROVEEDORES
                          ↓
                    PRODUCTOS_PROVEEDORES
                          ↓
TIENDA (1) ←----→ (N) INVENTARIO_TIENDA
```
---


## 📝 Comandos SQL principales
```sql
-- Crear base de datos
CREATE DATABASE techmanage;

-- Crear tablas
CREATE TABLE productos (...);
CREATE TABLE proveedores (...);
CREATE TABLE tienda (...);
CREATE TABLE inventario_tienda (...);
CREATE TABLE clientes (...);
CREATE TABLE ventas (...);
CREATE TABLE detalle_venta (...);
CREATE TABLE productos_proveedores (...);

-- Insertar datos de ejemplo
INSERT INTO productos VALUES (...);
INSERT INTO proveedores VALUES (...);
-- etc.
```
---


## Navegación rápida
```
sql/
├─ documentacion/
│       │    └── analisis_datos
│       └──── diagrama_ER
├─ modelajeSql/
│   └── techmanage.sql
└── README.md (este archivo)
```
---


## 📚 Recursos
- **MySQL:** Servidor local (phpMyAdmin)
- **Tablas:** 8 tablas principales
- **Registros de ejemplo:** 3 tiendas, 4 proveedores, 10 productos, 8 clientes, 6 ventas
- **Estado:** ✅ Completado
---


**Última actualización:** 2026-04-30