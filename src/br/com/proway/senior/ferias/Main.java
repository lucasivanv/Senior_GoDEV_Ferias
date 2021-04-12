package br.com.proway.senior.ferias;

public class Main {
	public static void main(String[] args) {
		/*O sistema recebe o colaborador e verifica se 
		ele possui saldo de férias positivo.*/
		System.out.println(informarSaldo(1));
		
	}
	
	static int[] saldoDeFerias = {20, 30, 15, 10};

	//O sistema recebe o colaborador e verifica se ele possui saldo de férias positivo.
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

	//Se não, informa que não existe saldo positivo de férias.
	public static String informarSaldo(int idColaborador) {
		String mensagem;

		if(verificarSePossuiSaldoPositivo(idColaborador)) {
			mensagem = "Saldo positivo: " + consultarSaldo(idColaborador);
		}
		else {
			mensagem = "Não existe saldo de férias disponível para o usuário informado.";
		}
		return mensagem;
	}
	
	/*Se sim, o sistema retorna relação de períodos de férias tiradas, contendo o tipo: 
	férias vendidas (valor), férias de direito (quantidade de dias, 
			e data de início e fim)*/
	public static 
	
	
	
	
}
