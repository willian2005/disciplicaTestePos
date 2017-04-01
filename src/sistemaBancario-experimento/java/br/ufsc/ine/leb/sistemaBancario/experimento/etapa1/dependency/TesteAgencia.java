package br.ufsc.ine.leb.sistemaBancario.experimento.etapa1.dependency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

@FixtureSetup(TesteBanco.class)
public class TesteAgencia {

	@Fixture private Banco caixaEconomica;

	private Agencia caixaEconomicaTrindade;

	@Before
	public void configurar() throws Exception {
		caixaEconomicaTrindade = caixaEconomica.criarAgencia("Trindade");
	}

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

}
