package layeredarhitecture;

import layeredarhitecture.entity.Employee;
import layeredarhitecture.entity.Project;
import layeredarhitecture.repository.RepositoryImpl;
import layeredarhitecture.service.ServiceImpl;

public class Client {

    public static void main(String[] args) {
        RepositoryImpl repository = new RepositoryImpl();
        ServiceImpl service = new ServiceImpl(repository);

        UI application = new UI(service);

        Project foodDeliveryProject = new Project("Food delivery app");
        Project bankingProject = new Project("Banking 1001");

        application.addEmployee(new Employee("ID1", "Darius", 300, foodDeliveryProject));
        application.addEmployee(new Employee("ID2", "Nicolae", 200, bankingProject));
        application.addEmployee(new Employee("ID3", "Demos", 400, bankingProject));
        application.addEmployee(new Employee("ID4", "Dino", 400, bankingProject));
        application.addEmployee(new Employee("ID5", "Enterprise", 400, bankingProject));

        application.getEmployeesBySalary(400);
        application.getEmployeesByProjectName("Banking 1001");
        application.getEmployee("ID5");
        application.updateEmployee(new Employee("ID5", "Enterprise", 400, foodDeliveryProject));
        application.getEmployee("ID5");

        application.assignProjectToEmployee("ID5", bankingProject.getProjectName());
        application.getEmployee("ID5");
    }
}
