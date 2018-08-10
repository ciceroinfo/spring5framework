package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.VetService;

@RequestMapping({ "vets", "vets.html" })
@Controller
public class VetController {

	VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({ "", "/" })
	public String listVets(Model model) {

		model.addAttribute("vets", vetService.findAll());

		return "vets";
	}
}
