CREATE DATABASE  IF NOT EXISTS `sysmed` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sysmed`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sysmed
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atua_como`
--

DROP TABLE IF EXISTS `atua_como`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atua_como` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf_medico` char(11) NOT NULL,
  `nome_especialidade` varchar(50) NOT NULL,
  `custo_consulta` double NOT NULL,
  `trabalha` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf_medico` (`cpf_medico`),
  KEY `nome_especialidade` (`nome_especialidade`),
  KEY `trabalha` (`trabalha`),
  CONSTRAINT `atua_como_ibfk_1` FOREIGN KEY (`cpf_medico`) REFERENCES `medico` (`cpf`),
  CONSTRAINT `atua_como_ibfk_2` FOREIGN KEY (`nome_especialidade`) REFERENCES `especialidade` (`nome`),
  CONSTRAINT `atua_como_ibfk_3` FOREIGN KEY (`trabalha`) REFERENCES `trabalha` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atua_como`
--

LOCK TABLES `atua_como` WRITE;
/*!40000 ALTER TABLE `atua_como` DISABLE KEYS */;
/*!40000 ALTER TABLE `atua_como` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_solicitacao` int(11) NOT NULL,
  `horario` datetime NOT NULL,
  `queixa_principal` varchar(2500) DEFAULT NULL,
  `sintomas` varchar(2500) DEFAULT NULL,
  `observacao_medica` varchar(2500) DEFAULT NULL,
  `historico_familiar` varchar(2500) DEFAULT NULL,
  `diagnostico` varchar(2500) DEFAULT NULL,
  `tratamento` varchar(2500) DEFAULT NULL,
  `recomendacao_medica` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_solicitacao` (`id_solicitacao`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`id_solicitacao`) REFERENCES `solicitao_consulta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade` (
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `cpf` char(11) NOT NULL,
  `salario` double NOT NULL,
  `tipo_funcionario` varchar(25) NOT NULL,
  PRIMARY KEY (`cpf`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `pessoa` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('nullR',0,'recepcionista');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_turno` varchar(50) NOT NULL,
  `dia_da_semana` tinyint(4) NOT NULL,
  `hora_inicial` time NOT NULL,
  `hora_final` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nome_turno` (`nome_turno`),
  CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`nome_turno`) REFERENCES `turno` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,'turno teste',1,'16:23:22','16:23:22'),(2,'turno teste',1,'16:25:23','16:25:23');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `cpf` char(11) NOT NULL,
  `sobre` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `funcionario` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `cpf` char(11) NOT NULL,
  `descricao_local_trabalho` varchar(2500) DEFAULT NULL,
  `medicao_atual` varchar(2500) DEFAULT NULL,
  `profissao_atual` varchar(200) DEFAULT NULL,
  `alergias_conhecidas` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `pessoa` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES ('123456',NULL,NULL,NULL,NULL),('j',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `cpf` char(11) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `data_nasc` date NOT NULL,
  `numero_casa` varchar(5) NOT NULL,
  `nome_rua` varchar(75) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` char(2) NOT NULL,
  `telefone` char(8) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `sexo` enum('M','F') NOT NULL,
  `estado_civil` varchar(10) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('123456','alex','1994-12-14','15','a','a','a','a','8888888',NULL,'M','a'),('j','j','1994-12-14','j','j','j','jj','j','j',NULL,'M','j'),('nullR','null','2015-04-26','null','null','null','null','nl','null','null','F','null');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepcionista`
--

DROP TABLE IF EXISTS `recepcionista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recepcionista` (
  `cpf` char(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  CONSTRAINT `recepcionista_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `funcionario` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepcionista`
--

LOCK TABLES `recepcionista` WRITE;
/*!40000 ALTER TABLE `recepcionista` DISABLE KEYS */;
INSERT INTO `recepcionista` VALUES ('nullR');
/*!40000 ALTER TABLE `recepcionista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitao_consulta`
--

DROP TABLE IF EXISTS `solicitao_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitao_consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horario` datetime NOT NULL,
  `cpf_paciente` char(11) NOT NULL,
  `cpf_medico` char(11) NOT NULL,
  `cpf_avaliador` char(11) NOT NULL,
  `nome_especialidade` varchar(50) NOT NULL,
  `status_solicitacao` enum('P','A','R') NOT NULL,
  `motivo_recusacao` varchar(500) DEFAULT NULL,
  `duracao_esperada` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf_paciente` (`cpf_paciente`),
  KEY `cpf_medico` (`cpf_medico`),
  KEY `cpf_avaliador` (`cpf_avaliador`),
  KEY `nome_especialidade` (`nome_especialidade`),
  CONSTRAINT `solicitao_consulta_ibfk_1` FOREIGN KEY (`cpf_paciente`) REFERENCES `paciente` (`cpf`),
  CONSTRAINT `solicitao_consulta_ibfk_2` FOREIGN KEY (`cpf_medico`) REFERENCES `medico` (`cpf`),
  CONSTRAINT `solicitao_consulta_ibfk_3` FOREIGN KEY (`cpf_avaliador`) REFERENCES `recepcionista` (`cpf`),
  CONSTRAINT `solicitao_consulta_ibfk_4` FOREIGN KEY (`nome_especialidade`) REFERENCES `especialidade` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitao_consulta`
--

LOCK TABLES `solicitao_consulta` WRITE;
/*!40000 ALTER TABLE `solicitao_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitao_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalha`
--

DROP TABLE IF EXISTS `trabalha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` char(11) NOT NULL,
  `turno` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf` (`cpf`),
  KEY `turno` (`turno`),
  CONSTRAINT `trabalha_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `funcionario` (`cpf`),
  CONSTRAINT `trabalha_ibfk_2` FOREIGN KEY (`turno`) REFERENCES `turno` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalha`
--

LOCK TABLES `trabalha` WRITE;
/*!40000 ALTER TABLE `trabalha` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabalha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES ('turno teste');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-19 13:54:59
