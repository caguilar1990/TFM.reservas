package entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PermisosTest {

	Permisos permisos;
	
	@Before
	public void init() {
		permisos= new Permisos(1,"Administrador","XXXXX");
	}


	@Test
	public void testGetDescripcion() {
		assertEquals("Administrador", permisos.getDescripcion().toString());
	}



	@Test
	public void testGetPermisos() {
		assertEquals("XXXXX", permisos.getPermisos());
	}




}
