package org.pczigany;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class EmployeeResourceTest {
    @Test
    void testNamesEndpoint() {
        given()
                .when().get("/rest/employees")
                .then()
                .statusCode(200)
                .body(is("[ " +
                        "\"Dale Miller\"," +
                        "\"George Smith\"," +
                        "\"James Doyle\"," +
                        "\"Joanne Olsen\"," +
                        "\"Michael Smith\"," +
                        "\"Peter Goeking\"," +
                        "\"Samuel Palmisano\"" +
                        " ]"));
    }
}
