package org.pczigany;

import java.util.ArrayList;

public class XmlEmployees implements Employees {
    @Override
    public Iterable<Employee> iterate() {
        final Iterable<Employee> employees = new ArrayList<>();

        return employees;
    }
}
