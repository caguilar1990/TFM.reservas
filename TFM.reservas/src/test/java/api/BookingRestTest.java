package api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import daos.PersonalDAO;
import daos.ResourcesDAO;
import daos.TimeDAO;
import entities.Horario;
import entities.Personal;
import entities.Recursos;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class BookingRestTest {

	@Autowired
    private TimeDAO timeDAO;
	@Autowired
    private ResourcesDAO resourcesDAO;
	@Autowired
    private PersonalDAO personalDAO;


	
	String url = Uris.BASE+Uris.SERVLET_MAP+Uris.RESERVAS;
	HttpClient client = HttpClientBuilder.create().build();
	

	@Test
	public void testGetAll() throws ClientProtocolException, IOException{

		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testFindClassroomsfree() throws ClientProtocolException, IOException {
		
		List<Recursos> listaRecursos = new ArrayList<>();
		listaRecursos =  resourcesDAO.findAll();
		List<Horario> listaHorarios = new ArrayList<>();
		listaHorarios =  timeDAO.findAll();
		HttpGet request = new HttpGet(url+"/2018-12-01/"+listaHorarios.get(1).getId()+"/"+listaRecursos.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());

	}

	@Test
	public void testFindClassroomsBookingByDate() throws ClientProtocolException, IOException {
	
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findAll();
	
		HttpGet request = new HttpGet(url+"/2018-12-01/personal/"+listaPersonal.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testFindClassroomsBookingByDateAndState() throws ClientProtocolException, IOException {
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findAll();
	
		HttpGet request = new HttpGet(url+"/2018-12-01/false/personal/"+listaPersonal.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}




	@Test
	public void testFindByPersonal() throws ClientProtocolException, IOException  {
		
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findAll();
	
		HttpGet request = new HttpGet(url+"/personal/"+listaPersonal.get(3).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testFindClassroomsBookingByDateMaster() throws ClientProtocolException, IOException {
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findMaestroLaboratorio();
	
		HttpGet request = new HttpGet(url+"/2018-12-01/maestros/"+listaPersonal.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testFindClassroomsBookingByDateAndStateMaster() throws ClientProtocolException, IOException {
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findMaestroLaboratorio();
	
		HttpGet request = new HttpGet(url+"/2018-12-01/false/maestros/"+listaPersonal.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testGetByMaster() throws ClientProtocolException, IOException {
		List<Personal> listaPersonal = new ArrayList<>();
		listaPersonal =  personalDAO.findAll();
	
		HttpGet request = new HttpGet(url+"/maestros/"+listaPersonal.get(3).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}
	



}
