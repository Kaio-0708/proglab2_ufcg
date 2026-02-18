package Conta;

import java.util.HashMap;

public class ContaController {
	private HashMap<Integer, Contabil> contas;
	private int cont;
	
	public ContaController() {
		contas = new HashMap<>();
		cont = 1;
	}
	
	public void cadastrarContaCorrente(String cpf, double chequeEspecial) {
		ContaCorrente conta = new ContaCorrente(cpf, cont, chequeEspecial);
		contas.put(cont, conta);
		cont ++;
	}
	public void cadastrarContaPoupanca(String cpf) {
		ContaPoupanca conta = new ContaPoupanca(cpf, cont);
		contas.put(cont, conta);
		cont ++;
	}
	public void cadastrarContaFamilia(String cpf1, String cpf2) {
		ContaFamilia conta = new ContaFamilia(cont, cpf1, cpf2);
		contas.put(cont, conta);
		cont ++;
	}
	public boolean sacar(int numero, double valor) {
		Contabil c = contas.get(numero);
		
		if(c != null) {
			return c.sacar(valor);
		}
		return false;
	}
	
	public void depositar(int numero, double valor) {
		Contabil c = contas.get(numero);
		
		if (c != null) {
	        c.depositar(valor);
	    }
	}
}
