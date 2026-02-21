package Agenda;

public class Workshop extends Evento{
	
	private int duracao;

	public Workshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
	}

	@Override
	public String exibirDetalhes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcularPontuacao() {
		return duracao;
	}
}
