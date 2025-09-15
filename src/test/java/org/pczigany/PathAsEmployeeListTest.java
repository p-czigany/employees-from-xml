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

    @Nested
    class Contains {
        @Test
        void containsIsTrue() {
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
        void containsIsTrueWhen() {
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

    @Test
    void debugDetailedEquality() {
        PathAsEmployeeList list = new PathAsEmployeeList("employee_test_short.xml");
        DefaultEmployee searchEmployee = new DefaultEmployee(new XMLDocument(
                """
                <employee>
                    <name>George Smith</name>
                    <department>finance</department>
                </employee>"""
        ));

        Employee firstFromList = list.get(0);

        // Check names
        String searchName = searchEmployee.name();
        String listName = firstFromList.name();
        System.out.println("Search name: '" + searchName + "' (length: " + searchName.length() + ")");
        System.out.println("List name: '" + listName + "' (length: " + listName.length() + ")");
        System.out.println("Names equal: " + searchName.equals(listName));

        // Check departments
        List<String> searchDepts = searchEmployee.departments();
        List<String> listDepts = firstFromList.departments();
        System.out.println("Search departments: " + searchDepts);
        System.out.println("List departments: " + listDepts);
        System.out.println("Departments equal: " + searchDepts.equals(listDepts));

        // Check the Name objects themselves
        if (firstFromList instanceof DefaultEmployee && searchEmployee instanceof DefaultEmployee) {
            DefaultEmployee listEmp = (DefaultEmployee) firstFromList;
            System.out.println("Name objects equal: " + searchEmployee.name.equals(listEmp.name));
            System.out.println("Department objects equal: " + searchEmployee.departments.equals(listEmp.departments));
        }

        System.out.println("Final equals: " + searchEmployee.equals(firstFromList));
    }
}
