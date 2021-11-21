/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.ciclo4.Repository;

import com.ciclo4.ciclo4.CrudRepository.UserCrudRepository;
import com.ciclo4.ciclo4.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;

    // METODO PARA OBTENER TODOS LOS USUARIOS
    public List<User> getAllUser() {
        return (List<User>) userCrudRepository.findAll();
    }

    // METODO PARA OBTENER UN USUARIO
    public Optional<User> getOneUser(int id) {
        return userCrudRepository.findById(id);
    }

    // METODO PARA GUARDAR EL USUARIO
    public User saveUser(User user) {
        return userCrudRepository.save(user);
    }

    //METODO PARA COMPROBAR SI UN EMAIL YA EXISTE
    public boolean comprobarEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    // METODO PARA AUTENTICAR EL USUARIO
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
