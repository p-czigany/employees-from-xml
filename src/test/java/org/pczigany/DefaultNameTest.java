package org.pczigany;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class DefaultNameTest {
    @Test
    void text() {
        final XML employeeNode = new XMLDocument(
                """
                        <employee>
                            <name>John Doe</name>
                            <department>it</department>
                        </employee>
                        """
        );
        MatcherAssert.assertThat(
                "the returned string is not correct",
                new DefaultName(employeeNode).text(),
                Matchers.is(Matchers.equalTo("John Doe"))
        );
    }
}
