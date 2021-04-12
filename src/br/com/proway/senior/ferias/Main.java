package br.com.proway.senior.ferias;

public class Main {
	public static void main(String[] args) {
		/*O sistema recebe o colaborador e verifica se 
		ele possui saldo de f�rias positivo.*/
		System.out.println(informarSaldo(1));
		
	}
	
	static int[] saldoDeFerias = {20, 30, 15, 10};

	//O sistema recebe o colaborador e verifica se ele possui saldo de f�rias positivo.
	public static boolean verificarSePossuiSaldoPositivo(int idColaborador) {
		int saldo = consultarSaldo(idColaborador);
		boolean podeTirarFerias = saldo > 0 ? true : false;

		return podeTirarFerias;
	}
	
	//metodo branch bruno
	public static int consultarSaldo(int idColaborador) {
		int saldo = saldoDeFerias[idColaborador];
		return saldo;
	}

	//Se n�o, informa que n�o existe saldo positivo de f�rias.
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
	
	/*Se sim, o sistema retorna rela��o de per�odos de f�rias tiradas, contendo o tipo: 
	f�rias vendidas (valor), f�rias de direito (quantidade de dias, 
			e data de in�cio e fim)*/
	public static 
	
	
	
	
}
