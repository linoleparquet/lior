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
		Doctor doctor3 = new Doctor("Martine", "Aubry", "Zombie-Land", 7, 1);
		Doctor doctor4 = new Doctor("Richard", "Coeur de Lion", "Angleterre", 8, 1);
		Doctor doctor5 = new Doctor("Domagio", "Le Fromagio", "Toulouse", 31, 1);
		Doctor doctor6 = new Doctor("Michemline", "Autant", "Rouen", 75, 1);
		Doctor doctor7 = new Doctor("Yves", "Remort", "Ababa", 12, 1);

		Visit visit1 = new Visit(1, LocalDate.of(2000, Month.JANUARY, 2), "haha c'était super avec Didier");
		Visit visit2 = new Visit(2, LocalDate.now(),
				"Dominque Jean pas ouf ouf il parlait pas trop, peut être parcequ'il est mort jsp");
		Visit visit3 = new Visit(1, LocalDate.of(2020, Month.JANUARY, 2), "Dider la famille j'l'adore trop !!!!!!");
		Visit visit4 = new Visit(3, LocalDate.of(2020, Month.MAY, 2),
				"Martinneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Visit visit5 = new Visit(1, LocalDate.of(2020, Month.MAY, 20), "Toujours pas remède contre le coronavirus?");
		Visit visit6 = new Visit(4, LocalDate.of(2020, Month.FEBRUARY, 2),
				"Lorem ipsum dolor sit amet consectetur adipisicing elit. veniam a. Dolor, at assumenda provident fugiat quod, delectus atque accusamus aliquid consequatur hic adipisci dignissimos minus molestiae maxime.");
		Visit visit7 = new Visit(5, LocalDate.of(2020, Month.MARCH, 7),
				"Lorem ipsum dolor sit amet consectetur adipisicing elit. veniam a. Dolor, at assumenda provident fugiat quod, delectus atque accusamus aliquid consequatur hic adipisci dignissimos minus molestiae maxime.");
		Visit visit8 = new Visit(6, LocalDate.of(2020, Month.JANUARY, 28),
				"Lorem ipsum dolor sit amet consectetur adipisicing elit. veniam a. Dolor, at assumenda provident fugiat quod, delectus atque accusamus aliquid consequatur hic adipisci dignissimos minus molestiae maxime.");
		Visit visit9 = new Visit(6, LocalDate.of(2020, Month.MARCH, 9),
				"Lorem ipsum dolor sit amet consectetur adipisicing elit. veniam a. Dolor, at assumenda provident fugiat quod, delectus atque accusamus aliquid consequatur hic adipisci dignissimos minus molestiae maxime.");
		Visit visit10 = new Visit(5, LocalDate.of(2020, Month.APRIL, 15),
				"Lorem ipsum dolor sit amet consectetur adipisicing elit. veniam a. Dolor, at assumenda provident fugiat quod, delectus atque accusamus aliquid consequatur hic adipisci dignissimos minus molestiae maxime.");

		return args -> {
//			log.info("Loading Doctor Table");
//			log.info("Preloading " + doctorRepository.save(doctor1));
//			log.info("Preloading " + doctorRepository.save(doctor2));
//			log.info("Preloading " + doctorRepository.save(doctor3));
//			log.info("Preloading " + doctorRepository.save(doctor4));
//			log.info("Preloading " + doctorRepository.save(doctor5));
//			log.info("Preloading " + doctorRepository.save(doctor6));
//			log.info("Preloading " + doctorRepository.save(doctor7));
//
//			log.info("Loading Visit Table");
//			log.info("Preloading " + visitRepository.save(visit1));
//			log.info("Preloading " + visitRepository.save(visit2));
//			log.info("Preloading " + visitRepository.save(visit3));
//			log.info("Preloading " + visitRepository.save(visit4));
//			log.info("Preloading " + visitRepository.save(visit5));
//			log.info("Preloading " + visitRepository.save(visit6));
//			log.info("Preloading " + visitRepository.save(visit7));
//			log.info("Preloading " + visitRepository.save(visit8));
//			log.info("Preloading " + visitRepository.save(visit9));
//			log.info("Preloading " + visitRepository.save(visit10));

		};
	}
}
