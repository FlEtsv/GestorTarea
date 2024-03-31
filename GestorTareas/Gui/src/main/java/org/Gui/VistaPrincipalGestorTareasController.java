package org.Gui;

import java.io.IOException;
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
    @FXML
private void mostrarAgregarTarea() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("agregarTarea.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Agregar Tarea");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        
    } catch (Exception e) {
        e.printStackTrace();

    }
}
    @FXML
private void mostrarEditarTarea() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editarTarea.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Modificar Tarea");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        
    } catch (Exception e) {
        e.printStackTrace();

    }
}
@FXML
private void mostrarDialogoEliminar() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmacionEliminarDialogo.fxml"));
        Parent root = loader.load();

        ConfirmacionEliminarDialogoController dialogoController = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Confirmar Eliminación");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    } catch (IOException e) {
        e.printStackTrace();
    }
}






}
