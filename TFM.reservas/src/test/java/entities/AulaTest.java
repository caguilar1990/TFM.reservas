package entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AulaTest {

	Aula aula;
	@Before
	public void init() {
		aula  = new Aula(1001, 1.1, false);
	
	}


	@Test
	public void testGetReferencia() {
		assertEquals(1001, aula.getReferencia());
	}

	@Test
	public void testSetReferencia() {
		aula.setReferencia(1003);
		assertEquals(1003, aula.getReferencia());
	}

	@Test
	public void testGetSuperficie() {
		assertEquals(1.1, aula.getSuperficie(),1.1);
	}

	@Test
	public void testSetSuperficie() {
		aula.setSuperficie(1.5);
		assertEquals(1.5, aula.getSuperficie(),1.1);
	}

	@Test
	public void testGetAccesibilidad() {
		assertEquals(false, aula.getAccesibilidad());
	}

	@Test
	public void testSetAccesibilidad() {
		aula.setAccesibilidad(true);
		assertEquals(true, aula.getAccesibilidad());
	}

}
