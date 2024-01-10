package com.example.restapp.service;

import com.example.restapp.domain.User;
import com.example.restapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı id : " + id));
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateHastaliklar(Long userId, String hastalik) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        List<String> newHastaliklar = user.hastaliklar;
        newHastaliklar.add(hastalik);
        user.setHastaliklar(newHastaliklar);
        return userRepository.save(user);
    }

    public User updateIlaclar(Long userId, String ilac) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        List<String> newHastaliklar = user.ilaclar;
        newHastaliklar.add(ilac);
        user.setHastaliklar(newHastaliklar);
        return userRepository.save(user);
    }

    public User updateTahliller(Long userId, String tahlil) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        List<String> newHastaliklar = user.tahliller;
        newHastaliklar.add(tahlil);
        user.setHastaliklar(newHastaliklar);
        return userRepository.save(user);
    }
}
