package Clube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClubeDoCafeController {
	
	private HashMap<String, Cafe> cafes;
	private HashMap<String, Socio> socios;
	
	public ClubeDoCafeController() {
		this.cafes = new HashMap<>();
		this.socios = new HashMap<>();
	}
	
	public boolean cadastrarCafeTradicional(String nome, String origem, int intensidade, int tempoTorra) {
		CafeTradicional cafeT = new CafeTradicional(nome, origem, intensidade, tempoTorra);
		
		if(cafes.containsKey(cafeT.getNome())) {
			throw new IllegalArgumentException("Cadastrado já realizado!");
		}
		
		cafes.put(nome, cafeT);
		
		return true;
	}
	
	public boolean cadastrarCafeEspecial(String nome, String origem, int intensidade, int nivelAroma) {
		CafeEspecial cafeF = new CafeEspecial(nome, origem, intensidade, nivelAroma);
		
		if(cafes.containsKey(cafeF.getNome())) {
			throw new IllegalArgumentException("Cadastrado já realizado!");
		}
		
		cafes.put(nome, cafeF);
		
		return true;
	}
	
	public boolean cadastrarCafePremium(String nome, String origem, int intensidade, int raridade) {
		CafePremium cafeP = new CafePremium(nome, origem, intensidade, raridade);
		
		if(cafes.containsKey(cafeP.getNome())) {
			throw new IllegalArgumentException("Cadastrado já realizado!");
		}
		
		cafes.put(nome, cafeP);
		
		return true;
	}
	
	public String[] listarCafes() {
		List<Cafe> cafe = new ArrayList<>(cafes.values());
		
		String[] lista = new String[cafe.size()];
		
		for(int i = 0; i < cafe.size(); i++) {
			lista[i] = cafe.get(i).toString();
		}
		
		return lista;
	}
	
	public boolean cadastrarSocio(String codigo, String nome) {
		Socio socio = new Socio(codigo, nome);
		
		if(socios.containsKey(socio.getCodigo())) {
			throw new IllegalArgumentException("Cadastrado já realizado!");
		}
		
		socios.put(codigo, socio);
		
		return true;
	}
	
	public void mudarStatusSocio(String codigo) {
		Socio socio = socios.get(codigo);
		socio.alterarStatus();
	}
	
	public String[] listarSocios() {
		List<Socio> socio = new ArrayList<>(socios.values());
		
		String[] lista = new String[socio.size()];
		
		for(int i = 0; i < socio.size(); i++) {
			lista[i] = socio.get(i).toString();
		}
		
		return lista;
	}
	
	public boolean degustar(String codigoSocio, String nomeCafe, int nota, String comentario) {
		Socio socio = socios.get(codigoSocio);
		Cafe cafe= cafes.get(nomeCafe);
		
		if(socio == null || cafe == null) {
			throw new IllegalArgumentException("Sócio e café não encontrado!");
		}
		
		if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
		
		if(!socio.getStatus()) {
		    return false;
		}
		
		Opiniao opiniao = new Opiniao(socio.getCodigo(), cafe.getNome(), nota, comentario);
		
		cafe.addOpiniao(opiniao);
		
		return true;
	}
	
	public String buscarCafeMelhorQualidade() {
		List<Cafe> cafe = new ArrayList<>(cafes.values());
		
		cafe.sort((c1, c2) -> {int comparacao = Double.compare(c2.definirQualidade(), c1.definirQualidade());
			if(comparacao != 0) {
				return comparacao;
			} else {
				return c1.getNome().compareTo(c2.getNome());
			}
		});
		
		return cafe.get(0).getNome();
	}
	
	public boolean adicionarCafeMeusFavoritos(String nomeCafe, String codigoSocio) {
		Cafe cafe = cafes.get(nomeCafe);
		Socio socio = socios.get(codigoSocio);
		
		if(cafe == null || socio == null) {
			throw new IllegalArgumentException("Café e sócio não encontrado!");
		}
		
		socio.addFavoritos(cafe, socio);
		
		return true;
	}
}

