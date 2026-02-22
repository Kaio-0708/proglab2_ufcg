package Agenda;

import java.util.ArrayList;
import java.util.List;

public class Palestra extends Evento{
	
	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "Titulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuação: " + calcularPontuacao() + "\n Nome dos Participantes: ";
		
		List<Estudante> lista = new ArrayList<>(participantes.values());
		
		for(int i = 0; i < lista.size(); i++) {
			detalhes = detalhes + " " + lista.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		return 2;
	}

}
