package org.pczigany;

import com.jcabi.xml.XMLDocument;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Test
    void debugDetailedEquality() {
//        PathAsEmployeeList list = new PathAsEmployeeList("employee_test_short.xml");
        PathAsEmployeeList list = new PathAsEmployeeList("employee_test.xml");
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
