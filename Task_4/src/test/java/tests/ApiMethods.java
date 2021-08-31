package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.conn.ssl.PrivateKeyDetails;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ApiMethods {
	
	String url = "http://localhost:3030/";
	

	public void assertFunctionForInt(int x , int y) {
		assertEquals(x, y);
	}

	public void assertFunctionForLong(long x , long y) {
		assertEquals(x, y);
	}

	public void assertFunctionForString(String x , String y) {
		assertEquals(x, y);
	}


	public Response getProducts() {
		RequestSpecification request = RestAssured.given();
		Response getProducts = request.
				get(url + "products");
		return getProducts; 
	}

	public Response postProduct() throws ParseException {
		String json = "{\r\n"
				+ "  \"name\": \"string\",\r\n"
				+ "  \"type\": \"string\",\r\n"
				+ "  \"price\": 0,\r\n"
				+ "  \"shipping\": 0,\r\n"
				+ "  \"upc\": \"string\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"manufacturer\": \"string\",\r\n"
				+ "  \"model\": \"string\",\r\n"
				+ "  \"url\": \"string\",\r\n"
				+ "  \"image\": \"string\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response postProduct =  request.
				body(json).
				post(url + "products");
		return postProduct;
	}

	public Response getProduct(String id) {
		Response getProduct = given().
				get(url + "products/" + id);
		return getProduct;
	}

	public Response deleteProduct(String id) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	
		Response deleteProduct = request.delete(url + "products/"+ id);
		return deleteProduct;
	}

	public Response patchProduct(String id) {
		String Json = "{\r\n"
				+ "  \"name\": \"Updated\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	
		Response patchProduct =  request.
				body(Json).
				patch(url + "products/" +id);
		return patchProduct;
	}

	public Response getStores() {
		RequestSpecification request = RestAssured.given();
		Response getStores = request.
				get(url + "stores");
		return getStores; 
	}

	public Response postStore() {
		String json = "{\r\n"
				+ "  \"name\": \"Test\",\r\n"
				+ "  \"type\": \"Test\",\r\n"
				+ "  \"address\": \"Test\",\r\n"
				+ "  \"address2\": \"Test\",\r\n"
				+ "  \"city\": \"Test\",\r\n"
				+ "  \"state\": \"Test\",\r\n"
				+ "  \"zip\": \"Test\",\r\n"
				+ "  \"lat\": 5,\r\n"
				+ "  \"lng\": 5,\r\n"
				+ "  \"hours\": \"Test\",\r\n"
				+ "  \"services\": {}\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response postStore =  request.
				body(json).
				post(url + "stores");
		return postStore;
	}

	public Response getStore(String id) {
		Response getStore = given().
				get(url + "stores/" + id);
		return getStore;
	}

	public Response deleteStore(String id) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response deleteStore = request.delete(url + "stores/"+ id);
		return deleteStore;
	}


	public Response patchStore(String id) {
		String Json = "{\r\n"
				+ "  \"name\": \"Updated\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	
		Response patchStore =  request.
				body(Json).
				patch(url + "stores/"+id);
		return patchStore;
	}


	public Response getServices() {
		RequestSpecification request = RestAssured.given();
		Response getStores = request.
				get(url + "services" );
		return getStores; 
	}

	public Response postService() {
		String json = "{\r\n"
				+ "  \"name\": \"Test\",\r\n"
				+ "  \"type\": \"Test\",\r\n"
				+ "  \"address\": \"Test\",\r\n"
				+ "  \"address2\": \"Test\",\r\n"
				+ "  \"city\": \"Test\",\r\n"
				+ "  \"state\": \"Test\",\r\n"
				+ "  \"zip\": \"Test\",\r\n"
				+ "  \"lat\": 5,\r\n"
				+ "  \"lng\": 5,\r\n"
				+ "  \"hours\": \"Test\",\r\n"
				+ "  \"services\": {}\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response postService =  request.
				body(json).
				post(url + "services" );
		return postService;
	}

	public Response getService(String id) {
		Response getService = given().
				get(url + "services/"  + id);
		return getService;
	}

	public Response deleteService(String id) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response deleteService = request.delete(url + "services/" + id);
		return deleteService;
	}


	public Response patchService(String id) {
		String Json = "{\r\n"
				+ "  \"name\": \"Updated\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	
		Response patchService =  request.
				body(Json).
				patch(url + "services/" +id);
		return patchService;
	}



	public Response getCategories() {
		RequestSpecification request = RestAssured.given();
		Response getCategories = request.
				get(url + "categories" );
		return getCategories; 
	}



	public Response postcategorie() throws ParseException {
		String json = "{\r\n"
				+ "  \"name\": \"string\",\r\n"
				+ "  \"type\": \"string\",\r\n"
				+ "  \"price\": 0,\r\n"
				+ "  \"shipping\": 0,\r\n"
				+ "  \"upc\": \"string\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"manufacturer\": \"string\",\r\n"
				+ "  \"model\": \"string\",\r\n"
				+ "  \"url\": \"string\",\r\n"
				+ "  \"image\": \"string\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response postcategorie =  request.
				body(json).
				post(url + "categories" );
		return postcategorie;
	}

	public Response getcategorie(String id) {
		Response getCategorie = given().
				get(url + "categories/"  + id);
		return getCategorie;
	}

	public Response deletecategorie(String id) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	

		Response deleteCategorie = request.delete(url + "categories/" + id);
		return deleteCategorie;
	}

	public Response patchcategorie(String id) {
		String Json = "{\r\n"
				+ "  \"name\": \"Updated\"\r\n"
				+ "}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");	
		Response patchCategorie =  request.
				body(Json).
				patch(url + "categories/" +id);
		return patchCategorie;
	}

	public Response getVersion(){
		RequestSpecification request = RestAssured.given();
		Response getVersion = request.
				get(url + "version" );
		return getVersion; 
	}

	public Response getHealth() {
		RequestSpecification request = RestAssured.given();
		Response getHelath = request.
				get(url + "healthcheck" );
		return getHelath; 
	}
}
