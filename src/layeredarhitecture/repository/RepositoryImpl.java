package layeredarhitecture.repository;

import layeredarhitecture.entity.Employee;
import layeredarhitecture.entity.Project;
import layeredarhitecture.exception.UserNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {
    private final Map<String, Employee> employeeMap;
    private final Set<Project> projects;

    public RepositoryImpl() {
        this.employeeMap = new HashMap<>();
        this.projects = new HashSet<>();
    }

    @Override
    public void addEmployee(Employee employee){
        employeeMap.put(employee.getId(), employee);
        projects.add(employee.getProject());
    }

    @Override
    public void updateEmployee(Employee employee){
        Employee existingEmployee = employeeMap.get(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setProject(employee.getProject());
    }

    @Override
    public void deleteEmployee(String id) throws UserNotFoundException {
        if(employeeMap.containsKey(id)) {
            employeeMap.remove(id);
        } else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public Employee getEmployee(String id){
        return employeeMap.get(id);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return new ArrayList<Employee>(employeeMap.values());
    }

    @Override
    public List<Employee> getEmployeesBySalary(Integer salary){
        List<Employee> employeeList = new ArrayList<>(employeeMap.values());
        return employeeList.stream().filter(employee -> Objects.equals(employee.getSalary(), salary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByProjectName(String projectName){
        List<Employee> employeeList = new ArrayList<>(employeeMap.values());
        return employeeList.stream().filter(employee -> Objects.equals(employee.getProject().getProjectName(), projectName)).collect(Collectors.toList());
    }

    @Override
    public void assignProjectToEmployee(String employeeId, String projectName){
        Employee employee = employeeMap.get(employeeId);
        Optional<Project> projectToUpdate = projects.stream().filter(project -> project.getProjectName().equals(projectName)).findFirst();
        if(projectToUpdate.isPresent()){
            employee.setProject(projectToUpdate.get());
        }
    }
}
