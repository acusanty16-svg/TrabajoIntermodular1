# Informe Técnico - TechManage 1.0

## 1. Tipo de sistema donde se ejecuta

### Opción elegida: Servidor local

Para una tienda de informática con varias ubicaciones, la mejor opción es un servidor local por las siguientes razones:

- **Control total**: La tienda tiene control completo sobre sus datos
- **Costos**: No requiere pago mensual de servicios cloud
- **Rendimiento**: Baja latencia al estar en la misma red local
- **Seguridad**: Los datos no salen de la infraestructura de la tienda

### Justificación

Un PC de usuario no es suficiente porque:

- Los datos deben estar centralizados para las tiendas
- Necesita estar siempre disponible
- Requiere mayor capacidad de almacenamiento

Una máquina virtual o equipo dedicado depende del volumen de datos y número de tiendas. Para empezar, un PC servidores suficiente.

---

## 2. Requisitos de hardware

### Hardware mínimo

| Componente     | Especificación mínima       |
| -------------- | --------------------------- |
| CPU            | Intel Core i3 / AMD Ryzen 3 |
| RAM            | 4 GB                        |
| Almacenamiento | 256 GB SSD                  |
| Red            | Ethernet 100 Mbps           |

### Hardware recomendado

| Componente     | Especificación recomendada  |
| -------------- | --------------------------- |
| CPU            | Intel Core i5 / AMD Ryzen 5 |
| RAM            | 8 GB                        |
| Almacenamiento | 512 GB SSD                  |
| Red            | Ethernet 1 Gbps             |

### Justificación

- **CPU**: MySQL requiere procesamiento para consultas, pero no es intensivo
- **RAM**: 4 GB mínimos para MySQL + aplicación Java, 8 GB recomendados para mejor rendimiento
- **Almacenamiento**: Los registros de inventario, clientes y ventas ocupan poco espacio (estimado < 1 GB anuales)
- **Red**: Importante si hay múltiples tiendas accediendo al servidor

---

## 3. Sistema operativo recomendado

### Sistema: Linux (Ubuntu Server)

**Versión recomendada**: Ubuntu Server 22.04 LTS

### Justificación

- **Gratuito**: Sin costo de licencia
- **Estabilidad**: Muy estable para servidores
- **MySQL**: Mejor rendimiento y soporte en Linux
- **Seguridad**: Actualizaciones de seguridad regulares
- **Comunidad**: Abundante documentación y ayuda

### Alternativa: Windows Server

Si el personal no tiene conocimientos de Linux, Windows Server 2022 es una alternativa válida, aunque requiere licencia.

---

## 4. Instalación del entorno

### Paso 1: Instalar sistema operativo

1. Descargar Ubuntu Server 22.04 LTS
2. Crear USB booteable
3. Instalar en el servidor
4. Configurar red (IP estática recomendada)

### Paso 2: Instalar MySQL Server

```bash
sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation
```

### Paso 3: Configurar MySQL

1. Crear usuario para la aplicación
2. Crear base de datos "techmanage"
3. Importar script SQL

### Paso 4: Instalar Java JDK

```bash
sudo apt install openjdk-17-jdk
```

### Paso 5: Clonar repositorio

```bash
git clone https://github.com/tu-usuario/TrabajoIntermodular1.git
```

### Paso 6: Configurar conexión

Editar archivo de configuración con:

- IP del servidor MySQL
- Puerto (3306)
- Usuario y contraseña
- Nombre de la base de datos

---

## 5. Usuarios, permisos y estructura

### Usuarios del sistema

| Usuario     | Función       | Permisos                      |
| ----------- | ------------- | ----------------------------- |
| root        | Administrador | Total                         |
| techmanage  | App Java      | Solo base de datos techmanage |
| dependiente | Acceso tienda | Solo consultas necesarias     |

### Estructura de carpetas

```
/home/
├── techmanage/
│   ├── src/              # Código fuente
│   ├── lib/              # Librerías
│   └── config/           # Archivos de configuración

/var/lib/mysql/
└── techmanage/           # Base de datos

/backup/
├── mysql/                # Copias de seguridad BBDD
└── app/                 # Copias de seguridad código
```

### Datos y backups

- **Datos**: En /var/lib/mysql/techmanage
- **Backups**: daily en /backup/mysql/
- **Retención**: 7 días de backups diarios, 4 semanales

---

## 6. Mantenimiento básico

### Actualizaciones recomendadas

| Componente        | Frecuencia     |
| ----------------- | -------------- |
| Sistema operativo | Mensual        |
| MySQL             | Trimestral     |
| Java              | Semestral      |
| Aplicación        | Según releases |

### Revisiones periódicas

- **Diario**: Verificar que el servicio MySQL está activo
- **Semanal**: Revisar logs de errores
- **Mensual**: Verificar espacio en disco
- **Trimestral**: Probar restauración de backups

### Si falla

1. Verificar servicio MySQL: `sudo systemctl status mysql`
2. Revisar logs: `sudo tail -f /var/log/mysql/error.log`
3. Comprobar espacio: `df -h`
4. Restaurar backup si es necesario

---

## 7. Evidencias

Las capturas de funcionamiento se encuentran en: `docs/sistemas/evidencias/`

## Anexo: Configuración de red recomendada

```
Servidor (IP estática): 192.168.1.100
Puertos abiertos:
- 3306 (MySQL) - solo red local
- 22 (SSH) - solo administración
```
