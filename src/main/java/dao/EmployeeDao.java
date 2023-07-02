package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployee();

    void updateEmployeeById(Employee employee, int id);

    void deleteEmployeeById(int id);
}
