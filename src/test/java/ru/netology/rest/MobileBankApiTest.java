package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


class MobileBankApiTest {

    @Test
    void shouldReturnDemoAccount() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("soma data"))
        ;
    }

    @Test
    void shouldReturnGet() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .param("one", "paramOne")
                .param("two", "paramTwo")
                .param("three", "paramThree")
// Выполняемые действия
                .when()
                .get("/get")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.one", equalTo("paramTwo"))
                .body("args.two", equalTo("paramOne"))
                .body("args.three", equalTo("paramThree"));
    }
}
