package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city")
//@Table(name = "city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String city_name;


    public City(int cityId, String city_name) {
        this.cityId = cityId;
        this.city_name = city_name;
    }
    public City() {

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(city_name, city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, city_name);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}

