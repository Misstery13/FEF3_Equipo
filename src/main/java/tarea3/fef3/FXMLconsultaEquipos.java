package tarea3.fef3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Collectors;

public class FXMLconsultaEquipos
{
    @javafx.fxml.FXML
    private TableColumn colET_Nombres;
    @javafx.fxml.FXML
    private TableView tablaJugadores;
    @javafx.fxml.FXML
    private TableColumn colD_CI;
    @javafx.fxml.FXML
    private TableColumn colJ_Peso;
    @javafx.fxml.FXML
    private TableColumn colJ_Edad;
    @javafx.fxml.FXML
    private TableColumn colU_Ocupacion;
    @javafx.fxml.FXML
    private TableView tablaDirectivos;
    @javafx.fxml.FXML
    private TableColumn colET_Nacionalidad;
    @javafx.fxml.FXML
    private ComboBox cbo_equipos;
    @javafx.fxml.FXML
    private TableColumn colET_CI;
    @javafx.fxml.FXML
    private TableColumn colD_Cargo;
    @javafx.fxml.FXML
    private TableColumn colET_Cargo;
    @javafx.fxml.FXML
    private TabPane tabPaneDatos;
    @javafx.fxml.FXML
    private TableView tablaEquipoTecnico;
    @javafx.fxml.FXML
    private TableView tablaUtileria;
    @javafx.fxml.FXML
    private TableColumn colJ_Nombres;
    @javafx.fxml.FXML
    private TableColumn colJ_CI;
    @javafx.fxml.FXML
    private TableColumn colU_CI;
    @javafx.fxml.FXML
    private TableColumn colD_Nombres;
    @javafx.fxml.FXML
    private TableColumn colJ_Posicion;
    @javafx.fxml.FXML
    private TableColumn colU_Nombres;

    @javafx.fxml.FXML
    public void initialize() {
        colJ_CI.setCellValueFactory(new PropertyValueFactory<>("ci"));
        colJ_Nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colJ_Posicion.setCellValueFactory(new PropertyValueFactory<>("posicion"));
        colJ_Edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colJ_Peso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        // Configurar columnas UTILERÍA
        colU_CI.setCellValueFactory(new PropertyValueFactory<>("ci"));
        colU_Nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colU_Ocupacion.setCellValueFactory(new PropertyValueFactory<>("ocupacion"));

        // Configurar columnas DIRECTIVOS
        colD_CI.setCellValueFactory(new PropertyValueFactory<>("ci"));
        colD_Nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colD_Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        // Configurar columnas EQUIPO TÉCNICO
        colET_CI.setCellValueFactory(new PropertyValueFactory<>("ci"));
        colET_Nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colET_Nacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        colET_Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        // Llenar ComboBox con nombres de equipos
        cbo_equipos.setItems(FXCollections.observableArrayList(
                BD.equipos.stream().filter(equipo -> "Activo".equals(equipo.getEstado())).map(Equipo::getNombreEq).collect(Collectors.toList())
        ));
    }

    @javafx.fxml.FXML
    public void acc_cboEquipoSeleccionado(ActionEvent actionEvent) {
        String equipoSeleccionado = (String) this.cbo_equipos.getValue();
        if (equipoSeleccionado != null) {
            // Filtrar y cargar JUGADORES
            ObservableList<Jugadores> listaJugadores = FXCollections.observableArrayList(
                    BD.jugadores.stream()
                            .filter(j -> j.getEquipo().equals(equipoSeleccionado))
                            .collect(Collectors.toList())
            );
            tablaJugadores.setItems(listaJugadores);

            // Filtrar y cargar UTILERÍA
            ObservableList<Personal> listaUtileria = FXCollections.observableArrayList(
                    BD.personal.stream()
                            .filter(u -> u.getEquipo().equals(equipoSeleccionado))
                            .collect(Collectors.toList())
            );
            tablaUtileria.setItems(listaUtileria);

            // Filtrar y cargar DIRECTIVOS
            ObservableList<Directivo> listaDirectivos = FXCollections.observableArrayList(
                    BD.directivos.stream()
                            .filter(d -> d.getEquipo().equals(equipoSeleccionado))
                            .collect(Collectors.toList())
            );
            tablaDirectivos.setItems(listaDirectivos);

            // Filtrar y cargar EQUIPO TÉCNICO
            ObservableList<EquipoTec> listaTecnicos = FXCollections.observableArrayList(
                    BD.equipoTec.stream()
                            .filter(et -> et.getEquipo().equals(equipoSeleccionado))
                            .collect(Collectors.toList())
            );
            tablaEquipoTecnico.setItems(listaTecnicos);
        }
    }
    }
