package escrevedeira;
import java.util.*;

public class Escrevedeira {
	
	private ClubesDeLeitura[] clubes = new ClubesDeLeitura[100];
	private int qntClubes = 0;
	private Leitor[] leitores = new Leitor[100];
	private int qntLeitores = 0;
	
	public void cadastrarClubeDeLeitura(String nomeClube, String livro, String autor, String data, String horario, String plataforma, String mediador, double preco) {
		if(qntClubes == 100) {
			throw new IllegalArgumentException("Limite máximo de clubes atingido.");
		}
		
		for(int i =0; i < qntClubes; i++) {
			if(clubes[i].getNomeClube().equals(nomeClube)) {
				throw new IllegalArgumentException("Clube já cadastrado");
			}
		}
		
		clubes[qntClubes] = new ClubesDeLeitura(nomeClube, livro, autor, data, horario, plataforma, mediador, preco);
		
		qntClubes ++;
	}
	
	public String[] listarClubesDeLeitura() {
		String[] lista = new String[qntClubes];
		for(int i =0; i < qntClubes; i++) {
			lista[i] = clubes[i].toString();
		}
		return lista;
	}
	
	public void reajustarValorClube(String nomeClube, double valor) {
		ClubesDeLeitura clube = buscarClube(nomeClube);
		clube.setValor(valor);
	}
	
	public void cadastrarLeitor(String nome, String email) {
		if(qntLeitores == 100) {
			throw new IllegalArgumentException("Limite máximo de leitores atingido");
		}
		
		for(int i = 0; i < qntLeitores; i ++) {
			if(leitores[i].getEmail().equals(email)) {
				throw new IllegalArgumentException("Leitor já cadastrado.");
			}
		}
		
		leitores[qntLeitores] = new Leitor(nome, email);
		qntLeitores ++;
	}
	
	public String[] listarLeitores() {
        String[] lista = new String[qntLeitores];
        for (int i = 0; i < qntLeitores; i++) {
            lista[i] = leitores[i].toString();
        }
        return lista;
    }

    public void inscreverEmClube(String email, String nomeClube) {
        Leitor leitor = buscarLeitor(email);
        ClubesDeLeitura clube = buscarClube(nomeClube);
        
        for (int i = 0; i < leitor.getQntDeClubes(); i++) {
            if (leitor.getClube(i).getNomeClube().equals(nomeClube)) {
                throw new IllegalArgumentException("Leitor já está inscrito neste clube");
            }
        }
        
        leitor.adicionarClube(clube);
    }

    public String[] listarClubesDoLeitor(String email) {
        Leitor leitor = buscarLeitor(email);
        return leitor.listarClubes();
    }

    public boolean incluirLivroPreferido(String email, String nomeLivro) {
        Leitor leitor = buscarLeitor(email);
        return leitor.adicionarFavorito(nomeLivro);
    }

    public String[] listarLivrosPreferidos(String email) {
        Leitor leitor = buscarLeitor(email);
        return leitor.listarFavoritos();
    }

    public double obterValorTotalPagoPorLeitor(String email) {
        Leitor leitor = buscarLeitor(email);
        return leitor.getValorTotal();
    }
    
    private ClubesDeLeitura buscarClube(String nomeClube) {
        for (int i = 0; i < qntClubes; i++) {
            if (clubes[i].getNomeClube().equals(nomeClube)) {
                return clubes[i];
            }
        }
        throw new IllegalArgumentException("Clube não encontrado.");
    }

    private Leitor buscarLeitor(String email) {
        for (int i = 0; i < qntLeitores; i++) {
            if (leitores[i].getEmail().equals(email)) {
                return leitores[i];
            }
        }
        throw new IllegalArgumentException("Leitor não encontrado.");
    }
}
