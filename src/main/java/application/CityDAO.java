package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityDAO {


    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;


    public CityDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = "jdbc:mysql://localhost:3306/distance_calculation";
        this.jdbcUsername = "D";
        this.jdbcPassword = "1";
    }


    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }


    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }


    public boolean insertCity(City city) throws SQLException {
        String sql = "INSERT INTO City (id, name, latitude, Longitude) VALUES (?, ?, ?, ?)";
        connect();


        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, city.getId());
        statement.setString(2, city.getName());
        statement.setDouble(3, city.getLatitude());
        statement.setDouble(4, city.getLongitude());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }


    public List<City> listAllCity() throws SQLException {
        List<City> listCity = new ArrayList<>();

        String sql = "SELECT * FROM City";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("Name");
            double latitude = resultSet.getDouble("Latitude");
            double longitude = resultSet.getDouble("Longitude");


            City city = new City(id, name, latitude, longitude);
            listCity.add(city);
        }


        resultSet.close();
        statement.close();

        disconnect();

        return listCity;
    }

    public boolean deleteCity(City city) throws SQLException {
        String sql = "DELETE FROM City where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, city.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateCity(City city) throws SQLException {
        String sql = "UPDATE City SET Name = ?, Latitude = ?, Longitude = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, city.getId());
        statement.setString(2, city.getName());
        statement.setDouble(3, city.getLatitude());
        statement.setDouble(4, city.getLongitude());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public City getCity(int id) throws SQLException {
        City city = null;
        String sql = "SELECT * FROM City WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            double latitude = resultSet.getDouble("latitude");
            double longitude = resultSet.getDouble("longitude");

            city = new City(id, name, latitude, longitude);
        }

        resultSet.close();
        statement.close();

        return city;
    }
}
