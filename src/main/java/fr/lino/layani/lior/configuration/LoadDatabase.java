package fr.lino.layani.lior.configuration;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.lino.layani.lior.model.Doctor;
import fr.lino.layani.lior.model.Visit;
import fr.lino.layani.lior.repository.DoctorRepository;
import fr.lino.layani.lior.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(DoctorRepository doctorRepository, VisitRepository visitRepository) {

		Doctor doctor1 = new Doctor("Didier", "Raoult", "Marseille", 13, 12);
		Doctor doctor2 = new Doctor("Dominique-Jean", "Larray", "Paris", 75, 1);

		Visit visit1 = new Visit(1, LocalDate.of(2000, Month.JANUARY, 2), "haha c'était super avec Didier");
		Visit visit2 = new Visit(2, LocalDate.now(),
				"Dominque Jean pas ouf ouf il parlait pas trop, peut être parcequ'il est mort jsp");

		return args -> {
			log.info("Loading Doctor Table");
			log.info("Preloading " + doctorRepository.save(doctor1));
			log.info("Preloading " + doctorRepository.save(doctor2));
			log.info("Loading Visit Table");
			log.info("Preloading " + visitRepository.save(visit1));
			log.info("Preloading " + visitRepository.save(visit2));

		};
	}
}
