package Job;

import java.util.ArrayList;
import java.util.HashMap;

public class Job {
	private String nomeEmpresa;
	private String descricao;
	private int vagas;
	private String contato;
	private String[] habilidades;
	private HashMap<String, Pessoa> candidatos = new HashMap<>();
	
	public Job(String nomeEmpresa, String descricao, int vagas, String contato, String[] habilidades) {
		this.nomeEmpresa = nomeEmpresa;
		this.descricao = descricao;
		this.vagas = vagas;
		this.contato = contato;
		this.habilidades = habilidades;
	}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getVagas() {
		return vagas;
	}
	
	public String getContato() {
		return contato;
	}
	
	public String[] getHabilidades() {
		return habilidades;
	}
	
	public double calcularPercentualDeChance(Pessoa pessoa) {
		int habilidadesEmComum = 0;
		double percentual = 0;
		
		String[] habilidadesPessoa = pessoa.getHabilidades();
		
		for(int i = 0; i < this.habilidades.length; i++) {
			for(int j = 0; j < pessoa.getHabilidades().length; j++) {
				if(this.habilidades[i].equals(habilidadesPessoa[j])) {
					habilidadesEmComum ++;
				}
			}
		}
		
		if(habilidadesEmComum == 0) {
			percentual = 0.00 * 100;
		}else if(habilidadesEmComum == 1) {
			percentual = 0.30 * 100;
		}else if(habilidadesEmComum == 2) {
			percentual = 0.60 * 100;
		}else {
			percentual = 0.90 * 100;
		}
		
		return percentual;
	}
	
	public String listarCandidatos() {
		String resultado = "";
		ArrayList<Pessoa> lista = new ArrayList<>(candidatos.values());
		
		for(int i = 0; i < lista.size(); i++) {
			Pessoa pessoa = lista.get(i);
		
			double percentual = calcularPercentualDeChance(pessoa);
			String link = pessoa.getLink();
			String linkFormatado = "";
			
			if(link == null) {
				linkFormatado = "Vazio";
			}else {
				linkFormatado = link;
			}
			
			resultado += "Nome: " + pessoa.getNome() + "\n"
						+ "Link: " + linkFormatado + "\n"
						+ "Percentual: " + percentual + "%";
		}
		
		return resultado;
	}
	
	
	@Override
	public String toString() {
		return "Nome da Empresa" + this.nomeEmpresa + "\n" + "Descrição" + this.descricao +  "\n" + "Vagas" + this.vagas+ "\n" + "Contato" + this.contato + "\n" + "Habilidades" + this.habilidades;
	}
}
