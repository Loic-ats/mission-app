package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerNextAvecTaux")
public class ListerProchainesMissionsParTJM implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissionsParTJM.class);

	private MissionRepository missionRepository;

	// Constructeur qui prend en parametre missionRepository

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {

		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		// Il faut mettre des String au bigDecimal pour qu'il soit précis et pas un
		// double ou int...

		List<Mission> listeMissions = missionRepository.listMissionAvenirEnFonctionDutaux(new BigDecimal("100"));

		if (listeMissions.isEmpty()) {

			LOG.warn("Il n'y a pas de mission à venir...");

		} else {

			for (Mission mission : listeMissions) {

				LOG.info("Id={} Libelle={} DateDebut={} DateFin={} TauxJournalier={}", mission.getId(),
						mission.getLibelle(), mission.getDateDebut(), mission.getDateFin(),
						mission.getTauxJournalier());

			}
		}

	}
}
