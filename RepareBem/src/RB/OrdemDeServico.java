package RB;

public class OrdemDeServico {
	private int id;
	private String nome;
	private String telefone;
	private String roupa;
	private int qntReparo;
	private String status;
	private Reparo[] reparos = new Reparo[10];
	
	public OrdemDeServico( String nome, String telefone, String roupa) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.roupa = roupa;
		this.qntReparo = 0;
		this.status= "Não iniciada";
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getRoupa() {
		return roupa;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public int getQntReparo() {
		return qntReparo;
	}
		
	public double calcularPrecoTotal() {
		double precoTotal = 0;
		for(int i = 0; i < qntReparo; i ++) {
			precoTotal += reparos[i].getPreco();
		}
		
		return precoTotal;
	}
	
	public void mudarStatus(String novoStatus) {
		if(novoStatus.equals("Concluida") || 
		   novoStatus.equals("Em andamento") || 
		   novoStatus.equals("Não iniciada")) {
			status = novoStatus;
		}
	}
	
	public void cadastrarReparo(Reparo reparo) {
		if(qntReparo <= 10) {
			reparos[qntReparo] = reparo;
			qntReparo++;
		}
	}
	
	public void listarOrdemDeServico(OrdemDeServico [] ordens, int qntOrdens, String status ) {
		boolean encontrou = false;
		
		System.out.println("Ordens de Serviço - " + status);
		for(int i = 0; i < qntOrdens; i ++) {
			if(ordens[i].getStatus().equals(status)) {
				System.out.println(ordens[i]);
				encontrou = true;
			}
		}
		
		if(!encontrou) {
			System.out.println("Não há ordens de serviço do tipo " + status);
		}
		}
	
	@Override
	public String toString() {
		return "#" + id + "; " + "cliente: " + nome + "; " + "roupa: " + roupa + "; " + "reparos: " + qntReparo + "; " + "total: " + "R$" + calcularPrecoTotal(); 
	}
}
