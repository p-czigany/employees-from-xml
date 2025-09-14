package org.pczigany;

import com.jcabi.xml.XML;

import java.util.Objects;

public class DefaultName implements Name {
    private static final String TEXT_OF_NAME_TAG = "//name/text()";
    private final XML employeeNode;

    public DefaultName(final XML employeeNode) {
        this.employeeNode = employeeNode;
    }

    @Override
    public String text() {
        return this.employeeNode.xpath(TEXT_OF_NAME_TAG).get(0);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DefaultName that = (DefaultName) o;
        return Objects.equals(this.text(), that.text());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.text());
    }

    @Override
    public String toString() {
        return "DefaultName{" +
                "employeeNode=" + employeeNode +
                '}';
    }
}
