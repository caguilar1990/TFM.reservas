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
import daos.ResourcesClassroomDAO;
import entities.AulaRecursos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class ResourcesClassroomRestTest {
	
	@Autowired
    private ResourcesClassroomDAO resourcesClassroomDAO;
	
	String url = Uris.BASE+Uris.SERVLET_MAP+Uris.AULA_RECURSOS;
	HttpClient client = HttpClientBuilder.create().build();

//
//	@Test
//	public void testGetAll() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testFindbyIDAula() throws ClientProtocolException, IOException {
		
		List<AulaRecursos> listaRecursos = new ArrayList<>();
		listaRecursos =  resourcesClassroomDAO.findAll();
		HttpGet request = new HttpGet(url+"/"+listaRecursos.get(1).getId().getIdAula());
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}



}
