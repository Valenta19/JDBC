import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "Valenta2001!";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement(" SELECT * FROM employeelist, city")) {
            System.out.println("Соединение установлено!");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployeeList = resultSet.getInt("id");
                System.out.println(" ID работника: " + idOfEmployeeList);

                String firsNameOfEmployeeList = resultSet.getString("firs_name");
                String lastNameOfEmployeeList = resultSet.getString("last_Name");
                String genderNameOfEmployeeList = resultSet.getString("gender");
                String cityNameNameOfEmployeeList = resultSet.getString("city_name");

                System.out.print("Имя: " + firsNameOfEmployeeList + ", ");
                System.out.print("Фамилия: " + lastNameOfEmployeeList + ", ");
                System.out.print("пол: " + genderNameOfEmployeeList + ", ");
                System.out.println("город проживания: " + cityNameNameOfEmployeeList);

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        System.out.println("Получение списка всех объектов Employee из базы ");
        List<Employee> getAllEmployee = employeeDAO.getAllEmployee();
        for (Employee employee : getAllEmployee) {
            System.out.println(employee);
        }
        System.out.println("Создание (добавление) сущности Employee в таблицу");
        employeeDAO.updateEmployee(new Employee(8, "Jon", "Martinez", "male", 26, 8));
        List<Employee> updateEmployee = employeeDAO.getAllEmployee();
        for (Employee employee : updateEmployee) {
            System.out.println(employee);
        }
        System.out.println(" Удаление конкретного объекта Employee из базы по id.");
        employeeDAO.deleteEmployee(6);
        List<Employee> deleteEmployee = employeeDAO.getAllEmployee();
        for (Employee employee : deleteEmployee) {
            System.out.println(employee);
        }
        System.out.println("Получение конкретного объекта Employee по id");
        System.out.println(employeeDAO.getEmployeeById(2));
        System.out.println("Изменение конкретного объекта Employee в базе по id.");
        employeeDAO.createEmployee(new Employee(3,"Mario","Barnett","male", 25, 3));
        List<Employee> createEmployee = employeeDAO.getAllEmployee();
        for (Employee employee : createEmployee) {
            System.out.println(employee);
        }

    }
}
