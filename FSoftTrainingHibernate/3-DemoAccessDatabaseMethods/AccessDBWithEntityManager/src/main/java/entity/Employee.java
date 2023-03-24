package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    /*    @Id
        @Column(name = "employee_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /*@Column(name = "employee_name")*/
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + employeeName + "]";
    }
}
