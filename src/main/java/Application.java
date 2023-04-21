public class Application {
    public static void main(String[] args) {

        Employee employee = new Employee(3,"Ramon", "Stokes", "male", 27, 4);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getAllEmployee();
        employeeDAO.getAllEmployee();
        employee.setAge(12);
        employeeDAO.updateEmployee(employee);
        employeeDAO.getAllEmployee();
        employeeDAO.deleteEmployee(employee);
        employeeDAO.createEmployee(employee);


    }
}
