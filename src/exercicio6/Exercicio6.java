package exercicio6;

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
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Exercicio6 {
	
	private Conta contaOrigem, contaDestino;
	private Banco banco;
	private Agencia agencia;
	private Operacao operacao;
	private Dinheiro valor50reais = new Dinheiro(Moeda.BRL, 50, 00);
	
	private SistemaBancario sistemaBancario = new SistemaBancario();
	
	@Before
	public void setUp() throws Exception {
		
		banco = sistemaBancario.criarBanco("Caixa economica", Moeda.BRL);
		agencia = banco.criarAgencia("Jurere");
		contaOrigem = agencia.criarConta("Willian");	
		contaDestino = agencia.criarConta("Fulano");
		sistemaBancario.depositar(contaOrigem, valor50reais);
		sistemaBancario.transferir(contaOrigem, contaDestino, valor50reais);
	}
	
	@Test
	public void testTransferencia() {
	
		assertEquals("50,00 BRL", contaDestino.calcularSaldo().obterQuantia().formatado());
		assertEquals("0,00", contaOrigem.calcularSaldo().obterQuantia().formatado());
		assertEquals(Moeda.BRL , banco.obterMoeda());
	}
	
}
