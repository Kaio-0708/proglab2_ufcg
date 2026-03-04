package BD;

import java.util.HashMap;

public abstract class Livro {
	
	protected String titulo;
	protected String autor;
	protected String data;
	protected int maxEmprestimos;
	protected HashMap<String, Leitor> leitores;
	
	public Livro(String titulo, String autor, String data, int maxEmprestimos) {
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
		this.maxEmprestimos = maxEmprestimos;
		this.leitores = new HashMap<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getData() {
		return data;
	}
	
	public int getMaxEmprestimos() {
		return maxEmprestimos;
	}
	
	public HashMap<String, Leitor> getLeitores(){
		return leitores;
	}
	
	public boolean inscreverLeitor(Leitor leitor) {
		if(leitores.size() >= maxEmprestimos) {
			throw new IllegalArgumentException("Não tem cópias disponíveis!");
		}
		
		if(leitores.containsKey(leitor.getEmail())) {
			throw new IllegalArgumentException("Leitor já pegou emprestado o livro!");
		}
		
		leitor.addLivroEmprestado();
		leitor.addPontos(gerarPontos());
		leitores.put(leitor.getEmail(), leitor);
		
		return true;
	}
	
	public abstract int gerarPontos();
	
	public abstract String informarDetalhes();

}
