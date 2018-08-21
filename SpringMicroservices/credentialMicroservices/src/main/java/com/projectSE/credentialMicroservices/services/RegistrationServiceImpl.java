package com.projectSE.credentialMicroservices.services;

import com.projectSE.credentialMicroservices.daos.UserDao;
import com.projectSE.credentialMicroservices.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}";

    @Autowired
    UserDao userDao;

    @Override
    public boolean controlPatternPassword(String password) {
        if (password.length() >= 6 && password.length() <= 20 && password.matches(pattern) == true){
            return true;
        }
        return false;
    }

    @Override
    public void saveUser(String name, String surname, String email, String password, int type, int id_course_of_study) {
        userDao.save(new User(name, surname, email, password, type, id_course_of_study));
    }

    @Override
    public String createEmail(String name, String surname) {
        String email;
        List<User> users = userDao.findByNameAndSurname(name, surname);
        if(users.size()>0) {
            email = name.toLowerCase()+"."+surname.toLowerCase()+users.size()+"@studenti.unisalento.it";
        }
        else {
            email = name.toLowerCase()+"."+surname.toLowerCase()+"@studenti.unisalento.it";
        }
        return email;
    }
}
