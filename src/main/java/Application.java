import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City();
        city.setCityName("Казань");

        Employee employee = new Employee("Sean", " Wilson", "male", 28);
        Employee employee1 = new Employee("Michael", "Lopez", "male", 29);
        Employee employee2 = new Employee("Ronald", "Hayes", "male", 33);
        List<Employee> employees = List.of(employee, employee1, employee2);
        cityDAO.createCity(city);
        cityDAO.deleteCity(city);
        city.setEmployees(employees);
        cityDAO.updateCity(city);
        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(10));


    }
}

