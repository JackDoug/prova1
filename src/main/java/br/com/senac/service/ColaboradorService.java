package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Colaborador;
import br.com.senac.repositorio.ColaboradorRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepositorio repocol;

	public Colaborador buscar(Integer id) {
		Optional<Colaborador> objColaborador = repocol.findById(id);
		try {
			return objColaborador.orElseThrow(() -> new ObjectNotFoundException(
					"Colaborador não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Colaborador inserir(Colaborador objColaborador) {
		objColaborador.setId(null);
		return repocol.save(objColaborador);
	}

	public Colaborador alterar(Colaborador objColaborador) {

		Colaborador objColaboradorEncontrado = buscar(objColaborador.getId());
		objColaboradorEncontrado.setNome(objColaborador.getNome());

		return repocol.save(objColaboradorEncontrado);
	}

	public void excluir(Integer id) {

		repocol.deleteById(id);
	}

	public List<Colaborador> listaColaboradores() {

		return repocol.findAll();
	}

}
