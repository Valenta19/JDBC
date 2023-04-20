public class Employee {
    int id;
    private String firs_name;
    private String last_name;
    private String gender;
    private int age;
    private int id_city;

    public Employee(int id, String firs_name, String last_name, String gender, int age, int id_city) {
        this.id = id;
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.id_city = id_city;
    }

    @Override
    public String toString() {
        return
                "ID работника: " + id +
                        ", Имя: " + firs_name +
                        ", Фамилия: " + last_name +
                        ", пол: " + gender +
                        ", Возраст: " + age +
                        ", номер города: " + id_city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }
}
