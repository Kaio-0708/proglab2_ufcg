package RB;

public class RepareBem {
	private Reparo[] reparos = new Reparo[100];
	private OrdemDeServico[] ordens = new OrdemDeServico[10];
	private int qntReparo = 0;
	private int qntOrdens = 0;
	
	public void cadastrarReparo(String idReparo, String descricao, double preco) {
		for(int i = 0; i < qntReparo; i++) {
			if(reparos[i].getIdentificador().equals(idReparo)) {
				return;
			}
		}
		
		reparos[qntReparo] = new Reparo(idReparo, descricao, preco);
		qntReparo ++;
	}
	
	public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
		OrdemDeServico os = new OrdemDeServico(cliente, telefone, roupa);
		ordens[qntOrdens] = os;
		qntOrdens++;
		return os.getId();
	}
	
	public void reajustarPrecoReparo(String idReparo, double percentual) {
		for(int i = 0; i < qntReparo; i++) {
			if(reparos[i].getIdentificador().equals(idReparo)) {
				reparos[i].reajustarPercentual(percentual);
				return;
			}
		}
	}
	
	public void mudarStatusOrdemDeServico(int idOS, String status) {
		for(int i = 0; i < qntOrdens; i++) {
			if(ordens[i].getId()==(idOS)) {
				ordens[i].mudarStatus(status);
				return;
			}
		}
	}
}
