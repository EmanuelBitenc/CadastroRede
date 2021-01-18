-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Jan-2021 às 14:59
-- Versão do servidor: 10.4.16-MariaDB
-- versão do PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdrede`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcomputador`
--

CREATE TABLE `tbcomputador` (
  `ip` char(12) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `bloco` char(1) NOT NULL,
  `andar` int(2) NOT NULL,
  `sala` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbcomputador`
--

INSERT INTO `tbcomputador` (`ip`, `nome`, `bloco`, `andar`, `sala`) VALUES
('192.12.34.12', 'Computador de testes', 'A', 23, 2),
('48548', 'teste', 'a', 2, 3),
('teste', 'teste', 't', 1, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcomputador`
--
ALTER TABLE `tbcomputador`
  ADD PRIMARY KEY (`ip`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
