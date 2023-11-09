package br.com.desafio.desafiocrud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CARS", uniqueConstraints={@UniqueConstraint(columnNames={"LICENSE_PLATE"})})
public class Car {

 
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="ID_USER", nullable=false)
   private User user;


    @Id
    @Column(name = "ID_CAR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCar;

    @Column(name = "LICENSE_PLATE")
    private String licensePlate;
    @Column(name = "YEAR")
    private int year;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "COLOR")
    private String color;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
