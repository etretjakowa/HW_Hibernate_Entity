package dao;

import model.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    final String user = "postgres";
    final String password = "1111";
    final String url = "jdbc:postgresql://localhost:5432/skypro";


    @Override
    public Integer add(Employee employee) {
        Integer id;
        {
            EntityManager entityManager = createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            id = (int) add(employee);
            entityManager.persist(employee);

            transaction.commit();
            entityManager.close();
        }
        return id;
    }

    @Override
    public Employee getById(int id) {

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        transaction.commit();
        entityManager.close();

        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT *FROM  employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
    }


    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();

    }

    public static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();

    }

}


