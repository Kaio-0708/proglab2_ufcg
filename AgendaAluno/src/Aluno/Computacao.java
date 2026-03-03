package Aluno;

import java.util.ArrayList;
import java.util.List;

public class Computacao extends Turma{

	public Computacao(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "TIulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuacao: " + calcularPontuacao() + "Participantes: " + maxParticipantes;
		
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		for(int i = 0; i < e.size(); i++) {
			detalhes = detalhes + "\n Nome do participante " + e.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return 2;
	}
}
