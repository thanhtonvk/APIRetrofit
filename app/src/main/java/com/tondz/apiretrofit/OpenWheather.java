package com.tondz.apiretrofit;

import java.util.ArrayList;

class City{
    private int id;
    private String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Temp{
    private double day,min,max,night,eve,morn;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public Temp(double day, double min, double max, double night, double eve, double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
class List{
    private Temp temp;
    private FeelsLike feels_like;

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public FeelsLike getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(FeelsLike feels_like) {
        this.feels_like = feels_like;
    }

    public List(Temp temp, FeelsLike feels_like) {
        this.temp = temp;
        this.feels_like = feels_like;
    }

    @Override
    public String toString() {
        return "List{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                '}';
    }
}
class FeelsLike{
    private double day,night,eve,morn;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public FeelsLike(double day, double night, double eve, double morn) {
        this.day = day;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "FeelsLike{" +
                "day=" + day +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}

class Wheather {
    private int id;
    private String main;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wheather(int id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Wheather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
public class OpenWheather{
    private City city;
    private ArrayList<List> list;
    private int pressure;
    private int humidity;
    private Wheather wheather;
    private double speed;
    private int deg;
    private int cloud;

    public OpenWheather(City city, ArrayList<List> list, int pressure, int humidity, Wheather wheather, double speed, int deg, int cloud) {
        this.city = city;
        this.list = list;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wheather = wheather;
        this.speed = speed;
        this.deg = deg;
        this.cloud = cloud;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Wheather getWheather() {
        return wheather;
    }

    public void setWheather(Wheather wheather) {
        this.wheather = wheather;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    @Override
    public String toString() {
        return "OpenWheather{" +
                "city=" + city +
                ", list=" + list +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", wheather=" + wheather +
                ", speed=" + speed +
                ", deg=" + deg +
                ", cloud=" + cloud +
                '}';
    }
}