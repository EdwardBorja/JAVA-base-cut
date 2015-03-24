-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema escuela
--

CREATE DATABASE IF NOT EXISTS escuela;
USE escuela;

--
-- Definition of table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `codigoA` int(30) NOT NULL default '0',
  `nombre` char(30) default NULL,
  `dom` varchar(30) default NULL,
  PRIMARY KEY  (`codigoA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` (`codigoA`,`nombre`,`dom`) VALUES 
 (1,'juan','jacarandas'),
 (2,'dany','en la nada'),
 (3,'japo','huertas'),
 (4,'pablo','capuchina'),
 (5,'alberto','limas');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;


--
-- Definition of table `maestro`
--

DROP TABLE IF EXISTS `maestro`;
CREATE TABLE `maestro` (
  `codigoMA` int(30) NOT NULL default '0',
  `nombre` char(30) default NULL,
  PRIMARY KEY  (`codigoMA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maestro`
--

/*!40000 ALTER TABLE `maestro` DISABLE KEYS */;
INSERT INTO `maestro` (`codigoMA`,`nombre`) VALUES 
 (1,'cesar'),
 (2,'corona'),
 (3,'swacheneger'),
 (4,'mcfly'),
 (5,'jesus');
/*!40000 ALTER TABLE `maestro` ENABLE KEYS */;


--
-- Definition of table `materias`
--

DROP TABLE IF EXISTS `materias`;
CREATE TABLE `materias` (
  `codigoM` int(30) NOT NULL default '0',
  `nombre` char(30) default NULL,
  `semestre` varchar(30) default NULL,
  `codigoMA` int(30) default NULL,
  PRIMARY KEY  (`codigoM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materias`
--

/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` (`codigoM`,`nombre`,`semestre`,`codigoMA`) VALUES 
 (1,'BD','4',1),
 (2,'IA','4',2),
 (3,'ING SOFT','3',4),
 (4,'AUTOMATAS','2',2),
 (5,'DISENO','1',2);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;


--
-- Definition of table `relacionaym`
--

DROP TABLE IF EXISTS `relacionaym`;
CREATE TABLE `relacionaym` (
  `codigoM` int(30) default NULL,
  `codigoA` int(30) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relacionaym`
--

/*!40000 ALTER TABLE `relacionaym` DISABLE KEYS */;
INSERT INTO `relacionaym` (`codigoM`,`codigoA`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (2,1),
 (2,2);
/*!40000 ALTER TABLE `relacionaym` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
