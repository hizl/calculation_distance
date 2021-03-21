package application.controller;

import application.dao.CityDAO;
import application.dao.CityDAOImpl;
import application.entity.CityModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Runner {
    public static void main(String[] args) {


            CityDAO FIND = new CityDAOImpl();
            List<CityModel> findAll = FIND.findAllCity();
            findAll.forEach(System.out::println);

    }

}