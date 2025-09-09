package org.pczigany;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultEmployee implements Employee {
    private String name;
    private List<String> departments;

    public DefaultEmployee() {
        this(null, new ArrayList<>());
    }

    public DefaultEmployee(final String name, @Nonnull final List<String> departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getDepartments() {
        return this.departments;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()){
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

    @Override
    public String toString() {
        return "\"" + this.name + "\"";
    }
}
