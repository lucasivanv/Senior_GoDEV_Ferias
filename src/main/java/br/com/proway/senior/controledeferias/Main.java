package br.com.proway.senior.controledeferias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

	/**
	 * Verifica intervalo entre data da solicita��o e data de inicio das f�rias
	 * 
	 * Verifica se a data de in�cio das f�rias solicitada � 10 dias ap�s a data de solicita��o, retornando verdadeiro caso seja.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de �nicio de f�rias solicitada
	 * @return boolean, de acordo com a condi��o (maior que 10 dias)
	 */
	public static boolean verificarDataSolicitacao(LocalDateTime dataInicioFerias) {
		boolean intervaloSuperior10dias = LocalDateTime.now().until(dataInicioFerias, ChronoUnit.DAYS) > 10? true : false;
		return intervaloSuperior10dias;
	}
	/**
	 * Verifica intervalo entre data inicio e data fim f�rias parciais
	 * 
	 * Verifica se o intervalo entre a data de in�cio e data de fim, considerando f�rias parciais, � inferior a 20 dias, retornando verdadeiro caso seja.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
	 * @return boolean, de acordo com a condi��o (inferior a 20 dias)
	 */
	public static boolean verificarIntervaloFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias) {
		boolean intervaloInferior20dias = dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS) < 20? true : false;
		return intervaloInferior20dias;
	}

	/**
	 * Registra as datas de in�cio e fim das f�rias totais
	 * 
	 * Realiza o registro das datas de in�cio e fim de f�rias totais solicitadas pelo colaborador. 
	 * A data fim � calculada 30 dias ap�s a data de in�cio solicitada.
	 * O registro do pedido s� ocorre caso a data de in�cio das f�rias seja, pelo menos, ap�s 10 dias a data da solicita��o. 
	 * 
	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
	 */
	public static void registraFeriasTotais(LocalDateTime dataInicioFerias){
		if (verificarDataSolicitacao(dataInicioFerias)) {

			LocalDateTime dataFimFerias = calculaDataFimFeriasTotais(dataInicioFerias);

			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);

		} else {
			System.out.println("A data da solicita��o � inferior a 10 dias deste chamado");
		}
	}

	/**
	 * Registra as datas de in�cio e fim das f�rias parciais
	 * 
	 * Realiza o registro das datas de in�cio e fim de f�rias parciais solicitadas pelo colaborador. 
	 * Para solicitar f�rias parcial, o intervalo entre in�cio e fim n�o pode ser superior a 20 dias. 
	 * O registro do pedido s� ocorre caso a data de in�cio das f�rias seja, pelo menos, ap�s 10 dias a data da solicita��o. 
	 * 
	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
	 */
	public static void registraFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias){
		if (verificarDataSolicitacao(dataInicioFerias)) {

			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);
		} else {
			System.out.println("A data da solicita��o � inferior a 10 dias deste chamado");
		}
	}

	/**
	 * Calcula data fim das f�rias totais
	 * 
	 * Calcula a data fim das f�rias totais com base na data in�cio das f�rias solicitada pelo colaborador.
	 * O c�lculo � realizado considerando que a data fim ser� 30 dias ap�s a data in�cio.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
	 * @return data fim das f�rias totais
	 */
	public static LocalDateTime calculaDataFimFeriasTotais(LocalDateTime dataInicioFerias) {
		LocalDateTime dataFimFerias = dataInicioFerias.plusDays(30);
		return dataFimFerias;
	}
	
	/**
	 * Registro da data in�cio das f�rias
	 * 
	 * A SER IMPLMENTADO Realiza o registro da data de in�cio das f�rias solicitada pelo colaborador. 
	 * Este registro s� � realizado ap�s a vefica��o das datas solicitadas.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de in�cio de f�rias solicitada pelo colaborador
	 * @return
	 */
	static LocalDateTime registraDataInicioFerias(LocalDateTime dataInicioFerias) {
		// TODO implementa��o
		return dataInicioFerias;
	}

	/**
	 * Registro da data fim das f�rias
	 * 
	 * Realiza o registro da data fim das f�rias solicitada pelo colaborador. 
	 * Este registro s� � realizado ap�s a vefica��o das datas solicitadas. 
	 * 
	 * @param dataFimFerias LocalDateTime - data do fim das f�rias solicitada pelo colaborador
	 * @return
	 */
	static LocalDateTime registraDataFimFerias(LocalDateTime dataFimFerias) {
		return dataFimFerias;
	}


}
