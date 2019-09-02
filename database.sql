-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 27 Juin 2019 à 12:43
-- Version du serveur :  5.7.26-0ubuntu0.18.04.1
-- Version de PHP :  7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `database`
--

-- --------------------------------------------------------

--
-- Structure de la table `appello`
--

CREATE TABLE `appello` (
  `id` int(11) NOT NULL,
  `aula` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `durata` double NOT NULL,
  `docente_matricola` int(11) DEFAULT NULL,
  `insegnamento_codice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `appello`
--

INSERT INTO `appello` (`id`, `aula`, `date`, `description`, `durata`, `docente_matricola`, `insegnamento_codice`) VALUES
(1, 'A1', '2019-02-22 00:00:00', 'Orale', 2, 2, 1),
(2, 'A2', '2019-02-22 00:00:00', 'Progetto con presentazione', 2, 2, 2),
(3, 'A3', '2019-02-15 00:00:00', 'Esame scritto ', 2, 2, 3),
(4, 'A4', '2019-02-28 00:00:00', 'Scritto', 3, 2, 4),
(5, 'A1', '2019-02-28 00:00:00', 'Esame Scritto', 2, 2, 1),
(6, 'A6', '2019-03-05 00:00:00', 'Orale', 2, 2, 2),
(7, 'Ab', '2019-06-21 00:00:00', 'aaaaa', 1, 2, 1),
(8, '', '2019-06-21 00:00:00', 'aaaaa', 1, 2, 1),
(9, 'aa', '2019-06-15 00:00:00', 'fhemt ?', 15, 2, 2),
(10, '2ga', '2019-06-14 00:00:00', 'Esame Orale', 2.3, 2, 1),
(11, 'E2', '2019-07-19 00:00:00', 'scritto', 2.3, 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `corsodistudio`
--

CREATE TABLE `corsodistudio` (
  `codice` int(11) NOT NULL,
  `annoScolastico` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `corsodistudio`
--

INSERT INTO `corsodistudio` (`codice`, `annoScolastico`, `nome`) VALUES
(1, '2019-02-06 00:00:00', 'IngInformatica'),
(2, '2019-02-08 00:00:00', 'IngMeccanica');

-- --------------------------------------------------------

--
-- Structure de la table `insegnamento`
--

CREATE TABLE `insegnamento` (
  `codice` int(11) NOT NULL,
  `annoDiStudi` varchar(255) DEFAULT NULL,
  `cfu` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `corsoDiStudio_codice` int(11) DEFAULT NULL,
  `pianoDiStudio_id` int(11) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `insegnamento`
--

INSERT INTO `insegnamento` (`codice`, `annoDiStudi`, `cfu`, `description`, `nome`, `corsoDiStudio_codice`, `pianoDiStudio_id`, `sistema_id`) VALUES
(1, 'T1', 9, 'xxxxxxx ', 'Fisica', 1, NULL, NULL),
(2, 'T3', 12, 'xxxxxxx', 'Automazione', 1, NULL, NULL),
(3, 'T2', 12, 'zzzzzzz', 'Informatica', 2, NULL, NULL),
(4, 'T1', 6, 'yyyyyyyy ', 'Analisi', 2, NULL, NULL),
(5, 'T1', 15, 'aa', 'aa', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `insegnamento_utente`
--

CREATE TABLE `insegnamento_utente` (
  `listInsegnamento_codice` int(11) NOT NULL,
  `listUtente_matricola` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `insegnamento_utente`
--

INSERT INTO `insegnamento_utente` (`listInsegnamento_codice`, `listUtente_matricola`) VALUES
(1, 1),
(3, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `pianodistudio`
--

CREATE TABLE `pianodistudio` (
  `id` int(11) NOT NULL,
  `annoScolastico` datetime DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pianodistudio`
--

INSERT INTO `pianodistudio` (`id`, `annoScolastico`, `tipo`, `sistema_id`) VALUES
(1, '2019-06-17 00:00:00', 'aa', 1);

-- --------------------------------------------------------

--
-- Structure de la table `prenotazione`
--

CREATE TABLE `prenotazione` (
  `id` int(11) NOT NULL,
  `idAppello` int(11) NOT NULL,
  `idStudente` int(11) NOT NULL,
  `voto` int(11) NOT NULL,
  `stato` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `prenotazione`
--

INSERT INTO `prenotazione` (`id`, `idAppello`, `idStudente`, `voto`, `stato`) VALUES
(1, 1, 1, 25, 'Accettato'),
(2, 4, 1, 29, 'Rifiutato'),
(3, 2, 1, 16, 'Rifiutato'),
(4, 9, 1, 15, 'Rifiutato'),
(5, 8, 1, -1, 'Rifiutato'),
(6, 11, 1, -1, 'In Corso');

-- --------------------------------------------------------

--
-- Structure de la table `sistema`
--

CREATE TABLE `sistema` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sistema`
--

INSERT INTO `sistema` (`id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `utente`
--

CREATE TABLE `utente` (
  `DTYPE` varchar(31) NOT NULL,
  `matricola` int(11) NOT NULL,
  `cellulare` int(11) NOT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `annoSt` varchar(255) DEFAULT NULL,
  `sistema_id` int(11) DEFAULT NULL,
  `corsoDiStudio_codice` int(11) DEFAULT NULL,
  `pianoDiStudio_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utente`
--

INSERT INTO `utente` (`DTYPE`, `matricola`, `cellulare`, `cognome`, `email`, `indirizzo`, `nome`, `password`, `annoSt`, `sistema_id`, `corsoDiStudio_codice`, `pianoDiStudio_id`) VALUES
('', 1, 20054879, 'Rebhi', 'asmarebhi@gmail.com', 'xxxxx', 'Asma', 'asma', 'T1', NULL, NULL, NULL),
('', 2, 12, 'azaz', 'jj', 'jj', 'jj', 'jj', NULL, NULL, NULL, NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `appello`
--
ALTER TABLE `appello`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpuwauoiobuxe27eqge1kyjlf6` (`docente_matricola`),
  ADD KEY `FKkdpwqru9p2b7t855aryb90lqh` (`insegnamento_codice`);

--
-- Index pour la table `corsodistudio`
--
ALTER TABLE `corsodistudio`
  ADD PRIMARY KEY (`codice`);

--
-- Index pour la table `insegnamento`
--
ALTER TABLE `insegnamento`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `FKhdlj057idoj542lifkuw03hcv` (`corsoDiStudio_codice`),
  ADD KEY `FK2fwum5pcb4h1gputp88oqwhq2` (`pianoDiStudio_id`),
  ADD KEY `FK3fdv0nvks2pj8mkvh3k8qk36t` (`sistema_id`);

--
-- Index pour la table `insegnamento_utente`
--
ALTER TABLE `insegnamento_utente`
  ADD KEY `FKfx2ewo2528w0aonkqagu5h3h5` (`listUtente_matricola`),
  ADD KEY `FKkei3bid7o5kxgthx66coyw955` (`listInsegnamento_codice`);

--
-- Index pour la table `pianodistudio`
--
ALTER TABLE `pianodistudio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4k59nmlvbvb8incfax73cwpsp` (`sistema_id`);

--
-- Index pour la table `prenotazione`
--
ALTER TABLE `prenotazione`
  ADD PRIMARY KEY (`id`,`idAppello`,`idStudente`),
  ADD KEY `FKemq7pfewsookfnep56aq16a4d` (`idAppello`),
  ADD KEY `FKoa29pxv58twecbkn3p90j1mwg` (`idStudente`);

--
-- Index pour la table `sistema`
--
ALTER TABLE `sistema`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`matricola`),
  ADD KEY `FKj7hi0s4d1jdoh8thd1xmncrgi` (`sistema_id`),
  ADD KEY `FK7l0uewte3a9nl23sulv6b55ae` (`corsoDiStudio_codice`),
  ADD KEY `FKrkjuus1iq637v6ygrjkiqad3c` (`pianoDiStudio_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `appello`
--
ALTER TABLE `appello`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `corsodistudio`
--
ALTER TABLE `corsodistudio`
  MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `insegnamento`
--
ALTER TABLE `insegnamento`
  MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `pianodistudio`
--
ALTER TABLE `pianodistudio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `prenotazione`
--
ALTER TABLE `prenotazione`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `sistema`
--
ALTER TABLE `sistema`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `utente`
--
ALTER TABLE `utente`
  MODIFY `matricola` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appello`
--
ALTER TABLE `appello`
  ADD CONSTRAINT `FKkdpwqru9p2b7t855aryb90lqh` FOREIGN KEY (`insegnamento_codice`) REFERENCES `insegnamento` (`codice`),
  ADD CONSTRAINT `FKpuwauoiobuxe27eqge1kyjlf6` FOREIGN KEY (`docente_matricola`) REFERENCES `utente` (`matricola`);

--
-- Contraintes pour la table `insegnamento`
--
ALTER TABLE `insegnamento`
  ADD CONSTRAINT `FK2fwum5pcb4h1gputp88oqwhq2` FOREIGN KEY (`pianoDiStudio_id`) REFERENCES `pianodistudio` (`id`),
  ADD CONSTRAINT `FK3fdv0nvks2pj8mkvh3k8qk36t` FOREIGN KEY (`sistema_id`) REFERENCES `sistema` (`id`),
  ADD CONSTRAINT `FKhdlj057idoj542lifkuw03hcv` FOREIGN KEY (`corsoDiStudio_codice`) REFERENCES `corsodistudio` (`codice`);

--
-- Contraintes pour la table `insegnamento_utente`
--
ALTER TABLE `insegnamento_utente`
  ADD CONSTRAINT `FKfx2ewo2528w0aonkqagu5h3h5` FOREIGN KEY (`listUtente_matricola`) REFERENCES `utente` (`matricola`),
  ADD CONSTRAINT `FKkei3bid7o5kxgthx66coyw955` FOREIGN KEY (`listInsegnamento_codice`) REFERENCES `insegnamento` (`codice`);

--
-- Contraintes pour la table `pianodistudio`
--
ALTER TABLE `pianodistudio`
  ADD CONSTRAINT `FK4k59nmlvbvb8incfax73cwpsp` FOREIGN KEY (`sistema_id`) REFERENCES `sistema` (`id`);

--
-- Contraintes pour la table `prenotazione`
--
ALTER TABLE `prenotazione`
  ADD CONSTRAINT `FKemq7pfewsookfnep56aq16a4d` FOREIGN KEY (`idAppello`) REFERENCES `appello` (`id`),
  ADD CONSTRAINT `FKoa29pxv58twecbkn3p90j1mwg` FOREIGN KEY (`idStudente`) REFERENCES `utente` (`matricola`);

--
-- Contraintes pour la table `utente`
--
ALTER TABLE `utente`
  ADD CONSTRAINT `FK7l0uewte3a9nl23sulv6b55ae` FOREIGN KEY (`corsoDiStudio_codice`) REFERENCES `corsodistudio` (`codice`),
  ADD CONSTRAINT `FKj7hi0s4d1jdoh8thd1xmncrgi` FOREIGN KEY (`sistema_id`) REFERENCES `sistema` (`id`),
  ADD CONSTRAINT `FKrkjuus1iq637v6ygrjkiqad3c` FOREIGN KEY (`pianoDiStudio_id`) REFERENCES `pianodistudio` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
