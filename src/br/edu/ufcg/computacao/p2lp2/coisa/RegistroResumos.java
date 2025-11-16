package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.*;

public class RegistroResumos {
	
	private int numeroDeResumos;
	
    private int contador;
    
    private Resumo[] resumos;
    
	public RegistroResumos (int numeroDeResumos) {
		this.numeroDeResumos = numeroDeResumos;
		this.resumos = new Resumo[numeroDeResumos];
		this.contador = 0;
	}
	
	public void adiciona(String tema, String conteudo) {
		if(!temResumo(tema)) {
			Resumo r = new Resumo(tema, conteudo);
			resumos[contador % numeroDeResumos] = r;
			contador ++;					
		}
	}
	
	public String[] pegaResumos() {
		String[] saida = new String[conta()];	
		for(int i =0 ; i < conta(); i++){
			saida[i] = resumos[i].toString();
		}
		return saida;
	}
	
	public String imprimeResumos() {
		String saida = "";
		
		for(int i =0; i < conta(); i++) {
			if(!(saida.equals(""))) {
				saida += " | " + resumos[i].getName();
			}else {
				saida += resumos[i].getName();
			}
		}
		
		return "- " + conta() + " resumo(s) cadastrados(s) \n" + "- " + saida;
	}
	
	public int conta() {
		if(contador < numeroDeResumos) {
			return contador;
		}
		return numeroDeResumos;
	}   
	
	public boolean temResumo(String tem) {
		for(int i = 0; i < conta(); i++) {
			if(tem.equals(resumos[i].getName())) {
				return true;
			}
		}
		    return false;
	}
	
	public String [] busca(String chaveDeBusca) {
		List<String> encontrados = new ArrayList<>();
        
		String chavePadronizar = chaveDeBusca.toLowerCase();
		
		for(int i = 0; i < conta(); i++) {
			String conteudoPadronizar = resumos[i].getConteudo().toLowerCase();
			if(conteudoPadronizar.contains(chavePadronizar)) {
				encontrados.add(resumos[i].getName());
			}
		}
		
		Collections.sort(encontrados);
		
		return encontrados.toArray(new String[0]);
	}   
	
	}
