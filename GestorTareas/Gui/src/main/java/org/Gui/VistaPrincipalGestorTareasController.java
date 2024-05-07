package org.Gui;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.BasesDatos.Tarea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaServicio;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaDAOImpl;



public class VistaPrincipalGestorTareasController extends BaseControlador implements  ControladorConStage {
        int usuarioId = Sesion.getInstance().getResultadoInicioSesion();
        TareaDAO tareaDAO = new TareaDAOImpl(); 
        TareaServicio tareaServicio = new TareaServicio(tareaDAO);
        TareaDAOImpl TareaDaoImp = new TareaDAOImpl();
        private Stage stage;
        private String currentFxmlPath;
        private Stage currentStage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
        @FXML
    private Menu menuFile;
    @FXML
    private Menu menuEdit;
    @FXML
    private Menu menuView;
    @FXML
    private Menu menuHelp;
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


    public void initialize() {

        
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_limite"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));




        cargarDatosEnTabla();
        configurarManejadoresEventos();
        
        tablaTareas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue != null) {
        System.out.println("ID de la tarea seleccionada: " + newValue.getId());
        Sesion.getInstance().setIdTarea(newValue.getId());
    }
});

    }
    
private void cargarDatosEnTabla() {
    ObservableList<Tarea> tareasParaVista = tareaServicio.obtenerTareasParaVista(usuarioId);
    System.out.println("Cargando tareas en la tabla...");
    tareasParaVista.forEach(tarea -> System.out.println("Tarea ID: " + tarea.getId()));
    tablaTareas.setItems(tareasParaVista);
}
public void cambiarIdioma(ActionEvent event) {
    if (Sesion.getInstance().getIdioma().equals("Español")) {
        Sesion.getInstance().setIdioma("Ingles");
    } else {
        Sesion.getInstance().setIdioma("Español");
    }
    
    actualizarTextos();
}

private void actualizarTextos() {
    mainApp.cargarVista("/org/Gui/vistaTareas.fxml", stage);
}



    private void configurarManejadoresEventos() {
        botonAgregarTarea.setOnAction(event -> {
               mostrarAgregarTarea();
               tablaTareas.getSelectionModel().clearSelection();
               tablaTareas.refresh();
               cargarDatosEnTabla();

        });
        
        botonEditarTarea.setOnAction(event -> {
            mostrarEditarTarea();
            tablaTareas.getSelectionModel().clearSelection();
            tablaTareas.refresh();
            cargarDatosEnTabla();

        });

        botonEliminarTarea.setOnAction(event -> {
            mostrarDialogoEliminar();
            tablaTareas.getSelectionModel().clearSelection();
            tablaTareas.refresh();
            cargarDatosEnTabla();

        });
    }
    // Método para configurar la localización y el idioma
    
private void configurarLocalizacion() {
    Locale idiomaLocalizacion = null;
    try {
        if (Sesion.getInstance().getIdioma().equals("Español")) {
            idiomaLocalizacion = new Locale("es", "ES");
        } else {
            idiomaLocalizacion = new Locale("en", "US");
        }
        if (idiomaLocalizacion == null) {
            throw new RuntimeException("Locale no establecido correctamente");
        }
        bundle = ResourceBundle.getBundle("org.Gui.MessagesBundle", idiomaLocalizacion);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error al cargar los recursos de localización", e);
    }
}
private ResourceBundle bundle;

    @FXML
private void mostrarAgregarTarea() {
    configurarLocalizacion(); // Llama al método de configuración del idioma y la localización
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("agregarTarea.fxml"), bundle);
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle(bundle.getString("tituloAgregarTarea")); // Usa el bundle para obtener el título
        stage.setScene(new Scene(root));
        stage.showAndWait();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML
private void mostrarEditarTarea() {
    configurarLocalizacion(); // Llama al método de configuración del idioma y la localización
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editarTarea.fxml"), bundle);
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle(bundle.getString("tituloEditarTarea")); // Usa el bundle para obtener el título
        stage.setScene(new Scene(root));
        stage.showAndWait();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML
private void mostrarDialogoEliminar() {
    configurarLocalizacion(); // Llama al método de configuración del idioma y la localización
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmacionEliminarDialogo.fxml"), bundle);
        Parent root = loader.load();

        ConfirmacionEliminarDialogoController dialogoController = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(bundle.getString("tituloConfirmarEliminacion")); // Usa el bundle para obtener el título
        stage.setScene(new Scene(root));
        stage.showAndWait();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Método para configurar la localización y el idioma








}
