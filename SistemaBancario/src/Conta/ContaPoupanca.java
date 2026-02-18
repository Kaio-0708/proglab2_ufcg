package Conta;

public class ContaPoupanca implements Contabil{
    private String cpf;
    private double saldo;
    private double percentualRendimento;
    private int numero;
    
    public ContaPoupanca(String cpf, int numero) {
    	this.cpf = cpf;
    	this.numero = numero;
    	this.percentualRendimento = 0.02;
    	this.saldo = 0;
    }
	
	@Override
	public boolean sacar(double valor) {
		if(valor <= saldo) {
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
