package service;

import java.util.Objects;

public class City {
        private int id;

        private String nameOfTheCity;
        private double latitude;
        private double longitude;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNameOfTheCity() {
                return nameOfTheCity;
        }

        public void setNameOfTheCity(String nameOfTheCity) {
                this.nameOfTheCity = nameOfTheCity;
        }

        public double getLatitude() {
                return latitude;
        }

        public void setLatitude(double latitude) {
                this.latitude = latitude;
        }

        public double getLongitude() {
                return longitude;
        }

        public void setLongitude(double longitude) {
                this.longitude = longitude;


        }

        @Override
        public String toString() {
                return "City{" +
                        "id=" + id +
                        ", nameOfTheCity='" + nameOfTheCity + '\'' +
                        ", latitude=" + latitude +
                        ", longitude=" + longitude +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                City city = (City) o;
                return id == city.id && Double.compare(city.latitude, latitude) == 0 && Double.compare(city.longitude, longitude) == 0 && nameOfTheCity.equals(city.nameOfTheCity);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, nameOfTheCity, latitude, longitude);
        }
}
