package dev.boca.ejercicio3;

import android.app.Application;

//Esta clase sirve (por ahora) para obtener el valor del switch en el profile
public class MyApplication extends Application {

    private boolean switchValue = false;

    public boolean getSwitchValue() {
        return switchValue;
    }

    public void setSwitchValue(boolean value) {
        switchValue = value;
    }
}
