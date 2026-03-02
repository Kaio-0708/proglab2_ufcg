package Tech;

public class CursoProfissionalizante extends Curso{
	
	public CursoProfissionalizante(String titulo, int cargaHoraria, int maxAlunos) {
		super(titulo, cargaHoraria, maxAlunos);
	}

	@Override
	public int calcularPontos() {
		return cargaHoraria;
	}
}
