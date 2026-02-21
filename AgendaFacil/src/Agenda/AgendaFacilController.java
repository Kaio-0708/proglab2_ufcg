package Agenda;

import java.util.HashMap;

public class AgendaFacilController {
	private HashMap<String, Estudante> estudantes;
	
	public AgendaFacilController() {
		this.estudantes = new HashMap<>();
	}
	
	public boolean cadastrarEstudante(String nome, String email) {
		return true;
	}
	
	public String exibirEstudante(String email) {
		return "ok";
	}
	
	public String[] listarEstudantes() {
		
	}
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		
	}
	
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		
	}
	
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificado) {
		
	}
	
	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento) {
		
	}
	
	public String exibitDetalhesEvento(int idEvento) {
		
	}
	
}
