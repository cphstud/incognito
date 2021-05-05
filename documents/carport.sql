-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beslag`
--

DROP TABLE IF EXISTS `beslag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beslag` (
  `beslag_id` int NOT NULL AUTO_INCREMENT,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`beslag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beslag`
--

LOCK TABLES `beslag` WRITE;
/*!40000 ALTER TABLE `beslag` DISABLE KEYS */;
/*!40000 ALTER TABLE `beslag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
  `carport_id` int NOT NULL AUTO_INCREMENT,
  `width` varchar(45) DEFAULT NULL,
  `length` varchar(45) DEFAULT NULL,
  `harredskabsrum` tinyint DEFAULT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`carport_id`,`order_id`),
  KEY `fk_carport_order1_idx` (`order_id`),
  CONSTRAINT `fk_carport_order1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` text,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `carport_id` int NOT NULL,
  `credit` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`carport_id`),
  KEY `fk_customer_carport1_idx` (`carport_id`),
  CONSTRAINT `fk_customer_carport1` FOREIGN KEY (`carport_id`) REFERENCES `mydb`.`carport` (`carport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `dato` datetime DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `subtotal` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlist` (
  `order_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_has_material_order1_idx` (`order_id`),
  CONSTRAINT `fk_order_has_material_order1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`order` (`order_id`),
  CONSTRAINT `fk_orderlist_beslag1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`beslag` (`beslag_id`),
  CONSTRAINT `fk_orderlist_skruer1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`skruer` (`skruer_id`),
  CONSTRAINT `fk_orderlist_tagplader1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`tagplader` (`tagplader_id`),
  CONSTRAINT `fk_orderlist_træ1` FOREIGN KEY (`order_id`) REFERENCES `mydb`.`træ` (`idtræ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlist`
--

LOCK TABLES `orderlist` WRITE;
/*!40000 ALTER TABLE `orderlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redskabsrum`
--

DROP TABLE IF EXISTS `redskabsrum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `redskabsrum` (
  `redskabsrum_id` int NOT NULL AUTO_INCREMENT,
  `carport_id` int NOT NULL,
  `width` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  PRIMARY KEY (`redskabsrum_id`),
  KEY `fk_redskabsrum_carport1_idx` (`carport_id`),
  CONSTRAINT `fk_redskabsrum_carport1` FOREIGN KEY (`carport_id`) REFERENCES `mydb`.`carport` (`carport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redskabsrum`
--

LOCK TABLES `redskabsrum` WRITE;
/*!40000 ALTER TABLE `redskabsrum` DISABLE KEYS */;
/*!40000 ALTER TABLE `redskabsrum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skruer`
--

DROP TABLE IF EXISTS `skruer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skruer` (
  `skruer_id` int NOT NULL AUTO_INCREMENT,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`skruer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skruer`
--

LOCK TABLES `skruer` WRITE;
/*!40000 ALTER TABLE `skruer` DISABLE KEYS */;
/*!40000 ALTER TABLE `skruer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagplader`
--

DROP TABLE IF EXISTS `tagplader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tagplader` (
  `tagplader_id` int NOT NULL AUTO_INCREMENT,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`tagplader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagplader`
--

LOCK TABLES `tagplader` WRITE;
/*!40000 ALTER TABLE `tagplader` DISABLE KEYS */;
/*!40000 ALTER TABLE `tagplader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `træ`
--

DROP TABLE IF EXISTS `træ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `træ` (
  `idtræ` int NOT NULL AUTO_INCREMENT,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `description` text,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtræ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `træ`
--

LOCK TABLES `træ` WRITE;
/*!40000 ALTER TABLE `træ` DISABLE KEYS */;
/*!40000 ALTER TABLE `træ` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-05 20:46:48
