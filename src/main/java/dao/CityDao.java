package dao;


import service.City;

import java.util.List;

public interface CityDao {

    List<City> findAll();

    City findBy(Integer id);

    City save(City city);

    void delete(Integer id);

    Double calculateDistance(int id1, int id2);

}
