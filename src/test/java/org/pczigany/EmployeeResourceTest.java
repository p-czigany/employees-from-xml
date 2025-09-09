package org.pczigany;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
class EmployeeResourceTest {
    /**
     * User Acceptance Test of the {@link EmployeeResource#names() names} endpoint
     */
    @Test
    void testNamesEndpoint() {
        final Response response = RestAssured.get("/rest/employees");
        MatcherAssert.assertThat(
                "Response status is not 200 OK",
                response.getStatusCode(),
                Matchers.is(Matchers.equalTo(200))
        );
        MatcherAssert.assertThat(
                "Response body is not correct",
                response.getBody().asString(),
                Matchers.is(Matchers.equalTo(
                        "[\"Dale Miller\","
                                + "\"George Smith\","
                                + "\"James Doyle\","
                                + "\"Joanne Olsen\","
                                + "\"Michael Smith\","
                                + "\"Peter Goeking\","
                                + "\"Samuel Palmisano\"]"
                ))
        );
    }
}
