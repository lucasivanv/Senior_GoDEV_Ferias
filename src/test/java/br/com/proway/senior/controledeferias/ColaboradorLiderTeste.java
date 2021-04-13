package br.com.proway.senior.controledeferias;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.controledeferias.ColaboradorLider;

public class ColaboradorLiderTeste {
	static int[] listaDeColaboradores = { 0, 1, 4 };// lista com id de colaboradores
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 }; // substituir por valor recebido do Banco de dados
	static int recebeColaboradores = 1; // recebe colaboradores do Banco de dados
	boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(recebeColaboradores);


		
	@Test
	public void test() {
		int saldo = ColaboradorLider.consultarSaldo(2);
		assertEquals(saldo,40);
	}

	@Test
	public void test2() {
		int saldo = ColaboradorLider.consultarSaldo(2);
		assertNotEquals(saldo,42);
	}
	
	@Test
	public void test3() {
		boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(0);
			assertEquals(possuiColab, false);
		}
	@Test
	public void test4() {
		boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(0);
			assertNotEquals(possuiColab, true);
		}
	@Test
	public void test5() {
		ColaboradorLider ColaboradorLider = new ColaboradorLider();
		ArrayList<Integer> lista = ColaboradorLider.consultaSituacaoDeFeriasDaEquipe(possuiColab, listaDeColaboradores, saldoDeFerias);
//		assertEquals(lista, );
	}
	
}

