package br.com.proway.senior.ferias;

public class Main {
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 };	
	
	public static void main(String[] args) {
		int saldo = consultarSaldo(4);
		System.out.println("O seu saldo � " + saldo);
	}
	// Se sim, o sistema retorna quantidade de saldo dispon�vel de f�rias do colaborador.



	public static int consultarSaldo(int idColaborador) {
		int saldo = saldoDeFerias[idColaborador];
		return saldo;
	}
	
}
