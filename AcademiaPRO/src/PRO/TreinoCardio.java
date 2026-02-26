package PRO;

public class TreinoCardio extends Treino{
	
	public TreinoCardio(String nome, int intensidade, int capacidade) {
		super(nome, intensidade, capacidade);
	}

	@Override
	public int calcularPontos() {
		return 5;
	}
}
