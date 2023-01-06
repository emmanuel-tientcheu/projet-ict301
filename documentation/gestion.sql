-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 05 jan. 2023 à 11:27
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartement`
--

CREATE TABLE `appartement` (
  `IDAPPARTEMENT` int(11) NOT NULL,
  `IDIMMEUBLE` int(11) DEFAULT NULL,
  `NUMERO` int(11) NOT NULL,
  `SUPERFICIE` float NOT NULL,
  `PRIX_PREVISIONNEL` float NOT NULL,
  `NBRE_CHAMBRE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `appartement`
--

INSERT INTO `appartement` (`IDAPPARTEMENT`, `IDIMMEUBLE`, `NUMERO`, `SUPERFICIE`, `PRIX_PREVISIONNEL`, `NBRE_CHAMBRE`) VALUES
(1, 1, 1, 25, 25, 2);

-- --------------------------------------------------------

--
-- Structure de la table `avocat`
--

CREATE TABLE `avocat` (
  `IDAVOCAT` int(11) NOT NULL,
  `NOMA` varchar(191) NOT NULL,
  `PRENOMA` varchar(191) NOT NULL,
  `ADRESSAA` varchar(191) NOT NULL,
  `TELEPHONEA` varchar(191) NOT NULL,
  `NUMEROAUTORISATION` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `avocat`
--

INSERT INTO `avocat` (`IDAVOCAT`, `NOMA`, `PRENOMA`, `ADRESSAA`, `TELEPHONEA`, `NUMEROAUTORISATION`) VALUES
(1, 'zogo', 'carles', 'douala', '655514455', '21');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `IDCLIENT` int(11) NOT NULL,
  `NUMERO_CNI` varchar(191) NOT NULL,
  `NOM` varchar(191) NOT NULL,
  `PRENOM` varchar(191) NOT NULL,
  `ADRESSEC` varchar(191) NOT NULL,
  `TELEPHONE` varchar(191) NOT NULL,
  `PROFESSION` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`IDCLIENT`, `NUMERO_CNI`, `NOM`, `PRENOM`, `ADRESSEC`, `TELEPHONE`, `PROFESSION`) VALUES
(1, '123456789', 'emmanuel', 'jean', 'yaounde', '655514455', 'artisan du web');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `IDCONTRAT` int(11) NOT NULL,
  `IDDIRECTEUR` int(11) DEFAULT NULL,
  `IDCLIENT` int(11) DEFAULT NULL,
  `IDAPPARTEMENT` int(11) DEFAULT NULL,
  `TYPEPAIEMENT` varchar(191) NOT NULL,
  `DATESIGNATURE` date NOT NULL,
  `IDAVOCAT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `desistement`
--

CREATE TABLE `desistement` (
  `IDDESISTEMENT` int(11) NOT NULL,
  `IDPROMESSE` int(11) DEFAULT NULL,
  `IDDIRECTEUR` int(11) DEFAULT NULL,
  `IDCLIENT` int(11) DEFAULT NULL,
  `IDAVOCAT` int(11) DEFAULT NULL,
  `NUMERO` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `CAUSES` text NOT NULL,
  `ISVALIDER` tinyint(1) NOT NULL,
  `IDAPPARTEMENT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

