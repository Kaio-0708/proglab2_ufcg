package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author Kaio Vitor Santos Queiroz
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	private Filme[] hotList;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.hotList = new Filme[10];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public Filme getFilme(int posicao) {
		return filmes[posicao -1];
	}
    
	public String atribuirHot(Filme filme, int posicao) {
		
		if (posicao < 1 || posicao > 10) {
			return "POSIÇÃO INVÁLIDA.";
		}
		if (filme == null) {
			return "FILME INVÁLIDO, POSIÇÃO VAZIA";
		}
		if (filme.isHotList()) {
			return "FILME JÁ ADICIONADO";
		}
		if (this.hotList[posicao - 1] != null) {
			this.hotList[posicao - 1].setHotList(false);
			this.hotList[posicao - 1] = filme;
			filme.setHotList(true);
			return "FILME ADICIONADO";
		}
		this.hotList[posicao - 1] = filme;
		filme.setHotList(true);
		return "FILME ADICIONADO";
	}
	
	public boolean removerHot(int posicao) {
		
		if (posicao < 1 || posicao > 10) {
			return false;
		}
		
		if (this.hotList[posicao - 1] == null) {
			return false;
		}
		
		this.hotList[posicao - 1].setHotList(false);
		this.hotList[posicao - 1] = null;
		return true;
	}
	
	public String exibirHotList() {
		String saida = "";
		int contador = 1;
		for (Filme f: this.hotList) {
			if (f != null) {
				if (f.getAno() == 0) {
					saida += contador + " - " + f.getNome() + "\n";
				} else {
					saida += contador + " - " + f.getNome() + ", " + f.getAno() + "\n";
				}
			}
			contador ++;
		}
		return saida;
	}
	
	public String mostrarTodosPeloNome(String nome) {
		String saida = "";
		for (int i = 0; i < this.filmes.length; i ++) {
			if (this.filmes[i] != null) {
				if (this.filmes[i].getNome().equals(nome)) {
					saida += ( i + 1) + " - " + this.filmes[i].getNome() + "\n";
				}
			}
		}
		return saida;
	}
	
	public String mostrarTodosPeloAno(int ano) {
		String saida = "";
		for (int i = 0; i < this.filmes.length; i ++) {
			if (this.filmes[i] != null) {
			    if (this.filmes[i].getAno() == ano) {
				    saida += (i + 1) + " - " + this.filmes[i].getAno() + "\n";
				    }
			    }
		}
		return saida;
	}
	
	public boolean removerFilme(int posicao) {
		
		if (posicao > 100 || posicao < 1) {
			return false;
		}
		if (this.filmes[posicao - 1] == null) {
			return false;
		}
		for (int i = 0; i < this.hotList.length; i++) {
			if (this.filmes[posicao - 1].equals(this.hotList[i])) {
				this.hotList[i] = null;
			}
		}
		this.filmes[posicao - 1] = null;
		return true;
	}
	
	
	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		
		if ("".equals(ano.trim())) {
			ano = "0";
		}
		Filme filme = new Filme(nome,Integer.parseInt(ano),local);
		if (posicao < 1 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		if ("".equals(local.trim()) || "".equals(nome.trim())) {
			return "FILME INVÁLIDO";
		}
				
		for (int i = 0; i < this.filmes.length; i ++) {
			Filme f = this.filmes[i];
			if (f != null && f.equals(filme)) {
				return "FILME JÁ ADICIONADO";
			}
		}
		
		this.filmes[posicao-1] = filme;
		return "FILME ADICIONADO";
		
	}

}
