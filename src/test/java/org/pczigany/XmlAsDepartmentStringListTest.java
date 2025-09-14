package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class XmlAsDepartmentStringListTest {
    @Test
    void isEmptyFalse() {
        MatcherAssert.assertThat(
                "doesnt work well",
                new XmlAsDepartmentStringList(new XMLDocument(
                        """
                                <employee>
                                    <name>John Doe</name>
                                    <department>it</department>
                                </employee>
                                """
                )).isEmpty(),
                Matchers.is(false)
        );
    }

    @Test
    void isEmptyTrue() {
        MatcherAssert.assertThat(
                "doesnt work well",
                new XmlAsDepartmentStringList(new XMLDocument(
                        """
                                <employee>
                                    <name>John Doe</name>
                                </employee>
                                """
                )).isEmpty(),
                Matchers.is(true)
        );
    }

    @Test
    void size() {
        MatcherAssert.assertThat(
                "doesnt work well",
                new XmlAsDepartmentStringList(new XMLDocument(
                        """
                                <employee>
                                    <name>John Doe</name>
                                    <department>it</department>
                                    <department>it</department>
                                </employee>
                                """
                )).size(),
                Matchers.is(Matchers.equalTo(2))
        );
    }

    @Test
    void contains() {

    }

    @Test
    void containsAll() {

    }
}
