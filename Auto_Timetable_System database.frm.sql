drop table login,student,subjectdetails,moduledetails,schedule;

CREATE TABLE `login` (
`S_id` int unsigned NOT NULL AUTO_INCREMENT,
`Email_id` varchar(80) NOT NULL,
`Password` varchar(50) NOT NULL,
PRIMARY KEY (`S_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `login` AUTO_INCREMENT=100;

CREATE TABLE `student` (
`S_id` int unsigned NOT NULL,
`First_name` varchar(30) NOT NULL,
`Last_name` varchar(30) NOT NULL,
`College_name` varchar(80) NOT NULL,
`Contact` varchar(45) NOT NULL,
FOREIGN KEY (`S_id`) REFERENCES `login` (`S_id`)
	ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subjectdetails` (
`S_id` int unsigned NOT NULL,
`Sub_id` int unsigned NOT NULL AUTO_INCREMENT,
`Sub_name` varchar(50) NOT NULL,
`No_of_Modules` int NOT NULL,
`Preference` decimal(7,6) DEFAULT '0',
PRIMARY KEY (`Sub_id`),
FOREIGN KEY (`S_id`) REFERENCES `login` (`S_id`)
	ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `subjectdetails` AUTO_INCREMENT=10;

CREATE TABLE `moduledetails` (
`S_id` int unsigned NOT NULL,
`Sub_id` int unsigned NOT NULL,
`M_id` int unsigned NOT NULL AUTO_INCREMENT,
`Module_name` varchar(80) NOT NULL,
`No_of_Hours` int NOT NULL,
`Hours_Remaining` int NOT NULL, 
PRIMARY KEY (`M_id`),
FOREIGN KEY (`S_id`) REFERENCES `login` (`S_id`)
	ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (`Sub_id`) REFERENCES `subjectdetails` (`Sub_id`)
	ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Schedule` (
`S_id` int unsigned NOT NULL,
`Timetable` blob,
FOREIGN KEY (`S_id`) REFERENCES `login` (`S_id`)
	ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;