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
        System.out.println(employeeDao.getAllEmployee());
        System.out.println();
        int id = 1;
        Employee newEmployee = new Employee("Все", "Получиться", "m", 100, 5);
        employeeDao.updateEmployeeById(newEmployee, id);
        System.out.println(employeeDao.getAllEmployee());
        employeeDao.deleteEmployeeById(id);

        entityManager.close();
        entityManagerFactory.close();
    }
}

