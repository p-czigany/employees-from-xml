package org.pczigany;

import java.util.List;

/**
 * An employee, working inside some departments
 */
public interface Employee {
    /**
     * @return the name as a String, e.g. Johann Schmidt
     */
    String getName();

    List<String> getDepartments();
}
