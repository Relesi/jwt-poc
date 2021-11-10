package com.relesi.jwt.services;

import com.relesi.jwt.domain.User;
import com.relesi.jwt.exceptions.ObjectNotFoundException;
import com.relesi.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;


    private Random rand = new Random();

    public void sendNewPassword(String email) {
        User user =  userRepository.findByEmail(email);
        if (user == null) {
            throw new ObjectNotFoundException("email not found");
        }

        String newPasswordReset = newPassword();
        user.setPassword(bCryptPasswordEncoder.encode(newPasswordReset));

        userRepository.save(user);
        emailService.sendNewPasswordEmail(user, newPasswordReset);

    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // generates a digit
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) { // generates capital letter
            return (char) (rand.nextInt(26) + 65);
        } else { // generates lowercase
            return (char) (rand.nextInt(26) + 97);
        }
    }

}
