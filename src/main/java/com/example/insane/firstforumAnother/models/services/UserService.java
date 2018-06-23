package com.example.insane.firstforumAnother.models.services;

import com.example.insane.firstforumAnother.models.UserEntity;
import com.example.insane.firstforumAnother.models.forms.LoginForm;
import com.example.insane.firstforumAnother.models.forms.RegisterForm;
import com.example.insane.firstforumAnother.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class UserService {

    @Autowired
    UserRepository userRepository;
    private UserEntity userEntity;
    private boolean isLogin;

    public boolean registerUser(RegisterForm registerForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(registerForm.getLogin());
        userEntity.setPassword(registerForm.getPassword());
        userRepository.save(userEntity);
        // boolean return for future if we plan to add try to catch db exceptions or sth
        return true;
    }

    public boolean isUserExistByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public boolean loginUser(LoginForm loginForm) {
        Optional<UserEntity> userEntity = userRepository.findFirstByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword());
        if (userEntity.isPresent()) {
            isLogin = true;
            this.userEntity = userEntity.get();
        }
       return userEntity.isPresent();
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
