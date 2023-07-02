import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(6, "K", "D", "f", 20, 5);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.getAllEmployee().forEach(System.out::println);
        employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());
        System.out.println();
        employeeDao.updateEmployee(employee, id);
        employeeDao.deleteEmployee(employeeDao.getById(id);

        System.out.println(employeeDao.getById(2));

    }
}

