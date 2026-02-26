package PRO;

public class TreinoFuncional extends Treino{
	
	private int duracao;
	
	public TreinoFuncional(String nome, int intensidade, int capacidade, int duracao) {
		super(nome, intensidade, capacidade);
		this.duracao = duracao;
	}

	@Override
	public int calcularPontos() {
		return duracao / 10;
	}
}
