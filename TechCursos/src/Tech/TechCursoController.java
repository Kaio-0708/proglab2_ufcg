package Tech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TechCursoController {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<Integer, Curso> cursos;
	private int idCurso;
	
	public TechCursoController() {
		this.alunos = new HashMap<>();
		this.cursos = new HashMap<>();
		this.idCurso = 0;
	}
	
	public boolean cadastrarAluno(String nome, String matricula) {
		Aluno aluno = new Aluno(nome, matricula);
		
		if(alunos.containsKey(aluno.getMatricula())) {
			throw new IllegalArgumentException("Aluno já cadastrado!");
		}
		
		alunos.put(matricula, aluno);
		
		return true;
	}
	
	public String exibirAluno(String matricula) {
		Aluno aluno = alunos.get(matricula);
		
		if(aluno == null) {
			throw new IllegalArgumentException("Aluno não encontrado!");
		}
		
		return aluno.toString();
	}
	
	public String[] listarAlunos() {
		List<Aluno> aluno = new ArrayList<>(alunos.values());
		
		aluno.sort((a1, a2) -> Integer.compare(a1.getPontos(), a2.getPontos()));
		
		String[] lista = new String[aluno.size()];
		
		for(int i = 0; i < aluno.size(); i++) {
			lista[i] = aluno.get(i).getMatricula();
		}
		
		return lista;
	}
	
	public int cadastrarCursoLivre(String titulo, int cargaHoraria, int maxAlunos) {
		idCurso ++;
		
		CursoLivre cursoL = new CursoLivre(titulo, cargaHoraria, maxAlunos);
		
		cursos.put(idCurso, cursoL);
		
		return idCurso;
	}
	
	public int cadastrarCursoProfissionalizante(String titulo, int cargaHoraria, int maxAlunos) {
		idCurso ++;
		
		CursoProfissionalizante cursoF = new CursoProfissionalizante(titulo, cargaHoraria, maxAlunos);
		
		cursos.put(idCurso, cursoF);
		
		return idCurso;
	}
	
	public int cadastrarBootcamp(String titulo, int cargaHoraria, int maxAlunos) {
		idCurso ++;
		
		CursoBootcamp cursoB = new CursoBootcamp(titulo, cargaHoraria, maxAlunos);
		
		cursos.put(idCurso, cursoB);
		
		return idCurso;
	}
	
	public boolean matricularAluno(String matricula, int idCurso) {
		Aluno aluno = alunos.get(matricula);		
		
		if(aluno == null) {
		    throw new IllegalArgumentException("Aluno não encontrado!");
		}
		
		Curso curso = cursos.get(idCurso);
		
		if(curso == null) {
		    throw new IllegalArgumentException("Curso não encontrado!");
		}
		
		curso.MatriculaAluno(aluno);
		
		return true;
	}
	
	public String exibirCurso(int idCurso) {
		Curso curso = cursos.get(idCurso);
		
		if(curso == null) {
			throw new IllegalArgumentException("Curso não encontrado!");
		}
		
		return curso.toString();
	}
}
