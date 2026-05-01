-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2026 at 11:11 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;

--
-- Base de datos: `techmanage`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `dni` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `email`, `telefono`, `direccion`, `dni`) VALUES
(1, 'Juan Pérez García', 'juan.perez@email.com', '666777888', 'Calle Luna 12, Madrid', '12345678A'),
(2, 'María López Sánchez', 'maria.lopez@email.com', '677888999', 'Avenida Sol 34, Barcelona', '23456789B'),
(3, 'Pedro Martínez Torres', 'pedro.martinez@email.com', '688999000', 'Plaza Mayor 5, Valencia', '34567890C'),
(4, 'Ana García Rodríguez', 'ana.garcia@email.com', '699000111', 'Calle Norte 8, Bilbao', '45678901D'),
(5, 'Carlos Sánchez Jiménez', 'carlos.sanchez@email.com', '600111222', 'Avenida Este 15, Sevilla', '56789012E'),
(6, 'Laura Martínez Fernández', 'laura.martinez@email.com', '611222333', 'Calle Oeste 22, Madrid', '67890123F'),
(7, 'Miguel Torres Ruiz', 'miguel.torres@email.com', '622333444', 'Avenida Sur 10, Bilbao', '78901234G'),
(8, 'Sofia Castro López', 'sofia.castro@email.com', '633444555', 'Calle Centro 7, Valencia', '89012345H');

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_detalle` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_detalle`, `id_venta`, `id_producto`, `cantidad`, `precio`, `total`) VALUES
(1, 1, 1, 1, 549.99, 549.99),
(2, 1, 3, 1, 29.99, 29.99),
(3, 1, 9, 2, 9.99, 19.99),
(4, 2, 2, 1, 89.99, 89.99),
(5, 3, 6, 1, 249.99, 249.99),
(6, 3, 7, 1, 49.99, 49.99),
(7, 4, 4, 1, 159.99, 159.99),
(8, 5, 8, 1, 12.99, 12.99),
(9, 5, 9, 1, 9.99, 9.99),
(10, 6, 10, 1, 899.99, 899.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `inventario_tienda`
--

CREATE TABLE `inventario_tienda` (
  `id_inventario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `cantidad_stock` int(11) NOT NULL DEFAULT 0,
  `stock_minimo` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `inventario_tienda`
--

INSERT INTO `inventario_tienda` (`id_inventario`, `id_producto`, `id_tienda`, `cantidad_stock`, `stock_minimo`) VALUES
(1, 1, 1, 15, 5),
(2, 1, 2, 8, 3),
(3, 1, 3, 12, 4),
(4, 2, 1, 25, 10),
(5, 2, 2, 20, 8),
(6, 3, 1, 50, 15),
(7, 3, 2, 30, 10),
(8, 3, 3, 40, 12),
(9, 4, 1, 10, 5),
(10, 4, 2, 6, 3),
(11, 5, 1, 100, 30),
(12, 5, 2, 80, 25),
(13, 6, 1, 5, 3),
(14, 7, 2, 20, 8),
(15, 8, 1, 200, 50),
(16, 9, 1, 150, 40),
(17, 10, 1, 0, 2),
(18, 10, 2, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `precio_venta` decimal(10,2) NOT NULL CHECK (`precio_venta` >= 0),
  `categoria` enum('disponible','sin stock') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `descripcion`, `precio_venta`, `categoria`) VALUES
(1, 'Portátil HP 15s', 'Portátil 15.6" Intel Core i5 8GB RAM', 549.99, 'disponible'),
(2, 'Teclado Mecánico RGB', 'Teclado gaming con luces RGB y switches rojos', 89.99, 'disponible'),
(3, 'Ratón Inalámbrico Logitech', 'Ratón ergonómico wireless USB', 29.99, 'disponible'),
(4, 'Monitor Samsung 24"', 'Monitor Full HD 1920x1080 60Hz', 159.99, 'disponible'),
(5, 'Disco SSD 500GB', 'Disco sólido interno SATA III 500GB', 59.99, 'disponible'),
(6, 'Auriculares Sony WH-1000XM4', 'Auriculares noise cancelling premium', 249.99, 'disponible'),
(7, 'Webcam HD 1080p', 'Cámara web Full HD con micrófono', 49.99, 'disponible'),
(8, 'Pendrive 64GB USB 3.0', 'Memoria USB 3.0 velocidad alta', 12.99, 'disponible'),
(9, 'Cable HDMI 2m', 'Cable HDMI 4K compatible', 9.99, 'disponible'),
(10, 'Portátil Lenovo ThinkPad', 'Portátil 14" i7 16GB RAM 512GB SSD', 899.99, 'sin stock');

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `productos_proveedores`
--

CREATE TABLE `productos_proveedores` (
  `id_pp` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `precio_compra` decimal(10,2) NOT NULL,
  `fecha_inicio` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `productos_proveedores`
--

INSERT INTO `productos_proveedores` (`id_pp`, `id_producto`, `id_proveedor`, `precio_compra`, `fecha_inicio`) VALUES
(1, 1, 1, 420.00, '2025-01-15'),
(2, 1, 2, 415.00, '2025-02-01'),
(3, 2, 3, 65.00, '2025-01-20'),
(4, 3, 3, 18.00, '2025-02-10'),
(5, 4, 1, 120.00, '2025-01-25'),
(6, 5, 4, 42.00, '2025-03-01'),
(7, 6, 2, 180.00, '2025-02-15'),
(8, 7, 3, 32.00, '2025-03-10'),
(9, 8, 4, 8.00, '2025-03-15'),
(10, 9, 1, 6.50, '2025-03-20'),
(11, 10, 2, 720.00, '2025-01-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `contacto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedor`, `nombre`, `email`, `telefono`, `direccion`, `contacto`) VALUES
(1, 'TechSupply S.L.', 'info@techsupply.es', '611223344', 'Polígono Industrial Norte, Madrid', 'Carlos Martínez'),
(2, 'GlobalComponents', 'contacto@globalcomponents.es', '622334455', 'Calle Industrial 25, Barcelona', 'Laura Sánchez'),
(3, 'DigitalWholesale', 'ventas@digitalwholesale.es', '633445566', 'Avenida Logística 10, Valencia', 'Miguel Torres'),
(4, 'ElectroMaster', 'comercial@electromaster.es', '644556677', 'Polígono Tecnológico 5, Sevilla', 'Ana Rodríguez');

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `tienda`
--

CREATE TABLE `tienda` (
  `id_tienda` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `tienda`
--

INSERT INTO `tienda` (`id_tienda`, `nombre`, `direccion`, `telefono`, `email`) VALUES
(1, 'TechManage Centro', 'Calle Mayor 123, Madrid', '912345678', 'centro@techmanage.es'),
(2, 'TechManage Norte', 'Avenida Bilbao 45, Bilbao', '944567890', 'norte@techmanage.es'),
(3, 'TechManage Sur', 'Calle Sevilla 78, Sevilla', '954321123', 'sur@techmanage.es');

-- --------------------------------------------------------

--
-- Estructura de tabla para tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_ventas` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_tienda` int(11) NOT NULL,
  `fecha_venta` datetime DEFAULT NULL,
  `metodo_pago` enum('efectivo','tarjeta') NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para tabla `ventas`
--

INSERT INTO `ventas` (`id_ventas`, `id_cliente`, `id_tienda`, `fecha_venta`, `metodo_pago`, `total`) VALUES
(1, 1, 1, '2026-04-01 10:30:00', 'tarjeta', 639.98),
(2, 2, 2, '2026-04-02 12:15:00', 'efectivo', 89.99),
(3, 3, 1, '2026-04-03 16:45:00', 'tarjeta', 299.98),
(4, 4, 3, '2026-04-04 11:20:00', 'tarjeta', 159.99),
(5, NULL, 1, '2026-04-05 14:00:00', 'efectivo', 22.98),
(6, 5, 2, '2026-04-06 09:30:00', 'tarjeta', 899.99);

-- --------------------------------------------------------

--
-- Índices para tablas volcadas
--

--
-- Índices para tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Índices para tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `fk_detalle_venta_venta` (`id_venta`),
  ADD KEY `fk_detalle_venta_producto` (`id_producto`);

--
-- Índices para tabla `inventario_tienda`
--
ALTER TABLE `inventario_tienda`
  ADD PRIMARY KEY (`id_inventario`),
  ADD KEY `fk_id_productos` (`id_producto`),
  ADD KEY `fk_id_tienda` (`id_tienda`);

--
-- Índices para tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Índices para tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  ADD PRIMARY KEY (`id_pp`),
  ADD KEY `fk_id_producto` (`id_producto`),
  ADD KEY `fk_id_proveedor` (`id_proveedor`);

--
-- Índices para tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Índices para tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`id_tienda`);

--
-- Índices para tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_ventas`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_tienda` (`id_tienda`);

-- --------------------------------------------------------

--
-- AUTO_INCREMENT para tablas volcadas
--

--
-- AUTO_INCREMENT para tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT para tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT para tabla `inventario_tienda`
--
ALTER TABLE `inventario_tienda`
  MODIFY `id_inventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT para tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT para tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  MODIFY `id_pp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT para tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT para tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `id_tienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT para tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_ventas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

-- --------------------------------------------------------

--
-- Restricciones para tablas volcadas
--

--
-- Restricciones para tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `fk_detalle_venta_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_detalle_venta_venta` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_ventas`);

--
-- Restricciones para tabla `inventario_tienda`
--
ALTER TABLE `inventario_tienda`
  ADD CONSTRAINT `fk_id_productos` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`) ON UPDATE CASCADE;

--
-- Restricciones para tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_id_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`);

--
-- Restricciones para tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`);

