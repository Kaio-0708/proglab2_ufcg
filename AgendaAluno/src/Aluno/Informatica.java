package Aluno;

import java.util.ArrayList;
import java.util.List;

public class Informatica extends Turma{

	private int duracao;
	
	public Informatica(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;	
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "Titulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuacao: " + calcularPontuacao() + "Participantes: " + maxParticipantes + "\n Duracao em Horas: " + duracao;
		
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		for(int i = 0; i < e.size(); i++) {
			detalhes = detalhes + "\n Nome do participante " + e.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return duracao;
	}
}
