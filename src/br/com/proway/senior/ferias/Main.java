package br.com.proway.senior.ferias;

import java.time.LocalDateTime;

public class Main {

	static void registraDatasFerias(String respostaTipoFerias){

		if (respostaTipoFerias == "total") {			

			LocalDateTime dataInicioFerias = getDataInicioFerias();

			LocalDateTime dataFimFerias = dataInicioFerias.plusDays(30);
			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);

		} else if(respostaTipoFerias == "parcial") {
			LocalDateTime dataInicioFerias = getDataInicioFerias();
			LocalDateTime dataFimFerias = getDataFimFerias();

			registraDataInicioFerias(dataInicioFerias);
			registraDataFimFerias(dataFimFerias);
		}
	}

	static LocalDateTime getDataInicioFerias() {
		LocalDateTime respostaDataInicioFerias = LocalDateTime.of(2021, 5, 15, 0, 0);
		return respostaDataInicioFerias;
	}

	static LocalDateTime getDataFimFerias() {
		LocalDateTime respostaDataFimFerias = LocalDateTime.of(2021, 5, 16, 0, 0);
		return respostaDataFimFerias;
	}

	static void registraDataInicioFerias(LocalDateTime respostaDataInicioFerias) {
		LocalDateTime dataInicio = respostaDataInicioFerias;
		System.out.println(dataInicio);
	}

	static void registraDataFimFerias(LocalDateTime respostaDataFimFerias) {
		LocalDateTime dataFim = respostaDataFimFerias;
		System.out.println(dataFim);
	}

	public static void main(String[] args) {
		String respostaTipoFerias = "total";
		registraDatasFerias(respostaTipoFerias);		
	}
}

