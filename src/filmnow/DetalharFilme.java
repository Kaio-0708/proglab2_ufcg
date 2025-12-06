package filmnow;

/**
 * Representação de um detalhamento de um filme.
 * @author Kaio Vitor Santos Queiroz
 */
public class DetalharFilme {
	
	private Filme filme;
	private int posicao;
	
	public DetalharFilme(Filme filme, int posicao) {
		this.filme = filme;
		this.posicao = posicao;
	}
	
	public String locaisDeExibicao() {
		String saida = "";
		
		for(String local: this.filme.getLocais()) {
			if (local != null) {
				saida += local + "\n";
			}
		}


		return saida.trim();
	}

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