-- =====================================================
-- CONSULTAS DE JOIN (MULTITABLA)
-- =====================================================

/* 1. Ver cada venta con datos del cliente y tienda */
SELECT v.id_ventas, v.fecha_venta, v.total, c.nombre AS nombreCliente, t.nombre AS nombreTienda, t.direccion AS direccionTienda 
FROM ventas v
LEFT JOIN clientes c ON v.id_cliente = c.id_cliente
JOIN tienda t ON v.id_tienda = t.id_tienda;

-- 2. Ver detalles de cada venta con productos
SELECT dv.id_detalle, dv.id_venta, dv.cantidad, dv.precio, dv.total, p.nombre AS nombreProducto, p.descripcion 
FROM detalle_venta dv
JOIN productos p ON dv.id_producto = p.id_producto
JOIN ventas v ON dv.id_venta = v.id_ventas;

-- 3. Ver inventario por tienda con nombre de producto
SELECT i.id_inventario, p.nombre AS nombreProducto, t.nombre AS nombreTienda, i.cantidad_stock, i.stock_minimo 
FROM inventario_tienda i
JOIN productos p ON i.id_producto = p.id_producto
JOIN tienda t ON i.id_tienda = t.id_tienda;

-- 4. Ver productos con sus proveedores y precios de compra
SELECT p.id_producto, p.nombre AS nombreProducto, p.precio_venta, pr.nombre AS nombreProveedor, pp.precio_compra, pp.fecha_inicio 
FROM productos p
JOIN productos_proveedores pp ON p.id_producto = pp.id_producto
JOIN proveedores pr ON pp.id_proveedor = pr.id_proveedor;

