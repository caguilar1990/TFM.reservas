package api;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class ResourcesRestTest {
	String url = Uris.BASE+Uris.SERVLET_MAP+Uris.RECURSOS;
	HttpClient client = HttpClientBuilder.create().build();
	
	@Test
	public void testGetAll() throws ClientProtocolException, IOException {
	
		
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testSearchByID() throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url+"/"+14);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}
//
//	@Test
//	public void testUpdateRecursos() {
//		fail("Not yet implemented");
//	}

}
