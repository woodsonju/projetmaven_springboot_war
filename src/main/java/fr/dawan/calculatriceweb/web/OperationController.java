package fr.dawan.calculatriceweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.calculatrice.Operation;
import fr.dawan.calculatriceweb.validation.CalculForm;
import jakarta.validation.Valid;

@Controller
public class OperationController {

	@GetMapping("/calculatrice")
	public String calculatrice(Model model) {
		model.addAttribute("calculForm", new CalculForm());
		return "calculatrice";
	}

	@PostMapping("/calculatrice")
	public String effectuerCalcul(@Valid @ModelAttribute("calculForm") CalculForm calculForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			// Le formulaire n'est pas valide, réaffichez-le avec des messages d'erreur
			return "calculatrice";
		}

		double somme = Operation.calculerSomme(calculForm.getNombre1(), calculForm.getNombre2());
		double produit = Operation.calculerProduit(calculForm.getNombre1(), calculForm.getNombre2());
		double soustraction = Operation.calculerSoustraction(calculForm.getNombre1(), calculForm.getNombre2());

		try {
			double division = Operation.calculerDivision(calculForm.getNombre1(), calculForm.getNombre2());
			// Ajoutez le résultat au modèle
			model.addAttribute("division", division);
		} catch (ArithmeticException e) {
			// Gérez l'exception ici, par exemple en ajoutant un message d'erreur au modèle
			model.addAttribute("divisionParZeroMessage", "Division par zéro impossible.");
		}

		// Ajoutez les résultats au modèle
		model.addAttribute("somme", somme);
		model.addAttribute("produit", produit);
		model.addAttribute("soustraction", soustraction);

		return "calculatrice";
	}
}
