import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "Valenta2001!";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employeelist")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployeeList = resultSet.getInt("id");
                String firsNameOfEmployeeList = resultSet.getString("firs_name");
                String lastNameOfEmployeeList = resultSet.getString("last_Name");
                String genderNameOfEmployeeList = resultSet.getString("gender");
                int ageOfEmployeeList = resultSet.getInt("age");
                int cityNameNameOfEmployeeList = resultSet.getInt("id_city");


                employees.add(new Employee(idOfEmployeeList, firsNameOfEmployeeList, lastNameOfEmployeeList, genderNameOfEmployeeList, ageOfEmployeeList, cityNameNameOfEmployeeList));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeelist WHERE id=" + id)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployeeList = resultSet.getInt("id");
                String firsNameOfEmployeeList = resultSet.getString("firs_name");
                String lastNameOfEmployeeList = resultSet.getString("last_Name");
                String genderNameOfEmployeeList = resultSet.getString("gender");
                int ageOfEmployeeList = resultSet.getInt("age");
                int cityNameNameOfEmployeeList = resultSet.getInt("id_city");
                employee = new Employee(idOfEmployeeList, firsNameOfEmployeeList, lastNameOfEmployeeList, genderNameOfEmployeeList, ageOfEmployeeList, cityNameNameOfEmployeeList);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employeelist SET id=?, firs_name =?,last_name=?,gender=?,age=?, id_city=? WHERE id =?")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirs_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getId_city());
            statement.setInt(7, employee.getId());
            int resultSet = statement.executeUpdate();
            System.out.println("Раюотник обновлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employeelist( id, firs_name, last_name, gender, age, id_city) VALUES (?,?,?,?,?,?)")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirs_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getId_city());
            int resultSet = statement.executeUpdate();
            System.out.println("работник добавлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employeelist WHERE id = " + id)) {
            int resultSet = statement.executeUpdate();
            System.out.println(" сотрудник удален");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();

        }
    }
}