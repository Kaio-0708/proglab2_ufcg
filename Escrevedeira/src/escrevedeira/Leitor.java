package escrevedeira;
import java.util.*;

public class Leitor {
	private String nome;
	private String email;
	private String status;
	private ClubesDeLeitura[] clubes = new ClubesDeLeitura[10];
	private int qntDeClubes;
	private String[] favoritos = new String[50];
	private int qntDeFavoritos;
	private double valorTotal;
	
	public Leitor(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.status = "leitor junior";
		this.qntDeClubes = 0;
		this.qntDeFavoritos = 0;
		this.valorTotal = 0.0;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getStatus() {
		return status;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public int getQntDeClubes() {
		return qntDeClubes;
	}
	
	public ClubesDeLeitura getClube(int index) {
		return clubes[index];
	}
	
	public void adicionarPagamento(double valor) {
		valorTotal += valor;
	}
	
	public void atualizarStatus() {
		if(qntDeClubes > 9) {
			status = "leitor voraz";
		}
	}
	
	public boolean adicionarClube(ClubesDeLeitura clube) {
		if(qntDeClubes == 10) {
			for(int i = 1; i < 10; i++) {
				clubes[i - 1] = clubes[i];
			}
			
			clubes[9] = clube;			
		} else {
			clubes[qntDeClubes] = clube;
			qntDeClubes ++;
		}
		
		atualizarStatus();		
		
		double valor = clube.getValor();	
		if(status.equals("leitor voraz")) {
			valor = valor / 2;
		}
		
		adicionarPagamento(valor);
		
		return true;
	}
	
	public boolean adicionarFavorito(String livro) {
		boolean participa = false;
		
		for(int i = 0; i < qntDeClubes; i++) {
			if(clubes[i].getTitulo().equals(livro)) {
				participa = true;
				break;
			}
		}
		
		if(!participa) {
			return false;
		}
		
		if(qntDeFavoritos < 50) {
			favoritos[qntDeFavoritos++] = livro;
			return true;
		}
		
		return false;
	}
	
	public String[] listarClubes() {
        String[] lista = new String[qntDeClubes];
        for (int i = 0; i < qntDeClubes; i++) {
            lista[i] = clubes[i].getNomeClube();
        }
        return lista;
    }

    public String[] listarFavoritos() {
        String[] lista = new String[qntDeFavoritos];
        for (int i = 0; i < qntDeFavoritos; i++) {
            lista[i] = favoritos[i];
        }
        return lista;
    }
	
	@Override
	public String toString() {
		return nome + email + "\n" + status + " - " + qntDeClubes + "clubes de leitura";
	}
}