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
import entities.Personal;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class PersonalRestTest {

	@Autowired
    private PersonalDAO personalDAO;
	
	String url = Uris.BASE+Uris.SERVLET_MAP+Uris.PERSONAL;
	HttpClient client = HttpClientBuilder.create().build();
	
	@Test
	public void testGetAll() throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}
	


	@Test
	public void testSearchByID() throws ClientProtocolException, IOException {
		List<Personal> personalList = new ArrayList<>();
		personalList =  personalDAO.findAll();
		HttpGet request = new HttpGet(url+"/"+personalList.get(1).getId());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testFindMaestroLaboratorio() throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url+"/maestros");
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

}
