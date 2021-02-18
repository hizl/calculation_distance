package dao;

import service.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplModelCity implements CityDao {


    private static final String FIND_ALL_CITY = "SELECT id, Name, Latitude, Longitude FROM City;";


    Connection getConnection() {
        try {
            System.out.println("connecting to database\n");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/distance_calculator",
                    "D",
                    "1");
        } catch (SQLException e) {
            System.err.println("Can't be connection\n" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<City> findAll() {

        Connection connection = getConnection();

        List<City> bookList = new ArrayList<>();
        try {

            PreparedStatement pstmt = connection.prepareStatement(FIND_ALL_CITY);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {

                City cityModel = new City();

                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double latitude = resultSet.getDouble(3);
                Double longitude = resultSet.getDouble(4);

                cityModel.setId(id);
                cityModel.setNameOfTheCity(name);
                cityModel.setLatitude(latitude);
                cityModel.setLongitude(longitude);


                bookList.add(cityModel);
            }


        } catch (SQLException e) {
            System.err.println("Exception while getting books\n" + e.getMessage());
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return bookList;
    }


    @Override
    public City findBy(Integer id) {
        return null;
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Double calculateDistance(int id1, int id2) {
        return null;
    }
}
