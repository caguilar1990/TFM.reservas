package api;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class LoginRestTest {
	String url = "http://localhost:9000/TFM.reserva/api/login/";
	
	@Test
	public void testSearchByUsername() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		String user = "admin";
		HttpGet request = new HttpGet(url+user);
		HttpResponse response = client.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

}
