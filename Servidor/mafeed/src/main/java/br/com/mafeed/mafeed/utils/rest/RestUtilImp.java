package br.com.mafeed.mafeed.utils.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


public class RestUtilImp extends RestUtil {
	
	public RestUtilImp(String urlBase) {
		super(urlBase);
	}

	@Override
	public ResponseEntity<?> post(Object params, String endPoint, HttpHeaders header, Class<?> responseType) {
		String url = urlBase.concat(endPoint.substring(0, 1).equals("/") ? endPoint : "/".concat(endPoint));
		HttpEntity<Object> httpEntity = new HttpEntity<>(params, header);
		return restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType);
	}

	@Override
	public ResponseEntity<?> get(String endPoint, HttpHeaders header, Class<?> responseType) {
		String url = urlBase.concat(endPoint.substring(0, 1).equals("/") ? endPoint : "/".concat(endPoint));
		HttpEntity<Object> httpEntity = new HttpEntity<>(header);
		return restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);
	}
}
