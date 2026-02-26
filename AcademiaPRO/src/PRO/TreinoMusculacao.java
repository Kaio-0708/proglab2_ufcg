package PRO;

public class TreinoMusculacao extends Treino{
	
	private int series;
	
	public TreinoMusculacao(String nome, int intensidade, int capacidade, int series) {
		super(nome, intensidade, capacidade);
		this.series = series;
	}

	@Override
	public int calcularPontos() {
		return series;
	}
}
