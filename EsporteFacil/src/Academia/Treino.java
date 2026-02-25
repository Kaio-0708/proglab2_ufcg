package Academia;

import java.util.ArrayList;
import java.util.List;

public class Treino extends Atividade{
	
	public Treino(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String toString() {
		String detalhes = "Titulo: " + titulo + "\n Descricao: " + descricao + "\n Data: " + data + "\n Pontuacao" + calcularPontuacao() + "\n Participantes: " + maxParticipantes;
		
		List<Atleta> a = new ArrayList<>(atletas.values());
		
		for(int i = 0; i < a.size(); i++) {
			detalhes = detalhes + "\n Nome dos participantes: " + a.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return 2;
	}
}
