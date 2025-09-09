package org.pczigany;

import java.util.List;
import java.util.Objects;

public class XmlEmployees implements Employees {
    private final List<Employee> cache;

    public XmlEmployees(final String path) {
        this(new PathAsEmployeeList(path));
    }

    public XmlEmployees(final List<Employee> employees) {
        this.cache = employees;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final XmlEmployees that = (XmlEmployees) o;
        return Objects.equals(this.cache, that.cache);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.cache);
    }
}
