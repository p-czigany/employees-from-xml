package org.pczigany;

import java.util.List;

public class DefaultJsonEmployee implements JsonEmployee {
    private final Employee employee;

    public DefaultJsonEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public String jsonEmployeeName() {
        return "\"" + this.employee.getName() + "\"";
    }

    @Override
    public String getName() {
        return this.employee.getName();
    }

    @Override
    public List<String> getDepartments() {
        return this.employee.getDepartments();
    }
}
