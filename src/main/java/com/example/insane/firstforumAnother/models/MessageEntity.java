package com.example.insane.firstforumAnother.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tmessage")
@Data
public class MessageEntity {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_id")
    private int userId;
    private Timestamp date;
    private String title;
    @Column(name = "text")
    private String content;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
