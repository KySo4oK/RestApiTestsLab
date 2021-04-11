import io.restassured.response.ValidatableResponse;
import models.FakeEntity;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class RestTest {

    private final FakeEntity fakeEntity = new FakeEntity(1L, "name");

    @Test
    public void testGetFakeEntity() {
        ValidatableResponse response = new FakeAPIFakeEndPoint()
                .getFakeEntity()
                .then()
                .statusCode(200);
        FakeEntity fakeEntity = response.extract().as(FakeEntity.class);

        assertThat(fakeEntity.getId(), is(1L));
        assertThat(fakeEntity.getName(), is("fakeName"));
    }

    @Test
    public void testUpdateFakeEntity() {
        ValidatableResponse response = new FakeAPIFakeEndPoint()
                .updateFakeEntity(fakeEntity, fakeEntity.getId())
                .then()
                .statusCode(200);
        FakeEntity returned = response.extract().as(FakeEntity.class);

        assertThat(returned.getId(), is(fakeEntity.getId()));
        assertThat(returned.getName(), is(fakeEntity.getName()));
    }

    @Test
    public void testCreateFakeEntity() {
        ValidatableResponse response = new FakeAPIFakeEndPoint()
                .createFakeEntity(fakeEntity)
                .then()
                .statusCode(200);
        FakeEntity returned = response.extract().as(FakeEntity.class);

        assertThat(returned.getId(), is(123L));
        assertThat(returned.getName(), is(fakeEntity.getName()));
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
