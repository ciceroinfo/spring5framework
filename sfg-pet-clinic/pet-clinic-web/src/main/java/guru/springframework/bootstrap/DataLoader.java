package guru.springframework.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setFirstName("Pamela");
		owner1.setLastName("Santos");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Cícero");
		owner2.setLastName("Fabio");

		ownerService.save(owner2);

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1");
		vet1.setLastName("Last Name");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2");
		vet2.setLastName("Last Name");

		vetService.save(vet2);

		PetType petType1 = new PetType();
		petType1.setId(1L);
		petType1.setName("Cat");

		PetType petType2 = new PetType();
		petType2.setId(2L);
		petType2.setName("Dog");

		Pet pet1 = new Pet();
		pet1.setOwner(owner1);
		pet1.setPetType(petType1);
		pet1.setBirthdate(LocalDate.now());
		
		petService.save(pet1);

		Pet pet2 = new Pet();
		pet2.setOwner(owner1);
		pet2.setPetType(petType2);
		pet2.setBirthdate(LocalDate.now());
		
		petService.save(pet2);

		Pet pet3 = new Pet();
		pet3.setOwner(owner2);
		pet3.setPetType(petType2);
		pet3.setBirthdate(LocalDate.now());
		
		petService.save(pet3);
	}

}
