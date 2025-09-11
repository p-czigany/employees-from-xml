package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class DefaultNameTest {
    @Test
    void text() {
        MatcherAssert.assertThat(
                "the returned string is not correct",
                new DefaultName(new XMLDocument(
                        """
                                <employee>
                                    <name>John Doe</name>
                                    <department>it</department>
                                </employee>
                                """
                )).text(),
                Matchers.is(Matchers.equalTo("John Doe"))
        );
    }
}
