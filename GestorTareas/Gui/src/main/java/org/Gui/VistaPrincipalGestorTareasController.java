package org.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.BasesDatos.Tarea;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaDAOImpl;
import org.BasesDatos.TareaServicio;

public class VistaPrincipalGestorTareasController {
    @FXML private TableView<Tarea> tablaTareas;
    @FXML private Button botonAgregarTarea;
    @FXML private Button botonEditarTarea;
    @FXML private Button botonEliminarTarea;
    @FXML private TableColumn<Tarea, String> columnaTitulo;
    @FXML private TableColumn<Tarea, String> columnaEstado;
    @FXML private TableColumn<Tarea, String> columnaFechaVencimiento;

    private TareaServicio datos;
    private int usuarioId;

    public void initialize() {
        usuarioId = SesionUsuario.getInstance().getResultadoInicioSesion();
        TareaDAO tareaDao = new TareaDAOImpl();
        datos = new TareaServicio(tareaDao);
        
        tablaTareas.setItems(datos.obtenerTareasParaVista(usuarioId));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));
        
        // Aquí puedes añadir cualquier lógica de inicialización adicional
    }
    
    // Aquí puedes añadir métodos para manejar acciones de los botones, etc.
}
