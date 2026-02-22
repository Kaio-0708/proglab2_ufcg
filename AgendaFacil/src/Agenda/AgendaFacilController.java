package Agenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AgendaFacilController {
	private HashMap<String, Estudante> estudantes;
	private HashMap<Integer, Evento> eventos;
	private int id;
	
	public AgendaFacilController() {
		this.estudantes = new HashMap<>();
		this.eventos = new HashMap<>();
		this.id = 0;
	}
	
	public boolean cadastrarEstudante(String nome, String email) {
		Estudante e = new Estudante(nome, email);
		
		if(estudantes.containsKey(email)) {
			throw new IllegalArgumentException("E-mail já existente no sistema!");
		}
		
		estudantes.put(email, e);
		return true;
	}
	
	public String exibirEstudante(String email) {
		Estudante e = estudantes.get(email);
		
		if(e == null) {
			throw new IllegalArgumentException("Estudante não encontrado!");
		}
		
		return e.toString();	
	}
	
	public String[] listarEstudantes() {
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		e.sort((e1, e2) -> Integer.compare(e2.getPontos(), e1.getPontos()));
		
		String[] lista = new String[e.size()];
		
		for(int i = 0; i < e.size(); i++) {
			lista[i] = e.get(i).getNome();;
		}
		
		return lista;
	}
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		id ++;
		
		Palestra palestra = new Palestra(titulo, descricao, data, maxParticipantes);		
		eventos.put(id, palestra);
		
		return id;
	}
	
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		id ++;
		
		Workshop workshop = new Workshop(titulo, descricao, data, maxParticipantes, duracao);
		eventos.put(id, workshop);
		
		return id;
	}
	
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		id ++;
		
		OficinaAprendizagem oficina = new OficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificado);
		eventos.put(id, oficina);
		
		return id;
	}
	
	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento) {
		Estudante e = estudantes.get(emailParticipante);
		
		if(e == null) {
			throw new IllegalArgumentException("Estudante não encontrado!");
		}
				
		if (!eventos.containsKey(idEvento)) {
		    throw new IllegalArgumentException("Evento não encontrado!");
		}
			
		Evento evento = eventos.get(idEvento);
		evento.inscreverParticipante(e);
		
		return true;
	}
	
	public String exibirDetalhesEvento(int idEvento) {
		Evento evento = eventos.get(idEvento);
		
		if(evento == null) {
			throw new IllegalArgumentException("Evento não encontrado!");
		}
		
		return evento.exibirDetalhes();
	}
}
