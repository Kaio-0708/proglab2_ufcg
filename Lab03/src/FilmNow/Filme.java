package FilmNow;

import java.util.*;

/**
 * A representação de um filme, com nome, ano de lançamento, locais de exibição e indicação de presença na HotList.
 * @author Kaio Vitor Santos Queiroz
 */

public class Filme {
	
	private String nome;
	private int ano;
	private String[] locais;
	private boolean HotList;
	
	/**
     * Constrói um novo filme com nome, ano e local de exibição inicial.
     *
     * @param nome o nome do filme; não pode ser nulo ou vazio
     * @param ano o ano de lançamento; deve ser maior que zero
     * @param local o primeiro local de exibição; não pode ser nulo ou vazio
     * @throws IllegalArgumentException caso algum dos parâmetros seja inválido
     */
	public Filme(String nome, int ano, String local) {
		if(nome == null || nome.trim().equals("")){
			throw new IllegalArgumentException("Nome não é válido.");
		}
		
		if(local == null || local.trim().equals("")){
			throw new IllegalArgumentException("Local não é válido.");
		}
		
		if(ano < 0 ) {
			throw new IllegalArgumentException("Ano não é válido.");
		}
		
		this.nome = nome;
		this.ano = ano;
		this.locais = new String[5];
		this.locais[0] = local;
		this.HotList =  false;
	}
	
	/**
     * Retorna o nome do filme.
     *
     * @return o nome do filme
     */
	public String getNome() {
		return this.nome;
	}
	

    /**
     * Retorna o ano de lançamento do filme.
     *
     * @return o ano de lançamento
     */
	public int getAno() {
		return this.ano;
	}
	
	 /**
     * Retorna o array contendo os locais de exibição do filme.
     *
     * @return um array de locais
     */
	public String[] getLocais() {
		return this.locais;
	}
	

    /**
     * Indica se o filme está marcado como HotList.
     *
     * @return {@code true} se estiver na HotList, {@code false} caso contrário
     */
	public boolean isHotList() {
		return this.HotList;
	}
	

    /**
     * Define se o filme deve ser marcado como HotList.
     *
     * @param valor {@code true} para marcar como HotList, {@code false} para remover da lista
     */
	public void setHotList(boolean valor) {
		this.HotList = valor;
	}
	
	/**
     * Gera o hashCode do filme com base no nome e ano.
     *
     * @return o valor de hashCode gerado
     */
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}
	
	/**
     * Verifica se dois filmes são iguais, considerando nome e ano.
     *
     * @param obj o objeto a ser comparado
     * @return {@code true} se forem equivalentes, {@code false} caso contrário
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return ano == other.ano && Objects.equals(nome, other.nome);
	}
	

    /**
     * Calcula a quantidade atual de locais cadastrados.
     *
     * @return o número de locais não nulos
     */
	public int quantidadeDeLocais() {
		int contador = 0;
		for (int i = 0; i < this.locais.length; i ++) {
			if (this.locais[i] != null) {
				contador ++;
			}
		} 
		return contador;
	}
	
	/**
     * Adiciona um novo local de exibição ao filme.
     *
     * Não permite adicionar locais duplicados ou exceder o limite de cinco locais.
     *
     * @param local o novo local a ser adicionado
     * @return {@code true} se o local for adicionado com sucesso; {@code false}
     *         se o limite for atingido ou se o local já existir
     */
	public boolean adicionarLocal(String local) {
		if (quantidadeDeLocais() == 5) {
			return false;
		}
		for (int i = 0; i < this.locais.length; i++) {
			if (this.locais[i] != null && this.locais[i].equals(local)) {
				return false;
			}
		}
		this.locais[quantidadeDeLocais()] = local;
		return true;
	}
	
	/**
     * Remove um local de exibição do filme.
     *
     * Não é permitido remover se o filme possuir apenas um local cadastrado.
     *
     * @param local o local a ser removido
     * @return {@code true} se o local for encontrado e removido; {@code false} caso contrário
     */
	public boolean removerLocal(String local) {
		if (quantidadeDeLocais() == 1) {
			return false;
		}
		for (int i =0; i < this.locais.length; i ++) {
			if (local.equals(this.locais[i])) {
				this.locais[i] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
     * Retorna a representação textual do filme, que é seu nome.
     *
     * @return o nome do filme
     */
	@Override
	public String toString() {
		return this.getNome();
	}
}