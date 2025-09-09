package org.pczigany;

import java.io.IOException;

public interface JsonEmployees extends Employees {
    String jsonEmployeeNames() throws IOException;
}
