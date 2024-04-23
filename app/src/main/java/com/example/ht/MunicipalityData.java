package com.example.ht;

public class MunicipalityData {
    private static int year;
    private static int population;

    public MunicipalityData(int y, int p) {
        year = y;
        population = p;
    }


    public static int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public static int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }



}