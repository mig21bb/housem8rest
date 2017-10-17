-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema housem8_schema
-- -----------------------------------------------------
CREATE DATABASE `housem8_schema` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

CREATE TABLE `housem8_schema`.`compensation` (
  `id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `datetime` datetime NOT NULL,
  `payer` int(11) NOT NULL,
  `receiver` int(11) NOT NULL,
  `notes` longtext COLLATE utf8_spanish_ci,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_COMPENSATION_MATE1_idx` (`payer`),
  KEY `fk_COMPENSATION_MATE2_idx` (`receiver`),
  CONSTRAINT `fk_COMPENSATION_MATE1` FOREIGN KEY (`payer`) REFERENCES `mate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_COMPENSATION_MATE2` FOREIGN KEY (`receiver`) REFERENCES `mate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`cost` (
  `id` int(11) NOT NULL,
  `description` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `MATE_id` int(11) NOT NULL,
  `HOUSE_id` int(11) NOT NULL,
  `COST_FAMILY_id` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_COST_MATE1_idx` (`MATE_id`),
  KEY `fk_COST_HOUSE1_idx` (`HOUSE_id`),
  KEY `fk_COST_COST_FAMILY1_idx` (`COST_FAMILY_id`),
  CONSTRAINT `fk_COST_COST_FAMILY1` FOREIGN KEY (`COST_FAMILY_id`) REFERENCES `cost_family` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_HOUSE1` FOREIGN KEY (`HOUSE_id`) REFERENCES `house` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_MATE1` FOREIGN KEY (`MATE_id`) REFERENCES `mate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`cost_family` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `period` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `street` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `cp` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `apartment` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `other` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `square_meters` float NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`mate` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `surname1` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `surname2` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `nationality` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `user` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pass` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`ocupation` (
  `id` int(11) NOT NULL,
  `ROOM_id` int(11) NOT NULL,
  `MATE_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_OCUPATION_ROOM1_idx` (`ROOM_id`),
  KEY `fk_OCUPATION_MATE1_idx` (`MATE_id`),
  CONSTRAINT `fk_OCUPATION_MATE1` FOREIGN KEY (`MATE_id`) REFERENCES `mate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OCUPATION_ROOM1` FOREIGN KEY (`ROOM_id`) REFERENCES `room` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`pictures` (
  `id` int(11) NOT NULL,
  `url` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `active` binary(1) DEFAULT '1',
  `data_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`room` (
  `id` int(11) NOT NULL,
  `square_meters` float NOT NULL,
  `windows` tinyint(1) DEFAULT NULL,
  `HOUSE_id` int(11) NOT NULL,
  `ROOM_CLASS_id` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ROOM_HOUSE_idx` (`HOUSE_id`),
  KEY `fk_ROOM_ROOM_CLASS1_idx` (`ROOM_CLASS_id`),
  CONSTRAINT `fk_ROOM_HOUSE` FOREIGN KEY (`HOUSE_id`) REFERENCES `house` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROOM_ROOM_CLASS1` FOREIGN KEY (`ROOM_CLASS_id`) REFERENCES `room_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `housem8_schema`.`room_class` (
  `id` int(11) NOT NULL,
  `description` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `category` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_borrado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;