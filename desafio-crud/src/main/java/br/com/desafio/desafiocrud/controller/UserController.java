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

import br.com.desafio.desafiocrud.dto.UserDTO;
import br.com.desafio.desafiocrud.model.User;
import br.com.desafio.desafiocrud.regraNegocio.RNUserCadastro;
import br.com.desafio.desafiocrud.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.findUsers();
    }

    @GetMapping("{idUser}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Integer idUser) {

          Optional<User> user = userService.findUser(idUser);
        if (user.isPresent()) {
           
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }        
    }

    /**
     * salva o User na base
     * 
     * @param userDTO
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        return userService.saveUser(user);

    }

    @PutMapping("{idUser}")
    public ResponseEntity<User> updateUser(@Validated  @PathVariable Integer idUser, @RequestBody UserDTO userDTO) {

        Optional<User> user = userService.findUser(idUser);

          if (user.isPresent()) {            
            user.get().setFirstName(userDTO.getFirstName());
            user.get().setBirthday(null);

            RNUserCadastro.getInstance().validate(user);

            return new ResponseEntity<>(userService.saveUser(user.get()), HttpStatus.OK);

        } else {
            return ResponseEntity.notFound().build();
        }
         
    }

    @DeleteMapping("{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer idUser) {
        Optional<User> user = userService.findUser(idUser);
        if (user.isPresent()) {
            userService.deleteUser(idUser);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
