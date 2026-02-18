package Conta;

public class ContaCorrente implements Contabil{
	private String cpf;
	private double saldo;
	private int numero;
	private double chequeEspecial;
	
	public ContaCorrente(String cpf, int numero, double chequeEspecial) {
		this.cpf = cpf;
		this.saldo = 0;
		this.numero = numero;
		this.chequeEspecial = chequeEspecial;
	}

	@Override
	public boolean sacar(double valor) {
		if(valor < (saldo + chequeEspecial)) {
			saldo -= valor;
			return true;
		}
		return false;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}		
}
