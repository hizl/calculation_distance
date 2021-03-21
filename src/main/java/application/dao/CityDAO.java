package application.dao;

import application.entity.CityModel;

import java.util.List;

public interface CityDAO {

    List<CityModel> findAllCity();

    void deleteCity(Integer id);

    CityModel findById(Integer id);

    CityModel saveNewCity(CityModel cityModel);


}
