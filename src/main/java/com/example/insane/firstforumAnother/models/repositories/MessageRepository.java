package com.example.insane.firstforumAnother.models.repositories;

import com.example.insane.firstforumAnother.models.MessageEntity;
import com.example.insane.firstforumAnother.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {

}
