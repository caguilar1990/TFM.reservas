package api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
import daos.ClassroomDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class ClassroomRestTest {

	String url = Uris.BASE+Uris.SERVLET_MAP+Uris.AULAS;
	HttpClient client = HttpClientBuilder.create().build();
	
	@Autowired
    private ClassroomDAO classroomDAO;
//	@Test
//	public void testSetAulaController() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetAll() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testSearchByID() throws ClientProtocolException, IOException {
		int id = classroomDAO.findAll().get(1).getId();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url+"/"+id);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

//	@Test
//	public void testUpdateAula() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddAula() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveAula() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindbyPersonal() {
//		fail("Not yet implemented");
//	}

}
