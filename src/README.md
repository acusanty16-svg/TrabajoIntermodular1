# SRC - Código Fuente - TechManage 1.0
**Asignaturas:** Programación (MPO) / Lenguaje de Marcas / Base de Datos
**Proyecto:** TechManage 1.0 - Sistema de gestión para tienda de componentes informáticos
---

## 📁 Contenido
Este directorio contiene el código fuente del proyecto organizado por asignaturas.

---

## 📁 Controlador
**Carpeta:** `Controlador/`
**Asignatura:** Programación (MPO) - Técnicas de Programación
**Contenido:** Código Java de la aplicación.
**Archivos principales:**
- `src//main/java/` - Código Java
  - `Main.java` - Punto de entrada (consola)
  - `TechmanageFX.java` - Aplicación JavaFX
  - `Launcher.java` - Launcher Maven
  - `controller/` - Controladores
    - `ConexionSQL.java` - Conexión JDBC a MySQL
    - `ModeloController.java` - Métodos CRUD
    - `ArchivoController.java` - Generación XML
    - `LoginController.java` - Controlador login
    - `AdminController.java` - Panel admin
    - `ClienteController.java` - Panel cliente
    - `ProveedorController.java` - Panel proveedor
  - `model/` - Modelos de datos
    - `Productos.java`, `Proveedores.java`, `Clientes.java`
    - `Tienda.java`, `Ventas.java`, `DetalleVenta.java`
    - `Login.java` - Enum tipos de usuario
    - `listas/` - Wrappers JAXB para XML
  - `data/` - Conjuntos de datos
    - `DataSet.java` - Validación de usuarios
  - `files/` - Archivos de datos
    - `Login.txt` - Credenciales de usuario
    - `*.xml` - Archivos XML exportados
- `src/ main/resources/` - Recursos
  - `org/example/controlador/` - Vistas FXML
    - `login- view.fxml` - Formulario de login
    - `admin- view.fxml` - Panel administrador
    - `client- view.fxml` - Panel cliente
    - `proveedor- view.fxml` - Panel proveedor
- `pom.xml` - Configuración Maven
**Tecnologías:** Java 17+, JavaFX 24.0.1, JDBC, Maven
**Estado:** ✅ Completado (Fase 6 - Consultas SQL)

---

## 📁 Programacion
**Carpeta:** `Programacion/` (pendiente de crear)
**Asignatura:** MPO - Técnicas de Programación
**Contenido:** Ejercicios y prácticas de programación Java.
**Archivos:**
- Ejercicios de refuerzo
- Prácticas de POO
- Ejemplos de patrones de diseño
- Ejercicios de interfaces y colecciones
**Estado:** ⏳ Pendiente de crear

---

## 📁 LenguajeDeMarcas
**Carpeta:** `LenguajeDeMarcas/`
**Asignatura:** Lenguaje de Marcas
**Contenido:** Archivos XML generados con JAXB. Ubicados en `Controlador/src/ main/java/files/`.
**Archivos del proyecto:** (en `files/`)
- `Techmanage.xml` - Documento principal XML (contiene todo)
- `Productos.xml` - Lista de productos
- `Proveedores.xml` - Lista de proveedores
- `Clientes.xml` - Lista de clientes
- `Tiendas.xml` - Lista de tiendas
- `Ventas.xml` - Lista de ventas
- `Login.txt` - Credenciales de usuarios
**Tecnologías:** XML, JAXB, XSD (validación de esquemas)
**Estado:** ✅ Completado (Fase 4)

---

## 📚 Lenguajes y Tecnologías
| Asignatura | Lenguaje/Tecnología |
|------------|---------------------|
| Programación (MPO) | Java, JavaFX, JDBC, Maven |
| Lenguaje de Marcas | XML, XSD, JAXB |
| Base de Datos | MySQL, SQL, JDBC |

---

## 🏗️ Arquitectura del Proyecto
```java
// Estructura Java
src/ Controlador/src/main/java/
├── Main.java                    // Entrada consola
├── TechmanageFX.java           // Aplicación JavaFX
├── controller/
│   ├── ConexionSQL.java       // MySQL
│   ├── ModeloController.java    // CRUD
│   ├── ArchivoController.java // XML
│   └── *Controller.java      // JavaFX
├── model/
│   ├── Productos.java         // Entidad
│   └── listas/              // Wrappers JAXB
├── data/
│   └── DataSet.java         // Login
└── files/
    └── Login.txt            // Usuarios
```

---

## 📋 Historial de Desarrollo
| Fecha | Fase | Descripción |
|-------|------|-------------|
| 2026-04-07 | Fase 3 | Conexión JDBC y métodos getAll() |
| 2026-04-08 | Fase 4 | Generación XML con JAXB |
| 2026-04-30 | Fase 5 | Interfaz JavaFX completa |
| 2026-05-01 | Fase 6 | 21 consultas SQL (JOIN, búsqueda, estadísticas) |

---

## Navegación rápida
```
src/
├── Controlador/              # ✅ Completado
│   ├── src/main/java/        # Código Java
│   ├── src/main/resources/    # FXML
│   └── pom.xml              # Maven
├── Programacion/              # ✅ Completado
└── LenguajeDeMarcas/        # ✅ Completado
    └── *.xml, *.xsd
```

---

## 📖 Recursos
- **Java:** https://docs. oracle.com/ javase/
- **JavaFX:** https://openjfx.io/
- **MySQL:** https://dev.mysql.com/ doc/
- **JAXB:** https://eclipse-ee4j.github.io/jaxb/

**Última actualización:** 2026-05-02 (Fase 6 - Consultas SQL)