package application.test;

import application.service.CityDAO;
import application.service.CityDAOImpl;
import application.model.CityModel;

import java.util.List;


public class TestingRawResponseFromDatabase {
    public static void main(String[] args) {
        //findAllCities();
        deleteById(1);

    }

    public static void findAllCities() {
        CityDAO FIND = new CityDAOImpl();
        List<CityModel> findAll = FIND.findAllCity();
        findAll.forEach(System.out::println);
    }


    public static void deleteById(Integer id) {
        CityDAO DELETE = new CityDAOImpl();
        DELETE.deleteCity(id);

    }

}