package LNG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LateNigthGramController {
	private HashMap<String, Usuario> usuarios;
	private HashSet<Cronica> cronicas;
	
	public LateNigthGramController() {
		this.cronicas = new HashSet<>();
		this.usuarios = new HashMap<>();
	}
	
	public void cadastrarUsuario(String nick, String email, String nome) {
		if("".equals(nick.trim())){
			throw new IllegalArgumentException("Nick vazio");
		}
		
		Usuario u = new Usuario(nick, email, nome);
		usuarios.put(nick, u);
	}
	
	public String recuperarUsuario(String nick) {
		Usuario u = usuarios.get(nick);
		
		if(u == null) {
			return "Usuário não encontrado";
		}
		
		return u.toString();
	}
	
	public String[] listarUsuario() {
		String[] lista = new String[usuarios.size()];
		List<Usuario> usuario = new ArrayList<>(usuarios.values());
		
		for(int i = 0; i < usuario.size(); i++) {
			lista[i] = usuario.get(i).getNick();
		}
		
		return lista;
	}
	
	public int fazerPostUsuario(String nick, String texto, String link) {
		Usuario u = usuarios.get(nick);
		
		if (u == null) {
	        throw new IllegalArgumentException("Usuário não encontrado");
	    }
		
		u.adicionarPost(texto, link);
		
		return 0;
	}
	
	public String[] exibirPostUsuario(String nick) {
		Usuario u = usuarios.get(nick);
		List<Post> posts = u.getPosts();
		String[] exibir = new String[posts.size()];
		
		for(int i = 0; i < posts.size(); i++) {
			exibir[i] = posts.get(i).toString();
		}
		
		return exibir;
	}
	
	public boolean cadastrarCronica(String nick, String tema, String titulo, String texto) {
		if("".equals(titulo.trim())){
			throw new IllegalArgumentException("Titulo vazio");
		}
		
		Usuario u = usuarios.get(nick);
		
		if (u == null) {
	        throw new IllegalArgumentException("Usuário não encontrado");
	    }
		
		Cronica c = new Cronica(u, tema, titulo, texto);
		cronicas.add(c);
		
		return true;
	}
	
	public String[] listarTemasDasCronica() {
		String[] lista = new String[cronicas.size()];
		List<Cronica> c = new ArrayList<>(cronicas);
		
		for(int i = 0; i < c.size(); i++) {
			lista[i] = c.get(i).getTema();
		}
		
		return lista;
	}
	
	public String[] listarCronicasTema(String tema) {
		int cont = 0;
		List<Cronica> c = new ArrayList<>(cronicas);
		
		for(int i = 0; i < c.size(); i++) {
			if(c.get(i).getTema().equals(tema)) {
				cont ++;
			}
		}
		
		String[] lista = new String[cont];
		int indice = 0;
		
		for(int j =0; j < c.size(); j++) {
			if(c.get(j).getTema().equals(tema)) {
				lista[indice] = c.get(j).toString();
				indice ++;
			}
		}
		
		return lista;
	}
	
	public boolean curtirPostAutor(String nickAutor, int posPost) {
		Usuario u = usuarios.get(nickAutor);
		
		if (u == null) {
	        throw new IllegalArgumentException("Usuário não encontrado");
	    }
		
		if(posPost < 0 || posPost >= u.getPosts().size()) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		u.curtirPost(posPost);
		
		return true;
	}
	
	public boolean curtirCronica(String titulo) {
		List<Cronica> lista = new ArrayList<>(cronicas);
		
		Cronica c = null;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getTitulo().equals(titulo)) {
				c = lista.get(i);
				break;
			}
		}
		
		if(c == null) {
			throw new IllegalArgumentException("Crônica não encontrada");
		}
		
		c.curtir();
		return true;
	}
	
	public String[] listarEspecialistas() {
		List<Usuario> u = new ArrayList<>(usuarios.values());
		List<String> especialistas = new ArrayList<>();
		
		for(int i = 0; i < u.size(); i++) {
			if(u.get(i).isEspecialista()) {
				especialistas.add(u.get(i).getNick());
			}
		}
		
		return especialistas.toArray(new String[0]);
	}
}
