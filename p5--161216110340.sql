/*
MySQL Backup
Source Server Version: 5.7.9
Source Database: p5
Date: пт, 16.12.2016 11:03:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`,`email`,`login`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `books` VALUES ('1','111','Titl1','Auth1'), ('2','222','When Dark times comes...','Nasty Field'), ('3','333','Fuck Oh Yeah!','James Hetfield'), ('4','444','Curly Wah','Kirk Hammet'), ('5','555','How To Be a Poser Shit','Lars Ulrich'), ('6','667','Is There Life After Coco Palm?','Rob Trujillo'), ('7','771','Brand New Book','Samuel L. Jackson'), ('8','772','Hallo On Fire','Metallica'), ('9','773','Murder One','Frankenstein'), ('10','774','Last Track','Band1'), ('11','775','Bastards on the Go','Some Unknown One....'), ('12','776','Void','Sep'), ('13','777','Holy Sand','QWE');
INSERT INTO `users` VALUES ('1','login1','a@a.a','123','USER','1','login1','login1'), ('2','login2','b@b.b','123','ADMIN','1','login2','login2');
