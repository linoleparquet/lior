package fr.lino.layani.lior.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Visit implements Comparable<Visit> {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
	private int doctorId;
	private LocalDate date;
	private String note;

	public Visit(int doctorId, LocalDate date, String note) {
		super();
		this.doctorId = doctorId;
		this.date = date;
		this.note = note;
	}

	public Visit() {
	}

	@Override
	public int compareTo(Visit o) {
		return this.getDate().compareTo(o.getDate());
	}
}
