package br.com.proway.senior.ferias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

	static void registraDatasFerias(String respostaTipoFerias){

		if (verificarDataDeChamado()) {			
			if (respostaTipoFerias == "total") {			

				LocalDateTime dataInicioFerias = getDataInicioFerias();

				LocalDateTime dataFimFerias = dataInicioFerias.plusDays(30);
				registraDataInicioFerias(dataInicioFerias);
				registraDataFimFerias(dataFimFerias);

			} else if(respostaTipoFerias == "parcial") {
				
				if (verificarIntervaloFeriasParcial()) {
					LocalDateTime dataInicioFerias = getDataInicioFerias();
					LocalDateTime dataFimFerias = getDataFimFerias();

					registraDataInicioFerias(dataInicioFerias);
					registraDataFimFerias(dataFimFerias);
				} else {
					System.out.println("O intervalo solicitado é inválido (superior a 20 dias)");
				}	
			}			
		} else {
			System.out.println("A data da solicitação é inferior a 10 dias deste chamado");
		}		
	}
	
	static LocalDateTime getDataInicioFerias() {
		LocalDateTime respostaDataInicioFerias = LocalDateTime.of(2021, 3, 23, 0, 0);
		return respostaDataInicioFerias;
	}

	static LocalDateTime getDataFimFerias() {
		LocalDateTime respostaDataFimFerias = LocalDateTime.of(2021, 4, 1, 0, 0);
		return respostaDataFimFerias;
	}

	public static LocalDateTime getDataDeChamado() {
		LocalDateTime dataChamado = LocalDateTime.of(2021, 3, 12, 0, 0);
		return dataChamado;			
	}

	static void registraDataInicioFerias(LocalDateTime respostaDataInicioFerias) {
		LocalDateTime dataInicio = respostaDataInicioFerias;
		System.out.println(dataInicio);
	}

	static void registraDataFimFerias(LocalDateTime respostaDataFimFerias) {
		LocalDateTime dataFim = respostaDataFimFerias;
		System.out.println(dataFim);
	}

	public static boolean verificarDataDeChamado() {
		LocalDateTime dataChamado = getDataDeChamado();
		LocalDateTime dataInicio = getDataInicioFerias();
		boolean intervaloSuperior10dias = dataChamado.until(dataInicio, ChronoUnit.DAYS) > 10? true : false;
		return intervaloSuperior10dias;
	}

	public static boolean verificarIntervaloFeriasParcial() {
		LocalDateTime dataFim = getDataFimFerias();
		LocalDateTime dataInicio = getDataInicioFerias();
		boolean intervaloInferior20dias = dataInicio.until(dataFim, ChronoUnit.DAYS) < 20? true : false;
		return intervaloInferior20dias;
	}	
	
	public static void main(String[] args) {
		String respostaTipoFerias = "parcial";
		registraDatasFerias(respostaTipoFerias);		
	}
}

