package api;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class PermissionRestTest {
	String url = "http://localhost:9000/TFM.reserva/api/permisos/";

	@Test
	public void testGetAll() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}
//
//	@Test
//	public void testSearchByID() {
//		fail("Not yet implemented");
//	}
//



}
