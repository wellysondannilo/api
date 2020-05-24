package Testes;

import static io.restassured.RestAssured.given;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Core.BaseTest;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletarUsersTeste extends BaseTest {
	
	@Test
	public void t01_testeDelete() {
		given()
		.when()
			.delete("users/2")
		.then()
			.statusCode(204);
	}
	

	@Test
	public void t02_testeDeleteSemPassaId() {
		given()
		.when()
			.delete("users")
		.then()
			.statusCode(204);
	}
	 
	@Test
	public void t03_testeDeleteIdInexistente() {
		given()
		.when()
			.delete("users/-10")
		.then()
			.statusCode(204);
	}



}