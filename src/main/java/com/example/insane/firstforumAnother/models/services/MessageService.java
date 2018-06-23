package com.example.insane.firstforumAnother.models.services;

import com.example.insane.firstforumAnother.models.MessageEntity;
import com.example.insane.firstforumAnother.models.UserEntity;
import com.example.insane.firstforumAnother.models.forms.LoginForm;
import com.example.insane.firstforumAnother.models.forms.MessageForm;
import com.example.insane.firstforumAnother.models.forms.RegisterForm;
import com.example.insane.firstforumAnother.models.repositories.MessageRepository;
import com.example.insane.firstforumAnother.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    List<MessageEntity> messageList = new ArrayList<MessageEntity>();

    public void saveMessage(int userId, MessageForm messageForm) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setUserId(userId);
        messageEntity.setTitle(messageForm.getTitle());
        messageEntity.setContent(messageForm.getContent());
        messageRepository.save(messageEntity);
    }

    public void loadMessagesToList() {
        messageList.clear();
        messageRepository.findAll().forEach(s -> messageList.add(s));
    }

    public List<MessageEntity> getMessageList() {
        return messageList;
    }
}
