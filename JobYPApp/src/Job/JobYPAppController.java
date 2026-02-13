package Job;

import java.util.ArrayList;
import java.util.HashMap;

public class JobYPAppController {
	
	private HashMap<String,Pessoa> pessoas = new HashMap<>();
	private ArrayList<Job> jobs = new ArrayList<>();
	
	public JobYPAppController() {
		this.pessoas = new HashMap<>();
		this.jobs = new ArrayList<>();
	}
	
	public int codastrarJob(String nomeEmpresa, String descricao, int vagas, String contato, String[] habilidades) {
		Job job = new Job(nomeEmpresa, descricao, vagas, contato, habilidades);
		
		if(jobs.size() < 100) {
			jobs.add(job);
		}
		
		return jobs.size();
	}
	
	public boolean cadastrarPessoa(String nome, String cpf, String link, String[] habilidades) {		
		if(cpf == null) {
			throw new IllegalArgumentException("CPF vazio");
		}
		
		if(this.pessoas.size() >= 100) {
			return false;
		}
		
		if(this.pessoas.containsKey(cpf)) {
			return false;
		}
		
		Pessoa pessoa = new Pessoa(nome, cpf, link, habilidades);
		this.pessoas.put(cpf, pessoa);
		return true;
	}
	
	public boolean cadastrarPessoa(String nome, String cpf, String[] habilidades) {
		if(cpf == null) {
			throw new IllegalArgumentException("CPF vazio");
		}
		
		if(this.pessoas.size() >= 100) {
			return false;
		}
		
		if(this.pessoas.containsKey(cpf)) {
			return false;
		}
		
		Pessoa pessoa = new Pessoa(nome, cpf, habilidades);
		this.pessoas.put(cpf, pessoa);
		return true;
	}
	
	public void mudaLinkCurriculo(Pessoa cpf, String novoLink) {
		Pessoa pessoa = this.pessoas.get(cpf);
		pessoa.mudarLink(novoLink);
	}
	
	public String[] listarPessoas() {
		String[] lista = new String[this.pessoas.size()];
		ArrayList<Pessoa> pessoa = new ArrayList<>(this.pessoas.values());
		
		for(int i = 0; i < pessoa.size(); i++) {
			lista[i] = pessoa.get(i).getNome();
		}
		
		return lista;
	}
	
	public void aplicarParaJob(String cpf, int indexJob) {
		Pessoa pessoa = this.pessoas.get(cpf);
		if(pessoa ==  null) {
			throw new IllegalArgumentException("CPF não encontrado");
		}
		
		Job vaga = jobs.get(indexJob);
		vaga.getCandidatos().put(cpf, pessoa);
		pessoa.registrarContatoDeConvocacao(vaga.getNomeEmpresa());
	}
	
	public String[] listarCandidatosJob(int indexJob) {
		Job vaga = jobs.get(indexJob);
		String candidatos = vaga.listarCandidatos();
		return new String[] {candidatos};
	}
	
	public String[] listarCandidatosJobComChance(int indexJob) {
		Job vaga = jobs.get(indexJob);
		ArrayList<Pessoa> candidatos = new ArrayList<>(vaga.getCandidatos().values());
		ArrayList<String> selecionados = new ArrayList<>();
		
		for(int i = 0; i < candidatos.size(); i++) {
			Pessoa pessoa = candidatos.get(i);
			double percentual = vaga.calcularPercentualDeChance(pessoa);
			
			if(percentual >= 90.0) {
				String linkFormatado = "";
				
				if(pessoa.getLink() == null) {
					linkFormatado = "Vazio";
				}else {
					linkFormatado = pessoa.getLink();
				}
				String resultado = "Nome: " + pessoa.getNome() + "\n"
							+ "Link: " + linkFormatado + "\n"
							+ "Percentual: " + percentual + "%";
				
				selecionados.add(resultado);
			}
		}
		
		String[] lista = new String[selecionados.size()];
		for(int i = 0; i < selecionados.size(); i++) {
			lista[i] = selecionados.get(i);
		}
		
		return lista;
	}
	
	public int calculaChancePessoaJob(String cpf, int indexJob) {
		Job vaga = jobs.get(indexJob);
		Pessoa pessoa = this.pessoas.get(cpf);
		
		if(pessoa ==  null) {
			throw new IllegalArgumentException("CPF não encontrado");
		}
		
		double percentual = vaga.calcularPercentualDeChance(pessoa);
		return(int) percentual;
	}
	
	public void convocarPessoa(String cpf, int indexJob) {
		Job vaga = jobs.get(indexJob);
		Pessoa pessoa = this.pessoas.get(cpf);
		
		if(pessoa.getCpf() ==  null) {
			throw new IllegalArgumentException("CPF não encontrado");
		}
		
		pessoa.registrarContatoDeConvocacao(vaga.getNomeEmpresa());
	}
	
	public int qtdConvocacoesPessoa(String cpf) {
		Pessoa pessoa = this.pessoas.get(cpf);
		
		if(pessoa ==  null) {
			throw new IllegalArgumentException("CPF não encontrado");
		}
		
		return pessoa.getConvocacoes().size();
	}
}
