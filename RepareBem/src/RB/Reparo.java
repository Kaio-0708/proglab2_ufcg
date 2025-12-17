package RB;

public class Reparo {
	private String identificador;
	private String descricao;
	private double preco;
	
	public Reparo(String identificador, String descricao, double preco) {
		this.identificador = identificador;
		this.preco = preco;
		this.descricao= descricao;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void reajustarPercentual(double percentual) {
		preco += preco * (percentual / 100);
	}
}
