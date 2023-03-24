import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


//nguon: https://www.digitalocean.com/community/tutorials/jpa-entitymanager-hibernate
public class EmployeeDemoProgram {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    /*@PersistenceContext
    private static EntityManager entityManager;*/

    static void getAll() {
        // get all the objects from Employee table
        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

        if (employeeList == null) {
            System.out.println("No employee found");
        } else {
            employeeList.forEach(System.out::println);
        }
    }

    static void insert() {
        // insert new Employee to DB
        System.out.println("Start Transaction");
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setEmployeeName("Quang Dat");
        System.out.println("Save new Employee to DB...");

        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        System.out.println("Generated Employee ID = " + employee.getEmployeeId());
    }

    static void findById(int id) {
        // get an object using primary key.
        Employee employee1 = entityManager.find(Employee.class, id);
        System.out.println(employee1);
    }

    static void remove(int id) {
        // remove and entity
        Employee employee2 = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        System.out.println("Deleting Employee with ID = " + employee2.getEmployeeId());
        entityManager.remove(employee2);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        getAll();
        // close the entity manager
        entityManager.close();
        //entityManagerFactory.close();
    }
}
