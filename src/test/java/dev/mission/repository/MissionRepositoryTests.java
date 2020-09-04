package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
public class MissionRepositoryTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	MissionRepository missionRepository;

	@Transactional
	@Test
	void findByDateDebutGreaterThanEqual() {

		// TODO insérer des données avec `entityManager`

		Mission missionInsert = new Mission();
		missionInsert.setLibelle("Mission 1");
		missionInsert.setTauxJournalier(new BigDecimal("150.50"));
		missionInsert.setDateDebut(LocalDate.of(2021, 7, 6));
		missionInsert.setDateFin(LocalDate.of(2021, 7, 5));

		missionRepository.save(missionInsert);

		// TODO exécuter la requête

		List<Mission> listeRequête = missionRepository.listMissionavenir();

		// TODO vérifier le résultat

		assertThat(listeRequête).isNotEmpty();
	}

	@Transactional
	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		// TODO insérer des données avec `entityManager`

		Mission missionInsert = new Mission();
		missionInsert.setLibelle("Mission 1");
		missionInsert.setTauxJournalier(new BigDecimal("150.50"));
		missionInsert.setDateDebut(LocalDate.of(2021, 7, 6));
		missionInsert.setDateFin(LocalDate.of(2021, 7, 5));

		missionRepository.save(missionInsert);

		// TODO exécuter la requête

		List<Mission> listeRequête = missionRepository.listMissionAvenirEnFonctionDutaux(new BigDecimal(500));

		// TODO vérifier le résultat

		assertThat(listeRequête).isEmpty();
	}

}
