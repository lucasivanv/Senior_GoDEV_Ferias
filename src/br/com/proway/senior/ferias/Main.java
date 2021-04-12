package br.com.proway.senior.ferias;

public class Main {
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 };

	public static void main(String[] args) {

		// O método retorna quantidade de saldo disponível de férias do colaborador.
		int saldo = consultarSaldo(4);
		System.out.println("O seu saldo é " + saldo);
	}

	public static int consultarSaldo(int idColaborador) {
		int saldo = saldoDeFerias[idColaborador];
		return saldo;

	}
	
	//O sistema recebe o usuário e verifica se este possui colaboradores em sua equipe
	public static int consultarColaboraoresDaEquipe(int idColaborador) {
		
	}
}
