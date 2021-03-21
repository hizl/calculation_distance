package application.controller;

import application.dao.CityDAO;
import application.dao.CityDAOImpl;
import application.entity.CityModel;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/")
public class GetCities extends HttpServlet {
    CityDAOImpl cityDAO;
    private Gson gson;


    @Override
    public void init() throws ServletException {
        cityDAO = new CityDAOImpl();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/findAll":
                try {
                    listCity(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }


    }

    private void listCity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<CityModel> city = cityDAO.findAllCity();
        request.setAttribute("city", city);
        RequestDispatcher dispatcher = request.getRequestDispatcher("city-list.jsp");
        dispatcher.forward(request, response);

    }


}
