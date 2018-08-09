package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

	@RequestMapping({ "pets", "pets.html" })
	public String listPets() {
		return "pets";
	}
}
