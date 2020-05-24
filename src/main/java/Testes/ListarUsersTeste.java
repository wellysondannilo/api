package Testes;
import static org.hamcrest.Matchers.is;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import Core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListarUsersTeste extends BaseTest {
	
	@Test
	public void t01_testListarUmUnicoUsuario() {
		given()
		.when()
			.get("/users")
		.then()
			.body("page", is (1))
			.body("data.id[0]",is (1))
			.body("data.email[0]", is("george.bluth@reqres.in")) 
			.body("data.first_name[0]", is ("George"))
			.body("data.last_name[0]", is("Bluth"))
			.body("data.avatar[0]", is ("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void t02_testListarTodosUsuarios() {
		given()
		.when()
			.get("/users?page=2")
		.then()
			.body("page", is (2))
			.body("total", is (12))
			.body("data.id[0]",is (7))
			.body("data.email[0]", is("michael.lawson@reqres.in")) 
			.body("data.first_name[0]", is ("Michael"))
			.body("data.last_name[0]", is("Lawson"))
			.body("data.avatar[0]", is ("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"))
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void t03_TestListarUsuarioUnicoNaoIndentificado() {
		given()
		.when()
			.get("api/users/23")
		.then()
			.statusCode(404);
	}
	
	@Test
	public void t04_testListarRecursos() {
		given()
		.when()
			.get("/unknown")
		.then()
			.body("page", is (1))
			.body("total", is (12))
			.body("data.id[0]",is (1))
			.body("data.name[0]", is("cerulean")) 
			.body("data.year[0]", is (2000))
			.body("data.color[0]", is ("#98B2D1"))
			.body("data.pantone_value[0]", is ("15-4020"))
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void t05_testUnicoRecurso() {
		given()
		.when()
			.get("/unknown/2")
		.then()
			.body("data.id",is (2))
			.body("data.name", is("fuchsia rose")) 
			.body("data.year", is (2001))
			.body("data.color", is ("#C74375"))
			.body("data.pantone_value", is ("17-2031"))
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void t06_testUnicoRecursoNaoEncontrado() {
		given()
		.when()
			.get("/unknown/23")
		.then()
			.log().all()
			.statusCode(404);
	}
	  
	@Test
	public void t07_testRespostaAtrasada() {
		given()
		.when()
			.get("/users?delay=3")
		.then()
			.body("page", is (1))
			.body("total", is (12))
			.body("data.id[0]",is (1))
			.body("data.email[0]", is("george.bluth@reqres.in")) 
			.body("data.first_name[0]", is ("George"))
			.body("data.last_name[0]", is ("Bluth"))
			.body("data.avatar[0]", is ("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
			.log().all()
			.statusCode(200);		
	}
	
	@Test
	public void t08_naoDeveAcessarApiSemToken(){
 
		given()
		.when()
			.get("/users?delay=3")
		.then()
			.statusCode(401)
		;
	}
	
}