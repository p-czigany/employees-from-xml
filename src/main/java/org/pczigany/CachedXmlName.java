package org.pczigany;

import com.jcabi.xml.XML;

public class CachedXmlName implements Name {
    private final XML employeeNode;
    private String text;

    public CachedXmlName(final XML employeeNode) {
        this.employeeNode = employeeNode;
    }

    @Override
    public String text() {
        if (this.text == null) {
            this.text = this.employeeNode.xpath("name/text()").get(0);
        }
        return this.text;
    }
}
