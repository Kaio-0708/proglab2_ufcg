package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameFacilController {
	
	private HashMap<String, Jogador> jogadores;
	private HashMap<Integer, Torneio> torneios;
	private int idTorneio;
	
	public GameFacilController() {
		this.jogadores = new HashMap<>();
		this.torneios = new HashMap<>();
		this.idTorneio = 0;
	}
	
	public boolean cadastrarJogador(String nome, String email) {
		if(nome == null || email == null) {
			throw new IllegalArgumentException("Nome e e-mail não encontrados!");
		}
		
		Jogador jogador = new Jogador(nome, email);
		
		if(jogadores.containsKey(jogador.getEmail())) {
			throw new IllegalArgumentException("Jogador já cadastrado!");
		}
		
		jogadores.put(email, jogador);
		
		return true;
	}
	
	public String exibirJogador(String email) {
		Jogador jogador = jogadores.get(email);
		
		if(jogador == null) {
			throw new IllegalArgumentException("Jogador não encontrado!");
		}
		
		return jogador.toString();
	}
	
	public String[] listarJogadores() {
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		jogador.sort((j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));
		
		String[] lista = new String[jogador.size()];
		
		for(int i = 0; i < jogador.size(); i++) {
			lista[i] = jogador.get(i).getNome();
		}
		
		return lista;
	}
	
	public String[] listarJogadorNome() {
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		jogador.sort((j1, j2) -> j1.getNome().compareTo(j2.getNome()));
		
		String[] lista = new String[jogador.size()];
		
		for(int i = 0; i < jogador.size(); i++) {
			lista[i] = jogador.get(i).getNome();
		}
		
		return lista;
	}
	
	public String[] desempateListarJogador() {
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		jogador.sort((j1, j2) -> {int comparacao = Integer.compare(j2.getPontuacao(), j1.getPontuacao());
			if(comparacao != 0) {
				return comparacao;
			} else {
				return j1.getNome().compareTo(j2.getNome());
			}
		});
		
		String[] lista = new String[jogador.size()];
		
		for(int i = 0; i < jogador.size(); i++) {
			lista[i] = jogador.get(i).getNome();
		}
		
		return lista;
	}
	
	public int cadastrarDesafioRapido(String titulo, String descricao, String data, int maxParticipantes) {
		idTorneio ++;
		
		DesafioRapido desafio = new DesafioRapido(titulo, descricao, data, maxParticipantes);
		torneios.put(idTorneio, desafio);
		
		return idTorneio;
	}
	
	public int cadastrarCampeonato(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		idTorneio ++;
		
		Campeonato c = new Campeonato(titulo, descricao, data, maxParticipantes, duracao);		
		torneios.put(idTorneio, c);
		
		return idTorneio;
	}
	
	public int cadastrarMaratona(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean bonus) {
		idTorneio ++;
		
		Maratona m = new Maratona(titulo, descricao, data, maxParticipantes, duracao, bonus);
		torneios.put(idTorneio, m);
		
		return idTorneio;
	}
	
	public boolean inscreverJogadorEmTorneio(String emailJogador, int idTorneio) {
		Jogador jogador = jogadores.get(emailJogador);
		
		if(jogador == null) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}
		
		Torneio torneio = torneios.get(idTorneio);
		
		if(torneio == null) {
			throw new IllegalArgumentException("Torneio nulo");
		}
		
		torneio.inscreverJogador(jogador);
		
		return true;
	}
	
	public String exibirDetalhesTorneio(int idTorneio) {
		Torneio torneio = torneios.get(idTorneio);
		
		if(torneio == null) {
			throw new IllegalArgumentException("Torneio nulo");
		}
		
		return torneio.detalhes();
	}
}
