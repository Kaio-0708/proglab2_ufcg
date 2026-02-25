package Academia;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class EsporteFacilController{
	
	private HashMap<String, Atleta> atletas;
	private HashMap<Integer, Atividade> atividades;
	private int id;
	
	public EsporteFacilController() {
		this.atletas = new HashMap<>();
		this.atividades = new HashMap<>();
		this.id = 0;
	}
	
	public boolean cadastrarAtleta(String nome, String email) {
		Atleta atleta = new Atleta(nome, email);
		
		if(atletas.containsKey(atleta.getEmail())) {
			throw new IllegalArgumentException("Atleta já cadastrado!");
		}
		
		atletas.put(email, atleta);
		return true;
	}
	
	public String exibirAtleta(String email) {
		Atleta atleta = atletas.get(email);
		
		if(atleta == null) {
			throw new IllegalArgumentException("Atleta está nulo!");
		}
		
		return atleta.toString();
	}
	
	public String[] listarAtletas() {
		List<Atleta> atleta = new ArrayList<>(atletas.values());
		
		atleta.sort((a1, a2) -> Integer.compare(a2.getPontuacao(), a1.getPontuacao()));
		
		String[] lista = new String[atleta.size()];
		
		for(int i = 0; i < atleta.size(); i++) {
			lista[i] = atleta.get(i).getNome();
		}
		
		return lista;
	}
	
	public int cadastrarTreino(String titulo, String descricao, String data, int maxParticipantes) {
		id ++;
		
		Treino treino = new Treino(titulo, descricao, data, maxParticipantes);
		
		atividades.put(id, treino);
		
		return id;
	}
	
	public int cadastrarCampeonato(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		id ++;
		
		Campeonato campeonato = new Campeonato(titulo, descricao, data, maxParticipantes, duracao);
		
		atividades.put(id, campeonato);
		
		return id;
	}
	
	public int cadastrarWorkshopTecnico(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		id ++;
		
		Workshop workshop = new Workshop(titulo, descricao, data, maxParticipantes, duracao, certificado);
			
		atividades.put(id, workshop);
		
		return id;
	}
	
	public boolean inscreverAtletaEmAtividade(String emailAtleta, int idAtividade) {
		Atleta atleta = atletas.get(emailAtleta);
		
		if(atleta == null) {
			throw new IllegalArgumentException("Atleta não cadastrado");
		}
		
		Atividade atividade = atividades.get(idAtividade);
		atividade.inscreverAtleta(atleta);
		
		return true;
	}
	
	public String exibirDetalhesAtividade(int idAtividade) {
		Atividade atividade = atividades.get(idAtividade);
		
		if(atividades == null) {
			throw new IllegalArgumentException("Atividade não cadastrada");
		}
		
		return atividade.toString();
	}
}
