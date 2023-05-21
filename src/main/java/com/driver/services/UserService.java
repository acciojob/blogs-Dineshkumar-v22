package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(User user){
        try{
            userRepository3.save(user);
        }
        catch (Exception e){}

    }

    public void deleteUser(int userId){
        try{
            userRepository3.deleteById(userId);
        }
        catch (Exception e){}
    }

    public void updateUser(User user){
        try{
            userRepository3.save(user);
        }
        catch (Exception e){}

    }

    public User findUserByUsername(String username){

        try{
            return userRepository3.findByUsername(username);
        }
        catch (Exception e){ return null;}

    }
}
