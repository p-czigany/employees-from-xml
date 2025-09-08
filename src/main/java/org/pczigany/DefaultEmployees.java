package org.pczigany;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultEmployees implements Employees {
    private List<Employee> employees;

    @Override
    public List<Employee> getEmployees() throws IOException {
        if (this.employees == null) {
            this.employees = this.xmlEmployees();
        }
        return this.employees;
    }

    private List<Employee> xmlEmployees() throws IOException {
        final InputStream xmlStream =
                getClass().getClassLoader().getResourceAsStream("employee.xml");
        if (xmlStream == null) {
            throw new FileNotFoundException(
                    "employee.xml not found in resources folder"
            );
        }
        final XML xml = new XMLDocument(xmlStream);
        final List<XML> employeeNodes = xml.nodes("//employee");

        final List<Employee> employees = new ArrayList<>();
        for (final XML employeeNode : employeeNodes) {
            final Employee employee = this.parseEmployee(employeeNode);
            employees.add(employee);
        }
        return employees;
    }

    private Employee parseEmployee(final XML employeeNode) {
        return new DefaultEmployee(
                employeeNode.xpath("name/text()").get(0),
                new ArrayList<>(employeeNode.xpath("department/text()"))
        );
    }

    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DefaultEmployees that = (DefaultEmployees) o;
        return Objects.equals(this.employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.employees);
    }

    @Override
    public String toString() {
        return "DefaultEmployees{" +
                "employees=" + employees +
                '}';
    }
}
