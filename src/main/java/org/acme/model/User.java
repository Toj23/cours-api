package org.acme.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;


@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity{
    public String username;
    public String password;
    public String role; // Soit admin ou Student 
    
    public static User findByUsername(String username){
        return find("username", username).firstResult();
    }
}
