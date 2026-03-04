package BD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BibliotecaDigitalController {
	
	private HashMap<String, Leitor> leitores;
	private HashMap<Integer, Livro> livros;
	private int idLivro;
	
	public BibliotecaDigitalController() {
		this.leitores = new HashMap<>();
		this.livros = new HashMap<>();
		this.idLivro = 0;
	}
	
	public boolean cadastrarLeitor(String nome, String email) {
		Leitor l = new Leitor(nome, email);
		
		if(leitores.containsKey(l.getEmail())) {
			throw new IllegalArgumentException("Cadastrado duplicado!");
		}
		
		leitores.put(email, l);
		
		return true;
	}
	
	public String exibirLeitor(String email) {
		Leitor l = leitores.get(email);
		
		if(l == null) {
			throw new IllegalArgumentException("Leitor já cadastrado!");
		}
		
		return l.toString();
	}
	
	public String[] listarLeitores() {
		List<Leitor> leitor = new ArrayList<>(leitores.values());
		
		leitor.sort((l1, l2) -> Integer.compare(l2.getPontos(), l1.getPontos()));
		
		String[] lista = new String[leitor.size()];
		
		for(int i = 0; i < leitor.size(); i++) {
			lista[i] = leitor.get(i).getNome();
		}
		
		return lista;
	}
	
	public String[] listarLeitoresNome() {
		List<Leitor> leitor = new ArrayList<>(leitores.values());
		
		leitor.sort((l1, l2) -> l1.getNome().compareTo(l2.getNome()));
		
		String[] lista = new String[leitor.size()];
		
		for(int i = 0; i < leitor.size(); i++) {
			lista[i] = leitor.get(i).getNome();
		}
		
		return lista;
	}
	
	public int cadastrarRomance(String titulo, String autor, String data, int maxEmprestimos) {
		idLivro ++;
		
		Romance r = new Romance(titulo, autor, data, maxEmprestimos);
		
		livros.put(idLivro, r);
		
		return idLivro;
	}
	
	public int cadastrarCientifico(String titulo, String autor, String data, int maxEmprestimos, int numPaginas) {
		idLivro ++;
		
		Cientifico c = new Cientifico(titulo, autor, data, maxEmprestimos, numPaginas);
		
		livros.put(idLivro, c);
		
		return idLivro;
	}
	
	public int cadastrarDidatico(String titulo, String autor, String data, int maxEmprestimos, int numPaginas, boolean geraPontosExtras) {
		idLivro ++;
		
		Didatico d = new Didatico(titulo, autor, data, maxEmprestimos, numPaginas, geraPontosExtras);
		
		livros.put(idLivro, d);
		
		return idLivro;
	}
	
	public boolean emprestarLivro(String emailLeitor, int idLivro) {
		Leitor leitor = leitores.get(emailLeitor);
		
		if(leitor == null) {
			throw new IllegalArgumentException("Leitor não encontrado!");
		}
		
		Livro livro = livros.get(idLivro);
		
		if(livro == null) {
			throw new IllegalArgumentException("Livro não encontrado!");
		}
		
		livro.inscreverLeitor(leitor);
		
		return true;
	}
	
	public String exibirDetalhesLivro(int idLivro) {
		Livro livro = livros.get(idLivro);
		
		return livro.informarDetalhes();
	}
}
