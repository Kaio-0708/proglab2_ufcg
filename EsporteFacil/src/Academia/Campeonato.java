package Academia;

import java.util.ArrayList;
import java.util.List;

public class Campeonato extends Atividade{
	
	private int duracao;
	
	public Campeonato(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		String detalhes = "Titulo: " + titulo + "\n Descricao: " + descricao + "\n Data: " + data + "\n Pontuacao" + calcularPontuacao() + "\n Participantes: " + maxParticipantes + "\n Duracao: " + duracao;
		
		List<Atleta> a = new ArrayList<>(atletas.values());
		
		for(int i = 0; i < a.size(); i++) {
			detalhes = detalhes + "\n Nome dos participantes: " + a.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return duracao;
	}
}
