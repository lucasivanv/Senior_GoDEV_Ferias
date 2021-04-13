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
}
