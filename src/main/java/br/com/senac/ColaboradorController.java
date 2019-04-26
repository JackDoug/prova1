package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Colaborador;
import br.com.senac.service.ColaboradorService;

@Controller
@RequestMapping("/Colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping("/listar")
	public ModelAndView listaColaboradores() {
		ModelAndView mv = new ModelAndView("/colaborador/paginaColaboradores");
		mv.addObject("colaboradores", colaboradorService.listaColaboradores());
		return mv;
	}

	@GetMapping("/adicionar")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("/colaborador/paginaAdicionar");
		mv.addObject("colaborador", new Colaborador());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView inserir(Colaborador colaborador) {
		colaboradorService.inserir(colaborador);
		return listaColaboradores();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		colaboradorService.excluir(id);

		return listaColaboradores();
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("colaborador/paginaAlterar");
		mv.addObject("colaborador", colaboradorService.buscar(id));
		return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Colaborador colaborador) {
		colaboradorService.alterar(colaborador);
		return listaColaboradores();
	}

}