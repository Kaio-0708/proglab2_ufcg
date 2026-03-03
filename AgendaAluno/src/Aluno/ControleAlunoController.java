package Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControleAlunoController {
	
	private HashMap<String, Estudante> estudantes;
	private HashMap<Integer, Turma> turmas;
	private int idTurma;
	
	public ControleAlunoController() {
		this.estudantes = new HashMap<>();
		this.turmas = new HashMap<>();
		this.idTurma = 0;
	}
	
	public boolean cadastrarEstudante(String nome, String email) {
		Estudante estudante = new Estudante(nome, email);
		
		if(estudantes.containsKey(estudante.getEmail())) {
			throw new IllegalArgumentException("E-mail já cadastrado");
		}
		
		estudantes.put(email, estudante);
		
		return true;
	}
	
	public String exibirEstudante(String email) {
		Estudante estudante = estudantes.get(email);
		
		if(estudante == null) {
			throw new IllegalArgumentException("Estudante não encontrado");
		}
		
		return estudante.toString();
	}
	
	public String[] listarEstudantes() {
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		e.sort((e1, e2) -> Integer.compare(e2.getPontos(), e1.getPontos()));
		
		String[] lista = new String[e.size()];
		
		for(int i = 0; i < e.size(); i++) {
			lista[i] = e.get(i).getNome();
		}
		
		return lista;
	}
	
	public String[] listarEstudanteOrdemCrescente() {
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		e.sort((e1, e2) -> Integer.compare(e1.getPontos(), e2.getPontos()));
		
		String[] lista = new String[e.size()];
		
		for(int i = 0; i < e.size(); i++) {
			lista[i] = e.get(i).getNome();
		}
		
		return lista;
	}
	
	public String[] listarEstudanteNome() {
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		e.sort((e1, e2) -> e1.getNome().compareTo(e2.getNome()));
		
		String[] lista = new String[e.size()];
		
		for(int i = 0; i < e.size(); i++) {
			lista[i] = e.get(i).getNome();
		}
		
		return lista;	
	}
	
	public String[] listarEstudanteEmail() {
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		e.sort((e1, e2) -> e1.getEmail().compareTo(e2.getEmail()));
		
		String[] lista = new String[e.size()];
		
		for(int i = 0; i < e.size(); i++) {
			lista[i] = e.get(i).getNome();
		}
		
		return lista;
	}
	
	public int cadastrarComputacao(String titulo, String descricao, String data, int maxParticipantes) {
		idTurma ++;
		
		Computacao c = new Computacao(titulo, descricao, data, maxParticipantes);
		
		turmas.put(idTurma, c);
		
		return idTurma;
	}
	
	public int cadastrarInformatica(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		idTurma ++;
		
		Informatica i = new Informatica(titulo, descricao, data, maxParticipantes, duracao);
		
		turmas.put(idTurma, i);
		
		return idTurma;
	}
	
	public int cadastrarEletrica(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		idTurma ++;
		
		Eletrica e = new Eletrica(titulo, descricao, data, maxParticipantes, duracao, certificacao);
		
		turmas.put(idTurma, e);
		
		return idTurma;
	}
	
	public boolean inscreverEstudanteEmTurma(String emailParticipante, int idTurma) {
		Estudante e = estudantes.get(emailParticipante);
		
		if(e == null) {
			throw new IllegalArgumentException("Estudando não encontrado!");
		}
		
		Turma t = turmas.get(idTurma);
		
		if(t == null) {
			throw new IllegalArgumentException("Turma não encontrada");
		}
		
		t.matricularEstudante(e);
		
		return true;
	}
	
	public String exibirDetalhesTurma(int idTurma) {
		Turma t = turmas.get(idTurma);
		
		return t.exibirDetalhes();
	}
}
