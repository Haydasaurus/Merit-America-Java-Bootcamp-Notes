package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private int departmentId;
    private String name;

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
//    ??*********************************
//made an empty constructor that way we can iterate a list department in printDepart


    public void setName(String name) {
        this.name = name;
    }

    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

}

