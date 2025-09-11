package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class DefaultEmployeeTest {
    @Test
    void name() {
        MatcherAssert.assertThat(
                "name is not correct",
                new DefaultEmployee(new XMLDocument(
                        """
                                <employee>
                                    <name>John Doe</name>
                                    <department>it</department>
                                </employee>
                                """
                )).getName(),
                Matchers.is(Matchers.equalTo("John Doe"))
        );
    }
}
