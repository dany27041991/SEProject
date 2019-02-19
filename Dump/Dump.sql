-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: se_database
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Activity`
--

DROP TABLE IF EXISTS `Activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `study_course` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `activity_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Activity_Professor_id_fk` (`id_prof`),
  KEY `Activity_Subject_id_fk_idx` (`activity_type`),
  KEY `Activity_Study_course_id_fk_idx` (`study_course`),
  KEY `Activity_Subject_id_fk_idx1` (`subject`),
  CONSTRAINT `Acitivity_type_id_fk` FOREIGN KEY (`activity_type`) REFERENCES `Activity_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Activity_Professor_id_fk` FOREIGN KEY (`id_prof`) REFERENCES `Professor` (`id`),
  CONSTRAINT `Activity_Study_course_id_fk` FOREIGN KEY (`study_course`) REFERENCES `Study_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Activity_Subject_id_fk` FOREIGN KEY (`subject`) REFERENCES `Subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activity`
--

LOCK TABLES `Activity` WRITE;
/*!40000 ALTER TABLE `Activity` DISABLE KEYS */;
INSERT INTO `Activity` VALUES (8,8,14,44,'2019-02-17 23:33:30','2019-02-18 23:33:31',1),(9,8,14,44,'2019-02-17 23:35:09','2019-02-18 00:35:13',2),(10,9,15,47,'2019-02-18 10:10:27','2019-02-18 13:10:28',1),(11,9,15,47,'2019-02-18 16:11:11','2019-02-18 21:11:16',2);
/*!40000 ALTER TABLE `Activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Activity_type`
--

DROP TABLE IF EXISTS `Activity_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activity_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activity_type`
--

LOCK TABLES `Activity_type` WRITE;
/*!40000 ALTER TABLE `Activity_type` DISABLE KEYS */;
INSERT INTO `Activity_type` VALUES (1,'Lesson'),(2,'Exam');
/*!40000 ALTER TABLE `Activity_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Attend_lesson`
--

DROP TABLE IF EXISTS `Attend_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attend_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback` int(11) NOT NULL,
  `id_lesson` int(11) NOT NULL,
  `badge_student` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Attend_lesson_Lesson_id_fk` (`id_lesson`),
  KEY `Attend_lesson_Student_id_fk` (`badge_student`),
  CONSTRAINT `Attend_lesson_Lesson_id_fk` FOREIGN KEY (`id_lesson`) REFERENCES `Lesson` (`id`),
  CONSTRAINT `Attend_lesson_Student_id_fk` FOREIGN KEY (`badge_student`) REFERENCES `Student` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attend_lesson`
--

LOCK TABLES `Attend_lesson` WRITE;
/*!40000 ALTER TABLE `Attend_lesson` DISABLE KEYS */;
INSERT INTO `Attend_lesson` VALUES (4,5,8,16),(5,4,10,48),(6,5,10,34);
/*!40000 ALTER TABLE `Attend_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Carryout_activity`
--

DROP TABLE IF EXISTS `Carryout_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carryout_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_activity` int(11) NOT NULL,
  `classroom_name` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Carryout_activity_Activity_id_fk_idx` (`id_activity`),
  KEY `Carryout_activity_Classroom_id_fk_idx` (`classroom_name`),
  CONSTRAINT `Carryout_activity_Activity_id_fk` FOREIGN KEY (`id_activity`) REFERENCES `Activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Carryout_activity_Classroom_id_fk` FOREIGN KEY (`classroom_name`) REFERENCES `Classroom` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carryout_activity`
--

LOCK TABLES `Carryout_activity` WRITE;
/*!40000 ALTER TABLE `Carryout_activity` DISABLE KEYS */;
INSERT INTO `Carryout_activity` VALUES (6,8,4),(7,9,5),(8,10,4),(9,11,5);
/*!40000 ALTER TABLE `Carryout_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Classroom`
--

DROP TABLE IF EXISTS `Classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `latitude` decimal(9,6) NOT NULL,
  `longitude` decimal(9,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Classroom`
--

LOCK TABLES `Classroom` WRITE;
/*!40000 ALTER TABLE `Classroom` DISABLE KEYS */;
INSERT INTO `Classroom` VALUES (1,'C1',53.125478,-6.854123),(2,'C2',53.365214,-6.325418),(3,'C3',53.149658,-6.654525),(4,'H1',53.475236,-6.898748),(5,'H2',53.136479,-6.125236),(6,'H3',53.325478,-6.478551),(7,'H4',40.810002,15.925296),(8,'C4',53.272707,-6.666497);
/*!40000 ALTER TABLE `Classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Download_teaching_material`
--

DROP TABLE IF EXISTS `Download_teaching_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Download_teaching_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_student` int(11) NOT NULL,
  `badge_student` int(11) NOT NULL,
  `id_teaching_material` int(11) NOT NULL,
  `note` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Download_teaching_material_Student_id_fk` (`badge_student`),
  KEY `Download_teaching_material_Teaching_materia_id_fk_idx` (`id_teaching_material`),
  CONSTRAINT `Download_teaching_material_Student_id_fk` FOREIGN KEY (`badge_student`) REFERENCES `Student` (`id`),
  CONSTRAINT `Download_teaching_material_Teaching_materia_id_fk` FOREIGN KEY (`id_teaching_material`) REFERENCES `Teaching_material` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Download_teaching_material`
--

LOCK TABLES `Download_teaching_material` WRITE;
/*!40000 ALTER TABLE `Download_teaching_material` DISABLE KEYS */;
INSERT INTO `Download_teaching_material` VALUES (3,4,16,1,'Good Material'),(4,5,16,2,'Great!'),(5,3,16,3,'Nice!'),(6,1,16,4,'Bad'),(7,5,16,8,'Perfect!'),(8,4,20,12,'Good Material!'),(9,5,34,15,'Perfect Material!');
/*!40000 ALTER TABLE `Download_teaching_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exam`
--

DROP TABLE IF EXISTS `Exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exam` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Exam__Activity_id_fk` FOREIGN KEY (`id`) REFERENCES `Activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exam`
--

LOCK TABLES `Exam` WRITE;
/*!40000 ALTER TABLE `Exam` DISABLE KEYS */;
INSERT INTO `Exam` VALUES (9),(11);
/*!40000 ALTER TABLE `Exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Faculty`
--

DROP TABLE IF EXISTS `Faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty`
--

LOCK TABLES `Faculty` WRITE;
/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT INTO `Faculty` VALUES (1,'Engineering'),(2,'Medicine'),(3,'Letters');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lesson`
--

DROP TABLE IF EXISTS `Lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lesson` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Lesson__Activity_id_fk` FOREIGN KEY (`id`) REFERENCES `Activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lesson`
--

LOCK TABLES `Lesson` WRITE;
/*!40000 ALTER TABLE `Lesson` DISABLE KEYS */;
INSERT INTO `Lesson` VALUES (8),(10);
/*!40000 ALTER TABLE `Lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `person_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `Person_Person_type_id_fk_idx` (`person_type`),
  CONSTRAINT `Person_Person_type_id_fk` FOREIGN KEY (`person_type`) REFERENCES `Person_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'secretary1@sec.com','secretary1',1),(2,'secretary2@sec.com','secretary2',1),(3,'secretary3@sec.com','secretary3',1),(4,'elliot.alderson@prof.com','professor1',2),(5,'tyrell.wellick@prof.com','professor2',2),(6,'angela.moss@prof.com','professor3',2),(7,'darlene.alderson@prof.com','professor4',2),(8,'alex.karev@prof.com','professor5',2),(9,'arizona.robbins@prof.com','professor6',2),(10,'atticus.lincoln@prof.com','professor7',2),(11,'nico.kim@prof.com','professor8',2),(12,'dean.winchester@prof.com','professor9',2),(13,'sam.winchester@prof.com','professor10',2),(14,'calliope.torres@prof.com','professor11',2),(15,'april.kepner@prof.com','professor12',2),(16,'hilary.pensive@student.com','student1',3),(17,'daniel.youngful@student.com','student2',3),(18,'ilary.lorentz@student.com','student3',3),(19,'jacob.nicolav@student.com','student4',3),(20,'emma.defenders@student.com','student5',3),(21,'robbie.strafellen@student.com','student6',3),(22,'kate.hardmountain@student.com','student7',3),(23,'fanny.wolf@student.com','student8',3),(24,'andrew.chalet@student.com','student9',3),(25,'luke.walls@student.com','student10',3),(26,'salvador.raven@student.com','student11',3),(27,'simon.flea@student.com','student12',3),(28,'mary.meow@student.com','student13',3),(29,'nikola.fingers@student.com','student14',3),(30,'alexis.turner@student.com','student15',3),(31,'dory.palmas@student.com','student16',3),(32,'sarah.lindt@student.com','student17',3),(33,'edward.advanced@student.com','student18',3),(34,'matthew.gothere@student.com','student19',3),(35,'gabriel.sunset@student.com','student20',3),(36,'valentine.sony@student.com','student21',3),(37,'andreas.ofjack@student.com','student22',3),(38,'glory.bigfoot@student.com','student23',3),(39,'hakan.calhanoglu@student.com','student24',3),(44,'albert.cool@prof.com','professor13',2),(45,'danilo.giovannico@student.com','student25',3),(46,'ilaria.malinconico@student.com','student26',3),(47,'raven.reyes@prof.com','professor14',2),(48,'john.murphy@student.com','student27',3);
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person_type`
--

DROP TABLE IF EXISTS `Person_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person_type`
--

LOCK TABLES `Person_type` WRITE;
/*!40000 ALTER TABLE `Person_type` DISABLE KEYS */;
INSERT INTO `Person_type` VALUES (1,'Secretary'),(2,'Professor'),(3,'Student');
/*!40000 ALTER TABLE `Person_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Professor` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `biography` longtext,
  `reception_time` varchar(255) NOT NULL,
  `subject` int(11) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Professor_Subject_id_fk_idx` (`subject`),
  CONSTRAINT `Professor_Person_id_fk` FOREIGN KEY (`id`) REFERENCES `Person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Professor_Subject_id_fk` FOREIGN KEY (`subject`) REFERENCES `Subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Professor`
--

LOCK TABLES `Professor` WRITE;
/*!40000 ALTER TABLE `Professor` DISABLE KEYS */;
INSERT INTO `Professor` VALUES (4,'Elliot','Alderson','mr. robot','wed. 10 - 12',1,'1994-03-09'),(5,'Tyrell','Wellick','mr. robot','fri. 9 - 10',2,'1994-03-11'),(6,'Angela','Moss','mr. robot','mon. 7 - 8',3,'1994-05-09'),(7,'Darlene','Alderson','mr. robot','tue. 13 - 14',4,'1994-11-09'),(8,'Alex','Karev','grey\'s anatomy','thu. 14 - 15',5,'1994-01-19'),(9,'Arizona','Robbins','grey\'s anatomy','mon. 9 - 11',6,'1994-03-29'),(10,'Atticus','Lincoln','grey\'s anatomy','sat. 21 - 22',7,'1991-03-09'),(11,'Nico','Kim','grey\'s anatomy','sun. 22 - 23',8,'1996-03-09'),(12,'Dean','Winchester','supernatural','sat. 6 - 8',9,'1954-03-09'),(13,'Sam','Winchester','supernatural','sun. 7 - 9',10,'1994-03-01'),(14,'Calliope','Torres','grey\'s anatomy','fri. 13 - 15',11,'1954-03-19'),(15,'April','Kepner','grey\'s anatomy','tue. 15 - 17',12,'1999-06-09'),(44,'Albert','Cool','Empty','Empty',14,'2019-02-20'),(47,'Raven','Reyes','The 100','wed. 11-12',15,'1974-11-29');
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reporting`
--

DROP TABLE IF EXISTS `Reporting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reporting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `note_prof` text NOT NULL,
  `support_material_prof` int(11) NOT NULL,
  `note_sec` text,
  `state` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `id_secretary` int(11) DEFAULT NULL,
  `id_classroom` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Reporting_Id-prof_fk_idx` (`id_prof`),
  KEY `Reporting_Id_secretary_fk_idx` (`id_secretary`),
  KEY `Reporting_Classroom_id_fk_idx` (`id_classroom`),
  KEY `Reporting_State_id_fk_idx` (`state`),
  KEY `Reporting_Support_material_id_fk_idx` (`support_material_prof`),
  CONSTRAINT `Reporting_Classroom_id_fk` FOREIGN KEY (`id_classroom`) REFERENCES `Classroom` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Reporting_Id-prof_fk` FOREIGN KEY (`id_prof`) REFERENCES `Professor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Reporting_State_id_fk` FOREIGN KEY (`state`) REFERENCES `State` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Reporting_Support_material_id_fk` FOREIGN KEY (`support_material_prof`) REFERENCES `Support_material` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reporting`
