package br.com.desafio.desafiocrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.desafiocrud.dto.CarDTO;
import br.com.desafio.desafiocrud.model.Car;
import br.com.desafio.desafiocrud.service.CarService;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {


    @Autowired
    private CarService carService;


        @GetMapping()
    public List<Car> getCars() {
        return carService.findCars();
    }

    @GetMapping("{idCar}")
    public ResponseEntity<Optional<Car>> getCar(@PathVariable Integer idCar) {

          Optional<Car> car = carService.findCar(idCar);
        if (car.isPresent()) {
           
            return ResponseEntity.ok().body(car);
        } else {
            return ResponseEntity.notFound().build();
        }        
    }

    /**
     * salva o Car na base
     * 
     * @param carDTO
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);

        return carService.saveCar(car);

    }

    @PutMapping("{idCar}")
    public ResponseEntity<Car> updateCar(@Validated  @PathVariable Integer idCar, @RequestBody CarDTO carDTO) {

        Optional<Car> car = carService.findCar(idCar);

          if (car.isPresent()) {            
           
            return new ResponseEntity<>(carService.saveCar(car.get()), HttpStatus.OK);

        } else {
            return ResponseEntity.notFound().build();
        }
         
    }

    @DeleteMapping("{idCar}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer idCar) {
        Optional<Car> car = carService.findCar(idCar);
        if (car.isPresent()) {
            carService.deleteCar(idCar);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
