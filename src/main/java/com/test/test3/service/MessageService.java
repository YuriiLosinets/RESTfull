package com.test.test3.service;

import com.test.test3.database.DatabaseClass;
import com.test.test3.exception.DataNotFoundException;
import com.test.test3.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by CMI-USER on 2/10/2016.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();


    public MessageService() {
        messages.put(1L, new Message(1,"Hello World!", "Yurii"));
        messages.put(2L, new Message(2,"Hello Jersey!", "Yurii"));
    }

    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : messages.values()){
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
            }
        }

        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        List<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) return new ArrayList<Message>();
        return list.subList(start, start + size);
    }


    public Message getMessage(long id){
        Message message =  messages.get(id);
        if (message == null)
            throw new DataNotFoundException("Message with id " + id + " not found");
        return message;
    }

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return  message;
    }

    public Message updateMessage(Message message){
        if (message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
