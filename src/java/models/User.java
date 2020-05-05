package models;

/**
 *
 * @author Walter
 */
public class User {
    String username;
    int id;
    
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public User(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", id=" + id + '}';
    }

   
    
    
}

