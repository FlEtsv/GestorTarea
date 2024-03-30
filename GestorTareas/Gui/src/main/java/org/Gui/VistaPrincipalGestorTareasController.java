package org.Gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.BasesDatos.Tarea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaServicio;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaDAOImpl;



public class VistaPrincipalGestorTareasController extends BaseControlador implements  ControladorConStage {
        int usuarioId = SesionUsuario.getInstance().getResultadoInicioSesion();
        TareaDAO tareaDAO = new TareaDAOImpl(); 
        TareaServicio tareaServicio = new TareaServicio(tareaDAO);
private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private TableView<Tarea> tablaTareas;

    @FXML
    private TableColumn<Tarea, String> columnaTitulo;

    @FXML
    private TableColumn<Tarea, String> columnaEstado;

    @FXML
    private TableColumn<Tarea, String> columnaFechaVencimiento;
    
    @FXML
    private TableColumn<Tarea, String> columnaDescripcion;

    @FXML
    private Button botonAgregarTarea;

    @FXML
    private Button botonEditarTarea;

    @FXML
    private Button botonEliminarTarea;

    // Añadir cualquier otro componente FXML que necesites manejar

    public void initialize() {
        // Configura las columnas de la tabla
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_limite"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));




        cargarDatosEnTabla();
        configurarManejadoresEventos();
    }
    
    private void cargarDatosEnTabla() {
        ObservableList<Tarea> tareasParaVista = tareaServicio.obtenerTareasParaVista(usuarioId);
        tablaTareas.setItems(tareasParaVista);
    }

    private void configurarManejadoresEventos() {
        botonAgregarTarea.setOnAction(event -> {
               mostrarAgregarTarea();
        });
        
        botonEditarTarea.setOnAction(event -> {
            // Código para editar tarea seleccionada
        });

        botonEliminarTarea.setOnAction(event -> {
            // Código para eliminar tarea seleccionada
        });
    }
    @FXML
private void mostrarAgregarTarea() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("agregarTarea.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Agregar Tarea");
        stage.setScene(new Scene(root));
        stage.show();
        
    } catch (Exception e) {
        e.printStackTrace();
        // Manejar el error
    }
}





}
