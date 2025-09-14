package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PathAsEmployeeListTest {
    @Test
    void size() {
        MatcherAssert.assertThat(
                "the size is not correct",
                new PathAsEmployeeList("employee_test.xml").size(),
                Matchers.is(Matchers.equalTo(10))
        );
    }

    @Test
    void contains() {
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

    @Test
    void containsAll() {
        MatcherAssert.assertThat(
                "some employees are missing",
                new PathAsEmployeeList("employee_test.xml").containsAll(
                        Arrays.asList(
                                new DefaultEmployee(
                                        new TextName("George Smith"),
                                        new DefaultDepartments(
                                                List.of("finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Michael Smith"),
                                        new DefaultDepartments(
                                                List.of("it", "finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("James Doyle"),
                                        new DefaultDepartments(
                                                List.of("packaging")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Peter Goeking"),
                                        new DefaultDepartments(
                                                List.of("finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Joanne Olsen"),
                                        new DefaultDepartments(
                                                List.of("finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Samuel Palmisano"),
                                        new DefaultDepartments(
                                                List.of("it")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Dale Miller"),
                                        new DefaultDepartments(
                                                List.of("packaging", "finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Peter Goeking"),
                                        new DefaultDepartments(
                                                List.of("finance")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("James Doyle"),
                                        new DefaultDepartments(
                                                List.of("packaging")
                                        )
                                ),
                                new DefaultEmployee(
                                        new TextName("Peter Goeking"),
                                        new DefaultDepartments(
                                                List.of("it")
                                        )
                                )
                        )
                ),
                Matchers.is(true)
        );
    }
}
