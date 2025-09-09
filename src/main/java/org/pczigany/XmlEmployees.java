package org.pczigany;

import com.jcabi.xml.XMLDocument;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XmlEmployees implements Employees {
    private List<Employee> cache;

    @Override
    public List<Employee> getEmployees() throws IOException {
        if (this.cache == null) {
            this.cache = this.xmlEmployees();
        }
        return this.cache;
    }

    private List<Employee> xmlEmployees() throws IOException {
        final InputStream xmlStream =
                getClass().getClassLoader().getResourceAsStream("employee.xml");
        if (xmlStream == null) {
            throw new FileNotFoundException(
                    "employee.xml not found in resources folder"
            );
        }
        return new ArrayList<>(
                new XMLDocument(xmlStream).nodes("//employee").stream()
                        .map(XmlEmployee::new).toList()
        );
    }

    public void setEmployees(final List<Employee> employees) {
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
