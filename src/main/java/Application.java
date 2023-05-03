import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City();
        city.setCityName("Kazan");
        Employee employee = new Employee("Sean", " Wilson", "male", 28,city);
        Employee employee1 = new Employee("Michael", "Lopez", "male", 29, city);
        Employee employee2 = new Employee("Ronald", "Hayes", "male", 33,city);
        List<Employee> employees = List.of(employee, employee1, employee2);
        cityDAO.createCity(city);
        city.setEmployees(employees);
        cityDAO.updateCity(city);
        cityDAO.deleteCity(city);



    }
}

