package org.pczigany;

import com.jcabi.xml.XML;

public class DefaultName implements Name {
    private final XML employeeNode;

    public DefaultName(final XML employeeNode) {
        this.employeeNode = employeeNode;
    }

    @Override
    public String text() {
        return this.employeeNode.xpath("//name/text()").get(0);
    }
}
