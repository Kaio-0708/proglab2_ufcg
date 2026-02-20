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
		
		return usuarios.toString();
	}
	
	public String[] listarUsuario() {
		String[] lista = new String[usuarios.size()];
		List<Usuario> usuario = new ArrayList<>(usuarios.values());
		
		for(int i = 0; i < usuario.size(); i++) {
			lista[i] = usuario.get(i).getNick();
		}
		
		return lista;
	}
}
