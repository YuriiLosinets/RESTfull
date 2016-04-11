package com.test.test3.database;

import com.test.test3.model.Message;
import com.test.test3.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CMI-USER on 2/10/2016.
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String , Profile> getProfiles() {
        return profiles;
    }
}
