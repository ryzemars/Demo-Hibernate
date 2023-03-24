import entity.Student;
import repository.StudentRepository;
import utils.StudentFormatUtil;

import java.util.List;
import java.util.Scanner;

public class DemoStudentProgram {
    public StudentRepository studentRepository;
    public Scanner sc;
    public StudentFormatUtil formatUtil;

    public DemoStudentProgram() {
        studentRepository = new StudentRepository();
        sc = new Scanner(System.in).useDelimiter("\n");
        formatUtil = new StudentFormatUtil();
    }

    public static void main(String[] args) {
        DemoStudentProgram studentProgram = new DemoStudentProgram();
        studentProgram.pickOption();
    }

    public void pickOption() {
        boolean stop = false;
        //while (stop == false)
        while (!stop) {
            option();
            System.out.println("Nhập phím bất kỳ để show menu, x để thoát");
            String input = sc.next();
            if ("x".equalsIgnoreCase(input)) {
                stop = true;
            }
        }
    }

    public void option() {
        studentRepository.getAllStudents();
        System.out.println("--------------Student Hibernate--------------");
        System.out.println("Nhập 1: hiển thị danh sách student");
        System.out.println("Nhập 2: tìm kiếm student theo id");
        System.out.println("Nhập 3: tìm kiếm theo tên hoặc địa chỉ (đang phát triển)");
        System.out.println("Nhập 4: thêm mới student");
        System.out.println("Nhập 5: update thông tin student");
        System.out.println("Nhập 6: xóa student");
        int choose = sc.nextInt();

        switch (choose) {
            case 1 -> getAll();
            case 2 -> askGetById();
            case 3 -> getByNameAndAddress();
            case 4 -> askInsert();
            case 5 -> askUpdate();
            case 6 -> askDelete();
        }
        /*if (choose < 1 || choose > 6) {
            System.out.println("Nhập sai, hãy nhập lại");
        } else {

        }*/
    }

    public void getAll() {
        // get all student
        List<Student> studentList = studentRepository.getAllStudents();
        formatUtil.printTable();
        studentList.forEach(Student::showInformation);
        formatUtil.printFooter();
    }

    public void getById() {
        //get by id
        System.out.println("Nhập vào id: ");
        int id = sc.nextInt();
        Student student = studentRepository.getStudentById(id);
        if (student == null)
            System.out.print("");
            //System.out.println("Không có student nào có id = " + id);
        else {
            formatUtil.printHeader();
            student.showInformation();
            formatUtil.printFooter();
        }

    }

    public void askGetById() {
        boolean stop = false;
        while (!stop) {
            getById();
            System.out.println("Nhập c để tiếp tục tìm theo id, s để thoát");
            String input = sc.next();
            if ("s".equalsIgnoreCase(input)) {
                stop = true;
            }
        }
    }

    public void getByNameAndAddress() {
        //get by name and address
        //List<Student> studentList1 = studentRepository.getStudentByNameAndAddress("Linh", "hd");
        //studentList1.forEach(System.out::println);
        System.out.println("Comming soon!");

    }

    public void insert() {
        // insert to DB
        Student student = new Student();
        System.out.println("Nhập tên: ");
        String name = sc.next();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.next();
        student.setStudentName(name);
        student.setStudentAddress(address);
        studentRepository.insertStudent(student);
        getAll();
    }

    public void askInsert() {
        boolean stop = false;
        while (!stop) {
            insert();
            System.out.println("Nhập c để tiếp tục insert, s để thoát");
            String input = sc.next();
            if ("s".equalsIgnoreCase(input)) {
                stop = true;
            }
        }
    }

    public void update() {
        getAll();
        System.out.println("Lựa chọn id muốn chỉnh sửa: ");
        int id = sc.nextInt();
        System.out.println("Nhập tên mới: ");
        String name = sc.next();
        studentRepository.updateStudent(id, name);
        System.out.println("Done update ✅");
        getAll();
    }

    public void askUpdate() {
        boolean stop = false;
        while (!stop) {
            update();
            System.out.println("Nhập c để tiếp tục update, s để thoát");
            String input = sc.next();
            if ("s".equalsIgnoreCase(input)) {
                stop = true;
            }
        }
    }

    public void delete() {
        // delete
        getAll();
        System.out.println("lựa chọn id muốn xóa: ");
        int id = sc.nextInt();
        studentRepository.deleteStudent(id);
        System.out.println("Đã xóa id " + id + " ✅");
        getAll();
    }

    public void askDelete() {
        boolean stop = false;
        while (!stop) {
            delete();
            System.out.println("Nhập c để tiếp tục delete, s để thoát");
            String input = sc.next();
            if ("s".equalsIgnoreCase(input)) {
                stop = true;
            }
        }
    }
}
