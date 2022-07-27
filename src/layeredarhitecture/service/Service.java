package layeredarhitecture.service;

import layeredarhitecture.entity.Employee;

import java.util.List;

public interface Service {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(String id);

    Employee getEmployee(String id);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesBySalary(Integer salary);

    List<Employee> getEmployeesByProjectName(String projectName);

    void assignProjectToEmployee(String employeeId, String projectName);
}