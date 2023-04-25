public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee("Ramon", "Stokes", "male", 27, 4);
        employeeDAO.createEmployee(employee);
        employeeDAO.getAllEmployee();
        employeeDAO.deleteEmployee(employee);

        employeeDAO.getAllEmployee();
        employee.setAge(1);
        employeeDAO.updateEmployee(employee);
        employeeDAO.getAllEmployee();



    }
}
