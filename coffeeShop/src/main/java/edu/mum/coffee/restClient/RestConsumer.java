package edu.mum.coffee.restClient;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.domain.Product;

public class RestConsumer {
	
	private static final String SERVER="http://localhost:8080/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printParsedProducts();
	}
	
	public static void printParsedProducts(){
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> products = restTemplate.getForObject(SERVER+"products/", List.class);
		for(LinkedHashMap map : products){
			System.out.println("ID="+map.get("id")+",Product Name="+map.get("productName")+",Description="+map.get("description")+",Price="+map.get("price")+",Product Type="+map.get("productType"));	
		}
	} 


}
