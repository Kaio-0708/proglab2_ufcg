package Tech;

import java.util.HashMap;

public abstract class Curso {
	
	protected String titulo;
	protected int cargaHoraria;
	protected int maxAlunos;
	protected HashMap<String, Aluno> alunos;
	
	public Curso(String titulo, int cargaHoraria, int maxAlunos) {
		this.titulo = titulo;
		this.cargaHoraria = cargaHoraria;
		this.maxAlunos = maxAlunos;
		this.alunos = new HashMap<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public int getMaxAlunos() {
		return maxAlunos;
	}
	
	public HashMap<String, Aluno> getAlunos() {
		return alunos;
	}
	
	public boolean matriculaAluno(Aluno a) {
		if(alunos.size() >= maxAlunos) {
			throw new IllegalArgumentException("Não há mais vagas!");
		}
		
		if(alunos.containsKey(a.getMatricula())) {
			throw new IllegalArgumentException("Aluno já matrículado!");
		}
		
		alunos.put(a.getMatricula(), a);
		a.addPontos(calcularPontos());
		
		
		return true;
	}
	
	public abstract int calcularPontos();
	
	@Override
	public String toString() {
		return "Titulo: " + titulo + "\n Carga Horária: " + cargaHoraria + "\nMáximo de Alunos" + maxAlunos;
	}
}
