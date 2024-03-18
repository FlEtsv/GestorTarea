package org.app;


import javafx.application.Application;
import javafx.application.Platform;
import org.BasesDatos.CrearBaseDatos;
import org.Gui.MainApp;


public class App {
    public static void main( String[] args )
    {
    	CrearBaseDatos crear = new CrearBaseDatos();
    	crear.Crear();
                // Ahora inicia la aplicación JavaFX
        Platform.startup(() -> {
        });

        // Después de la inicialización, lanza la UI principal
        Application.launch(MainApp.class, args);
}
}
