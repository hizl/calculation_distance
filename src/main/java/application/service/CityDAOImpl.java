package application.service;

import application.model.CityModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityDAOImpl implements CityDAO {
    Connection con = null;
    PreparedStatement pst;
    ResultSet rs = null;


    @Override
    public List<CityModel> findAllCity() {
        final String selectQuery = "SELECT ID, Name, Latitude,Longitude FROM City";
        List<CityModel> cityModelList = new ArrayList<>();


        try {
            con = DBConnector.getConnection();
            pst = con.prepareStatement(selectQuery);
            try {
                rs = pst.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(pst.toString());
                e.printStackTrace();
            }

            try {
                while (rs.next()) {
                    CityModel cityModel = new CityModel();
                    Integer id = rs.getInt(1);
                    String city = rs.getString(2);
                    Double latitude = rs.getDouble(3);
                    Double longitude = rs.getDouble(4);


                    cityModel.setId(id);
                    cityModel.setName(city);
                    cityModel.setLatitude(latitude);
                    cityModel.setLongitude(longitude);


                    cityModelList.add(cityModel);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnector.closeConnectionAll(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cityModelList;
    }


    @Override
    public void deleteCity(Integer id) {

    }

    @Override
    public CityModel findById(Integer id) {
        return null;
    }

    @Override
    public CityModel saveNewCity(CityModel cityModel) {
        return null;
    }


}
