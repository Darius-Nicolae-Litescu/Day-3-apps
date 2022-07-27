package layeredarhitecture;

import layeredarhitecture.entity.Employee;
import layeredarhitecture.exception.UserNotFoundException;
import layeredarhitecture.service.Service;

import java.util.List;

public class UI {

    private final Service service;

    public UI(Service service) {
        this.service = service;
    }

    public void addEmployee(Employee employee) {
        service.addEmployee(employee);
        System.out.println(employee + " | added");
    }

    public void updateEmployee(Employee employee) {
        service.updateEmployee(employee);
        System.out.println(employee + " | update");
    }

    public void deleteEmployee(String id) {
        try {
            service.deleteEmployee(id);
            System.out.println(id + " | deleted");
        } catch (UserNotFoundException exception) {
            System.out.println("User with id:" + id + " not found");
        }
    }

    public void getEmployee(String id) {
        Employee employee = service.getEmployee(id);
        System.out.println(employee + " | get");
    }

    public void getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        System.out.println(employees + " | all employees");
    }

    public void getEmployeesBySalary(Integer salary) {
        List<Employee> employeeList = service.getEmployeesBySalary(salary);
        System.out.println(employeeList + " | employees by salary");

    }

    public void getEmployeesByProjectName(String projectName) {
        List<Employee> employeeList = service.getEmployeesByProjectName(projectName);
        System.out.println(employeeList + " | employees by project name");
    }

    public void assignProjectToEmployee(String employeeId, String projectName) {
        service.assignProjectToEmployee(employeeId, projectName);
        System.out.println(employeeId + " assigned to " + projectName);
    }
}
