
USE ilearn;

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
    `ID` int NOT NULL AUTO_INCREMENT,
    `Title` varchar(255) NOT NULL,
    `Location` varchar(255) NOT NULL,
    `Instructor` varchar(255) NOT NULL,
    `Capacity` int DEFAULT 0 NOT NULL,
    `Term` varchar(255) NOT NULL,
    PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Fname` varchar(255) NOT NULL,
  `Lname` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Super` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
);

INSERT INTO `users` (`Fname`, `Lname`, `Address`, `Email`, `Phone`, `Password`, `Super`) VALUES
('Admin', 'Admin', "Place", 'admin@elearning.edu', "555-555-5555", '123456', 1),
('Student', 'Student', "Somewhere", 'student@eleanring.edu', "555-555-5553", '123456', 0);

INSERT INTO `classes`(`Title`, `Location`, `Instructor`, `Capacity`, `Term`) VALUES
("Science", "Place", "some guy", 5, "Spring"),
("Business", "Here", "Beevis", 4, "Fall");