package Agenda;

public class Palestra extends Evento{
	
	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String exibirDetalhes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcularPontuacao() {
		return 2;
	}

}
