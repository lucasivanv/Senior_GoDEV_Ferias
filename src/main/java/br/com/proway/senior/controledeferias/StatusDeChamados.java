package br.com.proway.senior.controledeferias;

public class StatusDeChamados {

	public String[][] chamados = new String[4][3];
	
	/**
	 * Pegar lista de chamados pendentes.
	 * 
	 * Retorna uma lista de String contendo os chamados que possuem status de
	 * pendente.
	 * 
	 * @param listaChamados
	 * @return
	 */
	public String[] getChamados(int tipoChamado) {
		return chamados[tipoChamado];
	}

	/**
	 * Verificar se existem chamados pendentes.
	 * 
	 * Verifica se existem Strings no array listaChamados.
	 * 
	 * @param listaChamados Lista de chamados do tipo String.
	 * @return
	 */
	public static boolean verificaSeExistemChamados(String[] listaChamados) {
		int quantidadeChamados = 0;
		boolean existemChamados = false;
		for (String chamado : listaChamados) {
			quantidadeChamados++;
		}

		if (quantidadeChamados > 0) {
			existemChamados = true;
		}

		return existemChamados;

	}

	/**
	 * Informa que não existem chamados.
	 * 
	 * Retorna uma String contendo a mensagem de que não existe chamados.
	 * 
	 * @return
	 */
	public static String informaNãoExistemChamados() {
		return "Não existem chamados com o status solicitado.";
	}

	public static String informaTipoChamado(int tipoChamado) {
		String nomeChamado = "Chamado";
		switch (tipoChamado) {
		case 0:
			nomeChamado = "Chamado pendente";
			break;
		case 1:
			nomeChamado = "Chamado deferido";
			break;
		case 2:
			nomeChamado = "Chamado finalizado";
			break;
		case 3:
			nomeChamado = "Chamado em atraso";
			break;
		}
		return nomeChamado;
	}
	
	public void criarChamados() {
		chamados[0][0] = "chamado 01";
		chamados[0][1] = "chamado 02";
		chamados[0][2] = "chamado 03";

		chamados[1][0] = "chamado 1";
		chamados[1][1] = "chamado 2";
		chamados[1][2] = "chamado 3";

		chamados[2][0] = "chamado 1";
		chamados[2][1] = "chamado 2";
		chamados[2][2] = "chamado 3";

		chamados[3][0] = "chamado 1";
		chamados[3][1] = "chamado 2";
		chamados[3][2] = "chamado 3";
	}

	public  void consultaChamadosPendentes() {
		// usuário clicou em consultar chamados pendentes
		int tipoChamado = 0;
		String[] chamados = getChamados(tipoChamado);
		if (verificaSeExistemChamados(chamados)) {
			System.out.println(informaTipoChamado(tipoChamado));
			for (String chamado : chamados) {
				System.out.println(chamado);
			}
		} else
			informaNãoExistemChamados();
	}
}
