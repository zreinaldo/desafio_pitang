package br.com.desafio.desafiocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.desafiocrud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
}
