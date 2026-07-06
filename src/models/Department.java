package models;

public class Department {
    private int department_id;
    private String department_name;
    private String location;

    public Department() {

    }

    // setters + getters
    public int getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + department_id +
                ", name='" + department_name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
