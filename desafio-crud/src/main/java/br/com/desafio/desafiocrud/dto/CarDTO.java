package br.com.desafio.desafiocrud.dto;

public class CarDTO {

    private Integer idUser;
    public Integer getIdUser() {
        return idUser;
    }



    private Integer idCar;
    private String licensePlate;
    private int year;
    private String model;
    private String color;


    
    public CarDTO(Integer idCar, String licensePlate, int year, String model, String color, Integer idUser) {
        this.idCar = idCar;
        this.licensePlate = licensePlate;
        this.year = year;
        this.model = model;
        this.color = color;
        this.idUser = idUser;
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
