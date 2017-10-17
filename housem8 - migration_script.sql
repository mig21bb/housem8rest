-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: housem8_schema
-- Source Schemata: housem8_schema
-- Created: Mon Sep 04 00:55:56 2017
-- Workbench Version: 6.3.6
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema housem8_schema
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `housem8_schema` ;
CREATE SCHEMA IF NOT EXISTS `housem8_schema` ;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.commerce
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`commerce` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `coordinates` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `cost_family` INT(11) NULL DEFAULT NULL,
  `logo` VARCHAR(300) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK6tk07m5kpbg14e9bcwcij1mi3` (`cost_family` ASC),
  CONSTRAINT `FK6tk07m5kpbg14e9bcwcij1mi3`
    FOREIGN KEY (`cost_family`)
    REFERENCES `housem8_schema`.`cost_family` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.compensation
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`compensation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` FLOAT NOT NULL,
  `datetime` DATETIME NOT NULL,
  `payer` INT(11) NOT NULL,
  `receiver` INT(11) NOT NULL,
  `notes` LONGTEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_COMPENSATION_MATE1_idx` (`payer` ASC),
  INDEX `fk_COMPENSATION_MATE2_idx` (`receiver` ASC),
  CONSTRAINT `FKho85krtjbl251xe7odmrgajdt`
    FOREIGN KEY (`payer`)
    REFERENCES `housem8_schema`.`mate` (`id`),
  CONSTRAINT `FKr4y32pb88axf8bbnjwdat3sky`
    FOREIGN KEY (`receiver`)
    REFERENCES `housem8_schema`.`mate` (`id`),
  CONSTRAINT `fk_COMPENSATION_MATE1`
    FOREIGN KEY (`payer`)
    REFERENCES `housem8_schema`.`mate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COMPENSATION_MATE2`
    FOREIGN KEY (`receiver`)
    REFERENCES `housem8_schema`.`mate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.cost
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`cost` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `period` INT(11) NULL DEFAULT NULL,
  `datetime` DATETIME NULL DEFAULT NULL,
  `amount` FLOAT NULL DEFAULT NULL,
  `MATE_id` INT(11) NOT NULL,
  `HOUSE_id` INT(11) NOT NULL,
  `COST_FAMILY_id` INT(11) NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  `COMMERCE_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_COST_MATE1_idx` (`MATE_id` ASC),
  INDEX `fk_COST_HOUSE1_idx` (`HOUSE_id` ASC),
  INDEX `fk_COST_COST_FAMILY1_idx` (`COST_FAMILY_id` ASC),
  INDEX `FK5euyxyxdloyxyjok1965fi6qu` (`COMMERCE_id` ASC),
  CONSTRAINT `FK5euyxyxdloyxyjok1965fi6qu`
    FOREIGN KEY (`COMMERCE_id`)
    REFERENCES `housem8_schema`.`commerce` (`id`),
  CONSTRAINT `FKf6gv4058ekv9t1qepnugub86v`
    FOREIGN KEY (`COST_FAMILY_id`)
    REFERENCES `housem8_schema`.`cost_family` (`id`),
  CONSTRAINT `FKlxbfkol7dm05bn6uhbwy267c4`
    FOREIGN KEY (`MATE_id`)
    REFERENCES `housem8_schema`.`mate` (`id`),
  CONSTRAINT `FKme13e55jajtc71bbevw191ltx`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`house` (`id`),
  CONSTRAINT `fk_COMMERCE`
    FOREIGN KEY (`COMMERCE_id`)
    REFERENCES `housem8_schema`.`commerce` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_COST_FAMILY1`
    FOREIGN KEY (`COST_FAMILY_id`)
    REFERENCES `housem8_schema`.`cost_family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_HOUSE1`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`house` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_MATE1`
    FOREIGN KEY (`MATE_id`)
    REFERENCES `housem8_schema`.`mate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 44
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.cost_family
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`cost_family` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `description` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `period` INT(11) NULL DEFAULT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.house
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`house` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `city` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `street` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `cp` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `number` INT(11) NULL DEFAULT NULL,
  `floor` INT(11) NULL DEFAULT NULL,
  `apartment` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `other` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `square_meters` FLOAT NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  `maker_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `maker_id_idx` (`maker_id` ASC),
  CONSTRAINT `FK9vpkte2leyusxmjqbvw9dam0d`
    FOREIGN KEY (`maker_id`)
    REFERENCES `housem8_schema`.`mate` (`id`),
  CONSTRAINT `maker_id`
    FOREIGN KEY (`maker_id`)
    REFERENCES `housem8_schema`.`mate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.mate
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`mate` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `surname1` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `surname2` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `birth_date` DATE NULL DEFAULT NULL,
  `nationality` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `user` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `pass` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.ocupation
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`ocupation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ROOM_id` INT(11) NOT NULL,
  `MATE_id` INT(11) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgbst436wco6wavom7qc3sdgkf` (`MATE_id` ASC),
  INDEX `FK6spqel4gyv785ooqxvle8gdlw` (`ROOM_id` ASC),
  CONSTRAINT `FK6spqel4gyv785ooqxvle8gdlw`
    FOREIGN KEY (`ROOM_id`)
    REFERENCES `housem8_schema`.`room` (`id`),
  CONSTRAINT `FKgbst436wco6wavom7qc3sdgkf`
    FOREIGN KEY (`MATE_id`)
    REFERENCES `housem8_schema`.`mate` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.pictures
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`pictures` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `datetime` DATETIME NULL DEFAULT NULL,
  `active` BINARY(1) NULL DEFAULT '1',
  `data_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.room
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`room` (
  `id` INT(11) NOT NULL,
  `square_meters` FLOAT NOT NULL,
  `windows` TINYINT(1) NULL DEFAULT NULL,
  `HOUSE_id` INT(11) NOT NULL,
  `ROOM_CLASS_id` INT(11) NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ROOM_HOUSE_idx` (`HOUSE_id` ASC),
  INDEX `fk_ROOM_ROOM_CLASS1_idx` (`ROOM_CLASS_id` ASC),
  CONSTRAINT `FKf99vlcy8dpjobte77jqmdunfs`
    FOREIGN KEY (`ROOM_CLASS_id`)
    REFERENCES `housem8_schema`.`room_class` (`id`),
  CONSTRAINT `FKg1kqtahwqgla8vnfpicmntcus`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`house` (`id`),
  CONSTRAINT `fk_ROOM_HOUSE`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`house` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROOM_ROOM_CLASS1`
    FOREIGN KEY (`ROOM_CLASS_id`)
    REFERENCES `housem8_schema`.`room_class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- ----------------------------------------------------------------------------
-- Table housem8_schema.room_class
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `housem8_schema`.`room_class` (
  `id` INT(11) NOT NULL,
  `description` VARCHAR(200) CHARACTER SET 'utf8' NOT NULL,
  `category` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT '1',
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `fecha_borrado` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;
SET FOREIGN_KEY_CHECKS = 1;
