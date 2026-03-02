package Tech;

public class CursoBootcamp extends Curso{
	
	public CursoBootcamp(String titulo, int cargaHoraria, int maxAlunos) {
		super(titulo, cargaHoraria, maxAlunos);
	}

	@Override
	public int calcularPontos() {
		return cargaHoraria + 20;
	}
}
