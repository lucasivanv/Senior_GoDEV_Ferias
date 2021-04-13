package br.com.proway.senior.ferias;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
	
	public static void main(String[] args) {
		String tipoFerias = "parcial";
		registraDatasFerias(tipoFerias);		
	}

	static void registraDatasFerias(String respostaTipoFerias){

		if (verificarDataChamado()) {			
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
		LocalDateTime dataInicioFerias = LocalDateTime.of(2021, 3, 23, 0, 0);
		return dataInicioFerias;
	}

	static LocalDateTime getDataFimFerias() {
		LocalDateTime dataFimFerias = LocalDateTime.of(2021, 4, 1, 0, 0);
		return dataFimFerias;
	}

	public static LocalDateTime getDataChamado() {
		LocalDateTime dataChamado = LocalDateTime.of(2021, 3, 12, 0, 0);
		return dataChamado;			
	}

	static void registraDataInicioFerias(LocalDateTime dataInicioFerias) {
		LocalDateTime dataInicio = dataInicioFerias;
		System.out.println(dataInicio);
	}

	static void registraDataFimFerias(LocalDateTime dataFimFerias) {
		LocalDateTime dataFim = dataFimFerias;
		System.out.println(dataFim);
	}

	public static boolean verificarDataChamado() {
		LocalDateTime dataChamado = getDataChamado();
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
}

