package br.com.proway.senior.controledeferias;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusDeChamadosTest {

	@Test
	public void testeGetChamados() {
		StatusDeChamados main = new StatusDeChamados();
		main.criarChamados();
		
		int tipoChamado = 0;
		String[] retornoChamados = main.getChamados(tipoChamado);
		assertEquals("chamado 01", retornoChamados[0]);
		assertEquals("chamado 02", retornoChamados[1]);
		assertEquals("chamado 03", retornoChamados[2]);		

	}

}
