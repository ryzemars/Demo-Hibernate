package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "Sinhvien")
@Table (name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "serial")
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_name", nullable = false, unique = false, length = 50)
    private String studentName;

    @Column(name = "student_address", nullable = true, unique = false, length = 100)
    private String studentAddress;

    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void showInformation() {
//        System.out.format("+------+----------------+---------------+%n");
//        System.out.format("|  ID  |      Name      |    Address    |%n");
//        System.out.format("+------+----------------+---------------+%n");

        System.out.format("|  %-3d |      %-8s  |    %-10s |%n", id, studentName, studentAddress);
    }
}

