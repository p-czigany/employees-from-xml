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
                )).getName(),
                Matchers.is(Matchers.equalTo("John Doe"))
        );
    }

    @Test
    void nameMethodCallsNameObject() {
        final FakeName fakeName = new FakeName();
        new DefaultEmployee(fakeName, new DefaultDepartments(Collections.emptyList()))
                .getName();
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
                ).getName(),
                Matchers.is(Matchers.equalTo("Fake Name"))
        );
    }
}
