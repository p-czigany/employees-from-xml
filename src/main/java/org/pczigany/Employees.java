package org.pczigany;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Employees {
    List<Employee> getEmployees() throws IOException;
}
