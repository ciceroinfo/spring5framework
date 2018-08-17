package guru.springframework.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Speciality;
import guru.springframework.model.Vet;
import guru.springframework.model.Visit;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.PetTypeService;
import guru.springframework.services.SpecialityService;
import guru.springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService,
			PetTypeService petTypeService, SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {

		System.out.println("Init loadData...");

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality syrgery = new Speciality();
		syrgery.setDescription("Syrgery");
		Speciality savedSurgery = specialityService.save(syrgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentisty = specialityService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1");
		vet1.setLastName("Last Name");
		vet1.getSpecialities().add(savedRadiology);
		vet1.getSpecialities().add(savedDentisty);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2");
		vet2.setLastName("Last Name");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		Owner pamela = new Owner();
		pamela.setFirstName("Pamela");
		pamela.setLastName("Santos");
		pamela.setAddress("R. João das Cove, 175");
		pamela.setCity("Curitiba");
		pamela.setTelephone("4199999999");

		Owner savedPamela = ownerService.save(pamela);

		Pet mica = new Pet();
		mica.setName("Mica");
		mica.setOwner(savedPamela);
		mica.setPetType(savedCatPetType);
		mica.setBirthdate(LocalDate.now());
		Pet savedCatMica = petService.save(mica);

		pamela.getPets().add(savedCatMica);
		ownerService.save(pamela);

		Pet lola = new Pet();
		lola.setName("Lola");
		lola.setOwner(savedPamela);
		lola.setPetType(savedDogPetType);
		lola.setBirthdate(LocalDate.now());
		Pet savedLola = petService.save(lola);

		pamela.getPets().add(savedLola);
		ownerService.save(pamela);

		Owner cicero = new Owner();
		cicero.setFirstName("Cícero");
		cicero.setLastName("Fabio");
		cicero.setAddress("R. João das Cove, 175");
		cicero.setCity("Curitiba");
		cicero.setTelephone("4199999999");
		Owner savedCicero = ownerService.save(cicero);

		Pet cachorro = new Pet();
		cachorro.setName("Cachorro");
		cachorro.setOwner(savedCicero);
		cachorro.setPetType(savedDogPetType);
		cachorro.setBirthdate(LocalDate.now());
		Pet savedCachoro = petService.save(cachorro);

		cicero.getPets().add(savedCachoro);
		ownerService.save(cicero);

		Visit catVisit = new Visit();
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("cat visit");
		catVisit.setPet(savedCatMica);

		System.out.println("End loadData...");
	}

}
