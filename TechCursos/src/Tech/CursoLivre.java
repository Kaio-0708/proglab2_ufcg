package Tech;

public class CursoLivre extends Curso{
	
	public CursoLivre(String titulo, int cargaHoraria, int maxAlunos) {
		super(titulo, cargaHoraria, maxAlunos);
	}

	@Override
	public int calcularPontos() {
		return 10;
	}
}
