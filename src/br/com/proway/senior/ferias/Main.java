package br.com.proway.senior.ferias;

public class Main {
	public static void main(String[] args) {
		/*O sistema recebe o colaborador e verifica se 
		ele possui saldo de f�rias positivo.*/
		System.out.println(informarSaldo(1));
		
	}
	
	static int[] saldoDeFerias = {20, 30, 15, 10};

	public static boolean verificarSePossuiSaldoPositivo(int idColaborador) {
		int saldo = consultarSaldo(idColaborador);
		boolean podeTirarFerias = saldo > 0 ? true : false;

		return podeTirarFerias;
	}
	
	public static int consultarSaldo(int idColaborador) {
		int saldo = saldoDeFerias[idColaborador];
		return saldo;
	}

	public static String informarSaldo(int idColaborador) {
		String mensagem;

		if(verificarSePossuiSaldoPositivo(idColaborador)) {
			mensagem = "Saldo positivo: " + consultarSaldo(idColaborador);
		}
		else {
			mensagem = "N�o existe saldo de f�rias dispon�vel para o usu�rio informado.";
		}
		return mensagem;
	}
	
	
	
	
	
	
}
