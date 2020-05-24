package Testes;

import static io.restassured.RestAssured.given;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.google.gson.JsonObject;
import Core.BaseTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdicionarUsersTeste extends BaseTest {

	@Test
    public void  t01_testPostLoginSucesso() {
		JsonObject Json = new JsonObject();
		Json.addProperty("email", "eve.holt@reqres.in");
		Json.addProperty("password", "cityslicka");
		given()
			.body(Json.toString())
		.when()
			.post("/login")
		.then()
			.statusCode(200)
			.extract()
			.path("token");		 
	}
	 
	@Test
    public void  t02_testPostLoginSemSucesso() {
		JsonObject Json = new JsonObject();
		Json.addProperty("email", "eve.holt@reqres.in"); 
		 given()
		 	.body(Json.toString())
		.when()
			.post("/login")
		.then()
			.statusCode(400);	
	}
	
	@Test
    public void  t03_testPostLoginRegistroSucesso() {
		JsonObject Json = new JsonObject();
		Json.addProperty("email", "eve.holt@reqres.in");
		Json.addProperty("password", "cityslicka");
		 given()
			.body(Json.toString())
		.when()
			.post("/register")
		.then()
			.statusCode(200);
	}
		
	@Test
    public void  t04_testPostRegistroSemSucesso() {
		JsonObject Json = new JsonObject();
		Json.addProperty("email", "eve.holt@reqres.in");
		 given()
		 	.body(Json.toString())
		.when()
			.post("/register")
		.then()
			.statusCode(400);		 
	}
	 
	@Test
    public void  t04_testPostLoginSemEnviarEmailePassword() {
		 given()
		.when()
			.post("/login")
		.then()
			.statusCode(400);	
	}
	
	  
}
