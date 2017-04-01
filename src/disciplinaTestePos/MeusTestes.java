package disciplinaTestePos;
import static org.junit.Assert.*;

import org.junit.Test;

public class MeusTestes {
	@Test
	public void meuTeste() throws Exception {
		
		String nome = "Joao";
		assertEquals("Joao", nome);
	}
	@Test
	public void meuTeste2() throws Exception {
		
		String nome = "Willian";
		assertNotEquals("Joao", nome);
	}
	@Test(expected = ArithmeticException.class)
	public void meuTeste3() throws Exception {
		
		int valor = 10/0;
	}
}
