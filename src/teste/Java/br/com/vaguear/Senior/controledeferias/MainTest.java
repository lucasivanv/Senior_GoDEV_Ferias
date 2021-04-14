package br.com.proway.senior.controledeferias;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class MainTest {

	@Test
	public void verificaSeIntervaloEntreDataSolicitacaoEDataInicioFeriasEhMaiorQue10Dias() {
		boolean intervaloEntreSolicitacaoEInicio = Main.verificarDataSolicitacao(LocalDateTime.now().plusDays(20));
		assertTrue(intervaloEntreSolicitacaoEInicio);
	}
	
	@Test
	public void verificaSeIntervaloEntreDataSolicitacaoEDataInicioFeriasEhMenorQue10Dias() {
		boolean intervaloEntreSolicitacaoEInicio = Main.verificarDataSolicitacao(LocalDateTime.now().plusDays(7));
		assertFalse(intervaloEntreSolicitacaoEInicio);
	}
	
	@Test
	public void verificaSeIntervaloEntreDataInicioEDataFimFeriasEhMenorQue20Dias() {
		boolean intervaloEntreSolicitacaoEInicio = Main.verificarIntervaloFeriasParciais(LocalDateTime.of(2021, 3, 29, 0, 0), LocalDateTime.of(2021, 4, 10, 0, 0));
		assertTrue(intervaloEntreSolicitacaoEInicio);
	}
	
	@Test
	public void verificaSeIntervaloEntreDataInicioEDataFimFeriasEhMaiorQue20Dias() {
		boolean intervaloEntreSolicitacaoEInicio = Main.verificarIntervaloFeriasParciais(LocalDateTime.of(2021, 3, 29, 0, 0), LocalDateTime.of(2021, 5, 1, 0, 0));
		assertFalse(intervaloEntreSolicitacaoEInicio);
	}
	
	@Test
	public void verificaSeIntervaloEntreDataInicioEDataFimParaFeriasTotaisEhIgualA30Dias() {
		LocalDateTime dataInicioFeriasTotais = LocalDateTime.of(2021, 3, 29, 0, 0);
		LocalDateTime dataFimFeriasTotais = Main.calculaDataFimFeriasTotais(dataInicioFeriasTotais);
		boolean intervaloEntreDataInicioEFim = dataInicioFeriasTotais.until(dataFimFeriasTotais, ChronoUnit.DAYS) == 30? true : false;
		assertTrue(intervaloEntreDataInicioEFim);
	}
	
	//Janaina <<<<<<<<<<<<< start
	
	@Test
	public void testeVerificaSePossuiSaldoPositivo() {
		int[] saldoDeFerias = { 20, 30, 15, 10 };
		int idColaborador = 1;
		
		boolean possuiSaldo = Main.verificarSePossuiSaldoPositivo(idColaborador, saldoDeFerias[2]);
		assertEquals(possuiSaldo, true);
	}

	@Test
	public void testeInformaChamado() {
		boolean existeSaldo = true;
		int idColaborador = 1; 
		
		String mensagem = Main.informarSaldo(existeSaldo, idColaborador);
		
		assertEquals(mensagem, "Saldo positivo: 30");
	}
	
	@Test
	public void testeGetSaldo() {
		int idColaborador = 1;
		int saldo = Main.pegarSaldo(idColaborador);
		
		assertEquals(saldo, 30);
	}
	
	@Test
	public void testeRetornaTipoDeFerias() {
		int tipoDeFerias = 1;
		
		String ferias = Main.retornarTipoDeFerias(tipoDeFerias);
		
		assertEquals(ferias, "Vendidas");
	}
	
	@Test
	public void testeRetornaValorDasFeriasVendidas() {
		int totalDiasTirados = 2;
		double valorUmDiaDeTrabalho = 10;
		double valorTotal = Main.retornarValorDasFeriasVendidas(totalDiasTirados, valorUmDiaDeTrabalho);
		
		assertEquals(valorTotal, 20, 0.1);
	}
	
	@Test
	public void testeRetornarIntervaloEmDiasEntreAsDatas() {
		LocalDate dataInicio = LocalDate.of(2020, 01, 01);
		LocalDate dataTermino = LocalDate.of(2020, 01, 11);
		
		long dias = Main.retornarIntervaloEmDiasEntreAsDatas(dataInicio, dataTermino);
		assertEquals(dias, 10);
	}
	
	@Test
	public void testeRetornaColaboradoresDoSetor() {
		Main.gerarColaboradores();
		int idSetor = 1;
		String[] esperado = {"Pessoa 5", "Pessoa 6", "Pessoa 7"};
		ArrayList<String> colaboradores = Main.retornarColaboradoresDoSetor(idSetor);
		
		for(int i = 0; i < colaboradores.size(); i++) {
			assertEquals(colaboradores.toArray()[i], esperado[i]);
		}
	}
	
	@Test
	public void testeAlterarPeriodoDeFeriasParciais() {
		int idPeriodo = 0;
		
		LocalDate novaDataInicio = LocalDate.of(2021, 01, 01);
		LocalDate novaDataTermino = LocalDate.of(2021, 01, 11);
		
		Main.feriasTiradas[idPeriodo] = 5;
		
		Main.alterarPeriodoDeFeriasParciais(idPeriodo, novaDataInicio, novaDataTermino);
		
		assertEquals(Main.feriasTiradas[idPeriodo], 10);
		
	}
	
	@Test
	public void testeInformarNovoPeriodoDeConcessaoParcial() {
		int idTipoDePeriodo = 0;
		LocalDate dataInicio = LocalDate.of(2021, 01, 01);
		LocalDate dataTermino =  LocalDate.of(2021, 01, 11);
		String mensagem = Main.informarNovoPeriodoDeConcessaoParcial(idTipoDePeriodo, dataInicio, dataTermino);
		assertEquals(mensagem, "Tipo de período: parcial. Quantidade de dias tirados: 10.");
		
	}
	
	@Test
	public void testeInformarNovoPeriodoDeConcessaoTotal() {
		int idTipoDePeriodo = 1;
		int idFeriasTiradas = 0;
		
		Main.feriasTiradas[idFeriasTiradas] = 5;
		String mensagem = Main.informarNovoPeriodoDeConcessaoTotal(idTipoDePeriodo, idFeriasTiradas);
		assertEquals(mensagem, "Tipo de período: total. Quantidade de dias tirados: 5.");
		
	}
	
	@Test
	public void testeNovoPeriodoEhValido() {
		int periodoAtual = 5;
		LocalDate dataInicio = LocalDate.of(2021, 01, 01);
		LocalDate dataTermino =  LocalDate.of(2021, 01, 11);
		
		boolean valido = Main.novoPeriodoEhValido(periodoAtual, dataInicio, dataTermino);
		assertEquals(valido, false);
	}
	
	//Janaina <<<<<<<<<<<<< end
	
	//Bruno START
	static int[] listaDeColaboradores = { 0, 1, 4 };// lista com id de colaboradores
	static int[] saldoDeFerias = { 30, 25, 40, 10, 5 }; // substituir por valor recebido do Banco de dados
	static int recebeColaboradores = 1; // recebe colaboradores do Banco de dados
	boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(recebeColaboradores);


		
	@Test
	public void testeConsultaDeSaloDeFerias1() {
		int saldo = ColaboradorLider.consultarSaldo(2);
		assertEquals(saldo,40);
	}

	@Test
	public void testeConsultaDeSaloDeFerias2() {
		int saldo = ColaboradorLider.consultarSaldo(2);
		assertNotEquals(saldo,42);
	}
	
	@Test
	public void testeConsultarSePossuiColaboradoresNaEquipe1() {
		boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(0);
			assertEquals(possuiColab, false);
		}
	@Test
	public void testeConsultarSePossuiColaboradoresNaEquipe2() {
		boolean possuiColab = ColaboradorLider.consultarColaboraoresDaEquipe(0);
			assertNotEquals(possuiColab, true);
		}
	
	@Test
	public void testeConsultaSituacaoDeFeriasDaEquipe() {
		ColaboradorLider ColaboradorLider = new ColaboradorLider();
		ArrayList<Integer> saldos = ColaboradorLider.consultaSituacaoDeFeriasDaEquipe(listaDeColaboradores, saldoDeFerias);
		for(int i = 0; i < saldos.size(); i++) {
			int saldoRecebido = saldos.get(i);
			int j = listaDeColaboradores[i];
			int saldoEsperado = saldoDeFerias[j];
			assertEquals(saldoRecebido, saldoEsperado);	
		}

	}
	// BRUNO END
//DANI
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
