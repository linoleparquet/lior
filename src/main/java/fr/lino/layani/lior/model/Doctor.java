package fr.lino.layani.lior.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Doctor {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
	private String name;
	private String surname;
	private String city;
	private int department;
	private int periodicity; // Entier compris entre 1 et 12. tout les frequency mois /ans
	private int lastVisitId;
	private LocalDate nextVisitDate;

	public Doctor(String name, String surname, String city, int department, int periodicity) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.department = department;
		this.periodicity = periodicity;
	}

	public Doctor() {
	}

}