package Agenda;

import java.util.ArrayList;
import java.util.List;

public class Workshop extends Evento{
	
	private int duracao;

	public Workshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "Titulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuação: " + calcularPontuacao() + "\n Duracao: " + duracao + " horas" + "\n Nome dos Participantes: ";
		
		List<Estudante> lista = new ArrayList<>(participantes.values());
		
		for(int i = 0; i < lista.size(); i++) {
			detalhes = detalhes + " " + lista.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return duracao;
	}
}
