package tarea3.fef3;

import javafx.event.ActionEvent;
import javafx.scene.control.Tooltip;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FXMLregistrojugadores {

    @javafx.fxml.FXML
    private TextField txtPeso;
    @javafx.fxml.FXML
    private TableColumn colCI;
    @javafx.fxml.FXML
    private TableView tablaJugadores;
    @javafx.fxml.FXML
    private TableColumn colEdad;
    @javafx.fxml.FXML
    private ImageView btn_eliminar;
    @javafx.fxml.FXML
    private TextField txtEdad;
    @javafx.fxml.FXML
    private TextField txtCI;
    @javafx.fxml.FXML
    private ImageView btn_guardar;
    @javafx.fxml.FXML
    private TableColumn colPosicion;
    @javafx.fxml.FXML
    private TableColumn colNombres;
    @javafx.fxml.FXML
    private TextField txtNombres;
    @javafx.fxml.FXML
    private TableColumn colPeso;
    @javafx.fxml.FXML
    private TextField txtPosicion;
    @javafx.fxml.FXML
    private ComboBox cbo_equipolist;

    @javafx.fxml.FXML
    public void initialize() {
        Tooltip tooltipGuardar = new Tooltip("Guardar");
        Tooltip.install(btn_guardar, tooltipGuardar);
        Tooltip tooltipEliminar = new Tooltip("Eliminar");
        Tooltip.install(btn_eliminar, tooltipEliminar);
    }

    @javafx.fxml.FXML
    public void acc_btnguardar(Event event) {

    }

    @javafx.fxml.FXML
    public void acc_btneliminar(Event event) {

    }

    @javafx.fxml.FXML
    public void acc_cboequipo(ActionEvent actionEvent) {

    }
}
