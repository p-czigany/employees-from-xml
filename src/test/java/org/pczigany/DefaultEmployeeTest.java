package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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
                )).name(),
                Matchers.is(Matchers.equalTo("John Doe"))
        );
    }

    @Test
    void nameMethodCallsNameObject() {
        final FakeName fakeName = new FakeName();
        new DefaultEmployee(
                fakeName,
                new DefaultDepartments(Collections.emptyList())
        ).name();
        MatcherAssert.assertThat(
                "did not call the neccessary service",
                fakeName.getNumberOfTextCalls(),
                Matchers.is(Matchers.equalTo(1))
        );
    }

    @Test
    void nameMethodReturnsWithAnswerOfNameObject() {
        MatcherAssert.assertThat(
                "return value is not correct",
                new DefaultEmployee(
                        new FakeName(),
                        new DefaultDepartments(Collections.emptyList())
                ).name(),
                Matchers.is(Matchers.equalTo("Fake Name"))
        );
    }

    @Test
    void equals() {
        MatcherAssert.assertThat(
                "equals method is not correct",
                new DefaultEmployee(new XMLDocument(
                        """
                                <employee>
                                    <name>George Smith</name>
                                    <department>finance</department>
                                </employee>
                                """
                )).equals(
                        new DefaultEmployee(
                                new DefaultName(new XMLDocument(
                                        """
                                                <employee>
                                                    <name>George Smith</name>
                                                    <department>finance</department>
                                                </employee>
                                                """
                                )),
                                new DefaultDepartments(new XMLDocument(
                                        """
                                                <employee>
                                                    <name>George Smith</name>
                                                    <department>finance</department>
                                                </employee>
                                                """
                                ))
                        )
                ),
                Matchers.is(true)
        );
    }
}
