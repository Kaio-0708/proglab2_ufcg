package Aluno;

import java.util.ArrayList;
import java.util.List;

public class Eletrica extends Turma{
    
	private int duracao;
	private boolean certificacao;
	
	public Eletrica(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		this.certificacao = certificacao;
	}

	@Override
	public String exibirDetalhes() {
		String detalhes = "TIulo: " + titulo + "\n Descrição: " + descricao + "\n Data: " + data + "\n Pontuacao: " + calcularPontuacao() + "Participantes: " + maxParticipantes + "\n Duracao em Horas: " + duracao;
		
		if(certificacao) {
			detalhes = detalhes + "Certificado ok";
		} else {
			detalhes = detalhes + "Certificado não ok";
		}
		
		List<Estudante> e = new ArrayList<>(estudantes.values());
		
		for(int i = 0; i < e.size(); i++) {
			detalhes = detalhes + "\n Nome do participante " + e.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		int resultado = 0;
		
		if(certificacao) {
			resultado = duracao + 10;
		} else {
			resultado = duracao;
		}
		
		return resultado;
	}
}
