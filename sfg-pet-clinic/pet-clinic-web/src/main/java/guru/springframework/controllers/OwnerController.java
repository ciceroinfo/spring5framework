package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.OwnerService;

@RequestMapping({ "owners", "owners.html" })
@Controller
public class OwnerController {

	OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/" })
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());

		return "owners";
	}
}
