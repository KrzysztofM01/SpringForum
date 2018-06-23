package com.example.insane.firstforumAnother.models.forms;

import lombok.Data;

@Data
public class MessageForm {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
