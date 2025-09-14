package org.pczigany;

import com.jcabi.xml.XML;

import java.util.List;
import java.util.Objects;

public class DefaultEmployee implements Employee {
    private final Name name;
    private final Departments departments;

    public DefaultEmployee(final XML employeeNode) {
        this(new DefaultName(employeeNode), new DefaultDepartments(employeeNode));
    }

    public DefaultEmployee(final Name name, final Departments departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String name() {
        return this.name.text();
    }

    @Override
    public List<String> getDepartments() {
        return this.departments.stream().toList();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DefaultEmployee that = (DefaultEmployee) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.departments);
    }
}
