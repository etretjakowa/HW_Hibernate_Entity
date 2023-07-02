package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee, int id);

    void deleteEmployee(Employee employee);
}
