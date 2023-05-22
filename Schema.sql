-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: auctionsystem
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `Auctions`
--

DROP TABLE IF EXISTS `Auctions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Auctions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `uid` int NOT NULL,
  `minimum_price` float NOT NULL,
  `closing_time` timestamp NOT NULL,
  `bid_type` int NOT NULL,
  `upper_limit` float DEFAULT NULL,
  `bid_increment` float DEFAULT NULL,
  `category` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  CONSTRAINT `auctions_ibfk_1` FOREIGN KEY (`category`) REFERENCES `Category` (`id`),
  CONSTRAINT `auctions_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `auctions_ibfk_3` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Auctions`
--

LOCK TABLES `Auctions` WRITE;
/*!40000 ALTER TABLE `Auctions` DISABLE KEYS */;
INSERT INTO `Auctions` VALUES (1,3,6,10,'2023-04-26 21:03:00',2,100,5,1),(2,2,6,20,'2023-04-26 21:18:00',1,100,5,2),(3,1,6,15,'2023-04-26 22:34:00',2,100,5,1),(5,6,6,30,'2023-05-26 04:00:00',1,100,5,1),(6,7,6,5,'2023-05-26 04:00:00',1,100,5,1),(7,8,6,25,'2023-05-26 04:00:00',1,100,5,1),(8,9,6,100,'2023-05-26 04:00:00',1,100,5,1),(9,4,6,20,'2023-03-26 04:00:00',1,200,10,3),(10,10,6,50,'2023-03-28 04:00:00',2,300,10,3),(11,11,9,9,'2023-03-19 04:00:00',2,20,1,3),(12,7,7,30,'2023-05-25 01:59:00',2,100,5,2),(13,9,8,20,'2023-05-29 02:07:00',1,100,5,2);
/*!40000 ALTER TABLE `Auctions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Men Shoes','Description for Category 1'),(2,'Women Shoes','Description for Category 2'),(3,'Men Jeans','Description for Category 3'),(4,'Women Jeans','Description for Category 4');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `category` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'Product 1','This is the description for Product 1',1),(2,'Product 2','This is the description for Product 2',2),(3,'Product 3','This is the description for Product 3',1),(4,'Product 4','This is the description for Product 4',3),(5,'Product 5','This is the description for Product 5',4),(6,'Nike Shoes','Shoes from Nike Brand',1),(7,'Adidas Shoes','Shoes from Adidas brand',1),(8,'Reebok Shoes','Shoes from Reebok Brand',1),(9,'Puma Shoes','Shoes from puma brand',1),(10,'Nike Air','Premium sports shoe',3),(11,'Puka Shoes','Premium brand from Malakpet',3);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product_bids`
--

DROP TABLE IF EXISTS `Product_bids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product_bids` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `pid` int NOT NULL,
  `current_price` float NOT NULL,
  `aid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  CONSTRAINT `product_bids_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `product_bids_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product_bids`
--

LOCK TABLES `Product_bids` WRITE;
/*!40000 ALTER TABLE `Product_bids` DISABLE KEYS */;
INSERT INTO `Product_bids` VALUES (1,7,1,20,3),(2,8,1,25,3),(3,7,2,30,2),(4,8,2,30,2),(5,7,2,40,2),(6,7,3,55,1),(7,8,3,75,1),(8,7,2,30,2),(9,7,3,80,1),(10,7,3,85,1),(11,7,3,85,1),(12,7,3,85,1),(13,7,3,85,1),(14,7,3,85,1),(15,7,3,90,1),(16,7,3,95,1),(17,7,3,100,1),(18,8,6,20,5),(19,8,7,20,6),(20,8,8,20,7),(21,8,9,20,8),(22,8,4,30,9),(23,7,10,60,10),(24,7,6,30,5),(25,7,3,105,1);
/*!40000 ALTER TABLE `Product_bids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `q_post_time` timestamp NOT NULL,
  `a_post_time` timestamp NULL DEFAULT NULL,
  `user` int NOT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'what is an auction system?','system to place auctions','2023-05-01 16:00:00','2023-05-02 00:00:00',1,1),(3,'Test Question','This question has been answered.','2023-05-01 04:00:00',NULL,7,1),(4,'How durable are the Air Jordans.','It lasts for 12 years.','2023-05-01 04:00:00',NULL,7,1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','password','admin@test.com',0),(2,'devesh','Devudu','devesh@test.com',0),(3,'arun','mahnubavudu','arun@test.com',0),(4,'loki','Metal123','loki@test.com',0),(5,'rep1','pass','rep1@test.com',1),(6,'seller1','pass','sell1@test.com',2),(7,'buyer1','pass','buy1@test.com',3),(8,'buyer2','pass','buy2@test.com',3),(9,'seller2','pass','sell2@test.com',2),(10,'Representative 1','1234','rep@rep.com',1),(11,'Representative 2','pass','rep2@rep.com',1),(12,'Representative 3','pass','rep3@rep.com',1);
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

-- Dump completed on 2023-05-01 23:46:38
