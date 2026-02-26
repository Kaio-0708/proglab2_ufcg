package PRO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AcademiaProController {
	
	private int id;
	private HashMap<String, Aluno> alunos;
	private HashMap<Integer, Treino> treinos;
	
	public AcademiaProController() {
		this.alunos = new HashMap<>();
		this.treinos = new HashMap<>();
		this.id = 0;
	}
	
	public boolean cadastrarAluno(String nome, String cpf) {
		Aluno aluno = new Aluno(nome, cpf);
		
		if(alunos.containsKey(cpf)) {
			throw new IllegalArgumentException("Aluno já cadastrado");
		}
		
		alunos.put(cpf, aluno);
		
		return true;
	}
	
	public String exibirAluno(String cpf) {
		Aluno aluno = alunos.get(cpf);
		
		if(aluno == null) {
			throw new IllegalArgumentException("Aluno não existe");
		}
		
		return aluno.toString();
	}
	
	public String[] listarAlunos() {
		List<Aluno> aluno = new ArrayList<>(alunos.values());
		
		aluno.sort((a1, a2) -> Integer.compare(a2.getPontuacao(), a1.getPontuacao()));
		
		String[] result = new String[aluno.size()];
		
		for(int i = 0;  i < aluno.size(); i++) {
			result[i] = aluno.get(i).getNome();
		}
		
		return result;
	}
	
	public int cadastrarTreinoCardio(String nome, int intensidade, int capacidade) {
		id ++;
		
		TreinoCardio treinoC = new TreinoCardio(nome, intensidade, capacidade);
	    treinos.put(id, treinoC);
	    
	    return id;
	}
	
	public int cadastrarTreinoMusculacao(String nome, int intensidade, int capacidade, int series) {
		id ++;
		
		TreinoMusculacao treinoM = new TreinoMusculacao(nome, intensidade, capacidade, series);
		treinos.put(id, treinoM);
		
		return id;
	}
	
	public int cadastrarTreinoFuncional(String nome, int intensidade, int capacidade, int duracao) {
		id ++;
		
		TreinoFuncional treinoF = new TreinoFuncional(nome, intensidade, capacidade, duracao);
		treinos.put(id, treinoF);
		
		return id;
	}
	
	public boolean inscreverAlunoEmTreino(String cpf, int idTreino) {
		Aluno aluno = alunos.get(cpf);
		
		if(aluno == null){
			throw new IllegalArgumentException("Aluno não cadastrado!");
		}
		
		Treino treino = treinos.get(idTreino);
		
		if(treino == null){
		    throw new IllegalArgumentException("Treino não encontrado!");
		}
		
		treino.inscreverAluno(aluno);
		
		return true;
	}
}
