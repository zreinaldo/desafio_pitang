package br.com.desafio.desafiocrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.desafio.desafiocrud.model.User;
import br.com.desafio.desafiocrud.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;


    public List<User> findUsers(){
        return userRepository.findAll();
    }
    
    public Optional<User> findUser(Integer idUser){
        return  userRepository.findById(idUser);
    }

    public Optional<User>  getUse(@PathVariable Integer idUser){
        return userRepository.findById(idUser);
    }


    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    
    public void deleteUser(Integer idUser)  {
        userRepository.deleteById(idUser);
    }

}
