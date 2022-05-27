-- MySQL Workbench Forward Engineering


CREATE SCHEMA IF NOT EXISTS `proyecto_dsw2`  ;
USE `proyecto_dsw2` ;

CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`personas` (
  `id_persona` INT NOT NULL AUTO_INCREMENT,
  `apellidos` VARCHAR(255) NULL DEFAULT NULL,
  `celular` VARCHAR(255) NULL DEFAULT NULL,
  `dni` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_registro` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `telefono` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona`));




CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`aplicacion` (
  `id_aplicacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_aplicacion`))
;



CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`authority` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
;




CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `enabled` BIT(1) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `id_authority` BIGINT NULL DEFAULT NULL,
  `id_persona` INT NOT NULL,
  PRIMARY KEY (`id`),
   CONSTRAINT `user_autorrity`
  FOREIGN KEY (`id_authority`)
    REFERENCES `proyecto`.`authority` (`id`),
     CONSTRAINT `user_persona`
   FOREIGN KEY (`id_persona`)
    REFERENCES `proyecto`.`personas` (`id_persona`))
;



-- -----------------------------------------------------
-- Table `proyecto`.`authorities_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`authorities_users` (
  `usuario_id` BIGINT NOT NULL,
  `authority_id` BIGINT NOT NULL,
  FOREIGN KEY (`usuario_id`)
    REFERENCES `proyecto`.`users` (`id`),
  FOREIGN KEY (`authority_id`)
    REFERENCES `proyecto`.`authority` (`id`))
;



-- -----------------------------------------------------
-- Table `proyecto`.`authority`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `proyecto`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria`))
;


CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`tipo_solicitud` (
  `id_tipo_solicitud` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_solicitud`))
;




CREATE TABLE IF NOT EXISTS `proyecto_dsw2`.`solicitud` (
  `id_solicitud` INT NOT NULL AUTO_INCREMENT,
  `descripcion_atencion` VARCHAR(255) NULL DEFAULT NULL,
  `descripcion_solicitud` VARCHAR(255) NULL DEFAULT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_cierre` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_registro` VARCHAR(255) NULL DEFAULT NULL,
  `prioridad` VARCHAR(255) NULL DEFAULT NULL,
  `id_aplicacion` INT NULL DEFAULT NULL,
  `id_categoria` INT NULL DEFAULT NULL,
  `id_persona` INT NULL DEFAULT NULL,
  `id_tipo_solicitud` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_solicitud`),
   FOREIGN KEY (`id_aplicacion`)
    REFERENCES `proyecto`.`aplicacion` (`id_aplicacion`) ,
 FOREIGN KEY (`id_categoria`)
    REFERENCES `proyecto`.`categoria` (`id_categoria`) ,
  FOREIGN KEY (`id_persona`)
    REFERENCES `proyecto`.`personas` (`id_persona`),
  FOREIGN KEY (`id_tipo_solicitud`)
    REFERENCES `proyecto`.`tipo_solicitud` (`id_tipo_solicitud`))
;

