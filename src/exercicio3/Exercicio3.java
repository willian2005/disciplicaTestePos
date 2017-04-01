package exercicio3;

import static org.junit.Assert.*;

import java.time.Period;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Interval;
import org.joda.time.JodaTimePermission;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class Exercicio3 {

	@Test
	public void testeJoda() throws Exception {
		
		LocalDate hoje = new LocalDate(2017, 4, 1);
		
		assertEquals(2017, hoje.getYear());
		assertEquals(4, hoje.getMonthOfYear());
		assertEquals(1, hoje.getDayOfMonth());
	}
	@Test
	public void testeJoda2() throws Exception {
		
		LocalDate nascimento = new LocalDate(1989, 11, 12);
		
		assertEquals(1989, nascimento.getYear());
		assertEquals(11, nascimento.getMonthOfYear());
		assertEquals(12, nascimento.getDayOfMonth());
	}
	@Test
	public void testeJoda3() throws Exception {
		
		LocalTime hora = new LocalTime( 8, 30, 02);
		
		assertEquals(8, hora.getHourOfDay());
		assertEquals(30, hora.getMinuteOfHour());
		assertEquals(02, hora.getSecondOfMinute());
	}

	@Test(expected = IllegalFieldValueException.class)
	public void diaInvalido29Fev() throws Exception{
		
		LocalDate dataInv = new LocalDate(2017, 2, 29);
	}
	@Test(expected = IllegalFieldValueException.class)
	public void diaComValorNegativo() throws Exception{
		
		LocalDate dataInv = new LocalDate(2017, 2, -2);
	}
	@Test // ano negativo e permitido
	public void anoNegativoPermitido() throws Exception{
		
		LocalDate dataInv = new LocalDate(-23, 2, 2);
	}
	@Test
	public void dataOk() throws Exception{
		
		LocalTime timeInv = new LocalTime(23, 1, 20);
	}
	@Test (expected = IllegalFieldValueException.class)
	public void execaoHora24() throws Exception{
		
		LocalTime timeInv = new LocalTime(24, 1, 20);
	}
	@Test (expected = IllegalFieldValueException.class)
	public void execaoMinuto60() throws Exception{
		
		LocalTime timeInv = new LocalTime(23, 60, 20);
	}
	@Test
	public void somarData() throws Exception{
		
		LocalDate data = new LocalDate(2017, 2, 28);
		
		data = data.plusDays(1);
		assertEquals(1, data.getDayOfMonth());
		assertEquals(3, data.getMonthOfYear());
	}
	@Test
	public void somarDataNovoAno() throws Exception{
		
		LocalDate data = new LocalDate(2017, 12, 31);
		
		data = data.plusDays(1);
		assertEquals(1, data.getDayOfMonth());
		assertEquals(1, data.getMonthOfYear());
		assertEquals(2018, data.getYear());
	}
	@Test
	public void diminuirDataAno() throws Exception{
		
		LocalDate data = new LocalDate(2017, 1, 1);
		
		data = data.plusDays(-1);
		assertEquals(31, data.getDayOfMonth());
		assertEquals(12, data.getMonthOfYear());
		assertEquals(2016, data.getYear());
	}
	@Test
	public void diminuirData() throws Exception{
		
		LocalDate data = new LocalDate(2017, 2, 28);
		
		data = data.plusDays(-1);
		assertEquals(27, data.getDayOfMonth());
		assertEquals(2, data.getMonthOfYear());
	}
	@Test
	public void subtraiUmMilisec() throws Exception{
		
		LocalTime milesec = new LocalTime(00, 00, 00, 00);
		milesec = milesec.plusMillis(-1);
		
		assertEquals(23, milesec.getHourOfDay());
		assertEquals(59, milesec.getMinuteOfHour());
		assertEquals(59, milesec.getSecondOfMinute());
		assertEquals(999, milesec.getMillisOfSecond());
	}
	@Test
	public void checaIntervalo() throws Exception{
		
		DateTime inicioAula = new DateTime(2017, 3, 31, 18, 30);
		DateTime finalAula = new DateTime(2017, 5, 6, 18, 30);
		Interval intervalo = new Interval(inicioAula, finalAula);
		
		assertTrue(intervalo.containsNow());
		assertEquals(36, intervalo.toDuration().getStandardDays());
		assertEquals(864, intervalo.toDuration().getStandardHours());
	}
}
