package utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	public static SocialResponses verifySocialAccounts(String twitter, String instagram) {

		String endpoint = "https://marketingapi.wheelsup.com/api/initial-data/";
		HttpUriRequest request = new HttpGet(endpoint);

		// When
		HttpResponse httpResponse = null;
		SocialResponses resource = null;
		try {
			httpResponse = HttpClientBuilder.create().build().execute(request);
			resource = retrieveResourceFromResponse(httpResponse, SocialResponses.class);
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resource;

	}

	public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
		
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(jsonFromResponse, clazz);
	}
}
