package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes, além de uma HotList com até 10 destaques.
 * O FilmNow possibilita cadastrar filmes, exibi-los por nome ou ano, 
 * adicioná-los ou removê-los da HotList e remover filmes cadastrados.
 * @author Kaio Vitor Santos Queiroz
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	private Filme[] hotList;

	/**
	 * Constrói um novo sistema FilmNow com capacidade para
	 * 100 filmes e uma HotList com 10 posições.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.hotList = new Filme[10];
	}
	
	/**
	 * Retorna uma cópia da lista completa de filmes cadastrados.
	 *
	 * @return um array contendo todos os filmes cadastrados (pode haver posições nulas)
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
    
	/**
	 * Adiciona um filme à HotList em uma posição específica.
	 * 
	 * Regras aplicadas:
	 *  Não permite posições fora do intervalo 1–10.
	 *  Não permite adicionar filmes nulos.
	 *  Não permite adicionar filmes já presentes na HotList.
	 *  Caso já exista um filme na posição, ele será removido da HotList.
	 *
	 * @param filme o filme a ser adicionado
	 * @param posicao a posição desejada na HotList (1 a 10)
	 * @return mensagem indicando o resultado da operação
	 */
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
	
	/**
	 * Remove um filme da HotList.
	 *
	 * @param posicao posição desejada (1 a 10)
	 * @return {@code true} se o filme for removido; {@code false} caso a posição
	 *         seja inválida ou esteja vazia
	 */
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
	
	/**
	 * Exibe todos os filmes presentes na HotList, ordenados por posição.
	 *
	 * @return uma string contendo os filmes e suas posições na HotList
	 */
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
	
	/**
	 * Exibe todos os filmes cujo nome corresponda ao nome informado.
	 *
	 * @param nome o nome do filme a ser buscado
	 * @return string com todas as ocorrências encontradas e suas posições
	 */
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
	
	/**
	 * Exibe todos os filmes cujo ano corresponda ao ano informado.
	 *
	 * @param ano ano de lançamento buscado
	 * @return string com todas as ocorrências encontradas e suas posições
	 */
	public String mostrarTodosPeloAno(int ano) {
		String saida = "";
		for (int i = 0; i < this.filmes.length; i ++) {
			if (this.filmes[i] != null) {
			    if (this.filmes[i].getAno() == ano) {
				    saida += (i + 1) + " - " + this.filmes[i].getNome() + "\n";
				    }
			    }
		}
		return saida;
	}
	
	/**
	 * Remove um filme do sistema. Caso o filme removido esteja na HotList,
	 * ele também será removido de lá.
	 *
	 * @param posicao a posição do filme a ser removido (1 a 100)
	 * @return {@code true} se o filme for removido; {@code false} caso a posição
	 *         seja inválida ou esteja vazia
	 */
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
	public String cadastrarFilme(int posicao, String nome, String ano, String local) {
		
		if (nome == null || nome.trim().isEmpty() ||
		        local == null || local.trim().isEmpty()) {
		        return "FILME INVALIDO";
		    }

		    if (ano.trim().isEmpty()) {
		        ano = "0";
		    }

		    if (posicao < 1 || posicao > 100) {
		        return "POSIÇÃO INVÁLIDA";
		    }
		
		Filme filme = new Filme(nome, Integer.parseInt(ano), local);    
	
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
