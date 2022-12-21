-- MySQL Script generated by MySQL Workbench
-- Thu Feb  3 15:58:15 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema timetable
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema timetable
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `timetable` DEFAULT CHARACTER SET utf8 ;
USE `timetable` ;

-- -----------------------------------------------------
-- Table `timetable`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `post` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusers`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `timetable`.`event`(
    `data_event` VARCHAR(45) NOT NULL,
    `event` VARCHAR(255) NOT NULL,
    `place` VARCHAR(45) NOT NULL,
    `idevent`INT NOT NULL AUTO_INCREMENT,
   PRIMARY KEY (`idevent`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
