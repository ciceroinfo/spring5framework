package guru.springframework.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private String description;
	private Pet pets;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPets() {
		return pets;
	}

	public void setPets(Pet pets) {
		this.pets = pets;
	}

}
