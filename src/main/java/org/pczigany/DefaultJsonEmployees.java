package org.pczigany;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultJsonEmployees implements JsonEmployees {
    private final Employees employees;

    public DefaultJsonEmployees(final Employees employees) {
        this.employees = employees;
    }

    @Override
    public String jsonEmployeeNames() throws IOException {
        return "["
                + this.employees.getEmployees().stream()
                .map(Object::toString).collect(Collectors.joining(","))
                + "]";
    }

    @Override
    public List<Employee> getEmployees() throws IOException {
        return this.employees.getEmployees();
    }
}
