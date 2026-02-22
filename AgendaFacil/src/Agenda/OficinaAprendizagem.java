package Agenda;

import java.util.ArrayList;
import java.util.List;

public class OficinaAprendizagem extends Evento{
	
	private int duracao;
	private boolean certificado;
	
	public OficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		this.certificado = certificado;
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "Titulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuação: " + calcularPontuacao() + "\n Duracao: " + duracao + " horas" + "\n Certificado não emitido" + "\n Nome dos Participantes: ";
		
		if(certificado) {
			detalhes = detalhes + "\n Certificado emitido";
		}else {
			detalhes = detalhes + "\n Certificado não emitido";
		}
		
		List<Estudante> lista = new ArrayList<>(participantes.values());
		
		for(int i = 0; i < lista.size(); i++) {
			detalhes = detalhes + " " + lista.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		if(certificado) {
			return duracao + 10;
		}else {
			return duracao;
		}		
	}
}
