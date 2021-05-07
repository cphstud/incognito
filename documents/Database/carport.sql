-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
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
-- Table structure for table `carport_item`
--

DROP TABLE IF EXISTS `carport_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_item` (
  `order_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `description` varchar(90) DEFAULT NULL,
  `item_id` int NOT NULL AUTO_INCREMENT,
  `length` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `roof_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_order_has_material_order1_idx` (`order_id`),
  CONSTRAINT `fk_order_has_material_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `fk_orderlist_træ1` FOREIGN KEY (`order_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_item`
--

LOCK TABLES `carport_item` WRITE;
/*!40000 ALTER TABLE `carport_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `carport_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `length` int DEFAULT NULL,
  `price_per_unit` int DEFAULT NULL,
  `name` text,
  `unit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_material_unit1_idx` (`unit`),
  CONSTRAINT `fk_material_unit1` FOREIGN KEY (`unit`) REFERENCES `unit` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,360,4,'25x200	mm.	trykimp.	Brædt','stk'),(2,540,4,'25x200	mm.	trykimp.	Brædt','stk'),(3,360,2,'25x125mm.	trykimp.	Brædt','stk'),(4,540,4,'25x125mm.	trykimp.	Brædt','stk'),(5,420,1,'38x73	mm.	Lægte	ubh.','stk'),(6,270,12,'45x95	mm.	Reglar	ub.','stk'),(7,240,4,'45x95	mm.	Reglar	ub.','stk'),(8,600,2,'45x195	mm.	spærtræ	ubh.','stk'),(9,480,1,'45x195	mm.	spærtræ	ubh.','stk'),(10,600,15,'97x97	mm.	trykimp.	Stolpe','stk'),(11,300,11,'19x100	mm.	trykimp.	Brædt		','stk'),(12,210,200,'19x100	mm.	trykimp.	Brædt		','stk'),(13,540,4,'19x100	mm.	trykimp.	Brædt		','stk'),(14,360,6,'Plastmo	Ecolite	blåtonet','stk'),(15,600,6,'Plastmo	Ecolite	blåtonet','stk'),(16,360,3,'plastmo	bundskruer	200	stk.','pakke'),(17,300,2,'hulbånd	1x20	mm.	10	mtr','rulle'),(18,NULL,15,'universal	190	mm	højre','stk'),(19,NULL,15,'universal	190	mm	venstre','stk'),(20,NULL,1,'4,5	x	60	mm.	skruer	200	stk.','pakke'),(21,NULL,3,'4,0	x	50	mm.	beslagskruer	250	\nstk.','pakke'),(22,NULL,18,'bræddebolt	10	x	120	mm.','stk'),(23,NULL,12,'firkantskiver	40x40x11mm','stk'),(24,NULL,2,'4,5	x	70	mm.	Skruer	400	stk.','pk.'),(25,NULL,2,'4,5	x	50	mm.	Skruer	300	stk.','pk.'),(26,NULL,1,'stalddørsgreb	50x75','sæt'),(27,NULL,2,'t	hængsel	390	mm','stk'),(28,NULL,32,'vinkelbeslag	35','stk');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `subtotal` decimal(10,0) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_customer1_idx` (`customer_id`),
  KEY `fk_order_order_status1_idx` (`status`),
  CONSTRAINT `fk_order_customer1` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_order_order_status1` FOREIGN KEY (`status`) REFERENCES `order_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES ('PAKKE'),('PK.'),('RULLE'),('SÆT'),('STK');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` text,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,NULL,NULL,NULL,'ermin','1234','customer',NULL),(4,NULL,NULL,NULL,'daniel','1234','employee',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 12:24:51