-- 5. Ver ventas completas con todos los datos
SELECT v.id_ventas, v.fecha_venta, v.total AS totalVenta, v.metodo_pago, c.nombre AS cliente, c.dni, t.nombre AS tienda, t.direccion AS direccionTienda, p.nombre AS producto, dv.cantidad, dv.total AS subtotal 
FROM ventas v
LEFT JOIN clientes c ON v.id_cliente = c.id_cliente
JOIN tienda t ON v.id_tienda = t.id_tienda
JOIN detalle_venta dv ON v.id_ventas = dv.id_venta
JOIN productos p ON dv.id_producto = p.id_producto;

-- 6. Ver productos con mejor margen por proveedor
SELECT p.nombre AS producto, p.precio_venta, pr.nombre AS proveedor, pp.precio_compra, (p.precio_venta - pp.precio_compra) AS margen
FROM productos p
JOIN productos_proveedores pp ON p.id_producto = pp.id_producto
JOIN proveedores pr ON pp.id_proveedor = pr.id_proveedor
ORDER BY margen DESC;

-- =====================================================
-- CONSULTAS DE BÚSQUEDA Y FILTROS
-- =====================================================

/* 7. Buscar cliente por nombre ( LIKE%) */
SELECT * FROM clientes WHERE nombre LIKE '%Juan%';

