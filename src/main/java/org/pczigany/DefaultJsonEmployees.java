package org.pczigany;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultJsonEmployees implements JsonEmployees {
    private final List<JsonEmployee> employees;

    public DefaultJsonEmployees(final Employees employees) {
        this(new EmployeeAsJsonEmployeeList(employees));
    }

    public DefaultJsonEmployees(final List<JsonEmployee> employees) {
        this.employees = employees;
    }

    @Override
    public String jsonEmployeeNames() {
        return "["
                + this.employees.stream()
                .map(JsonEmployee::jsonName).collect(Collectors.joining(","))
                + "]";
    }

//    @Override
//    public List<Employee> getEmployees() {
//        return this.employees;
//    }
}
