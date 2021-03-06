package Exercicio5;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.Transacao;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;;

public class Exercicio5 {


	private Conta conta;
	private Banco banco;
	private Agencia agencia;
	
	private SistemaBancario sistemaBancario = new SistemaBancario();
	private Dinheiro valor50reais = new Dinheiro(Moeda.BRL, 50, 00);
	private Operacao operacao;
	@Before
	public void setUp() throws Exception {
		
		banco = sistemaBancario.criarBanco("Caixa economica", Moeda.BRL);
		agencia = banco.criarAgencia("Jurere");
		conta = agencia.criarConta("Willian");	
		operacao = sistemaBancario.depositar(conta, valor50reais);
	}
	
	@Test
	public void testConta() {
	
		assertEquals("Willian", conta.obterTitular());
		assertEquals("Jurere", conta.obterAgencia().obterNome());
		assertEquals(Moeda.BRL , banco.obterMoeda());
	}
	
	@Test
	public void testChecaValorConta() {
	
		assertEquals("50,00 BRL", conta.calcularSaldo().obterQuantia().formatado());
		assertEquals(Moeda.BRL , banco.obterMoeda());
	}
	@Test
	public void testChecaOperacao() {
	
		
		assertEquals(Moeda.BRL , banco.obterMoeda());
	}
}
