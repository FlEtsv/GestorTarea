package org.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.BasesDatos.Tarea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class VistaPrincipalGestorTareasController extends BaseControlador implements  ControladorConStage {
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
        columnaFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));

 
        cargarDatosEnTabla();
        configurarManejadoresEventos();
    }
    
    private void cargarDatosEnTabla() {
        // Aquí debería cargar los datos en tu TableView. Por ejemplo, si tengo una lista de tareas:
        // tablaTareas.setItems(tuListaDeTareas);
    }

    private void configurarManejadoresEventos() {
        botonAgregarTarea.setOnAction(event -> {
            // Código para agregar tarea
        });
        
        botonEditarTarea.setOnAction(event -> {
            // Código para editar tarea seleccionada
        });

        botonEliminarTarea.setOnAction(event -> {
            // Código para eliminar tarea seleccionada
        });
    }




}
