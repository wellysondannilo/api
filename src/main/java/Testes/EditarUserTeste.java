package Testes;

import static io.restassured.RestAssured.given;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.gson.JsonObject;
import Core.BaseTest;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditarUserTeste extends BaseTest {
	  
	@Test
	public void t01_testAtualizarPut() {
		JsonObject Json = new JsonObject();
		Json.addProperty("name", "Dannilo");
		Json.addProperty("job","zion resident");
		given()
			.body(Json.toString())
		.when()
			.put("users/2")
		.then()
			.statusCode(200);	
	}
	  
	@Test
	public void t02_testAtualizarPath() {
		JsonObject Json = new JsonObject();
		Json.addProperty("name", "Dannilo");
		Json.addProperty("job","zion resident");
		given()
			.body(Json.toString())
		.when()
			.patch("users/2")
		.then()
			.statusCode(200);
		
		}
	
	@Test
	public void t03_testAtualizarSemEnviarName() {
		JsonObject Json = new JsonObject();
		Json.addProperty("job","zion resident");
		given()
			.body(Json.toString())
		.when()
			.patch("users/2")
		.then()
			.statusCode(200);
		
		}
	@Test
	public void t03_testAtualizarSemEnviarEmail() {
		JsonObject Json = new JsonObject();
		Json.addProperty("name", "Dannilo");
		given()
			.body(Json.toString())
		.when()
			.patch("users/2")
		.then()
			.statusCode(200);
		
		}
	
	@Test
	public void t04_testAtualizarSemEnviarCampos() {
		given()
		.when()
			.patch("users/2")
		.then()
			.statusCode(200);
		
		}
	}


