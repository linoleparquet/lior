package fr.lino.layani.lior.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lino.layani.lior.exception.DoctorNotFoundException;
import fr.lino.layani.lior.model.Doctor;
import fr.lino.layani.lior.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorController {

	private final DoctorRepository repo;

	DoctorController(DoctorRepository repo) {
		this.repo = repo;
	}
	// TO-DO: implement HATEOAS

	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor() {
		return repo.findAll();
	}

	@PostMapping("/doctor")
	public Doctor postCreateNewdoctor(@RequestBody Doctor newDoctor) {
		return repo.save(newDoctor);
	}

	@GetMapping("/doctor/{id}")
	public Doctor getOneDoctor(@PathVariable int id) {
		return repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));

	}

	@PutMapping("/doctor/{id}")
	public Doctor putUpdateOneDoctor(@RequestBody Doctor updatedDoctor, @PathVariable int id) {
		updatedDoctor.setId(id);
		Doctor doctor = repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
		doctor = updatedDoctor;
		return repo.save(doctor);
	}

	@DeleteMapping("/doctor/{id}")
	public void deleteOneDoctor(@PathVariable int id) {
		repo.deleteById(id);
	}
}
