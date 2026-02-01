package FilmNow;

/**
 * Representação de um detalhamento de um filme,incluindo sua posição em um ranking
 * e seus locais de exibição.
 * @author Kaio Vitor Santos Queiroz
 */
public class DetalharFilme {
	
	private Filme filme;
	private int posicao;
	
	/**
	 * Constrói um objeto {@code DetalharFilme} com base em um filme e sua posição.
	 *
	 * @param filme o filme que será detalhado
	 * @param posicao a posição do filme na lista
	 */
	public DetalharFilme(Filme filme, int posicao) {
		this.filme = filme;
		this.posicao = posicao;
	}
	
	/**
	 * Retorna uma lista formatada com os locais de exibição do filme.
	 * Cada local é exibido em uma nova linha. Locais nulos são ignorados.
	 *
	 * @return uma string contendo os locais de exibição separados por quebras de linha
	 */
	public String locaisDeExibicao() {
		String saida = "";
		
		for(String local: this.filme.getLocais()) {
			if (local != null) {
				saida += local + "\n";
			}
		}


		return saida.trim();
	}
    
	/**
	 * Retorna uma representação textual detalhada do filme para uma posição específica.
	 * 
	 * O formato de saída segue estas regras, nesta ordem de precedência:
	 * Se a posição for inválida (menor que 1 ou maior que 100), retorna "POSIÇÃO INVÁLIDA!".
	 * Se o filme for {@code null}, retorna uma string vazia ("").
	 * Se o filme estiver na HotList:
	 *  Sem ano definido: exibe apenas o nome seguido de 🔥
	 *  Com ano definido: exibe "Nome (Ano) 🔥"
	 * Se não estiver na HotList:
	 *  Sem ano definido: exibe apenas o nom
	 *  Com ano definido: exibe "Nome (Ano)"
	 * Para todos os casos válidos (não-nulos e com posição válida), após o nome/ano,
	 * são sempre adicionados os locais de exibição do filme no formato específico.
	 *
	 * @return string formatada conforme as regras acima, ou mensagem de erro/string vazia
	 *         nos casos especificados
	 */
	@Override
	public String toString() {
		if(this.posicao > 100 || this.posicao < 1) {
			return "POSIÇÃO INVÁLIDA!";
		}
		if(this.filme == null) {
			return "";
		}
		if (this.filme.isHotList() && this.filme.getAno() == 0) {
			return "\n" + "🔥" + this.filme.getNome()+ "\n" + locaisDeExibicao();
		}
		if (this.filme.isHotList()) {
			return "\n" + "🔥" + this.filme.getNome() + ", " + this.filme.getAno() + "\n" + locaisDeExibicao();
		}
		if(this.filme.getAno() == 0) {
			return "\n" + this.filme.getNome() + "\n" + locaisDeExibicao();
		}
	    return "\n" + this.filme.getNome() + ", " + this.filme.getAno() + "\n" + locaisDeExibicao();
	}
}
