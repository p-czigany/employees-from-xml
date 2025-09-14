package org.pczigany;

import java.util.List;

public class DefaultJsonEmployee implements JsonEmployee {
    private final Employee employee;

    public DefaultJsonEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public String name() {
        return "\"" + this.employee.name() + "\"";
    }

    @Override
    public List<String> departments() {
        return this.employee.departments();
    }

    @Override
    public String jsonName() {
        return "\"" + this.employee.name() + "\"";
    }
}
