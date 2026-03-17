# TechManage 1.0

Sistema de gestión integral para una tienda de informática.

## Definición del Proyecto

### ¿Qué aplicación va a hacer?
**TechManage 1.0** es una aplicación de escritorio para la gestión integral de una tienda de informática.

### ¿Para qué sirve?
Para automatizar y digitalizar tres procesos fundamentales:
- Control de inventario de componentes y productos
- Gestión de clientes (registro, histórico de compras)
- Registro de ventas con generación de tickets

### ¿A quién va dirigida?
- **Dependientes/Vendedores**: Para registrar ventas y consultar stock
- **Administradores**: Para gestionar inventario, clientes e informes

### ¿Qué problema resuelve?
- **Pérdida de información**: Sustituye hojas de cálculo y papel por una base de datos estructurada
- **Falta de stock**: Alertas cuando los productos están por debajo del mínimo
- **Proceso lento de ventas**: Generación automática de tickets y receipts
- **Sin visibilidad**: Informes y estadísticas en tiempo real

## Características principales

- **Gestión de Inventario**: Control completo del stock de componentes y productos
- **Gestión de Clientes**: Registro y seguimiento de clientes
- **Registro de Ventas**: Generación de tickets y seguimiento de ventas
- **Informes**: Generación de reportes sobre inventario y ventas

## Tecnologías

- **Lenguaje**: Java
- **Base de Datos**: MySQL (con JDBC)
- **XML**: Validación con XSD
- **Control de Versiones**: Git

## Estructura del Proyecto

```
TrabajoIntermodular1/
├── docs/              # Documentación
│   ├── empleabilidad/
│   └── sistemas/
├── sql/               # Scripts de base de datos
├── xml/               # Esquemas XML/XSD
├── src/               # Código fuente Java
└── README.md          # Este archivo
```

## Requisitos

- Java JDK 8 o superior
- MySQL Server 5.7 o superior
- IDE compatible con Java (Eclipse, IntelliJ, VS Code)

## Instalación

1. Clonar el repositorio
2. Importar la base de datos desde `sql/`
3. Configurar la conexión a la base de datos en el código
4. Compilar y ejecutar la aplicación

## Autor

David Santiago Acuña Toro - Estudiante de DAM