CREATE TABLE `directeur` (
  `IDDIRECTEUR` int(11) NOT NULL,
  `IDSOCIETE` int(11) NOT NULL,
  `NOMDIRECTEUR` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `directeur`
--

INSERT INTO `directeur` (`IDDIRECTEUR`, `IDSOCIETE`, `NOMDIRECTEUR`) VALUES
(1, 1, 'somo');

-- --------------------------------------------------------

--
-- Structure de la table `immeuble`
--

CREATE TABLE `immeuble` (
  `IDIMMEUBLE` int(11) NOT NULL,
  `IDSOCIETE` int(11) NOT NULL,
  `ADRESSE` varchar(191) NOT NULL,
  `NOMIMMEUBLE` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `immeuble`
--

INSERT INTO `immeuble` (`IDIMMEUBLE`, `IDSOCIETE`, `ADRESSE`, `NOMIMMEUBLE`) VALUES
(0, 1, 'yaounde2', 'tchotcho de la capital'),
(1, 1, 'yaounde2', 'tchotcho de la capital');

-- --------------------------------------------------------

--
-- Structure de la table `procesverbal`
--

CREATE TABLE `procesverbal` (
  `IDPROCESVERBAL` int(11) NOT NULL,
  `IDDIRECTEUR` int(11) DEFAULT NULL,
  `IDCLIENT` int(11) DEFAULT NULL,
  `DATEREMISE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `promesse`
--

CREATE TABLE `promesse` (
  `IDAPPARTEMENT` int(11) NOT NULL,
  `IDCLIENT` int(11) NOT NULL,
  `IDAVOCAT` int(11) DEFAULT NULL,
  `IDDIRECTEUR` int(11) DEFAULT NULL,
  `STATUT` tinyint(1) NOT NULL,
  `ISSIGNER` tinyint(1) NOT NULL,
  `DATESIGNATURE` date NOT NULL,
  `IDPROMESSE` int(11) NOT NULL,
  `PRIX_VENTE` float NOT NULL,
  `AVANCE` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `promesse`
--

INSERT INTO `promesse` (`IDAPPARTEMENT`, `IDCLIENT`, `IDAVOCAT`, `IDDIRECTEUR`, `STATUT`, `ISSIGNER`, `DATESIGNATURE`, `IDPROMESSE`, `PRIX_VENTE`, `AVANCE`) VALUES
(1, 1, 1, 1, 1, 1, '2023-01-10', 1, 200, 100),
(1, 1, 1, 1, 0, 0, '1970-01-01', 2, 300, 35),
(1, 1, 1, 1, 1, 0, '1970-01-01', 3, 200, 25);

-- --------------------------------------------------------

--
-- Structure de la table `societe`
--

CREATE TABLE `societe` (
  `IDSOCIETE` int(11) NOT NULL,
  `NOMSOCIETE` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `societe`
--

INSERT INTO `societe` (`IDSOCIETE`, `NOMSOCIETE`) VALUES
(0, ''),
(1, 'Kimmo');

-- --------------------------------------------------------

--
-- Structure de la table `visiter`
--

CREATE TABLE `visiter` (
  `IDAPPARTEMENT` int(11) NOT NULL,
  `IDCLIENT` int(11) NOT NULL,
  `DATEVISITE` date NOT NULL,
  `REMARQUES` text NOT NULL,
  `IDVISITER` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `visiter`
--

INSERT INTO `visiter` (`IDAPPARTEMENT`, `IDCLIENT`, `DATEVISITE`, `REMARQUES`, `IDVISITER`) VALUES
(1, 1, '2023-01-03', 'tres salle', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appartement`
--
ALTER TABLE `appartement`
  ADD PRIMARY KEY (`IDAPPARTEMENT`),
  ADD KEY `FK_RELATIONSHIP_7` (`IDIMMEUBLE`);

--
-- Index pour la table `avocat`
--
ALTER TABLE `avocat`
  ADD PRIMARY KEY (`IDAVOCAT`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`IDCLIENT`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`IDCONTRAT`),
  ADD UNIQUE KEY `IAVOCAT` (`IDCONTRAT`),
  ADD KEY `FK_RELATIONSHIP_11` (`IDDIRECTEUR`),
  ADD KEY `FK_RELATIONSHIP_12` (`IDCLIENT`),
  ADD KEY `FK_RELATIONSHIP_13` (`IDAPPARTEMENT`),
  ADD KEY `IDAVOCAT` (`IDAVOCAT`);

--
-- Index pour la table `desistement`
--
ALTER TABLE `desistement`
  ADD PRIMARY KEY (`IDDESISTEMENT`),
  ADD KEY `FK_RELATIONSHIP_10` (`IDPROMESSE`),
  ADD KEY `FK_RELATIONSHIP_16` (`IDDIRECTEUR`),
  ADD KEY `FK_RELATIONSHIP_17` (`IDCLIENT`),
  ADD KEY `FK_RELATIONSHIP_18` (`IDAVOCAT`),
  ADD KEY `IDAPPARTEMENT` (`IDAPPARTEMENT`);

--
-- Index pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD PRIMARY KEY (`IDDIRECTEUR`),
  ADD KEY `FK_ASSOCIATION_1` (`IDSOCIETE`);

--
-- Index pour la table `immeuble`
--
ALTER TABLE `immeuble`
  ADD PRIMARY KEY (`IDIMMEUBLE`),
  ADD KEY `FK_ASSOCIATION_2` (`IDSOCIETE`);

--
-- Index pour la table `procesverbal`
--
ALTER TABLE `procesverbal`
  ADD PRIMARY KEY (`IDPROCESVERBAL`),
  ADD KEY `FK_RELATIONSHIP_14` (`IDDIRECTEUR`),
  ADD KEY `FK_RELATIONSHIP_15` (`IDCLIENT`);

--
-- Index pour la table `promesse`
--
ALTER TABLE `promesse`
  ADD PRIMARY KEY (`IDPROMESSE`),
  ADD KEY `FK_PROMESSE` (`IDCLIENT`),
  ADD KEY `FK_PROMESSE2` (`IDAPPARTEMENT`),
  ADD KEY `FK_RELATIONSHIP_8` (`IDAVOCAT`),
  ADD KEY `FK_RELATIONSHIP_9` (`IDDIRECTEUR`);

--
-- Index pour la table `societe`
--
ALTER TABLE `societe`
  ADD PRIMARY KEY (`IDSOCIETE`);

--
-- Index pour la table `visiter`
--
ALTER TABLE `visiter`
  ADD PRIMARY KEY (`IDVISITER`),
  ADD KEY `FK_VISITER` (`IDCLIENT`),
  ADD KEY `FK_VISITER2` (`IDAPPARTEMENT`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartement`
--
ALTER TABLE `appartement`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`IDIMMEUBLE`) REFERENCES `immeuble` (`IDIMMEUBLE`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`IDDIRECTEUR`) REFERENCES `directeur` (`IDDIRECTEUR`),
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`IDCLIENT`) REFERENCES `client` (`IDCLIENT`),
  ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`IDAPPARTEMENT`) REFERENCES `appartement` (`IDAPPARTEMENT`),
  ADD CONSTRAINT `contrat_ibfk_1` FOREIGN KEY (`IDAVOCAT`) REFERENCES `avocat` (`IDAVOCAT`);

--
-- Contraintes pour la table `desistement`
--
ALTER TABLE `desistement`
  ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`IDPROMESSE`) REFERENCES `promesse` (`IDPROMESSE`),
  ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`IDDIRECTEUR`) REFERENCES `directeur` (`IDDIRECTEUR`),
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`IDCLIENT`) REFERENCES `client` (`IDCLIENT`),
  ADD CONSTRAINT `FK_RELATIONSHIP_18` FOREIGN KEY (`IDAVOCAT`) REFERENCES `avocat` (`IDAVOCAT`),
  ADD CONSTRAINT `desistement_ibfk_1` FOREIGN KEY (`IDAPPARTEMENT`) REFERENCES `appartement` (`IDAPPARTEMENT`);

--
-- Contraintes pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD CONSTRAINT `FK_ASSOCIATION_1` FOREIGN KEY (`IDSOCIETE`) REFERENCES `societe` (`IDSOCIETE`);

--
-- Contraintes pour la table `immeuble`
--
ALTER TABLE `immeuble`
  ADD CONSTRAINT `FK_ASSOCIATION_2` FOREIGN KEY (`IDSOCIETE`) REFERENCES `societe` (`IDSOCIETE`);

--
-- Contraintes pour la table `procesverbal`
--
ALTER TABLE `procesverbal`
  ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`IDDIRECTEUR`) REFERENCES `directeur` (`IDDIRECTEUR`),
  ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`IDCLIENT`) REFERENCES `client` (`IDCLIENT`);

--
-- Contraintes pour la table `promesse`
--
ALTER TABLE `promesse`
  ADD CONSTRAINT `FK_PROMESSE` FOREIGN KEY (`IDCLIENT`) REFERENCES `client` (`IDCLIENT`),
  ADD CONSTRAINT `FK_PROMESSE2` FOREIGN KEY (`IDAPPARTEMENT`) REFERENCES `appartement` (`IDAPPARTEMENT`),
  ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`IDAVOCAT`) REFERENCES `avocat` (`IDAVOCAT`),
  ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`IDDIRECTEUR`) REFERENCES `directeur` (`IDDIRECTEUR`);

--
-- Contraintes pour la table `visiter`
--
ALTER TABLE `visiter`
  ADD CONSTRAINT `FK_VISITER` FOREIGN KEY (`IDCLIENT`) REFERENCES `client` (`IDCLIENT`),
  ADD CONSTRAINT `FK_VISITER2` FOREIGN KEY (`IDAPPARTEMENT`) REFERENCES `appartement` (`IDAPPARTEMENT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
