package br.com.proway.senior.controledeferias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

	/**
	 * Verifica intervalo entre data da solicitação e data de inicio das férias
	 * 
	 * Verifica se a data de início das férias solicitada é 10 dias após a data de solicitação, retornando verdadeiro caso seja.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de ínicio de férias solicitada
	 * @return boolean, de acordo com a condição (maior que 10 dias)
	 */
	public static boolean verificarDataSolicitacao(LocalDateTime dataInicioFerias) {
		boolean intervaloSuperior10dias = LocalDateTime.now().until(dataInicioFerias, ChronoUnit.DAYS) > 10? true : false;
		return intervaloSuperior10dias;
	}
	/**
	 * Verifica intervalo entre data inicio e data fim férias parciais
	 * 
	 * Verifica se o intervalo entre a data de início e data de fim, considerando férias parciais, é inferior a 20 dias, retornando verdadeiro caso seja.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de início de férias solicitada pelo colaborador
	 * @param dataFimFerias LocalDateTime - data do fim das férias solicitada pelo colaborador
	 * @return boolean, de acordo com a condição (inferior a 20 dias)
	 */
	public static boolean verificarIntervaloFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias) {
		boolean intervaloInferior20dias = dataInicioFerias.until(dataFimFerias, ChronoUnit.DAYS) < 20? true : false;
		return intervaloInferior20dias;
	}

	/**
	 * Registra as datas de início e fim das férias totais
	 * 
	 * Realiza o registro das datas de início e fim de férias totais solicitadas pelo colaborador. 
	 * A data fim é calculada 30 dias após a data de início solicitada.
	 * O registro do pedido só ocorre caso a data de início das férias seja, pelo menos, após 10 dias a data da solicitação. 
	 * 
	 * @param dataInicioFerias LocalDateTime - data de início de férias solicitada pelo colaborador
	 */
	public static void registraFeriasTotais(LocalDateTime dataInicioFerias){
		if (verificarDataSolicitacao(dataInicioFerias)) {

			LocalDateTime dataFimFerias = calculaDataFimFeriasTotais(dataInicioFerias);

			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);

		} else {
			System.out.println("A data da solicitação é inferior a 10 dias deste chamado");
		}
	}

	/**
	 * Registra as datas de início e fim das férias parciais
	 * 
	 * Realiza o registro das datas de início e fim de férias parciais solicitadas pelo colaborador. 
	 * Para solicitar férias parcial, o intervalo entre início e fim não pode ser superior a 20 dias. 
	 * O registro do pedido só ocorre caso a data de início das férias seja, pelo menos, após 10 dias a data da solicitação. 
	 * 
	 * @param dataInicioFerias LocalDateTime - data de início de férias solicitada pelo colaborador
	 * @param dataFimFerias LocalDateTime - data do fim das férias solicitada pelo colaborador
	 */
	public static void registraFeriasParciais(LocalDateTime dataInicioFerias, LocalDateTime dataFimFerias){
		if (verificarDataSolicitacao(dataInicioFerias)) {

			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);
		} else {
			System.out.println("A data da solicitação é inferior a 10 dias deste chamado");
		}
	}

	/**
	 * Calcula data fim das férias totais
	 * 
	 * Calcula a data fim das férias totais com base na data início das férias solicitada pelo colaborador.
	 * O cálculo é realizado considerando que a data fim será 30 dias após a data início.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de início de férias solicitada pelo colaborador
	 * @return data fim das férias totais
	 */
	public static LocalDateTime calculaDataFimFeriasTotais(LocalDateTime dataInicioFerias) {
		LocalDateTime dataFimFerias = dataInicioFerias.plusDays(30);
		return dataFimFerias;
	}
	
	/**
	 * Registro da data início das férias
	 * 
	 * A SER IMPLMENTADO Realiza o registro da data de início das férias solicitada pelo colaborador. 
	 * Este registro só é realizado após a veficação das datas solicitadas.
	 * 
	 * @param dataInicioFerias LocalDateTime - data de início de férias solicitada pelo colaborador
	 * @return
	 */
	static LocalDateTime registraDataInicioFerias(LocalDateTime dataInicioFerias) {
		// TODO implementação
		return dataInicioFerias;
	}

	/**
	 * Registro da data fim das férias
	 * 
	 * Realiza o registro da data fim das férias solicitada pelo colaborador. 
	 * Este registro só é realizado após a veficação das datas solicitadas. 
	 * 
	 * @param dataFimFerias LocalDateTime - data do fim das férias solicitada pelo colaborador
	 * @return
	 */
	static LocalDateTime registraDataFimFerias(LocalDateTime dataFimFerias) {
		return dataFimFerias;
	}


}
