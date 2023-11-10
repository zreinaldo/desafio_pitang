package br.com.desafio.desafiocrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.desafiocrud.model.Car;
import br.com.desafio.desafiocrud.repository.CarRepository;

@Service
public class CarService {
    
    
    @Autowired
    private CarRepository carRepository;

    public List<Car> findCars() {

        return carRepository.findAll();
    }

    public Optional<Car> findCar(Integer idCar) {       
        return carRepository.findById(idCar);
    }
    
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Integer idCar) {
        carRepository.deleteById(idCar);
    }




}
