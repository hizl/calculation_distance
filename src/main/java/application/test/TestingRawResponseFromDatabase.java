package application.test;

import application.service.CityDAO;
import application.service.CityDAOImpl;
import application.model.CityModel;

import java.util.List;


public class TestingRawResponseFromDatabase {
    public static void main(String[] args) {
        FindAllCities();

    }

    public static void FindAllCities() {
        CityDAO FIND = new CityDAOImpl();
        List<CityModel> findAll = FIND.findAllCity();
        findAll.forEach(System.out::println);
    }

}