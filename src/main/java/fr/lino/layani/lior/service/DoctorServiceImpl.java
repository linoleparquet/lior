package fr.lino.layani.lior.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lino.layani.lior.exception.DoctorNotFoundException;
import fr.lino.layani.lior.model.Doctor;
import fr.lino.layani.lior.repository.DoctorRepository;

@Service(value = "doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository repo;

	@Override
	public List<Doctor> getAllDoctor() {
		return repo.findAll();
	}

	@Override
	public Doctor postCreateNewDoctor(Doctor newDoctor) {
		return repo.save(newDoctor);
	}

	@Override
	public Doctor getOneDoctor(int id) {
		return repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
	}

	@Override
	public Doctor putUpdateOneDoctor(Doctor doctor, int id) {
		doctor.setId(id);
		return repo.save(doctor);
	}

	@Override
	public void deleteOneDoctor(int id) {
		repo.deleteById(id);
	}

}
