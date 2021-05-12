import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.FakeEntity;

public class FakeAPIFakeEndPoint {

    public Response getFakeEntity() {
        return given()
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    public Response createFakeEntity(FakeEntity fakeEntity) {
        return given()
                .body(fakeEntity)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    public Response updateFakeEntity(FakeEntity fakeEntity, long id) {
        return given()
                .body(fakeEntity)
                .pathParam("id", id)
                .when()
                .put(Config.UPDATE_FATE_ENTITY)
                .then()
                .extract()
                .response();
    }

    public Response deleteFakeEntity(String id) {
        return given()
                .pathParam("id", id)
                .when()
                .delete(Config.DELETE_FATE_ENTITY)
                .then()
                .extract()
                .response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log()
                .uri()
                .log()
                .body()
                .baseUri(Config.FAKE_API_BASE_URL)
                .contentType(ContentType.JSON);
    }

}
