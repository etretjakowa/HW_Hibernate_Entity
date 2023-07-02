import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
               EntityManagerFactory entityManagerFactory
                       = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee("K", "D", "f", 20, 5);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.getAllEmployee().forEach(System.out::println);
        employeeDao.add(employee);
//        System.out.println(employeeDao.getAllEmployee());
//        System.out.println();
//        employeeDao.updateEmployee(employee, id);
//        employeeDao.deleteEmployee(employeeDao.getById(id);
//
//        System.out.println(employeeDao.getById(2));

        entityManager.close();
        entityManagerFactory.close();

    }
}

