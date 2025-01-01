package org.joe.gestion.model.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La {@code User} clase representa la la persona/usuario con el derecho a
 * gestionar equipos o jugadores con este aplicación
 *
 * @author Jonathan Arthur
 * @version 1.0
 * @since 2025-01-01
 */
public class User {

    private String username;
    private String password;

    /**
     * Constructor del clase que acepta dos paramateros
     *
     * @param username
     * @param password
     *
     */
    public User(String username, String password) {
        setPassword(password);
        setUsername(username);
    }

    /**
     * Metodo
     *
     * @return username
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            this.password = password;
        } else {
            throw new RuntimeException("Password must contain at least one capital letter, one number (not in sequence), and one special character.");
        }
    }

}
