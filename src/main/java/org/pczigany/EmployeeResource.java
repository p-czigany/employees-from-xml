package org.pczigany;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/employees")
public class EmployeeResource {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String names() throws IOException {
        final DefaultEmployees defaultEmployees = new DefaultEmployees();
        defaultEmployees.getEmployees();
        return defaultEmployees.toString();
    }
}
