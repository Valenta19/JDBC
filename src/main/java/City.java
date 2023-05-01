import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city", insertable = false, updatable = false)
    private String idCity;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City(String idCity, String cityName) {
        this.idCity = idCity;
        this.cityName = cityName;
    }

    public City() {

    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity='" + idCity + '\'' +
                ", cityName='" + cityName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
