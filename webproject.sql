SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `webproject` ;
CREATE SCHEMA IF NOT EXISTS `webproject` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `webproject` ;

-- -----------------------------------------------------
-- Table `webproject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`user` (
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(16) NOT NULL,
  `ismale` TINYINT(1) NOT NULL,
  `isadmin` TINYINT(1) NOT NULL,
  `isremoved` TINYINT(1) NOT NULL,
  `balance` INT(11) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webproject`.`remembered_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`remembered_user` (
  `UUID` VARCHAR(36) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`UUID`),
  INDEX `fk_remenbered_user_user_idx` (`username` ASC),
  CONSTRAINT `fk_remenbered_user_user`
    FOREIGN KEY (`username`)
    REFERENCES `webproject`.`user` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webproject`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`book` (
  `ISBN` VARCHAR(16) NOT NULL,
  `title` VARCHAR(128) NOT NULL,
  `author` VARCHAR(64) NOT NULL,
  `publish_date` DATE NOT NULL,
  `category` VARCHAR(16) NOT NULL,
  `price` INT(11) NOT NULL,
  `current_number` INT(11) NOT NULL,
  PRIMARY KEY (`ISBN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webproject`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`cart` (
  `username` VARCHAR(32) NOT NULL,
  `ISBN` VARCHAR(16) NOT NULL,
  `number` INT(11) NOT NULL,
  PRIMARY KEY (`username`, `ISBN`),
  INDEX `fk_user_has_book_book1_idx` (`ISBN` ASC),
  INDEX `fk_user_has_book_user1_idx` (`username` ASC),
  CONSTRAINT `fk_user_has_book_user1`
    FOREIGN KEY (`username`)
    REFERENCES `webproject`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_book_book1`
    FOREIGN KEY (`ISBN`)
    REFERENCES `webproject`.`book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webproject`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`orders` (
  `orderID` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `time` DATETIME NOT NULL,
  `total_price` INT(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `fk_orders_user1_idx` (`username` ASC),
  CONSTRAINT `fk_orders_user1`
    FOREIGN KEY (`username`)
    REFERENCES `webproject`.`user` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webproject`.`bought`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webproject`.`bought` (
  `orderID` INT(11) NOT NULL,
  `ISBN` VARCHAR(16) NOT NULL,
  `number` INT(11) NOT NULL,
  PRIMARY KEY (`orderID`, `ISBN`),
  INDEX `fk_orders_has_book_book1_idx` (`ISBN` ASC),
  INDEX `fk_orders_has_book_orders1_idx` (`orderID` ASC),
  CONSTRAINT `fk_orders_has_book_orders1`
    FOREIGN KEY (`orderID`)
    REFERENCES `webproject`.`orders` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_book_book1`
    FOREIGN KEY (`ISBN`)
    REFERENCES `webproject`.`book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
