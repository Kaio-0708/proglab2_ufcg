package Clube;

public class CafeTradicional extends Cafe{
    
	private int tempoTorra;
	
	public CafeTradicional(String nome, String origem, int intensidade, int tempoTorra) {
		super(nome, origem, intensidade);
		this.tempoTorra = tempoTorra;
	}

	@Override
	public double definirQualidade() {
		return tempoTorra * calcularMediaDasNotas();
	}
}
