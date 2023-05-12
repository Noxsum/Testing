package dev.boca.ejercicio3;

//Esta clase sirve para obtener el contenido del email en el login y usarlo en otras clases
public class GlobalVariables {
    private static GlobalVariables instance;
    private String userEmail;

    private GlobalVariables() {}

    public static synchronized GlobalVariables getInstance() {
        if (instance == null) {
            instance = new GlobalVariables();
        }
        return instance;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
