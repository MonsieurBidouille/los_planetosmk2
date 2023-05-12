package main;

import java.io.FileNotFoundException;

public final class Singleton {
    private static Logmachine instance = null;

    private Singleton() {
    }

    public static Logmachine getInstance() throws FileNotFoundException {
        if ( instance == null ) {
            instance = new Logmachine();
        }
        return instance;
    }
}