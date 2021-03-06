-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2022 at 06:26 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inmuebles`
--
CREATE DATABASE IF NOT EXISTS `inmuebles` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inmuebles`;

-- --------------------------------------------------------

--
-- Table structure for table `anioinmuebles`
--

DROP TABLE IF EXISTS `anioinmuebles`;
CREATE TABLE IF NOT EXISTS `anioinmuebles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anio` varchar(255) DEFAULT NULL,
  `datosAdicionales` varchar(255) DEFAULT NULL,
  `docSeguroImpago` longtext DEFAULT NULL,
  `docSeguroVivienda` longtext DEFAULT NULL,
  `docdatosAdicionales` longtext DEFAULT NULL,
  `importeSeguroImpago` double DEFAULT NULL,
  `importeSeguroVivienda` double DEFAULT NULL,
  `mes` varchar(255) DEFAULT NULL,
  `num_meses` int(11) DEFAULT NULL,
  `inmueble_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiwimvb2p84bbyd944d7bnpcgr` (`inmueble_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anioinmuebles`
--

INSERT IGNORE INTO `anioinmuebles` (`id`, `anio`, `datosAdicionales`, `docSeguroImpago`, `docSeguroVivienda`, `docdatosAdicionales`, `importeSeguroImpago`, `importeSeguroVivienda`, `mes`, `num_meses`, `inmueble_id`) VALUES
(1, '2008', 'datos adicionales', 'docSeguroImpago', 'docSeguroVivienda', 'docdatosAdicionales', 1, 2, '01', 12, 1),
(2, '2009', 'datosAdicionales', 'docSeguroImpago', 'docSeguroVivienda', 'docdatosAdicionales', 1, 2, '02', 12, 1),
(3, '2008', 'datos adicionales', 'docseguroimpago', 'docsegurovivienda', 'docdatosadicionales', 1, 3, 'mes 01', 12, 2),
(4, '2008', 'datos adicionales', 'docseguroimpago', 'docsegurovivienda', 'docdatosadicionales', 1, 3, 'mes 02', 12, 3),
(5, '2008', 'datos adicionales', 'docseguroimpago', 'docsegurovivienda', 'docdatosadicionales', 1, 3, 'mes 02', 12, 4);

-- --------------------------------------------------------

--
-- Table structure for table `detallemesinmueble`
--

DROP TABLE IF EXISTS `detallemesinmueble`;
CREATE TABLE IF NOT EXISTS `detallemesinmueble` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `detallegastosadicionales` varchar(255) DEFAULT NULL,
  `docgastosadicionales` longtext DEFAULT NULL,
  `docimporteComunidad` longtext DEFAULT NULL,
  `docimporteIbi` longtext DEFAULT NULL,
  `gastosAdicionales` double DEFAULT NULL,
  `importeAlquiler` double DEFAULT NULL,
  `importeComunidad` double DEFAULT NULL,
  `importeIbi` double DEFAULT NULL,
  `mes` varchar(255) DEFAULT NULL,
  `anioinmueble_id` bigint(20) DEFAULT NULL,
  `inmueble_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfsbaiix8vhcrhef6ix6u5rtqu` (`anioinmueble_id`),
  KEY `FK64boi5eyenm3ly6msbrpqqip2` (`inmueble_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detallemesinmueble`
--

INSERT IGNORE INTO `detallemesinmueble` (`id`, `detallegastosadicionales`, `docgastosadicionales`, `docimporteComunidad`, `docimporteIbi`, `gastosAdicionales`, `importeAlquiler`, `importeComunidad`, `importeIbi`, `mes`, `anioinmueble_id`, `inmueble_id`) VALUES
(1, 'detallegastosadicionales', 'docgastosadicionales', 'docimporteComunidad', 'docimporteIbi', 1, 2, 3, 4, 'MES01', 1, 1),
(2, 'detallegastosadicionales', 'docgastosadicionales', 'docimporteComunidad', 'docimporteIbi', 1, 2, 3, 4, 'MES02', 1, 1),
(3, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes01', 2, 2),
(4, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes02', 2, 2),
(5, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes03', 2, 2),
(6, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes04', 2, 2),
(7, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes05', 2, 2),
(8, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes06', 2, 2),
(9, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes07', 2, 2),
(10, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes08', 2, 2),
(11, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes09', 2, 2),
(12, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes10', 2, 2),
(13, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes11', 2, 2),
(14, 'detalle gastos adicionales', 'docgastosadicionales', 'docimportecomunidad', 'docimporteibi', 1, 2, 3, 4, 'mes12', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `inmuebles`
--

DROP TABLE IF EXISTS `inmuebles`;
CREATE TABLE IF NOT EXISTS `inmuebles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `fechacomprainmueble` date NOT NULL,
  `importecomprainmueble` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inmuebles`
--

INSERT IGNORE INTO `inmuebles` (`id`, `direccion`, `fechacomprainmueble`, `importecomprainmueble`) VALUES
(1, 'direccion1', '2022-06-01', 15000),
(2, 'direccion del inmueble 2', '2022-06-14', 1500),
(3, 'direccion del inmueble 3', '2022-06-14', 1500),
(4, 'direccion del inmueble 4', '2022-06-14', 1500);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `anioinmuebles`
--
ALTER TABLE `anioinmuebles`
  ADD CONSTRAINT `FKiwimvb2p84bbyd944d7bnpcgr` FOREIGN KEY (`inmueble_id`) REFERENCES `inmuebles` (`id`);

--
-- Constraints for table `detallemesinmueble`
--
ALTER TABLE `detallemesinmueble`
  ADD CONSTRAINT `FK64boi5eyenm3ly6msbrpqqip2` FOREIGN KEY (`inmueble_id`) REFERENCES `inmuebles` (`id`),
  ADD CONSTRAINT `FKfsbaiix8vhcrhef6ix6u5rtqu` FOREIGN KEY (`anioinmueble_id`) REFERENCES `anioinmuebles` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
