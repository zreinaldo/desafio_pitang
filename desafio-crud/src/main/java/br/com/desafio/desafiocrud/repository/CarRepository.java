package br.com.desafio.desafiocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafiocrud.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{
    
}
