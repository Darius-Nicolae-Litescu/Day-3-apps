package layeredarhitecture.service;

import layeredarhitecture.entity.Employee;
import layeredarhitecture.exception.UserNotFoundException;
import layeredarhitecture.repository.Repository;
import layeredarhitecture.repository.RepositoryImpl;

import java.util.List;

public class ServiceImpl implements Service {

    private final Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void addEmployee(Employee employee){
        repository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee){
        repository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(String id) throws UserNotFoundException {
        repository.deleteEmployee(id);
    }

    @Override
    public Employee getEmployee(String id){
        return repository.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return repository.getAllEmployees();
    }

    @Override
    public List<Employee> getEmployeesBySalary(Integer salary){
        return repository.getEmployeesBySalary(salary);
    }

    @Override
    public List<Employee> getEmployeesByProjectName(String projectName){
        return  repository.getEmployeesByProjectName(projectName);
    }

    @Override
    public void assignProjectToEmployee(String employeeId, String projectName){
       repository.assignProjectToEmployee(employeeId, projectName);
    }

}
