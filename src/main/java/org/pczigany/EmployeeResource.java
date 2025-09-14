package org.pczigany;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String names() {
        return new DefaultJsonEmployees(
                new XmlEmployees(
                        "employee.xml"
                )
        ).jsonEmployeeNames();
    }
}
