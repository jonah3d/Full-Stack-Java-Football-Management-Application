
package org.joe.gestion.model.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        setPassword(password);
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

   public void setPassword(String password) {
    String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
    Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);   
    Matcher matcher = pattern.matcher(password);
   
    if (matcher.find()) {
        this.password = password;
    } else {
        throw new RuntimeException("Password must contain at least one capital letter, one number (not in sequence), and one special character.");
    }
}

   
}
