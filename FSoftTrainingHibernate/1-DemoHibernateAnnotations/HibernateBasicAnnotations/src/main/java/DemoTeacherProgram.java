import entity.Teacher;
import repository.TeacherRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DemoTeacherProgram {
    static TeacherRepository teacherRepository = new TeacherRepository();
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void getAll() {
        List<Teacher> teacherList = teacherRepository.getAllTeachers();
        teacherList.forEach(System.out::println);
    }

    // Cách insert cũ
    public static void insert() {
        Teacher teacher = new Teacher();
        System.out.println("Nhập tên giáo viên: ");
        String name = scanner.next();
        teacher.setName(name);
        teacherRepository.insertTeacher(teacher);
        getAll();
    }

    // Cách insert new
    public static void insertScanner(String name) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacherRepository.insertTeacher(teacher);
        getAll();
    }

    public static void main(String[] args) {
        getAll();

        boolean stop = false;
        while (!stop) {
            /*insert();*/
            System.out.println("Nhập tên giáo viên để insert, x để thoát");

            String input = scanner.next();

            if (!Objects.equals(input, "x")) {
                insertScanner(input);
            } else stop = true;
        }
    }
}
