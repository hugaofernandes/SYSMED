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
  `nome_especialidade` varchar(50) NOT NULL,
  `custo_consulta` double NOT NULL,
  `trabalha` int(11) NOT NULL,
  `duracao_esperada` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nome_especialidade` (`nome_especialidade`),
  KEY `trabalha` (`trabalha`),
  CONSTRAINT `atua_como_ibfk_2` FOREIGN KEY (`nome_especialidade`) REFERENCES `especialidade` (`nome`),
  CONSTRAINT `atua_como_ibfk_3` FOREIGN KEY (`trabalha`) REFERENCES `trabalha` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atua_como`
--

LOCK TABLES `atua_como` WRITE;
/*!40000 ALTER TABLE `atua_como` DISABLE KEYS */;
INSERT INTO `atua_como` VALUES (1,'1',50,4,0),(2,'2',50,4,0),(3,'2212312assds',52,5,54);
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
-- Table structure for table `data_agendamento`
--

DROP TABLE IF EXISTS `data_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_agendamento` (
  `id_cliente` int(11) DEFAULT NULL,
  `id_especialidade` varchar(50) DEFAULT NULL,
  `id_medico` char(11) DEFAULT NULL,
  `id_horario` int(11) DEFAULT NULL,
  `valor_consulta` double DEFAULT NULL,
  KEY `id_cliente` (`id_cliente`),
  KEY `id_especialidade` (`id_especialidade`),
  KEY `id_medico` (`id_medico`),
  KEY `id_horario` (`id_horario`),
  CONSTRAINT `data_agendamento_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `data_cliente` (`id`),
  CONSTRAINT `data_agendamento_ibfk_2` FOREIGN KEY (`id_especialidade`) REFERENCES `data_especialidade` (`nome`),
  CONSTRAINT `data_agendamento_ibfk_3` FOREIGN KEY (`id_medico`) REFERENCES `data_medico` (`cpf`),
  CONSTRAINT `data_agendamento_ibfk_4` FOREIGN KEY (`id_horario`) REFERENCES `data_horario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_agendamento`
--

LOCK TABLES `data_agendamento` WRITE;
/*!40000 ALTER TABLE `data_agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_cliente`
--

DROP TABLE IF EXISTS `data_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_nasc` date DEFAULT NULL,
  `estado_civil` varchar(10) DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_cliente`
--

LOCK TABLES `data_cliente` WRITE;
/*!40000 ALTER TABLE `data_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_especialidade`
--

DROP TABLE IF EXISTS `data_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_especialidade` (
  `nome` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_especialidade`
--

LOCK TABLES `data_especialidade` WRITE;
/*!40000 ALTER TABLE `data_especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_horario`
--

DROP TABLE IF EXISTS `data_horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `trimestre` int(11) DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  `dia` int(11) DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_horario`
--

LOCK TABLES `data_horario` WRITE;
/*!40000 ALTER TABLE `data_horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_medico`
--

DROP TABLE IF EXISTS `data_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_medico` (
  `nome` varchar(75) DEFAULT NULL,
  `cpf` char(11) NOT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_medico`
--

LOCK TABLES `data_medico` WRITE;
/*!40000 ALTER TABLE `data_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_medico` ENABLE KEYS */;
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
INSERT INTO `especialidade` VALUES ('1','1'),('2','asd'),('2212312assds','2asd'),('22ds','sa'),('233','233'),('2334','2344'),('3','3'),('5','5'),('ac','ac'),('asd','asd'),('bb','bb'),('cardiologia','cuida do coracao'),('carid','asd'),('caridiologia2','cadridioasda'),('erwr','wer');
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
INSERT INTO `funcionario` VALUES ('1',0,'medico'),('10',0,'medico'),('1985',0,'medico'),('2',0,'medico'),('4',0,'medico'),('5',0,'medico'),('6',0,'medico'),('7',0,'medico'),('90',0,'medico'),('nullR',0,'recepcionista');
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,'turno teste',1,'16:23:22','16:23:22'),(2,'turno teste',1,'16:25:23','16:25:23'),(3,'mat2',2,'07:00:00','12:00:00'),(4,'mat2',3,'07:00:00','12:00:00'),(5,'mat2',4,'07:00:00','12:00:00'),(6,'mat2',5,'07:00:00','12:00:00'),(7,'mat2',6,'07:00:00','12:00:00'),(8,'asdasd',1,'01:00:00','02:00:00'),(9,'asdasd',2,'01:00:00','02:00:00'),(10,'asdasd',3,'01:00:00','02:00:00'),(11,'asdasd',4,'01:00:00','02:00:00'),(12,'asdasd',5,'01:00:00','02:00:00'),(13,'asdasd',6,'01:00:00','02:00:00'),(14,'asdasd',7,'01:00:00','02:00:00'),(15,'TESTE',1,'00:00:00','01:00:00'),(16,'TESTE',2,'00:00:00','01:00:00'),(17,'TESTE',3,'00:00:00','01:00:00'),(18,'TESTE',4,'00:00:00','01:00:00'),(19,'TESTE',5,'00:00:00','01:00:00'),(20,'TESTE',6,'00:00:00','01:00:00'),(21,'TESTE',7,'00:00:00','01:00:00'),(22,'testaea',3,'01:00:00','02:00:00'),(23,'heeeeee',1,'01:00:00','02:00:00');
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
INSERT INTO `medico` VALUES ('1',NULL),('10',NULL),('1985',NULL),('2',NULL),('4',NULL),('5',NULL),('6',NULL),('7',NULL),('90',NULL);
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
INSERT INTO `paciente` VALUES ('87888888888',NULL,NULL,NULL,NULL),('88888888888',NULL,NULL,NULL,NULL);
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
INSERT INTO `pessoa` VALUES ('1','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('10','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('1985','new medico','2015-05-26','null','null','null','null','RN','null','null','M','casado'),('2','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('4','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('5','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('6','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('7','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('87888888888','teste3','1995-12-14','2','rua','bairro','caico','RN','88888888',NULL,'M','Solteiro'),('88888888888','alex','1994-12-14','12','rua','bairro','caico','RN','88888888',NULL,'M','Solteiro'),('90','new medico','2015-05-25','null','null','null','null','RN','null','null','M','casado'),('nullR','null','2015-04-26','null','null','null','null','nl','null','null','F','null');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalha`
--

LOCK TABLES `trabalha` WRITE;
/*!40000 ALTER TABLE `trabalha` DISABLE KEYS */;
INSERT INTO `trabalha` VALUES (1,'6','mat'),(2,'7','TESTE'),(3,'90','testaea'),(4,'10','asdasd'),(5,'1985','heeeeee');
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
INSERT INTO `turno` VALUES ('asdasd'),('heeeeee'),('mat'),('mat2'),('testaea'),('TESTE'),('turno teste');
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

-- Dump completed on 2015-05-26 23:17:41
