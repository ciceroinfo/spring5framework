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

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1");
		vet1.setLastName("Last Name");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2");
		vet2.setLastName("Last Name");

		vetService.save(vet2);
		
		Owner pamela = new Owner();
		pamela.setFirstName("Pamela");
		pamela.setLastName("Santos");
		pamela.setAddress("R. João das Cove, 175");
		pamela.setCity("Curitiba");
		pamela.setTelephone("4199999999");

		Pet pet1 = new Pet();
		pet1.setName("Mica");
		pet1.setOwner(pamela);
		pet1.setPetType(savedCatPetType);
		pet1.setBirthdate(LocalDate.now());
		pamela.getPets().add(pet1);
		
		petService.save(pet1);

		Pet pet2 = new Pet();
		pet2.setName("Lola");
		pet2.setOwner(pamela);
		pet2.setPetType(savedDogPetType);
		pet2.setBirthdate(LocalDate.now());
		pamela.getPets().add(pet2);
		
		petService.save(pet2);
		
		Owner cicero = new Owner();
		cicero.setFirstName("Cícero");
		cicero.setLastName("Fabio");
		cicero.setAddress("R. João das Cove, 175");
		cicero.setCity("Curitiba");
		cicero.setTelephone("4199999999");

		Pet pet3 = new Pet();
		pet3.setName("Cachorro");
		pet3.setOwner(cicero);
		pet3.setPetType(savedDogPetType);
		pet3.setBirthdate(LocalDate.now());
		cicero.getPets().add(pet3);
		
		petService.save(pet3);
		
		ownerService.save(pamela);
		ownerService.save(cicero);
	}

}
