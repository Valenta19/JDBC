import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployee() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        for (Employee employee : employees) {
            System.out.println("ID работника: " + employee.getId());
            System.out.println("Имя работника: " + employee.getFirstName());
            System.out.println("Фамилия работника: " + employee.getLastName());
            System.out.println("возраст работника: " + employee.getAge());
            System.out.println("пол работника: " + employee.getGender());
            System.out.println("номер города: " + employee.getCityId());
            System.out.println(" ");
        }
        entityManager.close();
        entityManagerFactory.close();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Employee.class, id);

    }

    @Override
    public void createEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Transaction transaction = (Transaction) entityManager.getTransaction();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Transaction transaction = (Transaction) entityManager.getTransaction();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Transaction transaction = (Transaction) entityManager.getTransaction();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}