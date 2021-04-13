package br.com.proway.senior.controledeferias;

import java.util.ArrayList;

public class ColaboradorLider {
	static int[] listaDeColaboradores = { 0, 1, 4 };// lista com id de colaboradores
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 }; // substituir por valor recebido do Banco de dados
	static int recebeColaboradores = 1; // recebe colaboradores do Banco de dados

	public static void main(String[] args) {

		// O método retorna quantidade de saldo disponível de férias do colaborador.
		int saldoFerias = consultarSaldo(3);
		System.out.println("Você possúi " + saldoFerias + " dias de férias");

		// O método retorna se o usuário possúi colaboradores em sua equipe
		boolean possuiColab = consultarColaboraoresDaEquipe(recebeColaboradores);
		
		consultaSituacaoDeFeriasDaEquipe(possuiColab, listaDeColaboradores, saldoDeFerias);

	}

	/**
	 * Consulta saldo de férias Recebe um id de colaborador e utiliza ele como
	 * parametro para encontrar o saldo de férias que está em no vetor saldoDeFerias
	 * 
	 * @param id int Recebe um valor para selecionar intem do vetor
	 * @return saldo de férias
	 */
	public static int consultarSaldo(int id) {
		int saldo = saldoDeFerias[id];
		return saldo;

	}

	/**
	 * Verifica se possúi colaboradores na equipe 
	 * Verifica se o usúario possúi colaboradores em sua equipe atravé de valor recebido
	 * 
	 * @param id int Recebe um valor (quantidade de funcionarios) para fazer a
	 *           validação
	 * @return possuiColab true ou false
	 */
	public static boolean consultarColaboraoresDaEquipe(int id) {
		boolean possuiColab = (id <= 0) ? false : true;
		return possuiColab;
	}
/**
 * Consulta férias de membros da equipe
 * Após verificar se o usúario possúi colaboradores em sua equipe, 
 * o sistema retorna quais colaboradores são da equipe e o saldo de férias de cada um
 * 
 * @param possuiColab boolean recebe informação se possúi colaboradores ou não
 * @param listaDeColaboradores int[] recebe vetor com lista de colaboradores
 * @param saldoDeFerias int[] recebe vetor com saldo de férias por colaborador
 */
	public static ArrayList<Integer> consultaSituacaoDeFeriasDaEquipe(boolean possuiColab, int[] listaDeColaboradores,
			int[] saldoDeFerias) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if (possuiColab == true) {
			System.out.println("Você possúi " + listaDeColaboradores.length + " colaboradores em sua equipe.");
			for (int c = 0; c < listaDeColaboradores.length; c++) {
				lista.add(saldoDeFerias[c]);
				lista.add(listaDeColaboradores[c]);
			}
		} else {
			System.out.println("O usuário não possúi colaboradores em sua equipe");
		}
		return lista;
	}

}
