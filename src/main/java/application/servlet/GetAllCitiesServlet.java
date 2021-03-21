package application.servlet;

import application.service.CityDAO;
import application.service.CityDAOImpl;
import application.model.CityModel;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "GetCitiesServlet", urlPatterns = "/city")
public class GetAllCitiesServlet extends HttpServlet {
    private Gson gson = new Gson();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        CityDAO FIND = new CityDAOImpl();
        List<CityModel> findAll = FIND.findAllCity();

        String result = this.gson.toJson(findAll);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        out.print(result);
        out.flush();


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


}
