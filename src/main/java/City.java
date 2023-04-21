public class City {
    private String id_city;
    private String city_name;

    public City(String id_city, String city_name) {
        this.id_city = id_city;
        this.city_name = city_name;
    }

    public String getId_city() {
        return id_city;
    }

    public void setId_city(String id_city) {
        this.id_city = id_city;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}