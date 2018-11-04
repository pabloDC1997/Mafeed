package br.com.mafeed.mafeed.utils.rest;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class RestUtil {
	
	protected RestTemplate restTemplate;
	protected String urlBase;
	
	public RestUtil(String urlBase) {
		this.restTemplate = getTemplate();
		this.urlBase = urlBase;
	}

	private RestTemplate getTemplate() {
		if (restTemplate == null) {
			HttpComponentsClientHttpRequestFactory factory = createHttpComponentsClienFactory();
			restTemplate = new RestTemplate(factory);
		}
		return restTemplate;
	}
	
	private static HttpComponentsClientHttpRequestFactory createHttpComponentsClienFactory() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(30000);
		return httpRequestFactory;
	}

	public abstract ResponseEntity<?> post(Object params, String endPoint, HttpHeaders header, Class<?> responseType);
	
	public abstract ResponseEntity<?> get(String endPoint, HttpHeaders header, Class<?> responseType);
}
