package org.app;

import static javafx.application.Application.launch;
import javafx.stage.Stage;
import org.BasesDatos.CrearBaseDatos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CrearBaseDatos crear = new CrearBaseDatos();
    	crear.Crear();
        launch(args);
    	
    }
}
