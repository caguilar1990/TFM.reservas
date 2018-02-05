package entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import identifiers.AulaRecursosId;

public class AulaRecursosTest {

	AulaRecursos aulaRecursos;
	Aula aula;
	Recursos recursos;
	AulaRecursosId id;
	
	@Before
	public void init() {
		id = new AulaRecursosId(1, 1);
		aula = new Aula(1001, 1.1, true);
		recursos = new Recursos("MAC", "ordenador");
		aulaRecursos = new AulaRecursos(id, aula, recursos, 50);
	
	}

	@Test
	public void testGetId() {
		
		assertEquals(1, id.getIdAula());
		assertEquals(1, id.getIdRecurso());
	}

	@Test
	public void testSetId() {
		id.setIdAula(5);
		id.setIdRecurso(10);

		assertEquals(5, id.getIdAula());
		assertEquals(10, id.getIdRecurso());
	}

	
	@Test
	public void testGetCantidad() {
		assertEquals(50, aulaRecursos.getCantidad());
	}

	@Test
	public void testSetCantidad() {
		aulaRecursos.setCantidad(25);
		assertEquals(25, aulaRecursos.getCantidad());
	}



}
