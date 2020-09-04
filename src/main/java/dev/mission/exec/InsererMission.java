package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("insert")

//L'interface Runnable permet de ???
public class InsererMission implements Runnable {

	// On créer une instance de l'interface missionRepository afin de pouvoir
	// appeler les méthodes
	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 6");
		mission.setTauxJournalier(new BigDecimal("150.50"));
		mission.setDateDebut(LocalDate.of(2021, 7, 6));
		mission.setDateFin(LocalDate.of(2021, 7, 5));
		this.missionRepository.save(mission);
	}
}
