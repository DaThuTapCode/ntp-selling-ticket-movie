CREATE DATABASE  IF NOT EXISTS `ntp_booking_movie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ntp_booking_movie`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ntp_booking_movie
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `userId` bigint NOT NULL,
                           `bookingDate` timestamp NOT NULL,
                           `total_price` decimal(10,2) NOT NULL,
                           `transactioncode` varchar(100) DEFAULT NULL,
                           `status` varchar(20) NOT NULL,
                           `orderinfo` varchar(200) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `userId` (`userId`),
                           CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,'2024-06-16 10:38:14',200000.00,'14461869','CONFIRMED','Thanh toan don hang:17097190'),(2,1,'2024-06-19 06:02:29',190000.00,'14467027','CONFIRMED','Thanh toan don hang:93940478'),(3,1,'2024-06-19 10:18:58',90000.00,'14467708','CONFIRMED','Thanh toan don hang:72323043'),(4,1,'2024-06-19 13:10:22',190000.00,'14467926','CONFIRMED','Thanh toan don hang:05790864'),(5,1,'2024-06-21 11:00:36',100000.00,'14471903','CONFIRMED','Thanh toan don hang:69276231'),(6,2,'2024-06-21 15:22:33',180000.00,NULL,'CANCELED',NULL),(7,2,'2024-06-21 15:27:11',180000.00,NULL,'CANCELED',NULL),(8,2,'2024-06-21 15:29:01',180000.00,NULL,'CANCELED',NULL),(9,1,'2024-06-22 15:54:21',200000.00,'14473284','CONFIRMED','Thanh toan don hang:97626072'),(10,1,'2024-06-23 04:32:31',180000.00,'14473675','CONFIRMED','Thanh toan don hang:58962360'),(11,1,'2024-06-23 10:30:33',100000.00,'14474047','CONFIRMED','Thanh toan don hang:59840584'),(12,1,'2024-06-23 13:11:49',820000.00,NULL,'CANCELED',NULL),(13,1,'2024-06-24 10:31:16',290000.00,'14476033','CONFIRMED','Thanh toan don hang:46215008'),(14,1,'2024-06-24 11:25:07',200000.00,NULL,'CANCELED',NULL),(15,1,'2024-06-24 11:43:28',300000.00,'14476156','CONFIRMED','Thanh toan don hang:70919016'),(16,2,'2024-06-24 11:54:25',270000.00,'14476176','CONFIRMED','Thanh toan don hang:53014665'),(17,1,'2024-06-25 01:57:51',180000.00,NULL,'CANCELED',NULL),(18,1,'2024-06-25 01:58:17',200000.00,NULL,'CANCELED',NULL),(19,2,'2024-06-25 05:41:18',390000.00,'14477380','CONFIRMED','Thanh toan don hang:21000466'),(20,1,'2024-06-25 06:33:20',190000.00,NULL,'CANCELED',NULL),(21,1,'2024-06-25 06:34:22',190000.00,NULL,'CANCELED',NULL),(22,4,'2024-06-25 16:07:30',180000.00,'14478504','CONFIRMED','Thanh toan don hang:47501358'),(23,3,'2024-06-25 16:11:23',180000.00,NULL,'CANCELED',NULL),(24,5,'2024-06-25 16:31:18',190000.00,'14478550','CONFIRMED','Thanh toan don hang:77730058'),(25,2,'2024-06-25 16:34:02',90000.00,NULL,'CANCELED',NULL),(26,7,'2024-06-26 06:24:57',290000.00,'14479383','CONFIRMED','Thanh toan don hang:63679751'),(27,8,'2024-06-26 06:58:16',190000.00,NULL,'CANCELED',NULL),(28,12,'2024-06-26 07:50:47',200000.00,'14479598','CONFIRMED','Thanh toan don hang:90115254'),(29,2,'2024-06-26 07:53:58',90000.00,NULL,'CANCELED',NULL),(30,17,'2024-06-26 15:33:23',200000.00,'14480455','CONFIRMED','Thanh toan don hang:13997074'),(31,19,'2024-06-26 16:00:19',180000.00,'14480509','CONFIRMED','Thanh toan don hang:41562816'),(32,21,'2024-06-27 01:48:24',290000.00,'14480841','CONFIRMED','Thanh toan don hang:66045869'),(33,2,'2024-06-27 01:53:05',180000.00,NULL,'CANCELED',NULL),(34,21,'2024-06-27 01:55:06',200000.00,NULL,'CANCELED',NULL),(35,24,'2024-06-27 02:44:52',290000.00,'14480956','CONFIRMED','Thanh toan don hang:41806791'),(36,2,'2024-06-27 02:48:49',90000.00,NULL,'CANCELED',NULL),(37,2,'2024-06-27 02:50:14',360000.00,NULL,'CANCELED',NULL),(38,1,'2024-06-27 09:00:58',100000.00,NULL,'CANCELED',NULL),(39,1,'2024-06-27 09:01:30',100000.00,NULL,'CANCELED',NULL),(40,2,'2024-06-27 09:02:39',100000.00,NULL,'CANCELED',NULL),(41,1,'2024-06-27 09:03:48',100000.00,NULL,'CANCELED',NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookingdetail`
--

DROP TABLE IF EXISTS `bookingdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingdetail` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `bookingId` bigint NOT NULL,
                                 `showTimeId` bigint NOT NULL,
                                 `seatId` bigint NOT NULL,
                                 `theaterId` bigint NOT NULL,
                                 `price` decimal(10,2) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `bookingId` (`bookingId`),
                                 KEY `theaterId` (`theaterId`),
                                 KEY `showTimeId` (`showTimeId`),
                                 KEY `seatId` (`seatId`),
                                 CONSTRAINT `bookingdetail_ibfk_1` FOREIGN KEY (`bookingId`) REFERENCES `booking` (`id`),
                                 CONSTRAINT `bookingdetail_ibfk_2` FOREIGN KEY (`theaterId`) REFERENCES `theaters` (`id`),
                                 CONSTRAINT `bookingdetail_ibfk_3` FOREIGN KEY (`showTimeId`) REFERENCES `showtimes` (`id`),
                                 CONSTRAINT `bookingdetail_ibfk_4` FOREIGN KEY (`seatId`) REFERENCES `seats` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetail`
--

LOCK TABLES `bookingdetail` WRITE;
/*!40000 ALTER TABLE `bookingdetail` DISABLE KEYS */;
INSERT INTO `bookingdetail` VALUES (1,1,5,38,1,100000.00),(2,1,5,53,1,100000.00),(3,2,13,22,1,90000.00),(4,2,13,37,1,100000.00),(5,3,13,1,1,90000.00),(6,4,13,23,1,90000.00),(7,4,13,38,1,100000.00),(8,5,16,56,1,100000.00),(9,6,16,1,1,90000.00),(10,6,16,2,1,90000.00),(11,7,16,1,1,90000.00),(12,7,16,16,1,90000.00),(13,8,16,1,1,90000.00),(14,8,16,2,1,90000.00),(15,9,29,251,2,200000.00),(16,10,28,11,1,90000.00),(17,10,28,12,1,90000.00),(18,11,31,41,1,100000.00),(19,12,34,26,1,90000.00),(20,12,34,27,1,90000.00),(21,12,34,28,1,90000.00),(22,12,34,30,1,90000.00),(23,12,34,29,1,90000.00),(24,12,34,193,1,90000.00),(25,12,34,192,1,90000.00),(26,12,34,198,1,90000.00),(27,12,34,45,1,100000.00),(28,13,36,40,1,100000.00),(29,13,36,41,1,100000.00),(30,13,36,13,1,90000.00),(31,14,36,43,1,100000.00),(32,14,36,44,1,100000.00),(33,15,36,44,1,100000.00),(34,15,36,43,1,100000.00),(35,15,36,45,1,100000.00),(36,16,36,27,1,90000.00),(37,16,36,26,1,90000.00),(38,16,36,25,1,90000.00),(39,17,44,25,1,90000.00),(40,17,44,26,1,90000.00),(41,18,44,57,1,100000.00),(42,18,44,42,1,100000.00),(43,19,44,25,1,90000.00),(44,19,44,40,1,100000.00),(45,19,44,81,1,200000.00),(46,20,44,26,1,90000.00),(47,20,44,41,1,100000.00),(48,21,44,26,1,90000.00),(49,21,44,41,1,100000.00),(50,22,44,200,1,90000.00),(51,22,44,194,1,90000.00),(52,23,44,1,1,90000.00),(53,23,44,2,1,90000.00),(54,24,44,16,1,90000.00),(55,24,44,31,1,100000.00),(56,25,44,1,1,90000.00),(57,26,49,38,1,100000.00),(58,26,49,37,1,100000.00),(59,26,49,27,1,90000.00),(60,27,50,31,1,100000.00),(61,27,50,16,1,90000.00),(62,28,49,42,1,100000.00),(63,28,49,41,1,100000.00),(64,29,49,1,1,90000.00),(65,30,58,144,1,100000.00),(66,30,58,129,1,100000.00),(67,31,58,107,1,90000.00),(68,31,58,108,1,90000.00),(69,32,67,58,1,100000.00),(70,32,67,57,1,100000.00),(71,32,67,200,1,90000.00),(72,33,67,1,1,90000.00),(73,33,67,2,1,90000.00),(74,34,67,43,1,100000.00),(75,34,67,44,1,100000.00),(76,35,67,31,1,100000.00),(77,35,67,32,1,100000.00),(78,35,67,16,1,90000.00),(79,36,67,1,1,90000.00),(80,37,67,25,1,90000.00),(81,37,67,11,1,90000.00),(82,37,67,26,1,90000.00),(83,37,67,12,1,90000.00),(84,38,84,35,1,100000.00),(85,39,84,40,1,100000.00),(86,40,85,41,1,100000.00),(87,41,84,42,1,100000.00);
/*!40000 ALTER TABLE `bookingdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `movieId` bigint NOT NULL,
                         `theaterId` bigint NOT NULL,
                         `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `description` text,
                         `image` text,
                         `eventDate` date NOT NULL,
                         `location` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `movieId` (`movieId`),
                         KEY `theaterId` (`theaterId`),
                         CONSTRAINT `event_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`),
                         CONSTRAINT `event_ibfk_2` FOREIGN KEY (`theaterId`) REFERENCES `theaters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `title` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                          `descriptions` text,
                          `duration` int NOT NULL,
                          `releaseDate` date DEFAULT NULL,
                          `genre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                          `language` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                          `performers` text,
                          `director` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                          `trailer` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                          `image` text,
                          `status` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Transformer One','Người máy biến hình 1',180,'2024-06-15','Viễn Tưởng','Phụ đề','Trọng Phú ọp tì mớt','Trọng Phú','WLqCKr2h1BI','f97d88fc-9d37-4b33-8304-031e5abdebd6_TransformersOne.jpg',1),(2,'Mùa hè đẹp nhất','Mùa hè đẹp nhất',60,'2024-06-15','Healing','Phụ đề','Minh Dự, Khánh Vân, Công Dương',' Vũ Khắc Tuận','agLVNJ_v7Jo','e55577d7-76f4-4968-b490-a43cd3ff5a15_muaHeDepNhat.jpg',1),(3,'Kẻ trộm mặt trăng 4','Kẻ trộm mặt trăng 4',60,'2024-06-15','Viễn Tưởng','Phụ đề',' Kristen Wiig, Steve Carell','Chris Renaud, Patrick Delage','S1dnnQsY0QU','a4c816ba-4480-4ef2-8546-cfdd5a606156_keTromMatTrang4.jpg',1),(4,'Doraemon bản giao hưởng địa cầu','PHIM ĐIỆN ẢNH DORAEMON: NOBITA VÀ BẢN GIAO HƯỞNG ĐỊA CẦU ',60,'2024-06-15','Viễn Tưởng, Animation','Phụ đề','Trọng Phú Doraemon','Trọng Phú','Yug8gbDd5EQ&t=13s','91fed7f3-fb5e-4088-8986-16b38ca64070_doraemonBanGiaoHuongDiaCau.jpg',1),(5,'NHỮNG NGƯỜI BẠN TƯỞNG TƯỢNG (IF)','Những người bạn tưởng tượng IF',60,'2024-06-15','Viễn Tưởng, Animation','Phụ đề','Trọng Phú If','Trọng Phú','SSeT4AMckbo','d810a3f4-dac7-4d2f-960f-73d5c0c81836_if.jpg',1),(6,'Haikyu!!: Trận Chiến Bãi Phế Liệu','Haikyu!!: Trận Chiến Bãi Phế Liệu',60,'2024-06-15','Viễn Tưởng, Animation','Phụ đề','Trọng Phú Haikyu','Trọng Phú','OFB4mrupFX0','65038b94-51e7-4123-87de-c2d9c6a48d78_HAIKYU!!_THE_DUMPSTER_BATTLE.jpg',1),(7,'PANDA ĐẠI NÁO LÃNH ĐỊA VUA SƯ TỬ','PANDA ĐẠI NÁO LÃNH ĐỊA VUA SƯ TỬ',60,'2024-06-15','Viễn Tưởng, Animation','Phụ đề','Trọng Phú','Trọng Phú','iwKJ-qxo-t8&t=13s','65c0d896-e951-4754-95e6-4ddff781b7cb_pandaDaiNaoLanhDiaVuaSuTu.jpg',1),(8,'ABIGAIL ','ABIGAIL ',60,'2024-06-15','Viễn Tưởng, Kinh dị','Phụ đề','Trọng Phú','Trọng Phú','ORdAZ_4jdZ0','a4c4edce-30c8-4287-b38c-987f87bc91de_ABIGAIL.jpg',1),(9,'Án mạng lầu 4','Án mạng lầu 4',180,'2024-06-22','Viễn Tưởng','Phụ đề, Tiếng Việt','Trọng Phú lầu 4','Trọng Phú','agzckaoLRaY','e8cf05ad-2d1f-4638-a0e4-314ef2192790_anMangLau4.jpg',1),(10,'TAROT','TAROT',60,'2024-06-21','Viễn Tưởng, Kinh Dị','Phụ đề','Trọng Phú TAROT','Trọng Phú','KYKusPsrmi8','4f9122ad-ea58-4464-a676-d823812bfeb9_tarot.jpg',1),(11,'Vây hãm kẻ trừng phạt1','Người máy biến hình 1',60,'2024-06-29','Viễn Tưởng','Phụ đề, Hàn Quốc','Trọng Phú vây hãm','Trọng Phú','kwOgIPZvdgg','c53c08af-270a-483e-b3f9-83c57c2ae36b_vayHamKeTrungPhat.jpg',1),(12,'Deadpool','DeadPool',60,'2024-06-30','Viễn Tưởng','Phụ đề, Tiếng Anh','người sói, deadpool','Marvel','inIVdZSFfc0','ad5adfc0-bac6-4399-b923-f249d5c0f9a3_DeadPool.png',1),(13,'Conan','Thám tử conan',60,'2024-06-30','Viễn Tưởng, Trinh Thám','Phụ đề, Tiếng Nhật','Conan, 2bara','GhoAoyama','NwnQI9izPFc','0b133f24-db9b-4b9b-a462-6a356dc342b2_Conan.jpg',2),(14,'Lốc xoáy tử thần','Lốc xoáy',60,'2024-06-30','Viễn Tưởng','Phụ đề, Tiếng Anh','Diễn Viên aa','He he','1jfLifeGvjY','8f22faf3-21b2-480f-9f78-d0b71f6321a8_locXoayTuThan.png',1),(15,'Vụ bê bối ánh trăng','Vụ bê bối ánh trăng mô tả',60,'2024-06-29','Viễn Tưởng, Tình cảm','Phụ đề, Tiếng Anh','Trọng Phú ánh trănh','Trọng Phú','KY0hE2kWOck','2b42a53f-c331-4313-8970-db8233ffa3f2_ChangNuPhiCong.jpg',1);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieticketprices`
--

DROP TABLE IF EXISTS `movieticketprices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieticketprices` (
                                     `id` bigint NOT NULL AUTO_INCREMENT,
                                     `movieId` bigint NOT NULL,
                                     `theaterId` bigint NOT NULL,
                                     `price` decimal(10,2) DEFAULT NULL,
                                     `seatType` varchar(20) DEFAULT NULL,
                                     `dayOfWeek` int NOT NULL,
                                     `startTime` time NOT NULL,
                                     `endTime` time NOT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `movieId` (`movieId`),
                                     KEY `theaterId` (`theaterId`),
                                     CONSTRAINT `movieticketprices_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`),
                                     CONSTRAINT `movieticketprices_ibfk_2` FOREIGN KEY (`theaterId`) REFERENCES `theaters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieticketprices`
--

LOCK TABLES `movieticketprices` WRITE;
/*!40000 ALTER TABLE `movieticketprices` DISABLE KEYS */;
/*!40000 ALTER TABLE `movieticketprices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotions` (
                              `id` bigint NOT NULL,
                              `movieId` bigint NOT NULL,
                              `theaterId` bigint NOT NULL,
                              `title` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              `image` text,
                              `description` text,
                              `startDate` date DEFAULT NULL,
                              `endDate` date DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `movieId` (`movieId`),
                              KEY `theaterId` (`theaterId`),
                              CONSTRAINT `promotions_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`),
                              CONSTRAINT `promotions_ibfk_2` FOREIGN KEY (`theaterId`) REFERENCES `theaters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotions`
--

LOCK TABLES `promotions` WRITE;
/*!40000 ALTER TABLE `promotions` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `name` varchar(100) DEFAULT NULL,
                         `description` text,
                         `createAt` datetime DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN','Administrator role','2024-06-16 15:28:03'),(2,'USER','User role','2024-06-16 15:28:03'),(3,'MODERATOR','Moderator role','2024-06-16 15:28:03');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screens`
--

DROP TABLE IF EXISTS `screens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `screens` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `theaterId` bigint NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `type` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `theaterId` (`theaterId`),
                           CONSTRAINT `screens_ibfk_1` FOREIGN KEY (`theaterId`) REFERENCES `theaters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screens`
--

LOCK TABLES `screens` WRITE;
/*!40000 ALTER TABLE `screens` DISABLE KEYS */;
INSERT INTO `screens` VALUES (1,1,'Screen 1','Bình thường'),(2,1,'Screen 2','Bình thường'),(3,1,'Screen 3','Bình thường'),(4,1,'Screen 4','Bình thường'),(5,1,'Screen 5','Bình thường'),(6,1,'Screen 6','Bình thường'),(7,2,'Screen 1','Bình thường'),(8,2,'Screen 2','Bình thường'),(9,2,'Screen 3','Bình thường'),(10,2,'Screen 4','Bình thường'),(11,2,'Screen 5','Bình thường'),(12,2,'Screen 6','Bình thường'),(13,1,'Screen 7','Bình thường'),(14,2,'Screen 7','He he');
/*!40000 ALTER TABLE `screens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `screenId` bigint NOT NULL,
                         `seatRow` char(1) NOT NULL,
                         `seatNumber` int NOT NULL,
                         `type` varchar(20) DEFAULT NULL,
                         `status` varchar(20) DEFAULT 'available',
                         `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `screenId` (`screenId`,`seatRow`,`seatNumber`),
                         CONSTRAINT `seats_ibfk_1` FOREIGN KEY (`screenId`) REFERENCES `screens` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=348 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (1,1,'A',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-28 03:24:45'),(2,1,'A',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(3,1,'A',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(4,1,'A',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(5,1,'A',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(6,1,'A',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(7,1,'A',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(9,1,'A',9,'STANDARD','available','2024-06-16 08:28:03','2024-06-24 09:09:44'),(10,1,'A',10,'NULL','available','2024-06-16 08:28:03','2024-06-24 09:09:53'),(11,1,'A',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(12,1,'A',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(13,1,'A',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(14,1,'A',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(15,1,'A',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-20 16:26:31'),(16,1,'B',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(17,1,'B',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(18,1,'B',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(19,1,'B',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(20,1,'B',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(21,1,'B',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(22,1,'B',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(23,1,'B',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(24,1,'B',9,'NULL','available','2024-06-16 08:28:03','2024-06-20 13:43:10'),(25,1,'B',10,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(26,1,'B',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(27,1,'B',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(28,1,'B',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(29,1,'B',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(30,1,'B',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(31,1,'C',1,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(32,1,'C',2,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(33,1,'C',3,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(34,1,'C',4,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(35,1,'C',5,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(36,1,'C',6,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(37,1,'C',7,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(38,1,'C',8,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(39,1,'C',9,'NULL','available','2024-06-16 08:28:03','2024-06-25 11:28:57'),(40,1,'C',10,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(41,1,'C',11,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(42,1,'C',12,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(43,1,'C',13,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(44,1,'C',14,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(45,1,'C',15,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(46,1,'D',1,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(47,1,'D',2,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(48,1,'D',3,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(49,1,'D',4,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(50,1,'D',5,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(51,1,'D',6,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(52,1,'D',7,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(53,1,'D',8,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(54,1,'D',9,'NULL','available','2024-06-16 08:28:03','2024-06-20 13:43:15'),(55,1,'D',10,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(56,1,'D',11,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(57,1,'D',12,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(58,1,'D',13,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(59,1,'D',14,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(60,1,'D',15,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(61,1,'E',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(62,1,'E',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(63,1,'E',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(64,1,'E',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(65,1,'E',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(66,1,'E',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(67,1,'E',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(68,1,'E',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(69,1,'E',9,'NULL','available','2024-06-16 08:28:03','2024-06-20 13:43:17'),(70,1,'E',10,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(71,1,'E',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(72,1,'E',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(73,1,'E',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(74,1,'E',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(75,1,'E',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(76,1,'F',1,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:05'),(77,1,'F',2,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:02'),(78,1,'F',3,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:07'),(79,1,'F',4,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:09'),(80,1,'F',5,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:11'),(81,1,'F',6,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:14'),(82,1,'F',7,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:16'),(83,1,'F',8,'COUPLE','available','2024-06-16 08:28:03','2024-06-24 09:10:18'),(84,1,'F',9,'NULL','available','2024-06-16 08:28:03','2024-06-20 13:43:20'),(86,1,'F',11,'NULL','available','2024-06-16 08:28:03','2024-06-25 11:22:55'),(87,1,'F',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(88,1,'F',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(89,1,'F',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(90,1,'F',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(91,2,'A',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(92,2,'A',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(93,2,'A',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(94,2,'A',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(95,2,'A',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(96,2,'A',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(97,2,'A',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(98,2,'A',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(99,2,'A',9,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(100,2,'A',10,'NULL','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(101,2,'A',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(102,2,'A',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(103,2,'A',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(104,2,'A',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(105,2,'A',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(106,2,'B',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(107,2,'B',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(108,2,'B',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(109,2,'B',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(110,2,'B',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(111,2,'B',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(112,2,'B',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(113,2,'B',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(114,2,'B',9,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(115,2,'B',10,'NULL','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(116,2,'B',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(117,2,'B',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(118,2,'B',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(119,2,'B',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(120,2,'B',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(121,2,'C',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(122,2,'C',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(123,2,'C',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(124,2,'C',4,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(125,2,'C',5,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(126,2,'C',6,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(127,2,'C',7,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(128,2,'C',8,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(129,2,'C',9,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(130,2,'C',10,'STANDARD','available','2024-06-16 08:28:03','2024-06-26 15:51:11'),(131,2,'C',11,'NULL','available','2024-06-16 08:28:03','2024-06-26 15:51:16'),(132,2,'C',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(133,2,'C',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(134,2,'C',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(135,2,'C',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(136,2,'D',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(137,2,'D',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(138,2,'D',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(139,2,'D',4,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(140,2,'D',5,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(141,2,'D',6,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(142,2,'D',7,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(143,2,'D',8,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(144,2,'D',9,'VIP','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(145,2,'D',10,'NULL','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(146,2,'D',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(147,2,'D',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(148,2,'D',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(149,2,'D',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(150,2,'D',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(151,2,'E',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(152,2,'E',2,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(153,2,'E',3,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(154,2,'E',4,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(155,2,'E',5,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(156,2,'E',6,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(157,2,'E',7,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(158,2,'E',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(159,2,'E',9,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(160,2,'E',10,'NULL','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(161,2,'E',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(162,2,'E',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(163,2,'E',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(164,2,'E',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(165,2,'E',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(166,2,'F',1,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(167,2,'F',2,'COUPLE','available','2024-06-16 08:28:03','2024-06-26 15:50:21'),(168,2,'F',3,'COUPLE','available','2024-06-16 08:28:03','2024-06-26 15:50:26'),(169,2,'F',4,'COUPLE','available','2024-06-16 08:28:03','2024-06-26 15:50:28'),(170,2,'F',5,'COUPLE','available','2024-06-16 08:28:03','2024-06-26 15:50:34'),(171,2,'F',6,'COUPLE','available','2024-06-16 08:28:03','2024-06-26 15:50:37'),(172,2,'F',7,'NULL','available','2024-06-16 08:28:03','2024-06-26 15:51:24'),(173,2,'F',8,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(174,2,'F',9,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(175,2,'F',10,'NULL','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(176,2,'F',11,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(177,2,'F',12,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(178,2,'F',13,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(179,2,'F',14,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(180,2,'F',15,'STANDARD','available','2024-06-16 08:28:03','2024-06-16 08:28:03'),(186,1,'A',16,'STANDARD','available','2024-06-20 16:01:41','2024-06-20 16:02:21'),(187,1,'A',17,'STANDARD','available','2024-06-20 16:01:52','2024-06-20 16:02:19'),(188,1,'A',18,'STANDARD','available','2024-06-20 16:02:38','2024-06-20 16:26:34'),(189,1,'A',19,'STANDARD','available','2024-06-20 16:02:44','2024-06-24 09:09:46'),(190,1,'A',20,'NULL','available','2024-06-20 16:02:50','2024-06-25 11:28:29'),(191,1,'A',21,'STANDARD','available','2024-06-20 16:02:53','2024-06-20 16:26:45'),(192,1,'B',17,'STANDARD','available','2024-06-20 16:03:05','2024-06-20 16:26:43'),(193,1,'B',16,'STANDARD','available','2024-06-20 16:03:13','2024-06-20 16:03:13'),(194,1,'B',18,'STANDARD','available','2024-06-20 16:03:23','2024-06-20 16:03:23'),(195,1,'B',19,'NULL','available','2024-06-20 16:03:26','2024-06-20 16:27:02'),(196,1,'B',20,'STANDARD','available','2024-06-20 16:03:30','2024-06-20 16:03:30'),(197,1,'B',21,'STANDARD','available','2024-06-20 16:03:36','2024-06-20 16:03:36'),(198,1,'C',16,'STANDARD','available','2024-06-20 16:03:44','2024-06-20 16:03:44'),(199,1,'C',17,'STANDARD','available','2024-06-20 16:03:46','2024-06-20 16:03:46'),(200,1,'C',18,'STANDARD','available','2024-06-20 16:03:48','2024-06-20 16:03:48'),(201,1,'C',19,'NULL','available','2024-06-20 16:03:50','2024-06-20 16:27:00'),(202,1,'C',20,'STANDARD','available','2024-06-20 16:03:52','2024-06-20 16:03:52'),(203,1,'C',21,'STANDARD','available','2024-06-20 16:03:53','2024-06-20 16:03:53'),(204,1,'D',16,'STANDARD','available','2024-06-20 16:03:59','2024-06-20 16:03:59'),(205,1,'D',17,'STANDARD','available','2024-06-20 16:04:00','2024-06-20 16:04:00'),(206,1,'D',18,'STANDARD','available','2024-06-20 16:04:01','2024-06-20 16:04:01'),(207,1,'D',19,'NULL','available','2024-06-20 16:04:04','2024-06-20 16:26:58'),(208,1,'D',20,'STANDARD','available','2024-06-20 16:04:05','2024-06-20 16:04:05'),(209,1,'D',21,'STANDARD','available','2024-06-20 16:04:08','2024-06-20 16:04:08'),(210,1,'E',21,'STANDARD','available','2024-06-20 16:04:20','2024-06-20 16:04:20'),(211,1,'E',20,'STANDARD','available','2024-06-20 16:04:21','2024-06-20 16:04:21'),(212,1,'E',19,'NULL','available','2024-06-20 16:04:23','2024-06-20 16:26:56'),(213,1,'E',18,'STANDARD','available','2024-06-20 16:04:24','2024-06-20 16:04:24'),(214,1,'E',17,'STANDARD','available','2024-06-20 16:04:26','2024-06-20 16:04:26'),(215,1,'E',16,'STANDARD','available','2024-06-20 16:04:28','2024-06-20 16:04:28'),(217,4,'K',1,'STANDARD','available','2024-06-20 16:47:40','2024-06-20 16:47:40'),(218,7,'A',1,'NULL','available','2024-06-21 15:41:25','2024-06-21 15:42:58'),(219,7,'A',2,'NULL','available','2024-06-21 15:41:26','2024-06-21 15:43:00'),(220,7,'A',3,'NULL','available','2024-06-21 15:41:29','2024-06-21 15:43:06'),(221,7,'A',4,'NULL','available','2024-06-21 15:41:30','2024-06-21 15:43:09'),(222,7,'A',5,'NULL','available','2024-06-21 15:41:32','2024-06-21 15:43:10'),(223,7,'A',6,'NULL','available','2024-06-21 15:41:33','2024-06-21 15:43:12'),(224,7,'A',7,'NULL','available','2024-06-21 15:41:34','2024-06-21 15:43:15'),(225,7,'A',8,'NULL','available','2024-06-21 15:41:36','2024-06-21 15:43:17'),(226,7,'A',9,'NULL','available','2024-06-21 15:41:38','2024-06-21 15:43:19'),(227,7,'A',10,'NULL','available','2024-06-21 15:41:39','2024-06-21 15:43:22'),(228,7,'A',11,'NULL','available','2024-06-21 15:41:41','2024-06-21 15:43:24'),(229,7,'A',12,'NULL','available','2024-06-21 15:41:43','2024-06-21 15:43:26'),(230,7,'A',13,'NULL','available','2024-06-21 15:41:44','2024-06-21 15:43:28'),(231,7,'A',14,'NULL','available','2024-06-21 15:41:46','2024-06-21 15:43:30'),(232,7,'A',15,'NULL','available','2024-06-21 15:41:48','2024-06-21 15:43:32'),(233,7,'B',15,'STANDARD','available','2024-06-21 15:41:54','2024-06-21 15:41:54'),(234,7,'B',14,'STANDARD','available','2024-06-21 15:41:56','2024-06-21 15:41:56'),(235,7,'B',13,'STANDARD','available','2024-06-21 15:41:57','2024-06-21 15:41:57'),(236,7,'B',12,'STANDARD','available','2024-06-21 15:41:58','2024-06-21 15:41:58'),(237,7,'B',11,'NULL','available','2024-06-21 15:42:00','2024-06-21 15:43:04'),(238,7,'B',10,'STANDARD','available','2024-06-21 15:42:01','2024-06-21 15:42:01'),(239,7,'B',9,'VIP','available','2024-06-21 15:42:02','2024-06-21 15:43:48'),(240,7,'B',8,'VIP','available','2024-06-21 15:42:03','2024-06-21 15:43:44'),(241,7,'B',7,'VIP','available','2024-06-21 15:42:06','2024-06-21 15:43:50'),(242,7,'B',6,'VIP','available','2024-06-21 15:42:14','2024-06-21 15:43:52'),(243,7,'B',5,'STANDARD','available','2024-06-21 15:42:16','2024-06-21 15:42:16'),(244,7,'B',4,'STANDARD','available','2024-06-21 15:42:17','2024-06-21 15:42:17'),(245,7,'B',3,'STANDARD','available','2024-06-21 15:42:19','2024-06-21 15:42:19'),(246,7,'B',2,'STANDARD','available','2024-06-21 15:42:20','2024-06-21 15:42:20'),(247,7,'C',1,'NULL','available','2024-06-21 15:42:27','2024-06-21 15:44:27'),(248,7,'C',2,'COUPLE','available','2024-06-21 15:42:29','2024-06-21 15:44:25'),(249,7,'C',3,'COUPLE','available','2024-06-21 15:42:30','2024-06-21 15:44:02'),(250,7,'C',4,'COUPLE','available','2024-06-21 15:42:31','2024-06-21 15:43:59'),(251,7,'C',5,'COUPLE','available','2024-06-21 15:42:33','2024-06-21 15:43:57'),(252,7,'C',6,'COUPLE','available','2024-06-21 15:42:35','2024-06-21 15:44:14'),(253,7,'C',7,'NULL','available','2024-06-21 15:42:37','2024-06-21 15:44:17'),(254,7,'C',8,'NULL','available','2024-06-21 15:42:39','2024-06-21 15:44:20'),(255,7,'C',9,'NULL','available','2024-06-21 15:42:41','2024-06-21 15:43:35'),(256,7,'C',10,'NULL','available','2024-06-21 15:42:43','2024-06-21 15:44:23'),(257,7,'C',11,'COUPLE','available','2024-06-21 15:42:44','2024-06-21 15:44:08'),(258,7,'C',12,'COUPLE','available','2024-06-21 15:42:49','2024-06-21 15:44:06'),(259,1,'A',22,'STANDARD','available','2024-06-24 06:10:41','2024-06-24 06:10:41'),(304,2,'C',16,'STANDARD','available','2024-06-26 15:50:51','2024-06-26 15:51:04'),(305,2,'C',17,'STANDARD','available','2024-06-26 15:50:54','2024-06-26 15:51:06'),(306,3,'A',1,'STANDARD','available','2024-06-28 03:25:20','2024-06-28 03:25:20'),(307,3,'A',2,'STANDARD','available','2024-06-28 03:25:22','2024-06-28 03:25:22'),(308,3,'A',3,'STANDARD','available','2024-06-28 03:25:23','2024-06-28 03:25:23'),(309,3,'A',4,'STANDARD','available','2024-06-28 03:25:24','2024-06-28 03:25:24'),(310,3,'A',5,'STANDARD','available','2024-06-28 03:25:26','2024-06-28 03:25:26'),(311,3,'A',6,'NULL','available','2024-06-28 03:25:27','2024-06-28 03:27:34'),(312,3,'A',7,'STANDARD','available','2024-06-28 03:25:28','2024-06-28 03:25:28'),(313,3,'A',8,'STANDARD','available','2024-06-28 03:25:30','2024-06-28 03:25:30'),(314,3,'A',9,'STANDARD','available','2024-06-28 03:25:31','2024-06-28 03:25:31'),(315,3,'B',9,'STANDARD','available','2024-06-28 03:25:35','2024-06-28 03:25:35'),(316,3,'B',8,'NULL','available','2024-06-28 03:25:37','2024-06-28 03:27:37'),(317,3,'B',7,'STANDARD','available','2024-06-28 03:25:38','2024-06-28 03:25:38'),(318,3,'B',6,'STANDARD','available','2024-06-28 03:25:53','2024-06-28 03:25:53'),(319,3,'B',5,'STANDARD','available','2024-06-28 03:25:55','2024-06-28 03:25:55'),(320,3,'B',4,'STANDARD','available','2024-06-28 03:25:56','2024-06-28 03:25:56'),(321,3,'C',4,'COUPLE','available','2024-06-28 03:26:03','2024-06-28 03:26:03'),(322,3,'C',3,'NULL','available','2024-06-28 03:26:06','2024-06-28 03:27:39'),(323,3,'C',2,'COUPLE','available','2024-06-28 03:26:07','2024-06-28 03:26:07'),(324,3,'C',1,'COUPLE','available','2024-06-28 03:26:09','2024-06-28 03:26:09'),(325,3,'D',1,'STANDARD','available','2024-06-28 03:26:17','2024-06-28 03:26:17'),(326,3,'D',2,'STANDARD','available','2024-06-28 03:26:18','2024-06-28 03:26:18'),(327,3,'D',3,'STANDARD','available','2024-06-28 03:26:19','2024-06-28 03:26:19'),(328,3,'D',4,'STANDARD','available','2024-06-28 03:26:21','2024-06-28 03:26:21'),(329,3,'D',5,'STANDARD','available','2024-06-28 03:26:22','2024-06-28 03:26:22'),(330,3,'D',6,'STANDARD','available','2024-06-28 03:26:23','2024-06-28 03:26:23'),(331,3,'D',7,'STANDARD','available','2024-06-28 03:26:25','2024-06-28 03:26:25'),(332,3,'D',8,'NULL','available','2024-06-28 03:26:28','2024-06-28 03:27:43'),(333,3,'D',9,'STANDARD','available','2024-06-28 03:26:34','2024-06-28 03:26:34'),(334,3,'D',10,'STANDARD','available','2024-06-28 03:26:52','2024-06-28 03:26:52'),(335,3,'D',11,'STANDARD','available','2024-06-28 03:26:54','2024-06-28 03:26:54'),(336,3,'D',12,'STANDARD','available','2024-06-28 03:26:55','2024-06-28 03:26:55'),(337,3,'E',12,'VIP','available','2024-06-28 03:27:03','2024-06-28 03:27:03'),(338,3,'E',11,'VIP','available','2024-06-28 03:27:04','2024-06-28 03:27:04'),(339,3,'E',10,'VIP','available','2024-06-28 03:27:05','2024-06-28 03:27:05'),(340,3,'E',9,'NULL','available','2024-06-28 03:27:06','2024-06-28 03:27:46'),(341,3,'E',8,'VIP','available','2024-06-28 03:27:08','2024-06-28 03:27:08'),(342,3,'E',7,'VIP','available','2024-06-28 03:27:09','2024-06-28 03:27:09'),(343,3,'E',6,'VIP','available','2024-06-28 03:27:10','2024-06-28 03:27:10'),(344,3,'E',5,'VIP','available','2024-06-28 03:27:12','2024-06-28 03:27:12'),(345,3,'E',4,'VIP','available','2024-06-28 03:27:13','2024-06-28 03:27:13'),(346,3,'E',3,'VIP','available','2024-06-28 03:27:15','2024-06-28 03:27:15'),(347,3,'E',2,'VIP','available','2024-06-28 03:27:17','2024-06-28 03:27:17');
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtimes`
--

DROP TABLE IF EXISTS `showtimes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtimes` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `movieId` bigint NOT NULL,
                             `screenId` bigint NOT NULL,
                             `showDate` date NOT NULL,
                             `showTime` time NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `movieId` (`movieId`),
                             KEY `screenId` (`screenId`),
                             CONSTRAINT `showtimes_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`),
                             CONSTRAINT `showtimes_ibfk_2` FOREIGN KEY (`screenId`) REFERENCES `screens` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtimes`
--

LOCK TABLES `showtimes` WRITE;
/*!40000 ALTER TABLE `showtimes` DISABLE KEYS */;
INSERT INTO `showtimes` VALUES (1,1,1,'2024-06-16','00:00:00'),(2,1,1,'2024-06-16','23:59:00'),(3,2,7,'2024-06-18','00:00:00'),(4,2,1,'2024-06-18','00:00:00'),(5,2,1,'2024-06-16','18:00:00'),(6,2,1,'2024-06-18','18:00:00'),(7,3,1,'2024-06-17','00:00:00'),(8,3,1,'2024-06-17','12:00:00'),(9,3,1,'2024-06-17','23:59:00'),(10,3,1,'2024-06-16','23:59:00'),(11,2,1,'2024-06-17','20:21:00'),(12,2,2,'2024-06-18','01:00:00'),(13,2,1,'2024-06-20','00:00:00'),(14,4,1,'2024-06-21','00:00:00'),(15,2,1,'2024-06-22','00:00:00'),(16,1,1,'2024-06-22','01:00:00'),(17,3,1,'2024-06-22','04:00:00'),(18,4,1,'2024-06-22','05:00:00'),(19,5,1,'2024-06-22','06:00:00'),(20,6,1,'2024-06-22','07:00:00'),(21,7,1,'2024-06-22','08:00:00'),(22,8,1,'2024-06-22','09:00:00'),(23,8,1,'2024-06-22','10:00:00'),(24,9,1,'2024-06-22','11:00:00'),(25,10,1,'2024-06-22','14:00:00'),(26,1,7,'2024-06-22','00:00:00'),(27,1,1,'2024-06-23','00:00:00'),(28,1,1,'2024-06-23','11:59:00'),(29,2,7,'2024-06-23','00:00:00'),(30,2,1,'2024-06-23','17:00:00'),(31,3,1,'2024-06-23','18:00:00'),(32,4,1,'2024-06-23','19:00:00'),(33,5,1,'2024-06-23','20:00:00'),(34,6,1,'2024-06-23','21:00:00'),(35,2,1,'2024-06-23','22:00:00'),(36,2,1,'2024-06-25','00:00:00'),(37,3,1,'2024-06-25','01:00:00'),(38,4,1,'2024-06-25','03:00:00'),(39,5,1,'2024-06-25','04:00:00'),(40,6,1,'2024-06-25','05:00:00'),(41,2,1,'2024-06-25','06:00:00'),(42,2,2,'2024-06-25','00:00:00'),(43,2,7,'2024-06-25','00:00:00'),(44,1,1,'2024-06-26','00:00:00'),(45,2,1,'2024-06-26','03:00:00'),(46,3,1,'2024-06-26','04:00:00'),(47,4,1,'2024-06-26','05:00:00'),(48,1,1,'2024-06-26','13:00:00'),(49,2,1,'2024-06-26','16:00:00'),(50,3,1,'2024-06-26','17:00:00'),(51,5,1,'2024-06-26','18:00:00'),(52,2,7,'2024-06-26','17:00:00'),(53,2,2,'2024-06-26','16:00:00'),(54,2,1,'2024-06-26','19:00:00'),(55,2,1,'2024-06-26','22:10:00'),(56,3,1,'2024-06-26','23:10:00'),(57,2,7,'2024-06-26','23:10:00'),(58,2,2,'2024-06-26','23:59:00'),(59,1,3,'2024-06-26','23:00:00'),(60,4,4,'2024-06-26','23:00:00'),(61,2,1,'2024-06-27','00:10:00'),(62,3,1,'2024-06-27','01:10:00'),(63,2,1,'2024-06-27','08:00:00'),(64,3,1,'2024-06-27','09:00:00'),(65,4,1,'2024-06-27','10:00:00'),(66,5,1,'2024-06-27','11:00:00'),(67,2,1,'2024-06-27','12:00:00'),(68,2,1,'2024-06-27','13:00:00'),(69,2,1,'2024-06-27','14:00:00'),(70,2,2,'2024-06-27','09:00:00'),(71,3,2,'2024-06-27','10:00:00'),(72,5,2,'2024-06-27','11:00:00'),(73,2,7,'2024-06-27','09:00:00'),(74,2,7,'2024-06-28','09:00:00'),(75,1,1,'2024-06-28','08:00:00'),(76,2,1,'2024-06-28','11:00:00'),(77,7,1,'2024-06-28','12:00:00'),(78,8,1,'2024-06-28','13:00:00'),(79,2,1,'2024-06-28','14:00:00'),(80,6,1,'2024-06-28','15:00:00'),(81,2,7,'2024-06-28','10:00:00'),(82,2,7,'2024-06-27','10:00:00'),(83,2,2,'2024-06-27','12:00:00'),(84,2,1,'2024-06-27','18:00:00'),(85,1,1,'2024-06-27','19:00:00'),(86,1,3,'2024-06-28','11:00:00'),(87,2,3,'2024-06-28','14:05:00'),(88,9,3,'2024-06-28','15:10:00'),(89,4,3,'2024-06-28','18:20:00'),(90,2,1,'2024-06-28','18:20:00'),(91,2,1,'2024-06-29','18:20:00');
/*!40000 ALTER TABLE `showtimes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `social_accounts`
--

DROP TABLE IF EXISTS `social_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `social_accounts` (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `provider` varchar(20) NOT NULL COMMENT 'Tên nhà social network',
                                   `providerId` varchar(50) NOT NULL,
                                   `email` varchar(150) NOT NULL COMMENT 'Email tài khoản',
                                   `name` varchar(100) NOT NULL COMMENT 'Tên người dùng',
                                   `userId` bigint DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `userId` (`userId`),
                                   CONSTRAINT `social_accounts_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `social_accounts`
--

LOCK TABLES `social_accounts` WRITE;
/*!40000 ALTER TABLE `social_accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `social_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theaters`
--

DROP TABLE IF EXISTS `theaters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theaters` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `location` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `image` text,
                            `phone` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `email` varchar(200) NOT NULL,
                            `description` text,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theaters`
--

LOCK TABLES `theaters` WRITE;
/*!40000 ALTER TABLE `theaters` DISABLE KEYS */;
INSERT INTO `theaters` VALUES (1,'NTP Cinema Mỹ Đình','Hà Nội, Mỹ Đình','7ea4701e-ade0-423a-8143-49785d971cc5_theater-ntp-2.jpg','19002080','ntpcineHNMD@gmail.com','Rạp chiếu phim Mỹ Đình, Hà Nội'),(2,'NTP Cinema Cầu Giấy','Hà Nội, Cầu Giấy','acc6acaf-395a-4c12-9a39-9677847f6e2b_theater-ntp-1.jpg','19002081','ntpcineHNCG@gmail.com','Rạp chiếu phim Cầu Giấy, Hà Nội'),(3,'NTP Cinema Tây Hồ','Tây Hồ, Hà Nội','727a374b-a3ea-4664-a2e9-106f616e6005_theater-ntp-4.jpg','19002082','ntpcineHNTH@gmail.com	','Rạp chiếu phim ở Tây Hồ Hà Nội'),(4,'NTP Cinema Hà Đông','Tây Mỗ, Hà Đông','f734009b-13ac-4c7b-8c11-1fa0c50883f9_theater-ntp-2.jpg','19002083','ntpcineHNHD@gmail.com	','Rạp chiếu phim ở Hà Đông'),(7,'NTP Cinema Long Biên','Long Biên, Hà Nội','2c28a931-e849-4ae3-874d-cee5fb9ce37f_logo-ntp-2.jpg','19002085','ntpcineHNLB@gmail.com	','Rạp chiếu tại Long Biên');
/*!40000 ALTER TABLE `theaters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `token` varchar(255) NOT NULL,
                          `tokenType` varchar(50) NOT NULL,
                          `expirationDate` datetime DEFAULT NULL,
                          `revoked` tinyint(1) NOT NULL,
                          `expired` tinyint(1) NOT NULL,
                          `userId` bigint DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `token` (`token`),
                          KEY `userId` (`userId`),
                          CONSTRAINT `tokens_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `roleId` bigint NOT NULL,
                         `userName` varchar(100) DEFAULT NULL,
                         `fullName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                         `password` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                         `email` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                         `image` text,
                         `createdAt` datetime DEFAULT NULL,
                         `updateAt` datetime DEFAULT NULL,
                         `faceBookAcountId` int DEFAULT NULL,
                         `googleAcountId` int DEFAULT NULL,
                         `status` varchar(100) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `unique_email` (`email`),
                         KEY `fk_user_roles` (`roleId`),
                         CONSTRAINT `fk_user_roles` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'phunt','Nguyễn Trọng Phú','$2a$10$s3D2ilX5/GTaGBHdwiVvYuESNY9Bjp4xgyTE.uYwZmF1fSiBsbGdW','test@gmail.com','','2024-06-16 00:00:00','2024-06-16 00:00:00',0,0,'ACTIVE'),(2,2,'thaont','Nguyễn Thanh Thảo','$2a$10$l6aZ9d2htc5zCXq8ay99ruWQTZv9IRRXbOeXXY8d6hMbWE5mumJKm','thaont@example.com','','2024-06-16 15:28:03','2024-06-16 15:28:03',0,0,'ACTIVE'),(3,3,'ngochn','Ngô Hồng Ngọc','$2a$10$l6aZ9d2htc5zCXq8ay99ruWQTZv9IRRXbOeXXY8d6hMbWE5mumJKm','ngochn@example.com','','2024-06-16 15:28:03','2024-06-16 15:28:03',0,0,'ACTIVE'),(4,2,'tamtt','Trần Minh Tâm','$2a$10$DnEjMQ7B7i8nnErUKXkTUu4iuYzV5Exep6vROw0xo8A7AyfCJq.TS','tamtt2004@gmail.com',NULL,'2024-06-25 00:00:00','2024-06-25 00:00:00',0,0,'ACTIVE'),(5,2,'test1','Nguyen Van Test','$2a$10$CNwN.15yAocd6XmH/76Ja.urWkmQMg1B7ycMnIdgsPVNlN7K3CQRq','test1@gmail.com',NULL,'2024-06-25 00:00:00','2024-06-25 00:00:00',0,0,'ACTIVE'),(7,2,'test123','Nguyễn Trọng Phú','$2a$10$sEvJ/P4TquIZjbcss3xq3uCr0qM2U3O4WMx3nCDLVtogM2p4dEMfq','test123@gmail.com',NULL,'2024-06-26 00:00:00','2024-06-26 00:00:00',0,0,'ACTIVE'),(8,2,'user1','Nguyễn User 1','$2a$10$LQPpvRnJhwxjdiW1I1npMeGeSUlvqkoCHG9EObE9QGy751pzbv7EO','user1@gmail.com',NULL,'2024-06-26 00:00:00','2024-06-26 00:00:00',0,0,'ACTIVE'),(12,2,'demo','Nguyễn Trọng Phú DEMO','$2a$10$YTAwApcPBlopSTVCDUu.VOGpi8qAYG9dtD1RN3.yduSmmusPqbnt6','demo@gmail.com',NULL,'2024-06-26 00:00:00','2024-06-26 00:00:00',0,0,'ACTIVE'),(17,2,'demo2','Nguyen Trong Phu','$2a$10$D2HAj/MDgjR8MIdSpqdHZOF5.s0.8QYgEwgWHrTVJf7ReSckUT//.','demo2@gmail.com',NULL,'2024-06-26 00:00:00','2024-06-26 00:00:00',0,0,'ACTIVE'),(19,2,'demo26','Nguyen Trong Phu','$2a$10$4D2om4YpwNhYmMnuXn8lBe6JgtQprn8C0l82sxWjE.j4HV1aoqUpe','demo26@gmail.com',NULL,'2024-06-26 00:00:00','2024-06-26 00:00:00',0,0,'ACTIVE'),(21,2,'demo27','Nguyen Trong Phu','$2a$10$d8OPWxzwcVSHSY9oIwGf3eN47ExtUK8/H4.Pa2DUQMaRQzjxpjZdm','demo27@gmail.com',NULL,'2024-06-27 00:00:00','2024-06-27 00:00:00',0,0,'ACTIVE'),(24,2,'trongphu','Nguyen Trong Phu','$2a$10$2/WAWgUwPIx5zQ267wLLG.0O/L1FVjehCNiXI62.UJ7BsUKFAuTru','ntpdth2004@gmail.com',NULL,'2024-06-27 00:00:00','2024-06-27 00:00:00',0,0,'ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-30 13:04:52
