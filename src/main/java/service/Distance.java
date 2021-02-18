package service;

public class Distance implements ImplDistance{

    private int id;
    City city;


    @Override
    public Distance calculatingDistance(int id, City toCity, City fromCity) {
        return this;
    }
}
