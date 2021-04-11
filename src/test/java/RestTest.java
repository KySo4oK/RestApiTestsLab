import models.FakeEntity;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

public class RestTest {

    private FakeEntity fakeEntity;

    @Test
    public void testGetFakeEntity() {
        when()
                .get("http://localhost:7777/fake")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testUpdateFakeEntity() {
        when()
                .put("http://localhost:7777/fake/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testCreateFakeEntity() {
        fakeEntity = new FakeEntity(1L, "name");
        when()
                .post("http://localhost:7777/fake")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteFakeEntity() {
        when()
                .delete("http://localhost:7777/fake/1")
                .then()
                .statusCode(204);
    }
}
