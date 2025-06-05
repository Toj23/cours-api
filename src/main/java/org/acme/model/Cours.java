package org.acme.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "cours")
public class Cours extends PanacheMongoEntity{
    public String titre;
    public String description;
    public String professeur;


    public static Cours findByTitre(String titre){
        return find("titre", titre).firstResult();
    }
    
}
