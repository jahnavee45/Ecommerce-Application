package com.project.ecommerce.services;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return null;
    }

    public User findByEmail(String email) {
        Optional<User> getUser = Optional.ofNullable(userRepository.findByEmail(email));

        User user = null;
        if(getUser.isPresent()){
            user = getUser.get();
        }else{
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public void deleteById(Long id) {

    }

    public boolean authenticate(String email, String password) {
        Optional<User> opUser = Optional.ofNullable(userRepository.findByEmail(email));
        if(opUser.isPresent()) {
            User user = opUser.get();
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }
}
