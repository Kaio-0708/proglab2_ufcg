package PRW;

public class Restaurante {
	private String nome;
	private String pratoEscolhido;
	private final double valorMenu = 89.90;
	private Clientes[] clientes = new Clientes[100];
	private int qntCliente;
	private int voto;
	
	public Restaurante(String nome, String pratoEscolhido) {
		this.nome = nome;
		this.pratoEscolhido = pratoEscolhido;
		this.qntCliente = 0;
		this.voto = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPratoEscolhido() {
		return pratoEscolhido;
	}
	
	public double getValorMenu() {
		return valorMenu;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public int getQntCliente() {
		return qntCliente;
	}
	
	public void registrarVisita(Clientes cliente) {
		for (int i = 0; i < qntCliente; i++) {
			if (clientes[i].getEmail().equals(cliente.getEmail())) {
				return;
			}
		}
		clientes[qntCliente] = cliente;
		qntCliente++;
	}
	
	public String votar(Clientes cliente) {
		for (int i =0; i < qntCliente; i ++) {
			if (clientes[i].getEmail().equals(cliente.getEmail())){
				voto ++;
				cliente.escolherPratoPreferido(pratoEscolhido);
				return "Voto registrado com sucesso!";
			}
		}
		
		return "Voto não registrado";
	}
	
	public String[] listarClientes() {
		String [] lista = new String[qntCliente];
		for (int i = 0; i < qntCliente;  i ++) {
			lista[i] = clientes[i].toString();
		}
        return lista;
	}
}
