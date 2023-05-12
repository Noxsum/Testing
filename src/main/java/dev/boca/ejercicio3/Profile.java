package dev.boca.ejercicio3;

public class Profile {
    private static String name = "Paco";
    private static String surname = "Perez Avellán";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Profile.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        Profile.surname = surname;
    }
}
