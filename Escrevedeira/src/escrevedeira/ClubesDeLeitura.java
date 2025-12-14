package escrevedeira;

public class ClubesDeLeitura {
	private String nomeClube;
	private String titulo;
	private String autor;
	private String data;
	private String horario;
	private String local;
	private String pessoaMediadora;
	private double valor;
	
	public ClubesDeLeitura(String nomeClube, String titulo, String autor, String data, String horario, String local, String pessoaMediadora, double valor) {
		this.nomeClube = nomeClube;
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
		this.horario = horario;
		this.local = local;
		this.pessoaMediadora = pessoaMediadora;
		this.valor = valor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
	    this.valor = valor;
	}
	
	public String getNomeClube() {
		return nomeClube;
	}
	
	@Override
	public String toString() {
		return nomeClube + "\n" + "Livro: " + titulo + " - " + "Autor: " + autor + 
				"\n" + "Data: " + data + " - Hora: " + horario + " -Local: " + local + " - Mediador(a):" + pessoaMediadora +
				"\n" + "Valor: R$" + valor;
	}
}
