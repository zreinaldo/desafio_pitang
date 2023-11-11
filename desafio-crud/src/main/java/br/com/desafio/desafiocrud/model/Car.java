package br.com.desafio.desafiocrud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CARS", uniqueConstraints = { @UniqueConstraint(columnNames = { "LICENSE_PLATE" }) })
public class Car implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER")
    @JsonBackReference
    private Car cars;

    @Id
    @Column(name = "ID_CAR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public Car getCars() {
        return cars;
    }

    public void setCars(Car cars) {
        this.cars = cars;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCar == null) ? 0 : idCar.hashCode());
        result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
        result = prime * result + year;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (idCar == null) {
            if (other.idCar != null)
                return false;
        } else if (!idCar.equals(other.idCar))
            return false;
        if (licensePlate == null) {
            if (other.licensePlate != null)
                return false;
        } else if (!licensePlate.equals(other.licensePlate))
            return false;
        if (year != other.year)
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }

}
