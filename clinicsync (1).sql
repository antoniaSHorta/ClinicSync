-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2023 a las 17:32:39
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinicsync`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `rutDoctor` varchar(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `especialidad` varchar(200) NOT NULL,
  `formacion` varchar(200) NOT NULL,
  `consulta` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`rutDoctor`, `nombre`, `apellido`, `fecha_nacimiento`, `direccion`, `telefono`, `correo`, `especialidad`, `formacion`, `consulta`) VALUES
('12345678-9', 'pepito', 'perez', '0000-02-13', 'brasil', 1111111, 'correita@gmail.com', 'cirugia', 'pucv', 'redsalud');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `fecha` date NOT NULL,
  `recetas` varchar(200) NOT NULL,
  `examenes` varchar(200) NOT NULL,
  `observaciones` varchar(500) NOT NULL,
  `rutPaciente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`fecha`, `recetas`, `examenes`, `observaciones`, `rutPaciente`) VALUES
('2023-11-20', 'crema atopica', 'de sangre', 'n/o', '21108786-2'),
('2023-11-28', 'ninguna', 'sangre', 'acne en la piel', '21108786-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `rutPaciente` varchar(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(200) NOT NULL,
  `altura` float NOT NULL,
  `peso` float NOT NULL,
  `correo` varchar(200) NOT NULL,
  `grupo_sanguineo` varchar(4) NOT NULL,
  `alergias` varchar(200) NOT NULL,
  `genero` varchar(200) NOT NULL,
  `pre_existencias` varchar(200) NOT NULL,
  `observaciones` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`rutPaciente`, `nombre`, `apellido`, `fecha_nacimiento`, `direccion`, `telefono`, `altura`, `peso`, `correo`, `grupo_sanguineo`, `alergias`, `genero`, `pre_existencias`, `observaciones`) VALUES
('21108786-2', 'antonia', 'horta', '2023-11-28', 'luis acevedo', '95979793', 1.65, 65, 'antonia@gmail.com', 'arh-', 'ni', 'femenino', 'n/o', 'nada'),
('21595795-4', 'benjamin', 'correa', '2004-05-16', 'hijuelas', '95975463', 1, 65, 'benajmin@gmail.com', 'arh-', 'nininguna', 'm', 'n/o', 'ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planificador`
--

CREATE TABLE `planificador` (
  `observacion` varchar(200) NOT NULL,
  `idConsulta` int(11) NOT NULL,
  `disponibilidad` int(11) NOT NULL,
  `hora` datetime NOT NULL,
  `rutDoctor` varchar(20) NOT NULL,
  `rutPaciente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `planificador`
--

INSERT INTO `planificador` (`observacion`, `idConsulta`, `disponibilidad`, `hora`, `rutDoctor`, `rutPaciente`) VALUES
('ninguna', 1, 0, '2023-12-12 00:00:00', '12345678-9', '21108786-2'),
('ninguna', 3, 1, '2023-12-08 00:00:00', '12345678-9', '21108786-2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`rutDoctor`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD UNIQUE KEY `fecha` (`fecha`),
  ADD KEY `rutPaciente` (`rutPaciente`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`rutPaciente`);

--
-- Indices de la tabla `planificador`
--
ALTER TABLE `planificador`
  ADD PRIMARY KEY (`idConsulta`),
  ADD UNIQUE KEY `hora` (`hora`),
  ADD KEY `rutDoctor` (`rutDoctor`),
  ADD KEY `rutPaciente` (`rutPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `planificador`
--
ALTER TABLE `planificador`
  MODIFY `idConsulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`rutPaciente`) REFERENCES `paciente` (`rutPaciente`);

--
-- Filtros para la tabla `planificador`
--
ALTER TABLE `planificador`
  ADD CONSTRAINT `planificador_ibfk_1` FOREIGN KEY (`rutDoctor`) REFERENCES `doctor` (`rutDoctor`),
  ADD CONSTRAINT `planificador_ibfk_2` FOREIGN KEY (`rutPaciente`) REFERENCES `paciente` (`rutPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
