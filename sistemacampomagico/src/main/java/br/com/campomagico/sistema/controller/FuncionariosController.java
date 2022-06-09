package br.com.campomagico.sistema.controller;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.campomagico.sistema.model.Funcionario;
import br.com.campomagico.sistema.repository.Funcionarios;

@Controller
@RequestMapping
public class FuncionariosController {

	private Funcionarios funcionariosRepository;
	
	public FuncionariosController (Funcionarios funcionariosRepository) {
		this.funcionariosRepository = funcionariosRepository;
	}
	
	@GetMapping("sistema/funcionarios")
	public String funcionarios(Model model) {
		model.addAttribute("listaFuncionarios", funcionariosRepository.findAll());
		
		return "/sistema/funcionarios/TelaFuncionarios";
	}
	
	@GetMapping("/sistema/funcionarios/novo")
	public String novoFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
	
		return "/sistema/funcionarios/FormFuncionarios";
	}
	
	@GetMapping("/sistema/funcionarios/{idfuncionario}")
	public String alterarFuncionario(@PathVariable("idfuncionario") Long idfuncionario, Model model) {
		Optional<Funcionario> funcionarioOpt = funcionariosRepository.findById(idfuncionario);
		if (!funcionarioOpt.isPresent()) {
			throw new IllegalArgumentException("Funcionário inválido.");
		}
		model.addAttribute("funcionario", funcionarioOpt.get());
		return "/sistema/funcionarios/FormFuncionarios";
	}
	
	@PostMapping("/sistema/funcionarios/salvar")
	public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
		funcionariosRepository.save(funcionario);
		return "redirect:/sistema/funcionarios";
	}
	
	@GetMapping("/sistema/funcionarios/excluir/{idfuncionario}")
	public String excluirFuncionario(@PathVariable("idfuncionario") Long idfuncionario) {
		Optional<Funcionario> funcionarioOpt = funcionariosRepository.findById(idfuncionario);
		if (funcionarioOpt.isEmpty()) {
			throw new IllegalArgumentException("Funcionário inválido.");
		}
		
		funcionariosRepository.delete(funcionarioOpt.get());
		return "redirect:/sistema/funcionarios";
		
	}
}
