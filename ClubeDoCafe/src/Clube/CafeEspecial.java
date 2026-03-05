package Clube;

public class CafeEspecial extends Cafe{
    
	private int nivelAroma;
	
	public CafeEspecial(String nome, String origem, int intensidade, int nivelAroma) {
		super(nome, origem, intensidade);
		this.nivelAroma = nivelAroma;
	}

	@Override
	public double definirQualidade() {
		return nivelAroma * 2 * calcularMediaDasNotas();
	}
}
