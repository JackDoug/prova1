package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Colaborador;
import br.com.senac.repositorio.ColaboradorRepositorio;



@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	
	
	@Autowired
	ColaboradorRepositorio colaboradorRepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		
		Colaborador colaborador1 = new Colaborador(null, "Jack");
		
		Colaborador colaborador2 = new Colaborador(null, "Marcelo");
		
		colaboradorRepositorio.saveAll(Arrays.asList(colaborador1, colaborador2));
		
	
		
	}
	
}