package fr.lino.layani.lior.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lino.layani.lior.exception.VisitNotFoundException;
import fr.lino.layani.lior.model.Doctor;
import fr.lino.layani.lior.model.Visit;
import fr.lino.layani.lior.repository.VisitRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VisitController {

	@Autowired
	DoctorController doctorController;

	private final VisitRepository visitRepository;

	VisitController(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	// TO-DO: implement HATEOAS

	@GetMapping("/visits")
	public List<Visit> getAllVisit() {
		return visitRepository.findAll();
	}

	@GetMapping("/visit/{id}")
	public Visit getOneVisit(@PathVariable int id) {
		return visitRepository.findById(id).orElseThrow(() -> new VisitNotFoundException(id));

	}

	@PostMapping("/visit")
	public Visit postCreateNewVisit(@RequestBody Visit newVisit) {

		Doctor doctor = doctorController.getOneDoctor(newVisit.getDoctorId());
		Visit lastVisit = visitRepository.getOne(doctor.getLastVisitId());
		if (newVisit.getDate().isAfter(lastVisit.getDate())) {
			doctor.setLastVisitId(newVisit.getId());
			doctorController.putUpdateOneDoctor(doctor, doctor.getId());
		}
		return visitRepository.save(newVisit);
	}

	@PutMapping("/visit/{id}")
	public Visit putUpdateOneVisit(@RequestBody Visit updatedVisit, @PathVariable int id) {
		updatedVisit.setId(id);
		Visit actualVisit = visitRepository.findById(id).orElseThrow(() -> new VisitNotFoundException(id));

		// If change doctor
		if (updatedVisit.getDoctorId() != actualVisit.getDoctorId()) {
			Doctor oldDoctor = doctorController.getOneDoctor(actualVisit.getDoctorId());
			LocalDate oldDoctorLastVisit = getOneVisit(oldDoctor.getLastVisitId()).getDate();

			if (actualVisit.getDate().isEqual(oldDoctorLastVisit)) {
				getAllVisit().stream().filter(v -> v.getDoctorId() == oldDoctor.getId())
						.filter(v -> v.getDate().isBefore(oldDoctorLastVisit)).sorted().findFirst()
						.ifPresentOrElse(v -> oldDoctor.setLastVisitId(v.getId()), () -> oldDoctor.setLastVisitId(0));

				doctorController.putUpdateOneDoctor(oldDoctor, oldDoctor.getId());
			}
		}

		// If change date
		if (updatedVisit.getDate() != actualVisit.getDate()) {

		}

		actualVisit = updatedVisit;
		return visitRepository.save(actualVisit);
	}

	@DeleteMapping("/visit/{id}")
	public void deleteOneVisit(@PathVariable int id) {
		visitRepository.deleteById(id);
	}
}
