package com.example.hieu.service;

import com.example.hieu.entity.User;
import com.example.hieu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
//    private final UserRepository userRepository;

    public User createUser(User user) {
        User userNew = new User();

        try {
            if (userRepository.findAllByUserName(user.getUserName()) != null) {
                return new User();
            }
            userNew.setUserName(user.getUserName());
            userNew.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
            userNew.setFullName(user.getFullName());
            userNew.setInfo(user.getInfo());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userRepository.save(userNew);
    }
}
