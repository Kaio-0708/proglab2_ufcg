package Agenda;

public class OficinaAprendizagem extends Evento{
	
	private int duracao;
	private boolean certificado;
	
	public OficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		this.certificado = certificado;
	}

	@Override
	public String exibirDetalhes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcularPontuacao() {
		if(certificado) {
			return duracao + 10;
		}else {
			return duracao;
		}		
	}
}
