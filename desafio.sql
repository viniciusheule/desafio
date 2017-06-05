-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: desafio
-- ------------------------------------------------------
-- Server version	5.6.32-log

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
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `estado_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_3uxfxu3ar4lpub19hldftpikb` (`estado_codigo`),
  CONSTRAINT `FK_3uxfxu3ar4lpub19hldftpikb` FOREIGN KEY (`estado_codigo`) REFERENCES `estado` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'São Paulo',3),(5,'Cerqueria César',3),(6,'Ourinhos',3),(7,'Blumenau',7),(8,'Curitiba',10),(9,'Londrina',10),(10,'Belo Horizonte',8),(11,'Salvador',9);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(50) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `complemento` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `razaoSocial` varchar(50) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `tipoCliente` varchar(50) NOT NULL,
  `cidade_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_qupeok4t191vlj4k8is4cmnac` (`cidade_codigo`),
  CONSTRAINT `FK_qupeok4t191vlj4k8is4cmnac` FOREIGN KEY (`cidade_codigo`) REFERENCES `cidade` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Bairro 1','18760-000','12121212121212','','shaushaush@gmail.com','25','Empresa de TI','Avenida','(14)3714-1259','Ouro',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (3,'São Paulo','SP'),(6,'Rio de Janeiro','RJ'),(7,'Santa Catarina','SC'),(8,'Minas Gerais','MG'),(9,'Bahia','BA'),(10,'Parana','PR');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `tipoServico` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Site com uma pagina de informações','One Page'),(2,'Site Advogado','Site Institucional');
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicocontratado`
--

DROP TABLE IF EXISTS `servicocontratado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicocontratado` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtContratacao` date NOT NULL,
  `dtFim` date NOT NULL,
  `dtInicio` date NOT NULL,
  `dtPagamento` date NOT NULL,
  `valor` decimal(9,2) NOT NULL,
  `cliente_codigo` bigint(20) NOT NULL,
  `servico_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_2cp4ctbxwy8osvcknns5363k7` (`cliente_codigo`),
  KEY `FK_lti228dtk4muyte1fhjonisuc` (`servico_codigo`),
  CONSTRAINT `FK_2cp4ctbxwy8osvcknns5363k7` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`),
  CONSTRAINT `FK_lti228dtk4muyte1fhjonisuc` FOREIGN KEY (`servico_codigo`) REFERENCES `servico` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicocontratado`
--

LOCK TABLES `servicocontratado` WRITE;
/*!40000 ALTER TABLE `servicocontratado` DISABLE KEYS */;
INSERT INTO `servicocontratado` VALUES (1,'2017-06-01','2017-06-30','2017-06-02','2017-06-29',100.00,1,1),(2,'2017-06-01','2017-06-30','2017-06-01','2017-06-29',100.00,1,1),(3,'2017-06-01','2017-06-30','2017-06-01','2017-06-29',100.00,1,1),(4,'2017-06-02','2017-06-29','2017-06-02','2017-06-28',70.00,1,2);
/*!40000 ALTER TABLE `servicocontratado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-04 23:43:01
