package br.com.desafio.desafiocrud.dto;

import java.sql.Date;
import java.util.List;

import br.com.desafio.desafiocrud.model.Car;

public class UserDTO {

    private Integer idUser;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String login;
    private String password;
    private String phone;
    private List<Car> cars;

    public UserDTO(Integer idUser, String firstName, String lastName, String email, Date birthday, String login,
            String password, String phone, List<Car> cars) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phone = phone;

        this.email = email;
        this.login = login;
        this.password = password;
        this.cars = cars;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public List<Car> getCars() {
        return cars;
    }


    
}