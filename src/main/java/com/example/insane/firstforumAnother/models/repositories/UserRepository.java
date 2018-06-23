package com.example.insane.firstforumAnother.models.repositories;

import com.example.insane.firstforumAnother.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    boolean existsByLogin(String login);

    Optional<UserEntity> findFirstByLoginAndPassword (String login, String password);

}
