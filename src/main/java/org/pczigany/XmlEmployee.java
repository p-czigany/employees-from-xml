package org.pczigany;

import com.jcabi.xml.XML;

import java.util.List;

public class XmlEmployee implements Employee {
    private final Name name;
    private final Departments departments;

    public XmlEmployee(final XML employeeNode) {
        this(new CachedXmlName(employeeNode), new CachedXmlDepartments(employeeNode));
    }

    public XmlEmployee(final Name name, final Departments departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String getName() {
        return this.name.text();
    }

    @Override
    public List<String> getDepartments() {
        return this.departments.stream().toList();
    }
}
