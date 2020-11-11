-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2020 at 10:50 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbportfolio`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresse`
--

CREATE TABLE `adresse` (
  `AdressId` int(11) NOT NULL,
  `Straße` varchar(70) NOT NULL,
  `Hausnummer` varchar(10) NOT NULL,
  `Postleitzahl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adresse`
--

INSERT INTO `adresse` (`AdressId`, `Straße`, `Hausnummer`, `Postleitzahl`) VALUES
(1, 'Hauptstraße', '54', 76887),
(2, 'Am Bach', '99', 10115),
(3, 'Zollstraße', '3', 55116),
(4, 'Bahnhofstraße', '65', 76137),
(5, 'Gartenstraße', '45', 20095),
(6, 'Ettlingerstraße', '12', 76131),
(7, 'Am Seeweg', '4', 76131),
(8, 'Bachstraße', '9', 76133),
(9, 'Bahnhofstraße', '65', 76137),
(10, 'Hansstraße', '2', 76199),
(11, 'Am Tor', '33', 76199),
(12, 'Donaustraße', '2', 76829),
(13, 'Zaunpfad', '78a', 76829),
(14, 'Untere Hauptstraße', '231', 55116),
(15, 'Adenauerring', '99', 75177),
(16, 'Baldachinstraße', '23', 76133),
(17, 'Schneeweg', '4', 10115),
(18, 'Milchstraße', '44', 76133);

-- --------------------------------------------------------

--
-- Table structure for table `arbeitgeber`
--

CREATE TABLE `arbeitgeber` (
  `ArbeitgeberId` int(11) NOT NULL,
  `Firmenname` varchar(120) NOT NULL,
  `AdressId` int(11) NOT NULL,
  `Abrechnungsverband` varchar(10) NOT NULL,
  `MitarbeiterNr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arbeitgeber`
--

INSERT INTO `arbeitgeber` (`ArbeitgeberId`, `Firmenname`, `AdressId`, `Abrechnungsverband`, `MitarbeiterNr`) VALUES
(1, 'ENBW', 6, 'West', 1),
(2, 'DRV', 7, 'West', 1),
(3, 'Stadt Karlsruhe', 8, 'West', 2),
(4, 'Stadt Berlin', 9, 'Ost', 2),
(5, 'SAP', 15, 'West', 3),
(6, 'Helios Klinik', 16, 'West', 4),
(7, 'Bundeswehr', 17, 'Ost', 5),
(8, 'Stadt Stuttgart', 18, 'West', 4);

-- --------------------------------------------------------

--
-- Table structure for table `arbeitsverhaeltnisse`
--

CREATE TABLE `arbeitsverhaeltnisse` (
  `VersicherungsNr` int(11) NOT NULL,
  `ArbeitgeberId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arbeitsverhaeltnisse`
--

INSERT INTO `arbeitsverhaeltnisse` (`VersicherungsNr`, `ArbeitgeberId`) VALUES
(1, 6),
(2, 6),
(3, 7),
(4, 7),
(5, 8),
(6, 1),
(7, 1),
(8, 2),
(9, 4),
(10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `keyaccountmanager`
--

CREATE TABLE `keyaccountmanager` (
  `MitarbeiterNr` int(11) NOT NULL,
  `Vorname` varchar(70) NOT NULL,
  `Nachname` varchar(70) NOT NULL,
  `Eintrittsdatum` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keyaccountmanager`
--

INSERT INTO `keyaccountmanager` (`MitarbeiterNr`, `Vorname`, `Nachname`, `Eintrittsdatum`) VALUES
(1, 'Frauke', 'Bauer', '2000-04-01'),
(2, 'Martin', 'Lutz', '2010-06-15'),
(3, 'Ingrid', 'Nist', '2020-08-15'),
(4, 'Tim', 'Seibert', '1990-12-01'),
(5, 'Walter', 'Mayer', '1980-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `ort`
--

CREATE TABLE `ort` (
  `Postleitzahl` int(11) NOT NULL,
  `Ortsname` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ort`
--

INSERT INTO `ort` (`Postleitzahl`, `Ortsname`) VALUES
(10115, 'Berlin'),
(20095, 'Hamburg'),
(55116, 'Mainz'),
(75177, 'Pforzheim'),
(76131, 'Karlsruhe'),
(76133, 'Karlsruhe'),
(76137, 'Karlsruhe'),
(76199, 'Ettlingen'),
(76829, 'Landau'),
(76887, 'Bad Bergzabern');

-- --------------------------------------------------------

--
-- Table structure for table `versicherter`
--

CREATE TABLE `versicherter` (
  `VersicherungsNr` int(11) NOT NULL,
  `Vorname` varchar(70) NOT NULL,
  `Nachname` varchar(70) NOT NULL,
  `Geburtsdatum` date NOT NULL,
  `Versorgungspunkte` float DEFAULT NULL,
  `AdressId` int(11) NOT NULL,
  `Rentenart` varchar(20) DEFAULT NULL,
  `Versicherungsstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `versicherter`
--

INSERT INTO `versicherter` (`VersicherungsNr`, `Vorname`, `Nachname`, `Geburtsdatum`, `Versorgungspunkte`, `AdressId`, `Rentenart`, `Versicherungsstatus`) VALUES
(1, 'Horst', 'Ehren', '1978-11-08', 34, 1, '', 'aktiv'),
(2, 'Axel', 'Zaun', '1990-07-23', 55, 2, '', 'aktiv'),
(3, 'Ulli', 'Weber', '2000-10-06', 90, 3, '', 'pausiert'),
(4, 'Lilli', 'Schick', '1988-08-15', 150, 4, '', 'pausiert'),
(5, 'Karl', 'Grün', '1983-09-17', 180, 5, '', 'aktiv'),
(6, 'Max', 'Müller', '1950-02-02', 190, 10, 'Altersrente', 'inaktiv'),
(7, 'Roman', 'Frey', '1950-12-08', 220, 11, 'Altersrente', 'inaktiv'),
(8, 'Markus', 'Ulm', '1931-09-13', 259, 12, 'Altersrente', 'inaktiv'),
(9, 'Thomas', 'Braun', '1920-12-09', 274, 13, 'Witwenrente', 'inaktikv'),
(10, 'Olaf', 'Nau', '1936-05-30', 210, 14, 'Altersrente', 'inaktiv');

-- --------------------------------------------------------

--
-- Table structure for table `vertrag`
--

CREATE TABLE `vertrag` (
  `VertragsId` int(11) NOT NULL,
  `VersicherungsNr` int(11) NOT NULL,
  `Abschlussdatum` date NOT NULL,
  `Vertragsstatus` varchar(20) DEFAULT NULL,
  `Vertragstyp` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vertrag`
--

INSERT INTO `vertrag` (`VertragsId`, `VersicherungsNr`, `Abschlussdatum`, `Vertragsstatus`, `Vertragstyp`) VALUES
(1, 1, '2000-12-12', 'aktiv', 'klassik'),
(2, 6, '1990-12-01', '', 'klassik'),
(3, 8, '1979-09-15', '', 'dynamik'),
(4, 10, '1978-03-20', '', 'riester'),
(5, 9, '1950-11-23', '', 'klassik'),
(6, 1, '2005-10-24', 'inaktiv', 'dynamik'),
(7, 2, '2014-03-08', 'aktiv', 'klassik'),
(8, 3, '2016-05-29', 'aktiv', 'klassik'),
(9, 4, '2000-10-01', 'aktiv', 'klassik'),
(10, 5, '2000-08-15', 'aktiv', 'klassik'),
(11, 6, '1990-12-01', '', 'klassik'),
(12, 7, '1964-04-01', '', 'dynamik'),
(13, 8, '1961-03-15', '', 'klassik'),
(14, 9, '1960-12-15', '', 'riester'),
(15, 10, '1958-09-13', '', 'klassik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`AdressId`),
  ADD KEY `Postleitzahl` (`Postleitzahl`);

--
-- Indexes for table `arbeitgeber`
--
ALTER TABLE `arbeitgeber`
  ADD PRIMARY KEY (`ArbeitgeberId`),
  ADD KEY `AdressId` (`AdressId`);

--
-- Indexes for table `arbeitsverhaeltnisse`
--
ALTER TABLE `arbeitsverhaeltnisse`
  ADD PRIMARY KEY (`VersicherungsNr`,`ArbeitgeberId`),
  ADD KEY `ArbeitgeberId` (`ArbeitgeberId`);

--
-- Indexes for table `keyaccountmanager`
--
ALTER TABLE `keyaccountmanager`
  ADD PRIMARY KEY (`MitarbeiterNr`);

--
-- Indexes for table `ort`
--
ALTER TABLE `ort`
  ADD PRIMARY KEY (`Postleitzahl`);

--
-- Indexes for table `versicherter`
--
ALTER TABLE `versicherter`
  ADD PRIMARY KEY (`VersicherungsNr`),
  ADD KEY `AdressId` (`AdressId`);

--
-- Indexes for table `vertrag`
--
ALTER TABLE `vertrag`
  ADD PRIMARY KEY (`VertragsId`),
  ADD KEY `VersicherungsNr` (`VersicherungsNr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `AdressId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `arbeitgeber`
--
ALTER TABLE `arbeitgeber`
  MODIFY `ArbeitgeberId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `keyaccountmanager`
--
ALTER TABLE `keyaccountmanager`
  MODIFY `MitarbeiterNr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `versicherter`
--
ALTER TABLE `versicherter`
  MODIFY `VersicherungsNr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vertrag`
--
ALTER TABLE `vertrag`
  MODIFY `VertragsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `adresse_ibfk_1` FOREIGN KEY (`Postleitzahl`) REFERENCES `ort` (`Postleitzahl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `arbeitgeber`
--
ALTER TABLE `arbeitgeber`
  ADD CONSTRAINT `arbeitgeber_ibfk_1` FOREIGN KEY (`AdressId`) REFERENCES `adresse` (`AdressId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `arbeitsverhaeltnisse`
--
ALTER TABLE `arbeitsverhaeltnisse`
  ADD CONSTRAINT `arbeitsverhaeltnisse_ibfk_1` FOREIGN KEY (`VersicherungsNr`) REFERENCES `versicherter` (`VersicherungsNr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `arbeitsverhaeltnisse_ibfk_2` FOREIGN KEY (`ArbeitgeberId`) REFERENCES `arbeitgeber` (`ArbeitgeberId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `versicherter`
--
ALTER TABLE `versicherter`
  ADD CONSTRAINT `versicherter_ibfk_1` FOREIGN KEY (`AdressId`) REFERENCES `adresse` (`AdressId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vertrag`
--
ALTER TABLE `vertrag`
  ADD CONSTRAINT `vertrag_ibfk_1` FOREIGN KEY (`VersicherungsNr`) REFERENCES `versicherter` (`VersicherungsNr`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
