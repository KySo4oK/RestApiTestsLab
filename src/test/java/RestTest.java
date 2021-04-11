import models.FakeEntity;
import org.junit.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.notNullValue;

public class RestTest {

    private final FakeEntity fakeEntity = new FakeEntity(1L, "name");

    @Test
    public void testGetFakeEntity() {
        new FakeAPIFakeEndPoint()
                .getFakeEntity()
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testUpdateFakeEntity() {
        new FakeAPIFakeEndPoint()
                .updateFakeEntity(fakeEntity, fakeEntity.getId())
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testCreateFakeEntity() {
        new FakeAPIFakeEndPoint()
                .createFakeEntity(fakeEntity)
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testDeleteFakeEntity() {
        new FakeAPIFakeEndPoint()
                .deleteFakeEntity(1L)
                .then()
                .statusCode(204)
                .body(emptyString());
    }
}
