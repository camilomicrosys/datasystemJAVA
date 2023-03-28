-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2023 a las 04:09:42
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `stsitemaernesto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre_cliente` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email_cliente` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel_cliente` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dir_cliente` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ultima_modificacion` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre_cliente`, `email_cliente`, `tel_cliente`, `dir_cliente`, `ultima_modificacion`) VALUES
(5, 'camilo', 'cami', '88877', 'cl 21', 'Camilo_admin'),
(6, 'lupita', 'duque', '123', 'bellavista', 'camilo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `tipo_equipo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num_serie` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dia_ingreso` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mes_ingreso` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `anio_ingreso` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `observaciones` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ultima_modificacion` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comentarios_tecnicos` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `revision_tecnica_de` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id`, `id_cliente`, `tipo_equipo`, `marca`, `modelo`, `num_serie`, `dia_ingreso`, `mes_ingreso`, `anio_ingreso`, `observaciones`, `estatus`, `ultima_modificacion`, `comentarios_tecnicos`, `revision_tecnica_de`) VALUES
(1, 5, 'portatil', 'lenovo', '2022', '2233333', '3', '3', '2023', 'casi nuevo', 'Entregado', 'carlos_tecnico', 'entregado satisfactoriamente', 'carlos_tecnico'),
(2, 6, 'Laptop', 'Acer', '455', '55', '20', '3', '2023', 'sin registro', 'No reparado', 'carlos_tecnico', 'no se puedo reparar no hay repuesto', 'carlos_tecnico'),
(4, 6, 'Impresora', 'hp', '88', '11111', '20', '3', '2023', 'solicitud cambio de teclado', 'En revision', 'carlos_tecnico', 'sss', 'carlos_tecnico'),
(5, 5, 'Desktop', 'Samsumg', '123456', '88', '26', '3', '2023', 'revisar pantalla', 'Nuevo ingreso', 'Camilo_admin', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_nivel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registrado_por` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `email`, `telefono`, `username`, `password`, `tipo_nivel`, `estatus`, `registrado_por`) VALUES
(1, 'camilo', 'camilo@pruebas.com', '5480000', 'Camilo_admin', '123456789', 'administrador', 'activo', 'Camilo_admin'),
(2, 'cris', 'cris@pruebas.com', '222', 'cris_capturista', '123', 'capturista', 'activo', 'Camilo_admin'),
(3, 'carlos', 'carlos@pruebas.com', '965874', 'carlos_tecnico', '123456789', 'tecnico', 'activo', 'Camilo_admin'),
(5, 'andrea', 'andrea@pruebas.com', '123456789', 'andrea_admin', '777', 'administrador', 'activo', 'Camilo_admin'),
(6, 'juuu', 'juuu', '111', '2222', '2222', 'administrador', 'activo', 'Camilo_admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_equipos_clientes` (`id_cliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD CONSTRAINT `fk_equipos_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