--

LOCK TABLES `Reporting` WRITE;
/*!40000 ALTER TABLE `Reporting` DISABLE KEYS */;
INSERT INTO `Reporting` VALUES (1,'Projector Break!',2,'Proojector Fixed!',3,4,1,1),(2,'The air conditioning does not work',3,NULL,2,4,NULL,5),(3,'The whiteboard does not work!',4,'Fixed!',3,4,1,6),(4,'The projector doesn\'t work!',2,NULL,4,4,NULL,3),(5,'Video projector does not work!',2,NULL,1,4,NULL,6),(6,'The Electronic Whiteboard does not work!',4,'Fixed!',3,13,1,5),(7,'Projector doesn\'t work!',2,NULL,1,4,NULL,5),(8,'Air doesn\'t work!',3,'In progress',2,4,1,3),(9,'Projector does not work!',2,'Too much time to solve this!',4,11,1,5);
/*!40000 ALTER TABLE `Reporting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Secretary`
--

DROP TABLE IF EXISTS `Secretary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Secretary` (
  `id` int(11) NOT NULL,
  `faculty` int(11) NOT NULL,
  `venue` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Secretary_Faculty_id_fk_idx` (`faculty`),
  CONSTRAINT `Secretary_Faculty_id_fk` FOREIGN KEY (`faculty`) REFERENCES `Faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Secretary_Person_id_fk` FOREIGN KEY (`id`) REFERENCES `Person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Secretary`
--

LOCK TABLES `Secretary` WRITE;
/*!40000 ALTER TABLE `Secretary` DISABLE KEYS */;
INSERT INTO `Secretary` VALUES (1,1,'25 Galtymore Road, Dublin, Eire, D10'),(2,2,'45 All Saints Road, Dublin, Eire, D12'),(3,3,'7 Mary Street Little, Dublin, Eire, D01');
/*!40000 ALTER TABLE `Secretary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `State`
--

DROP TABLE IF EXISTS `State`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `State` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `State`
--

LOCK TABLES `State` WRITE;
/*!40000 ALTER TABLE `State` DISABLE KEYS */;
INSERT INTO `State` VALUES (1,'Taken in'),(2,'In progress'),(3,'Resolved'),(4,'Refused');
/*!40000 ALTER TABLE `State` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `badge_number` int(11) NOT NULL AUTO_INCREMENT,
  `study_course` int(11) NOT NULL,
  `enrollment_year` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Student_badge_number_uindex` (`badge_number`),
  KEY `Student_Study_course_id_fk_idx` (`study_course`),
  CONSTRAINT `Student_Person_id_fk` FOREIGN KEY (`id`) REFERENCES `Person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Student_Study_course_id_fk` FOREIGN KEY (`study_course`) REFERENCES `Study_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10028 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (16,'Hilary','Pensive','1994-04-11',10001,1,'2010-01-29'),(17,'Daniel','Youngful','1991-04-27',10002,1,'2010-01-29'),(18,'Ilary','Lorentz','1994-03-09',10003,2,'2010-01-29'),(19,'Jacob','Nicolav','1994-05-05',10004,2,'2010-01-29'),(20,'Emma','Defenders','1994-02-23',10005,3,'2010-01-29'),(21,'Robbie','Strafellen','1994-05-20',10006,3,'2010-01-29'),(22,'Kate','Hardmountain','1995-01-25',10007,4,'2010-01-29'),(23,'Fanny','Wolf','1993-10-16',10008,4,'2010-01-29'),(24,'Andrew','Chalet','1995-07-23',10009,5,'2010-01-29'),(25,'Luke','Walls','1992-08-19',10010,5,'2010-01-29'),(26,'Salvador','Raven','1988-12-15',10011,6,'2010-01-29'),(27,'Simon','Flea','1954-11-23',10012,6,'2010-01-29'),(28,'Mary','Meow','1978-06-21',10013,1,'2016-01-18'),(29,'Nikola','Fingers','1983-10-05',10014,1,'2016-01-18'),(30,'Alexis','Turner','1997-01-31',10015,2,'2016-01-18'),(31,'Dory','Palmas','1984-03-25',10016,2,'2016-01-18'),(32,'Sarah','Lindt','1978-02-20',10017,3,'2016-01-18'),(33,'Edward','Advanced','1967-09-09',10018,3,'2016-01-18'),(34,'Matthew','Gothere','1981-05-15',10019,4,'2016-01-18'),(35,'Gabriel','Sunset','1981-10-14',10020,4,'2016-01-18'),(36,'Valentine','Sony','1979-01-10',10021,5,'2016-01-18'),(37,'Andreas','Ofjack','1983-01-23',10022,5,'2016-01-18'),(38,'Glory','Bigfoot','1981-07-14',10023,6,'2016-01-18'),(39,'Hakan','Calhanoglu','1994-01-06',10024,6,'2016-01-18'),(45,'Danilo','Giovannico','2019-02-01',10025,7,'2018-08-03'),(46,'Ilaria','Malinconico','1994-01-06',10026,8,'2016-01-18'),(48,'John','Murphy','1998-08-28',10027,9,'2017-02-20');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Study_course`
--

DROP TABLE IF EXISTS `Study_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Study_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `faculty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Study_course_Faculty_id_fk_idx` (`faculty`),
  CONSTRAINT `Study_course_Faculty_id_fk` FOREIGN KEY (`faculty`) REFERENCES `Faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Study_course`
--

LOCK TABLES `Study_course` WRITE;
/*!40000 ALTER TABLE `Study_course` DISABLE KEYS */;
INSERT INTO `Study_course` VALUES (1,'Computer Engineering',1),(2,'Communication Engineering',1),(3,'Pediatrics',2),(4,'Orthopedics',2),(5,'Modern Letters',3),(6,'Classic Letters',3),(7,'Civil Engineering',1),(8,'Material Engineering',1),(9,'Aerospace Engineering',1);
/*!40000 ALTER TABLE `Study_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `study_course` int(11) NOT NULL,
  `year_course` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Subject_Study_course_id_fk_idx` (`study_course`),
  CONSTRAINT `Subject_Study_course_id_fk` FOREIGN KEY (`study_course`) REFERENCES `Study_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES (1,'Software Engineering',1,1),(2,'Database',1,2),(3,'Microwaves',2,1),(4,'Microelectronics Design',2,2),(5,'General Pediatrics',3,1),(6,'Neonatology',3,2),(7,'Rheumatology',4,1),(8,'Pediatric Orthopedics',4,2),(9,'Philology',5,1),(10,'General Linguistics',5,2),(11,'Latin Literature',6,1),(12,'Papyrology',6,2),(13,'ACT',1,2),(14,'Materials',8,1),(15,'Aerodynamics',9,1),(16,'Aerospace Propulsion',9,1);
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Support_material`
--

DROP TABLE IF EXISTS `Support_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Support_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Support_material`
--

LOCK TABLES `Support_material` WRITE;
/*!40000 ALTER TABLE `Support_material` DISABLE KEYS */;
INSERT INTO `Support_material` VALUES (1,'Wifi'),(2,'Video projector'),(3,'Air conditioning'),(4,'Electronic whiteboard');
/*!40000 ALTER TABLE `Support_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teaching_material`
--

DROP TABLE IF EXISTS `Teaching_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teaching_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` int(11) NOT NULL,
  `media` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Teaching_material_Subject_id_fk_idx` (`subject`),
  CONSTRAINT `Teaching_material_Subject_id_fk` FOREIGN KEY (`subject`) REFERENCES `Subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teaching_material`
--

LOCK TABLES `Teaching_material` WRITE;
/*!40000 ALTER TABLE `Teaching_material` DISABLE KEYS */;
INSERT INTO `Teaching_material` VALUES (1,1,'http://localhost:8090/files/4/Mello18.pdf'),(2,1,'http://localhost:8090/files/4/children-cat-playing-photography-2__880.jpg'),(3,1,'http://localhost:8090/files/4/Schermata 2019-01-31 alle 09.54.33.png'),(4,1,'http://localhost:8090/files/4/65c19f7b-d35c-4d74-8de6-bc78a8738c7eMello18.pdf'),(5,1,'http://localhost:8090/files/4/children-cat-playing-photography-2__880.jpg'),(7,2,'http://localhost:8090/files/5/travel-english-it.pdf'),(8,2,'http://localhost:8090/files/5/eserciziario_java.pdf'),(9,10,'http://localhost:8090/files/13/travel-english-it.pdf'),(12,6,'http://localhost:8090/files/9/travel-english-it.pdf'),(13,1,'http://localhost:8090/files/4/CV Danilo Giovannico.pdf'),(14,1,'http://localhost:8090/files/4/OO__JAVA5.pdf'),(15,8,'http://localhost:8090/files/11/travel-english-it.pdf');
/*!40000 ALTER TABLE `Teaching_material` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-19 14:27:53
