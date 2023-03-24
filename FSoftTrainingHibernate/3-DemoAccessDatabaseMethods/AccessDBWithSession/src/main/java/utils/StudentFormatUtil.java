package utils;

public class StudentFormatUtil {
    public void printTable() {
        System.out.format("+---------------------------------------+%n");
        System.out.format("|          STUDENT INFORMATION          |%n");
        System.out.format("+------+----------------+---------------+%n");
        System.out.format("|  ID  |      Name      |    Address    |%n");
        System.out.format("+------+----------------+---------------+%n");
    }

    public void printHeader() {
        System.out.format("+------+----------------+---------------+%n");
        System.out.format("|  ID  |      Name      |    Address    |%n");
        System.out.format("+------+----------------+---------------+%n");
    }

    public void printFooter() {
        System.out.format("+------+----------------+---------------+%n");
    }
}
