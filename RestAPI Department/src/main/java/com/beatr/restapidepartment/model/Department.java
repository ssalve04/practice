package com.beatr.restapidepartment.model;

public class Department {
    private int id;
    private String dept_name;
    private String dept_location;

    public Department(int id, String dept_name, String dept_location) {
        this.id = id;
        this.dept_name = dept_name;
        this.dept_location = dept_location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_location() {
        return dept_location;
    }

    public void setDept_location(String dept_location) {
        this.dept_location = dept_location;
    }
}
