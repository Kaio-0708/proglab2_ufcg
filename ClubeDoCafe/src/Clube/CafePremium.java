package Clube;

public class CafePremium extends Cafe{

	private int raridade;
	
	public CafePremium(String nome, String origem, int intensidade, int raridade) {
		super(nome, origem, intensidade);
		this.raridade = raridade;
	}

	@Override
	public double definirQualidade() {
		return raridade * 3.5 * calcularMediaDasNotas();
	}
}
