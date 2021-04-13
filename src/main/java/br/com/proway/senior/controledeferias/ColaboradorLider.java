package br.com.proway.senior.controledeferias;

import java.util.ArrayList;

public class ColaboradorLider {
	static int[] listaDeColaboradores = { 0, 1, 4 };// lista com id de colaboradores
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 }; // substituir por valor recebido do Banco de dados
	static int recebeColaboradores = 1; // recebe colaboradores do Banco de dados

	public static void main(String[] args) {

		// O m�todo retorna quantidade de saldo dispon�vel de f�rias do colaborador.
		int saldoFerias = consultarSaldo(3);
		System.out.println("Voc� poss�i " + saldoFerias + " dias de f�rias");

		// O m�todo retorna se o usu�rio poss�i colaboradores em sua equipe
		boolean possuiColab = consultarColaboraoresDaEquipe(recebeColaboradores);
		
		consultaSituacaoDeFeriasDaEquipe(possuiColab, listaDeColaboradores, saldoDeFerias);

	}

	/**
	 * Consulta saldo de f�rias Recebe um id de colaborador e utiliza ele como
	 * parametro para encontrar o saldo de f�rias que est� em no vetor saldoDeFerias
	 * 
	 * @param id int Recebe um valor para selecionar intem do vetor
	 * @return saldo de f�rias
	 */
	public static int consultarSaldo(int id) {
		int saldo = saldoDeFerias[id];
		return saldo;

	}

	/**
	 * Verifica se poss�i colaboradores na equipe 
	 * Verifica se o us�ario poss�i colaboradores em sua equipe atrav� de valor recebido
	 * 
	 * @param id int Recebe um valor (quantidade de funcionarios) para fazer a
	 *           valida��o
	 * @return possuiColab true ou false
	 */
	public static boolean consultarColaboraoresDaEquipe(int id) {
		boolean possuiColab = (id <= 0) ? false : true;
		return possuiColab;
	}
/**
 * Consulta f�rias de membros da equipe
 * Ap�s verificar se o us�ario poss�i colaboradores em sua equipe, 
 * o sistema retorna quais colaboradores s�o da equipe e o saldo de f�rias de cada um
 * 
 * @param possuiColab boolean recebe informa��o se poss�i colaboradores ou n�o
 * @param listaDeColaboradores int[] recebe vetor com lista de colaboradores
 * @param saldoDeFerias int[] recebe vetor com saldo de f�rias por colaborador
 */
	public static ArrayList<Integer> consultaSituacaoDeFeriasDaEquipe(boolean possuiColab, int[] listaDeColaboradores,
			int[] saldoDeFerias) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if (possuiColab == true) {
			System.out.println("Voc� poss�i " + listaDeColaboradores.length + " colaboradores em sua equipe.");
			for (int c = 0; c < listaDeColaboradores.length; c++) {
				lista.add(saldoDeFerias[c]);
				lista.add(listaDeColaboradores[c]);
			}
		} else {
			System.out.println("O usu�rio n�o poss�i colaboradores em sua equipe");
		}
		return lista;
	}

}
