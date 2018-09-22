package by.home.dartlen.dindindon.list;

import androidx.room.Entity;

@Entity
public class Person {



    private String token;
    private String name;
//    private double longitude;
//    private double latitude;





    public Person() {
    }

    public Person(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
