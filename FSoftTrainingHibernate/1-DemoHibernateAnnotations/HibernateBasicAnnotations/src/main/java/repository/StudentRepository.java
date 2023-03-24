package repository;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class StudentRepository {

    private final HibernateUtil hibernateUtil;

    public StudentRepository() {
        hibernateUtil = HibernateUtil.getInstance();
    }

    public void insertStudent(Student student) {
        try (Session session = hibernateUtil.openSession()) {
            session.save(student);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = hibernateUtil.openSession()) {
            Query<Student> query = session.createQuery("FROM Sinhvien.class");
            return query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Student checkIdExist(int id) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            Student student = session.get(Student.class, id);
            return student;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Student getStudentById(int id) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            session.beginTransaction();
            if (id < 1)
                throw new Exception("Invalid input! ID must be > 0");
            if (checkIdExist(id) == null)
                throw new Exception("Id is not exist, try another");
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        } catch (Exception e) {
            if (null != session)
                session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            if (null != session)
                session.close();
        }
        return null;
    }

    public List<Student> getStudentByNameAndAddress(String name, String address) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Student s WHERE s.studentName = :studentName AND s.studentAddress = :studentAddress");
            query.setParameter("studentName", name);
            query.setParameter("studentAddress", address);
            List<Student> studentList = query.list();
            session.getTransaction().commit();
            return studentList;
        } catch (Exception e) {
            if (null != session)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (null != session)
                session.close();
        }
        return null;
    }

    public void updateStudent(int id, String newStudentName) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            System.out.println("    Name before set: " + student.getStudentName());
            student.setStudentName(newStudentName);
            System.out.println("    Name after set: " + student.getStudentName());
            session.getTransaction().commit();
        } catch (Exception exception) {
            if (null != session)
                session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtil.openSession();
            transaction = session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null)
                transaction.rollback();
            exception.printStackTrace();
        }
    }
}
