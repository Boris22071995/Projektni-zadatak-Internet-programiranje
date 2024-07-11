-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitnesIp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitnesIp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnesIp` DEFAULT CHARACTER SET utf8 ;
USE `fitnesIp` ;

-- -----------------------------------------------------
-- Table `fitnesIp`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`instructor` (
  `idinstructor` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `expirience` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idinstructor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`category` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`program` (
  `idProgram` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `price` DOUBLE NOT NULL,
  `intensityLevel` VARCHAR(20) NOT NULL,
  `duration` INT NOT NULL,
  `contactPerson` VARCHAR(45) NOT NULL,
  `picture` VARCHAR(250) NOT NULL,
  `locationName` VARCHAR(45) NOT NULL,
  `locationAdress` VARCHAR(45) NOT NULL,
  `instructorIdinstructor` INT NOT NULL,
  `categoryIdCategory` INT NOT NULL,
  PRIMARY KEY (`idProgram`),
  INDEX `fk_program_instructor1_idx` (`instructorIdinstructor` ASC) VISIBLE,
  INDEX `fk_program_category1_idx` (`categoryIdCategory` ASC) VISIBLE,
  CONSTRAINT `fk_program_instructor1`
    FOREIGN KEY (`instructorIdinstructor`)
    REFERENCES `fitnesIp`.`instructor` (`idinstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_category1`
    FOREIGN KEY (`categoryIdCategory`)
    REFERENCES `fitnesIp`.`category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `isActivated` TINYINT NOT NULL,
  `programIdProgram` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_user_program1_idx` (`programIdProgram` ASC) VISIBLE,
  CONSTRAINT `fk_user_program1`
    FOREIGN KEY (`programIdProgram`)
    REFERENCES `fitnesIp`.`program` (`idProgram`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`userAvatar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`userAvatar` (
  `iduserAvatar` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(250) NOT NULL,
  `useridUser` INT NOT NULL,
  PRIMARY KEY (`iduserAvatar`),
  INDEX `fk_userAvatar_user_idx` (`useridUser` ASC) VISIBLE,
  CONSTRAINT `fk_userAvatar_user`
    FOREIGN KEY (`useridUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`message` (
  `idMessage` INT NOT NULL AUTO_INCREMENT,
  `textMessage` VARCHAR(250) NOT NULL,
  `dateAndTime` DATETIME NOT NULL,
  `isRead` TINYINT NOT NULL,
  `reciver` VARCHAR(45) NOT NULL,
  `useridUser` INT NOT NULL,
  PRIMARY KEY (`idMessage`),
  INDEX `fk_message_user1_idx` (`useridUser` ASC) VISIBLE,
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`useridUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`diary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`diary` (
  `idDiary` INT NOT NULL AUTO_INCREMENT,
  `useridUser` INT NOT NULL,
  PRIMARY KEY (`idDiary`),
  INDEX `fk_diary_user1_idx` (`useridUser` ASC) VISIBLE,
  CONSTRAINT `fk_diary_user1`
    FOREIGN KEY (`useridUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`activity` (
  `idActivity` INT NOT NULL AUTO_INCREMENT,
  `excersise` VARCHAR(45) NOT NULL,
  `weight` INT NOT NULL,
  `intensity` INT NOT NULL,
  `duration` INT NOT NULL,
  `date` DATE NOT NULL,
  `result` INT NOT NULL,
  `diaryidDiary` INT NOT NULL,
  PRIMARY KEY (`idActivity`, `diaryidDiary`),
  INDEX `fk_activity_diary1_idx` (`diaryidDiary` ASC) VISIBLE,
  CONSTRAINT `fk_activity_diary1`
    FOREIGN KEY (`diaryidDiary`)
    REFERENCES `fitnesIp`.`diary` (`idDiary`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`user_has_program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`user_has_program` (
  `userIdUser` INT NOT NULL,
  `programIdProgram` INT NOT NULL,
  `date` DATE NOT NULL,
  `paymentMethod` VARCHAR(45) NOT NULL,
  `pay` DOUBLE NOT NULL,
  PRIMARY KEY (`userIdUser`, `programIdProgram`),
  INDEX `fk_user_has_program_program1_idx` (`programIdProgram` ASC) VISIBLE,
  INDEX `fk_user_has_program_user1_idx` (`userIdUser` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_program_user1`
    FOREIGN KEY (`userIdUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_program_program1`
    FOREIGN KEY (`programIdProgram`)
    REFERENCES `fitnesIp`.`program` (`idProgram`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`question` (
  `idQuestion` INT NOT NULL,
  `userIdUser` INT NOT NULL,
  `programIdProgram` INT NOT NULL,
  `text` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idQuestion`, `userIdUser`, `programIdProgram`),
  INDEX `fk_user_has_program1_program1_idx` (`programIdProgram` ASC) VISIBLE,
  INDEX `fk_user_has_program1_user1_idx` (`userIdUser` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_program1_user1`
    FOREIGN KEY (`userIdUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_program1_program1`
    FOREIGN KEY (`programIdProgram`)
    REFERENCES `fitnesIp`.`program` (`idProgram`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`attribute` (
  `idAttribute` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `categoryIdCategory` INT NOT NULL,
  PRIMARY KEY (`idAttribute`),
  INDEX `fk_attribute_category1_idx` (`categoryIdCategory` ASC) VISIBLE,
  CONSTRAINT `fk_attribute_category1`
    FOREIGN KEY (`categoryIdCategory`)
    REFERENCES `fitnesIp`.`category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`atributeValue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`atributeValue` (
  `idatributeValue` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NOT NULL,
  `programIdProgram` INT NOT NULL,
  `attributeIdAttribute` INT NOT NULL,
  PRIMARY KEY (`idatributeValue`, `programIdProgram`, `attributeIdAttribute`),
  INDEX `fk_atributeValue_program1_idx` (`programIdProgram` ASC) VISIBLE,
  INDEX `fk_atributeValue_attribute1_idx` (`attributeIdAttribute` ASC) VISIBLE,
  CONSTRAINT `fk_atributeValue_program1`
    FOREIGN KEY (`programIdProgram`)
    REFERENCES `fitnesIp`.`program` (`idProgram`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atributeValue_attribute1`
    FOREIGN KEY (`attributeIdAttribute`)
    REFERENCES `fitnesIp`.`attribute` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`subscription` (
  `category_idCategory` INT NOT NULL,
  `user_idUser` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`category_idCategory`, `user_idUser`),
  INDEX `fk_category_has_user_user1_idx` (`user_idUser` ASC) VISIBLE,
  INDEX `fk_category_has_user_category1_idx` (`category_idCategory` ASC) VISIBLE,
  CONSTRAINT `fk_category_has_user_category1`
    FOREIGN KEY (`category_idCategory`)
    REFERENCES `fitnesIp`.`category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_user_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `fitnesIp`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`replay`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`replay` (
  `idReply` INT NOT NULL AUTO_INCREMENT,
  `questionidQuestion` INT NOT NULL,
  `questionUserIdUser` INT NOT NULL,
  `questionProgramIdProgram` INT NOT NULL,
  PRIMARY KEY (`idReply`),
  INDEX `fk_reply_question1_idx` (`questionidQuestion` ASC, `questionUserIdUser` ASC, `questionProgramIdProgram` ASC) VISIBLE,
  CONSTRAINT `fk_reply_question1`
    FOREIGN KEY (`questionidQuestion` , `questionUserIdUser` , `questionProgramIdProgram`)
    REFERENCES `fitnesIp`.`question` (`idQuestion` , `userIdUser` , `programIdProgram`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`administrator` (
  `idAdministrator` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdministrator`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitnesIp`.`support`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesIp`.`support` (
  `idSupport` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSupport`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
