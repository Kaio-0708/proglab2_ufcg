package Academia;

import java.util.ArrayList;
import java.util.List;

public class Workshop extends Atividade{

	private boolean certificado;
	private int duracao;
	
	public Workshop(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		super(titulo, descricao, data, maxParticipantes);
		this.certificado = certificado;	
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		String detalhes = "Titulo: " + titulo + "\n Descricao: " + descricao + "\n Data: " + data + "\n Pontuacao" + calcularPontuacao() + "\n Participantes: " + maxParticipantes + "\n Duracao: " + duracao;
		
		if(certificado) {
			detalhes = detalhes + "\n Certificado emitido";
		} else {
			detalhes = detalhes + "\n Certificado não emitido";
		}
		
		List<Atleta> a = new ArrayList<>(atletas.values());
		
		for(int i = 0; i < a.size(); i++) {
			detalhes = detalhes + "\n Nome dos participantes: " + a.get(i).getNome();
		}
		
		return detalhes;
	}

	@Override
	public int calcularPontuacao() {
		if(certificado) {
			return duracao + 10;
		} else {
			return duracao;
		}
	}
}
