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
import guru.springframework.services.PetTypeService;
import guru.springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		Owner pamela = new Owner();
		pamela.setFirstName("Pamela");
		pamela.setLastName("Santos");

		ownerService.save(pamela);

		Owner cicero = new Owner();
		cicero.setFirstName("Cícero");
		cicero.setLastName("Fabio");

		ownerService.save(cicero);

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1");
		vet1.setLastName("Last Name");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2");
		vet2.setLastName("Last Name");

		vetService.save(vet2);

		Pet pet1 = new Pet();
		pet1.setOwner(pamela);
		pet1.setPetType(savedCatPetType);
		pet1.setBirthdate(LocalDate.now());
		
		petService.save(pet1);

		Pet pet2 = new Pet();
		pet2.setOwner(pamela);
		pet2.setPetType(savedDogPetType);
		pet2.setBirthdate(LocalDate.now());
		
		petService.save(pet2);

		Pet pet3 = new Pet();
		pet3.setOwner(cicero);
		pet3.setPetType(savedDogPetType);
		pet3.setBirthdate(LocalDate.now());
		
		petService.save(pet3);
	}

}
