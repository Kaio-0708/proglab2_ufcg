package Agenda;

public class Workshop extends Evento{
	
	public Workshop(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String exibirDetalhes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcularPontuacao() {
		// TODO Auto-generated method stub
		return 0;
	}
}
