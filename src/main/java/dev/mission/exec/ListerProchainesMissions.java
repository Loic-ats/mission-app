package dev.mission.exec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerNext")
public class ListerProchainesMissions implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissions.class);

	// On créer une instance de l'interface missionRepository afin de pouvoir
	// appeler les méthodes
	private MissionRepository missionRepository;

	/*
	 * 
	 * On créer une instance static de la classe Logger pour afficher les
	 * information via les Log et non avec un system.out.println() Attention a
	 * importer les Log de slf4j...
	 * 
	 */

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		List<Mission> listeMissions = missionRepository.listMissionavenir();

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
