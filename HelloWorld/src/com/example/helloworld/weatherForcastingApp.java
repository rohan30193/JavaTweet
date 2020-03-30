package com.example.helloworld;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/*
* This is a dummy weather forcasting application
* */
public class weatherForcastingApp {

    public interface WeatherData{

        public void notifyUsers();
        public void addUser(observer obs);
        public void removeUser(observer obs);
    }
    public interface Display{
        public void display();
    }

    public interface observer{
        public void update(double temp,double humidity, double pressure);
    }


    public static class WeatherApp implements WeatherData{

        ArrayList<observer> List;
        double temp;
        double humidity;
        double pressure;

        public WeatherApp()
        {
            List = new ArrayList<observer>();
        }

        @Override
        public void addUser(observer obs) {
            List.add(obs);
        }
        @Override
        public void removeUser(observer obs)
        {
            int i=List.indexOf(obs);
            if(i>=0)
            {
                List.remove(i);
            }
        }

        @Override
        public void notifyUsers() {

            for(int i=0;i<List.size();i++)
            {
                observer obs= List.get(i);
                obs.update(temp,humidity,pressure);
            }
        }

        public void setUpdate(double temp, double humidity, double pressure)
        {
            this.temp=temp;
            this.humidity=humidity;
            this.pressure=pressure;
            notifyUsers();
        }


    }

    public static class currentObserver implements Display,observer{

        double temp;
        double humidity;
        double pressure;
        WeatherData weatherData;

        public currentObserver(WeatherData weatherData)
        {
            this.weatherData=weatherData;
            weatherData.addUser(this);
        }
        @Override
        public void display() {
            System.out.println("your current temp is :- " + temp +", pressure is:- " + pressure+", and humidity is :- "+humidity +".");
        }

        @Override
        public void update(double temp,double humidity, double pressure) {
            this.temp=temp;
            this.humidity=humidity;
            this.pressure=pressure;
            display();
        }
    }

    public static void main(String[] args) {
        WeatherApp weatherApp = new WeatherApp();

        currentObserver curr = new currentObserver(weatherApp);
        currentObserver currentObserver = new currentObserver(weatherApp);

        weatherApp.setUpdate(20.0,79.0,22.02);
        weatherApp.setUpdate(21.0,78.05,23.0);
        weatherApp.setUpdate(23.0,79.03,24);
    }
}
