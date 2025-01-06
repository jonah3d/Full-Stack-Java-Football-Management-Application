package org.joe.gestion.model.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code User} representa a un usuario con derechos para gestionar
 * equipos o jugadores en esta aplicación.
 * <p>
 * Esta clase contiene información básica del usuario, como su nombre de usuario
 * y contraseña, y proporciona métodos para acceder y modificar estos atributos.
 * </p>
 *
 * @author Jonathan Arthur
 * @version 1.0
 * @since 2025-01-01
 */
public class User {

    private String username;
    private String password;

    /**
     * Constructor de la clase {@code User} que inicializa un nuevo usuario con
     * un nombre de usuario y una contraseña.
     *
     * @param username el nombre de usuario del usuario.
     * @param password la contraseña del usuario.
     */
    public User(String username, String password) {
        setPassword(password);
        setUsername(username);
    }

    /**
     * Devuelve el nombre de usuario del usuario.
     *
     * @return el nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param username el nuevo nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * <p>
     * La contraseña debe cumplir con los siguientes criterios:
     * </p>
     * <ul>
     * <li>Debe contener al menos una letra mayúscula.</li>
     * <li>Debe contener al menos un número.</li>
     * <li>Debe contener al menos un carácter especial.</li>
     * <li>Debe tener entre 8 y 20 caracteres.</li>
     * <li>No puede contener espacios.</li>
     * </ul>
     *
     * @param password la nueva contraseña del usuario.
     * @throws RuntimeException si la contraseña no cumple con los requisitos.
     */
    public void setPassword(String password) {
        String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            this.password = password;
        } else {
            throw new RuntimeException("La contraseña debe contener al menos una letra mayúscula, un número, y un carácter especial.");
        }
    }
}
