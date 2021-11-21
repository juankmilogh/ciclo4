/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.ciclo4.Services;

import com.ciclo4.ciclo4.Model.User;
import com.ciclo4.ciclo4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class UserService {
    
      @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public Optional<User> getOneUser(int id) {
        return userRepository.getOneUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (comprobarEmail(user.getEmail()) == false) {
                return userRepository.saveUser(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean comprobarEmail(String email) {
        return userRepository.comprobarEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
