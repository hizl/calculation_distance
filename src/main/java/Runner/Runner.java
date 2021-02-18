package Runner;

import dao.CityDao;
import dao.ImplModelCity;
import service.City;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        CityDao model = new ImplModelCity();



        List<City> findBooks = model.findAll();
        findBooks.forEach(System.out::println);

    }
}
