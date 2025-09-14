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

    @Test
    void equals() {
        MatcherAssert.assertThat(
                new XmlAsDepartmentStringList(new XMLDocument(
                        """
                                <?xml version="1.0" encoding="UTF-8"?>
                                <list>
                                <employee>
                                <name>George Smith</name>
                                <department>finance</department>
                                </employee>
                                <employee>
                                <name>Michael Smith</name>
                                <department>it</department>
                                <department>finance</department>
                                </employee>
                                </list>"""
                )).equals(
                        new XmlAsDepartmentStringList(new XMLDocument(
                                """
                                        <list>
                                        <employee>
                                        <name>George Smith</name>
                                        <department>finance</department>
                                        </employee>
                                        <employee>
                                        <name>Michael Smith</name>
                                        <department>it</department>
                                        <department>finance</department>
                                        </employee>
                                        </list>"""
                        ))
                ),
                Matchers.is(true)
        );
    }
}
