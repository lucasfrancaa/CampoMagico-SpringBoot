package br.com.campomagico.sistema.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.campomagico.sistema.model.Cargo;
import br.com.campomagico.sistema.repository.Cargos;

@Controller
@RequestMapping
public class CargosController {

	private Cargos cargosRepository;
	
	public CargosController(Cargos cargosRepository) {
		this.cargosRepository = cargosRepository;
	}
	
	@GetMapping("sistema/index")
	public String telaInicial() {		
		return "/sistema/index";
	}
	
	@GetMapping("sistema/cargos")
	public String cargos(Model model) {
		model.addAttribute("listaCargos", cargosRepository.findAll());
		
		return "/sistema/cargos/TelaCargos";
	}
	
	@GetMapping("/sistema/cargos/novo")
	public String novoCargo(@ModelAttribute("cargo") Cargo cargo) {
	
		return "/sistema/cargos/form";
	}
	
	@GetMapping("/sistema/cargos/{idcargo}")
	public String alterarCargo(@PathVariable("idcargo") Long idcargo, Model model) {
		Optional<Cargo> cargoOpt = cargosRepository.findById(idcargo);
		if (!cargoOpt.isPresent()) {
			throw new IllegalArgumentException("Cargo inválido.");
		}
		model.addAttribute("cargo", cargoOpt.get());
		return "/sistema/cargos/form";
	}
	
	@PostMapping("/sistema/cargos/salvar")
	public String salvarCargo(@ModelAttribute("cargo") Cargo cargo) {
		cargosRepository.save(cargo);
		return "redirect:/sistema/cargos";
		
	}
	
	@GetMapping("/sistema/cargos/excluir/{idcargo}")
	public String excluirCargo(@PathVariable("idcargo") Long idcargo) {
		Optional<Cargo> cargoOpt = cargosRepository.findById(idcargo);
		if (cargoOpt.isEmpty()) {
			throw new IllegalArgumentException("Cargo inválido.");
		}
		
		cargosRepository.delete(cargoOpt.get());
		return "redirect:/sistema/cargos";
	}
}
