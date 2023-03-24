package repository;

import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherRepository {
    private final HibernateUtil hibernateUtil;

    public TeacherRepository() {
        hibernateUtil = HibernateUtil.getInstance();
    }

    public void insertTeacher(Teacher teacher) {
        try (Session session = hibernateUtil.openSession()) {
            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        try (Session session = hibernateUtil.openSession()) {
            Query<Teacher> query = session.createQuery("FROM Teacher");
            return query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /*public Teacher checkIdExist(int id) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            Teacher teacher = session.get(Teacher.class, id);
            return teacher;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Teacher getTeacherById(int id) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            session.beginTransaction();
            if (id < 1)
                throw new Exception("Invalid input! ID must be > 0");
            if (checkIdExist(id) == null)
                throw new Exception("Id is not exist, try another");
            Teacher teacher = session.get(Teacher.class, id);
            session.getTransaction().commit();
            return teacher;
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

    public void updateTeacher(int id, String newTeacherName) {
        Session session = null;
        try {
            session = hibernateUtil.openSession();
            session.beginTransaction();
            Teacher Teacher = session.load(Teacher.class, id);
            System.out.println("    Name before set: " + Teacher.getName());
            Teacher.setName(newTeacherName);
            System.out.println("    Name after set: " + Teacher.getName());
            session.getTransaction().commit();
        } catch (Exception exception) {
            if (null != session)
                session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void deleteTeacher(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtil.openSession();
            transaction = session.beginTransaction();
            Teacher teacher = session.load(Teacher.class, id);
            session.delete(teacher);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null)
                transaction.rollback();
            exception.printStackTrace();
        }
    }*/
}
