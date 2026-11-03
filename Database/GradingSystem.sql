/*
SQLyog Community v9.30 
MySQL - 5.6.25-log : Database - gradingsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gradingsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gradingsystem`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `CREADIT_NUMBER` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`CREADIT_NUMBER`,`DESCRIPTION`,`NAME`) values (1,NULL,NULL,NULL,NULL,6,'sdbsdbcisdbvibw,edvcuwveucvweuvc','MCA'),(2,NULL,NULL,NULL,NULL,5,'wefvwrevhiswgrfvirw,dscbuwgefiucw','BCA');

/*Table structure for table `course_to_student` */

DROP TABLE IF EXISTS `course_to_student`;

CREATE TABLE `course_to_student` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  `COURSE_NAME` varchar(225) DEFAULT NULL,
  `STUDENT_ID` bigint(20) DEFAULT NULL,
  `STUDENT_NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `course_to_student` */

insert  into `course_to_student`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`COURSE_ID`,`COURSE_NAME`,`STUDENT_ID`,`STUDENT_NAME`) values (1,NULL,NULL,NULL,NULL,1,'MCA',1,'Avye Moon'),(2,NULL,NULL,NULL,NULL,2,'BCA',2,'Sydney Wood');

/*Table structure for table `course_to_teacher` */

DROP TABLE IF EXISTS `course_to_teacher`;

CREATE TABLE `course_to_teacher` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  `COURSE_NAME` varchar(225) DEFAULT NULL,
  `TEACHER_ID` bigint(20) DEFAULT NULL,
  `TEACHER_NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `course_to_teacher` */

insert  into `course_to_teacher`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`COURSE_ID`,`COURSE_NAME`,`TEACHER_ID`,`TEACHER_NAME`) values (1,NULL,NULL,NULL,NULL,1,'MCA',1,'Samantha Mcleod'),(2,NULL,NULL,NULL,NULL,2,'BCA',2,'Cole Burch');

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `location` */

insert  into `location`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`NAME`) values (1,NULL,NULL,NULL,NULL,'Indore');

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `AMOUNT` bigint(20) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `STUDENT_ID` bigint(20) DEFAULT NULL,
  `STUDENT_NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `payment` */

insert  into `payment`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`AMOUNT`,`DATE`,`STUDENT_ID`,`STUDENT_NAME`) values (1,NULL,NULL,NULL,NULL,20000,'2020-12-30',1,'Avye Moon'),(2,NULL,NULL,NULL,NULL,3000,'2020-12-30',2,'Sydney Wood');

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  `COURSE_NAME` varchar(225) DEFAULT NULL,
  `MARK` bigint(20) DEFAULT NULL,
  `SESSION_NO` bigint(20) DEFAULT NULL,
  `STUDENT_ID` bigint(20) DEFAULT NULL,
  `STUDENT_NAME` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `COURSE_ID` (`COURSE_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `result` */

insert  into `result`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`COURSE_ID`,`COURSE_NAME`,`MARK`,`SESSION_NO`,`STUDENT_ID`,`STUDENT_NAME`) values (1,NULL,NULL,NULL,NULL,1,'MCA',3,101,1,'Avye Moon'),(2,NULL,NULL,NULL,NULL,2,'BCA',6,102,2,'Sydney Wood');

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  `COURSE_NAME` varchar(225) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `END_HOUR` varchar(225) DEFAULT NULL,
  `END_MINUTE` varchar(225) DEFAULT NULL,
  `LOCATION_ID` bigint(20) DEFAULT NULL,
  `LOCATION_NAME` varchar(225) DEFAULT NULL,
  `START_HOUR` varchar(225) DEFAULT NULL,
  `START_MINUTE` varchar(225) DEFAULT NULL,
  `ENTRY_AMOUNT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `COURSE_ID` (`COURSE_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `schedule` */

insert  into `schedule`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`COURSE_ID`,`COURSE_NAME`,`DATE`,`END_HOUR`,`END_MINUTE`,`LOCATION_ID`,`LOCATION_NAME`,`START_HOUR`,`START_MINUTE`,`ENTRY_AMOUNT`) values (1,NULL,NULL,NULL,NULL,1,'MCA','2020-12-31','4','25',1,'Indore','2','25',500),(2,NULL,NULL,NULL,NULL,2,'BCA','2021-01-02','4','25',1,'Indore','2','25',600);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `CITY` varchar(225) DEFAULT NULL,
  `COUNTRY` varchar(225) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `EMAIL_ID` varchar(225) DEFAULT NULL,
  `FAX` varchar(225) DEFAULT NULL,
  `FIRST_NAME` varchar(225) DEFAULT NULL,
  `GENDER` varchar(225) DEFAULT NULL,
  `LAST_NAME` varchar(225) DEFAULT NULL,
  `ORGANIZATION` varchar(225) DEFAULT NULL,
  `STATE` varchar(225) DEFAULT NULL,
  `TELEPHONE` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`CITY`,`COUNTRY`,`DOB`,`EMAIL_ID`,`FAX`,`FIRST_NAME`,`GENDER`,`LAST_NAME`,`ORGANIZATION`,`STATE`,`TELEPHONE`) values (1,NULL,NULL,NULL,NULL,'Rerum ','Nobis ','1997-06-10','zirusizoro@mailinator.com','854565','Avye','Female','Moon','Gomez and Mueller Trading','Illo ','9685456585'),(2,NULL,NULL,NULL,NULL,'Doloribus','Rem','1998-08-25','lubaz@mailinator.com','96854','Sydney','Male','Wood','Stout Fox Plc','Magna','9685456585');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `ADDRESS` varchar(225) DEFAULT NULL,
  `CITY` varchar(225) DEFAULT NULL,
  `COUNTRY` varchar(225) DEFAULT NULL,
  `EMAIL_ID` varchar(225) DEFAULT NULL,
  `FIRST_NAME` varchar(225) DEFAULT NULL,
  `LAST_NAME` varchar(225) DEFAULT NULL,
  `PHONE_NO` varchar(225) DEFAULT NULL,
  `SALARY` bigint(20) DEFAULT NULL,
  `STATE` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`ADDRESS`,`CITY`,`COUNTRY`,`EMAIL_ID`,`FIRST_NAME`,`LAST_NAME`,`PHONE_NO`,`SALARY`,`STATE`) values (1,NULL,NULL,NULL,NULL,'Suscipit nisi laudan','Sed','Dolor','cytixehaq@mailinator.com','Samantha','Mcleod','9685456585',25000,'Est'),(2,NULL,NULL,NULL,NULL,'Sed aute nisi enim c','Illo','Nesciunt','facenuwofy@mailinator.com','Cole','Burch','9685452535',20000,'Molestias');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `FIRST_NAME` varchar(225) DEFAULT NULL,
  `GENDER` varchar(225) DEFAULT NULL,
  `LAST_NAME` varchar(225) DEFAULT NULL,
  `LOGIN` varchar(225) DEFAULT NULL,
  `MOBILE_NO` varchar(225) DEFAULT NULL,
  `PASSWORD` varchar(225) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`Id`,`CREATED_BY`,`CREATED_DATETIME`,`MODIFIED_BY`,`MODIFIED_DATETIME`,`FIRST_NAME`,`GENDER`,`LAST_NAME`,`LOGIN`,`MOBILE_NO`,`PASSWORD`,`ROLE_ID`) values (1,'root','2020-12-26 11:00:55','root','2020-12-26 11:01:01','Admin','Male','Admin','Admin@gmail.com','9685456586','Admin@321',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