-- 8. Buscar producto por nombre
SELECT * FROM productos WHERE nombre LIKE '%Portátil%';

-- 9. Ver productos sin stock
SELECT p.id_producto, p.nombre, p.categoria, t.nombre AS tienda, i.cantidad_stock
FROM productos p
JOIN inventario_tienda i ON p.id_producto = i.id_producto
JOIN tienda t ON i.id_tienda = t.id_tienda
WHERE i.cantidad_stock = 0;

-- 10. Ver stock bajo mínimo
SELECT p.nombre AS producto, t.nombre AS tienda, i.cantidad_stock, i.stock_minimo
FROM inventario_tienda i
JOIN productos p ON i.id_producto = p.id_producto
JOIN tienda t ON i.id_tienda = t.id_tienda
WHERE i.cantidad_stock < i.stock_minimo;

-- 11. Ver ventas por fecha (rango)
SELECT * FROM ventas WHERE fecha_venta BETWEEN '2026-04-01' AND '2026-04-05';

-- 12. Ver ventas por método de pago
SELECT * FROM ventas WHERE metodo_pago = 'tarjeta';

-- =====================================================
-- CONSULTAS DE ESTADÍSTICAS Y AGREGADOS
-- =====================================================

/* 13. Ver top clientes por compras (suma total) */
SELECT c.id_cliente, c.nombre, c.email, SUM(v.total) AS totalGastado, COUNT(v.id_ventas) AS numVentas
FROM clientes c
JOIN ventas v ON c.id_cliente = v.id_cliente
GROUP BY c.id_cliente, c.nombre, c.email
ORDER BY totalGastado DESC;

-- 14. Ver tienda con más ventas
SELECT t.id_tienda, t.nombre AS nombreTienda, COUNT(v.id_ventas) AS numVentas, SUM(v.total) AS totalVentas
FROM tienda t
JOIN ventas v ON t.id_tienda = v.id_tienda
GROUP BY t.id_tienda, t.nombre
ORDER BY totalVentas DESC;

-- 15. Ver productos más vendidos (por cantidad)
SELECT p.id_producto, p.nombre, SUM(dv.cantidad) AS cantidadVendida, SUM(dv.total) AS totalVendido
FROM productos p
JOIN detalle_venta dv ON p.id_producto = dv.id_producto
GROUP BY p.id_producto, p.nombre
ORDER BY cantidadVendida DESC;

-- 16. Ver proveedores de un producto
SELECT p.nombre AS producto, pr.nombre AS proveedor, pp.precio_compra, pp.fecha_inicio
FROM productos p
JOIN productos_proveedores pp ON p.id_producto = pp.id_producto
JOIN proveedores pr ON pp.id_proveedor = pr.id_proveedor
WHERE p.id_producto = 1;

-- 17. Ver gasto total por proveedor
SELECT pr.id_proveedor, pr.nombre AS nombreProveedor, COUNT(pp.id_pp) AS numProductos, SUM(pp.precio_compra) AS gastoTotal
FROM proveedores pr
JOIN productos_proveedores pp ON pr.id_proveedor = pp.id_proveedor
GROUP BY pr.id_proveedor, pr.nombre
ORDER BY gastoTotal DESC;

-- 18. Ver total de ventas por tienda
SELECT t.nombre AS tienda, SUM(v.total) AS totalVentas
FROM tienda t
JOIN ventas v ON t.id_tienda = v.id_tienda
GROUP BY t.nombre;

-- 19. Ver promedio de venta
SELECT AVG(total) AS promedioVenta FROM ventas;

-- 20. Ver cantidad total de productos vendidos
SELECT SUM(cantidad) AS totalProductosVendidos FROM detalle_venta;

-- 21. Ver inventario total por producto (todas las tiendas)
SELECT p.id_producto, p.nombre, SUM(i.cantidad_stock) AS stockTotal
FROM productos p
JOIN inventario_tienda i ON p.id_producto = i.id_producto
GROUP BY p.id_producto, p.nombre
ORDER BY stockTotal DESC;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;