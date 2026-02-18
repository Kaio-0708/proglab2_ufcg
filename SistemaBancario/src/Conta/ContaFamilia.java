package Conta;

public class ContaFamilia implements Contabil{
	private int numero;
	private double saldo;
	private double chequeEspecial;
	private String c1;
	private String c2;

	public ContaFamilia(int numero, String c1, String c2) {
		this.numero = numero;
		this.c1 = c1;
		this.c2 = c2;
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
