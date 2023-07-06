package dao;

import model.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    static EntityManager readPersistent() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    final String user = "postgres";
    final String password = "1111";
    final String url = "jdbc:postgresql://localhost:5432/skypro";


    @Override
    public void add(Employee employee) {
        EntityManager entityManager = readPersistent();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employee getById(int id) {
        EntityManager entityManager = readPersistent();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = readPersistent();
        String s = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(s, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employees;
    }


    @Override
    public void updateEmployeeById(Employee employee, int id) {
        EntityManager entityManager = readPersistent();
        employee.setId(id);
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteEmployeeById(int id) {
        EntityManager entityManager = readPersistent();
        entityManager.remove(entityManager.find(Employee.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}


