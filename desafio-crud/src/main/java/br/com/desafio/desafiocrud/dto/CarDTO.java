package br.com.desafio.desafiocrud.dto;

import javax.persistence.Column;

public class CarDTO {

    private Integer idCar;
    private String licensePlate;
    private int year;
    private String model;
    private String color;


    
    public CarDTO(Integer idCar, String licensePlate, int year, String model, String color) {
        this.idCar = idCar;
        this.licensePlate = licensePlate;
        this.year = year;
        this.model = model;
        this.color = color;
    }



    public Integer getIdCar() {
        return idCar;
    }



    public String getLicensePlate() {
        return licensePlate;
    }



    public int getYear() {
        return year;
    }



    public String getModel() {
        return model;
    }



    public String getColor() {
        return color;
    }


    


}
