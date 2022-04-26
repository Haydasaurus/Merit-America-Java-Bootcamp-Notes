package org.meritamerica;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentConstants {
    public enum DEPARTMENT_CONSTANTS {
        Admin,
        Editorial,
        Marketing
    }
    public final List<String> DEPARTMENT_CONSTANTS = new ArrayList<String>() {
        {
        add("Admin");
        add("Editorial");
        add("Marketing");
        }
    };
}
