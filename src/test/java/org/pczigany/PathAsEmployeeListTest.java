package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PathAsEmployeeListTest {
    @Test
    void size() {
        MatcherAssert.assertThat(
                "the size is not correct",
                new PathAsEmployeeList("employee_test.xml").size(),
                Matchers.is(Matchers.equalTo(10))
        );
    }

    @Nested
    class Contains {
        @Test
        void trueWhenOnlyOneEmployeeInSourceFile() {
            MatcherAssert.assertThat(
                    "this employee is missing",
                    new PathAsEmployeeList("employee_test_short.xml").contains(
                            new DefaultEmployee(new XMLDocument(
                                    """
                                            <employee>
                                                <name>George Smith</name>
                                                <department>finance</department>
                                            </employee>"""
                            ))
                    ),
                    Matchers.is(true)
            );
        }

        @Test
        void trueWhenMultipleEmployeesInSourceFile() {
            MatcherAssert.assertThat(
                    "this employee is missing",
                    new PathAsEmployeeList("employee_test.xml").contains(
                            new DefaultEmployee(new XMLDocument(
                                    """
                                            <employee>
                                                <name>George Smith</name>
                                                <department>finance</department>
                                            </employee>"""
                            ))
                    ),
                    Matchers.is(true)
            );
        }
    }
}
