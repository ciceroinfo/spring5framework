package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.PetService;

@RequestMapping({ "pets", "pets.html" })
@Controller
public class PetController {

	PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}

	@RequestMapping({ "", "/" })
	public String listPets(Model model) {

		model.addAttribute("pets", petService.findAll());

		return "pets";
	}
}
