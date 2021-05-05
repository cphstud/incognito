-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.23

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
  `enhed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`beslag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beslag`
--

LOCK TABLES `beslag` WRITE;
/*!40000 ALTER TABLE `beslag` DISABLE KEYS */;
INSERT INTO `beslag` VALUES (1,1000,20,1,'Hulbånd','Til vindkryds på spær',11,'Rulle'),(2,0,190,190,'Universal højre','Til montering af spær på rem',12,'Stk'),(3,0,190,190,'Unisersal venstre','Til montering af spær på rem',12,'Stk'),(4,0,75,50,'Stalddørsgreb','Til lås på dør i skur',5,'Sæt'),(5,360,0,0,'T-hængsel','Til skurdør',5,'Stk'),(6,35,35,35,'Vinkelbeslag','Til montering af løsholter i skur',7,'Stk');
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_status` varchar(45) DEFAULT NULL,
  `order_time` timestamp NULL DEFAULT NULL,
  `fk_user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_orders_users1_idx` (`fk_user_id`),
  CONSTRAINT `fk_orders_users1` FOREIGN KEY (`fk_user_id`) REFERENCES `mydb`.`users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
  `enhed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`skruer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skruer`
--

LOCK TABLES `skruer` WRITE;
/*!40000 ALTER TABLE `skruer` DISABLE KEYS */;
INSERT INTO `skruer` VALUES (1,0,0,0,'Plastmo bundskruer 200 stk.','Skruer til tagplader.',10,'Pakke'),(2,60,45,0,'Skruer 200 stk.','Til montering af stern&vandbrædt',11,'Pakke'),(3,50,40,0,'Beslagskruer 250 stk.','Til montering af universalbeslag + hulbånd',12,'Pakke'),(4,120,100,0,'Bræddebolt ','Til montering af rem på stolper',5,'Stk'),(5,40,40,11,'Firkantskiver','Tilmontering af rem på stolper',5,'Stk'),(6,70,45,0,'Skruer 400 stk.','Til montering af yderste beklædning',20,'Pakke'),(7,50,45,0,'Skruer 300 stk.','Til montering af inderste beklædning',15,'Pakke');
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
  `enhed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tagplader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagplader`
--

LOCK TABLES `tagplader` WRITE;
/*!40000 ALTER TABLE `tagplader` DISABLE KEYS */;
INSERT INTO `tagplader` VALUES (1,600,200,5,'Plastmo Ecolite blåtonet','tagplader monteres på spær ',20,'Stk'),(2,360,200,5,'Plastmo Ecolite blåtonet','tagplader monteres på spær ',21,'Stk');
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
  `enhed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtræ`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `træ`
--

LOCK TABLES `træ` WRITE;
/*!40000 ALTER TABLE `træ` DISABLE KEYS */;
INSERT INTO `træ` VALUES (1,360,200,25,11,'understernbrædder til for & bag ende','trykimp. Brædt','Stk'),(2,540,200,25,12,'understernbrædder til siderne','trykimp. Brædt','Stk'),(3,360,125,25,13,'oversternbrædder til forenden','trykimp. Brædt','Stk'),(4,540,125,25,14,'oversternbrædder til siderne','trykimp. Brædt','Stk'),(5,420,73,38,15,'til z på bagside af dør ','Lægte ubh.','Stk'),(6,270,95,45,16,'løsholter til skur gavle ','Reglar ub.','Stk'),(7,240,95,45,17,'løsholter til skur sider','Reglar ub.','Stk'),(8,600,195,45,18,'Remme i sider, sadles ned i stolper','spærtræ ubh.','Stk'),(9,480,195,45,19,'Remme i sider, sadles ned i stolper (skur del, deles)','spærtræ ubh.','Stk'),(10,600,195,45,20,'Spær, monteres på rem','spærtræ ubh.','Stk'),(11,300,97,97,21,'Stolper nedgraves 90 cm. i jord','trykimp. Stolpe','Stk'),(12,210,100,19,22,'til beklædning af skur 1 på 2 ','trykimp. Brædt','Stk'),(13,540,100,19,23,'vandbrædt på stern i sider','trykimp. Brædt','Stk'),(14,360,100,19,24,'vandbrædt på stern i forende','trykimp. Brædt','Stk');
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

-- Dump completed on 2021-05-05 22:00:47
