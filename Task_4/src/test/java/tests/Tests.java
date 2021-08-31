package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.parser.ParseException;

public class Tests extends ApiMethods {
	int statusGet = 200;
	int statusPost = 201;
	int statusNotFound = 404; 
	
	String expextedType = "application/json; charset=utf-8";
	//Tests for products API's
	
	//Test for get all products
	@Test
	public void test_01() {
		Response r = getProducts();
		int StatusCode = r.getStatusCode();
		String type = r.getContentType();
		System.out.println(type);
		assertFunctionForInt(StatusCode, statusGet);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test_02() throws ParseException {
		Response r = postProduct();
		int statusCode = r.getStatusCode();
		String idCreated = r.jsonPath().getString("id");
		Response r2 = getProduct(idCreated);
		String type = r.getContentType();
		String idFound = r.jsonPath().getString("id");
		assertFunctionForInt(statusCode, statusPost);
		assertFunctionForString(type, expextedType);
		assertFunctionForString(idCreated, idFound);
	}
	
	@Test
	public void test_03() throws ParseException {
		Response r = postProduct();
		String id = r.jsonPath().getString("id");
		Response r2 = deleteProduct(id);
		int code = r2.statusCode();
		String type = r2.getContentType();
		Response r3 = getProduct(id);
		int code2 = r3.statusCode();
		assertFunctionForInt(code2, statusNotFound);
		assertFunctionForString(type, expextedType);
		
	}
	
	@Test
	public void test_04() throws ParseException {
		Response r = postProduct();
		String id = r.jsonPath().getString("id");
		int status1 = r.statusCode();
		Response r2 = patchProduct(id);
		int status2 = r2.statusCode();
		String type = r2.getContentType();
		Response r3 = getProduct(id);
		String name = r3.jsonPath().getString("name");
		assertFunctionForInt(status2, statusNotFound);
		assertFunctionForString(type, expextedType);
		
	}
	
	
	//Tests for stores
	@Test
	public void test_05() {
		Response r = getStores();
		int StatusCode = r.getStatusCode();
		String type = r.getContentType();
		assertFunctionForInt(StatusCode, statusGet);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test06() {
		Response r = postStore();
		int statusCode = r.getStatusCode();
		String id = r.jsonPath().getString("id");
		Response r2 = getProduct(id);
		String type = r2.getContentType();
		System.out.println(statusCode);
		assertFunctionForInt(statusCode, statusPost);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test07() throws ParseException {
		Response r = postStore();
		String id = r.jsonPath().getString("id");
		Response r2 = deleteStore(id);
		int code = r2.statusCode();
		Response r3 = getStore(id);
		int code2 = r3.statusCode();
		String type = r2.getContentType();
		assertFunctionForInt(code, statusNotFound);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test08() {
		Response r = postStore();
		String id = r.jsonPath().getString("id");
		int status1 = r.statusCode();
		Response r2 = patchStore(id);
		int status2 = r2.statusCode();
		String type = r2.getContentType();
		Response r3 = getStore(id);
		String name = r3.jsonPath().getString("name");
		assertFunctionForInt(status2, statusGet);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test_09() {
		Response r = getServices();
		int StatusCode = r.getStatusCode();
		String type = r.getContentType();
		assertFunctionForInt(StatusCode, statusGet);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test010() {
		Response r = postService();
		int statusCode = r.getStatusCode();
		String id = r.jsonPath().getString("id");
		Response r2 = getService(id);
		String type = r.getContentType();
		assertFunctionForInt(statusCode, statusPost);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test11() throws ParseException {
		Response r = postService();
		String id = r.jsonPath().getString("id");
		Response r2 = deleteService(id);
		int code = r2.statusCode();
		Response r3 = getService(id);
		int code2 = r3.statusCode();
		String type = r.getContentType();
		assertFunctionForInt(code2, statusNotFound);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test012() {
		Response r = postService();
		String id = r.jsonPath().getString("id");
		int status1 = r.statusCode();
		Response r2 = patchService(id);
		int status2 = r2.statusCode();
		Response r3 = getService(id);
		String type = r.getContentType();
		String name = r3.jsonPath().getString("name");
		assertFunctionForInt(status2, statusGet);
		assertFunctionForString(type, expextedType);
	}
	
	//Tests for categories API's
	
	@Test
	public void test_013() {
		Response r = getCategories();
		int StatusCode = r.getStatusCode();
		String type = r.getContentType();
		assertFunctionForInt(StatusCode, statusPost);
		assertFunctionForString(type, expextedType);
	}
	
	@Test
	public void test014() throws ParseException {
		Response r = postcategorie();
		int statusCode = r.getStatusCode();
		String id = r.jsonPath().getString("id");
		Response r2 = getcategorie(id);
		String type = r.getContentType();
		assertFunctionForInt(statusCode, statusGet);
		assertFunctionForString(type, expextedType);
		}
	@Test
	public void test15() throws ParseException {
		Response r = postcategorie();
		String id = r.jsonPath().getString("id");
		Response r2 = deletecategorie(id);
		int code = r2.statusCode();
		//verify code
		Response r3 = getcategorie(id);
		int code2 = r3.statusCode();
		String type = r2.getContentType();
		assertFunctionForInt(code2, statusNotFound);
		assertFunctionForString(type, expextedType);	
		}
	
	@Test
	public void test016() throws ParseException {
		Response r = postcategorie();
		String id = r.jsonPath().getString("id");
		int status1 = r.statusCode();
		Response r2 = patchcategorie(id);
		int status2 = r2.statusCode();
		//verify code
		Response r3 = getcategorie(id);
		String type = r2.getContentType();
		String name = r3.jsonPath().getString("name");
		assertFunctionForInt(status2, statusGet);
		assertFunctionForString(type, expextedType);	
	}
	
	//Tests for version
	@Test
	public void test17() {
		Response r = getVersion();
		int status1 = r.statusCode();
		String type = r.getContentType();
		assertFunctionForInt(status1, statusGet);
		assertFunctionForString(type, expextedType);	
	}
	
	//Tests for health
	
	@Test
	public void test18() {
		Response r = getHealth();
		int status = r.statusCode();
		String type = r.getContentType();
		assertFunctionForInt(status, statusGet);
		assertFunctionForString(type, expextedType);	
	}
	
}
