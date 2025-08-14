package tarea3.fef3;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.stream.Collectors;

import static tarea3.fef3.BD.personal;

public class FXMLregistropersonal {
    @javafx.fxml.FXML
    private TableColumn colCI;
    @javafx.fxml.FXML
    private ImageView btn_guardar;
    @javafx.fxml.FXML
    private ImageView btn_eliminar;
    @javafx.fxml.FXML
    private TableView tablaUtileria;
    @javafx.fxml.FXML
    private TableColumn colEquipo;
    @javafx.fxml.FXML
    private ComboBox cbo_equipolist;
    @javafx.fxml.FXML
    private TableColumn colNombres;
    @javafx.fxml.FXML
    private TextField txtNombres;
    @javafx.fxml.FXML
    private TextField txtCI;
    @javafx.fxml.FXML
    private TextField txtOcupacion;
    @javafx.fxml.FXML
    private TableColumn colOcupacion;
    @javafx.fxml.FXML
    private CheckBox check_ced;

    @javafx.fxml.FXML
    public void initialize() {
        cbo_equipolist.getItems().clear();
        cbo_equipolist.getItems().addAll(
                BD.equipos.stream()
                        .filter(equipo -> "Activo".equals(equipo.getEstado()))
                        .map(equipo -> equipo.getNombreEq()) // Ajusta el método según tu clase Equipo
                        .collect(Collectors.toList()));
        colEquipo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("equipo"));
        colCI.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("ci"));
        colNombres.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombres"));
        colOcupacion.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("ocupacion"));
        cargarPersonalEnTabla();
    }

    private void cargarPersonalEnTabla() {
        tablaUtileria.getItems().clear();
        tablaUtileria.getItems().addAll(personal);
    }

    @javafx.fxml.FXML
    public void acc_cboequipo(ActionEvent actionEvent) {
        try {
            if (this.cbo_equipolist.getValue() == null) {
                ModGeneral.fun_mensajeInformacion("Debe seleccionar un equipo");
                this.cbo_equipolist.requestFocus();
            } else {
                String equipo = (String) this.cbo_equipolist.getValue();
                tablaUtileria.getItems().setAll(
                        BD.personal.stream()
                                .filter(p -> p.getEquipo().equals(equipo))
                                .collect(Collectors.toList()));
            }
        } catch (Exception e) {
            ModGeneral.fun_mensajeError(e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void acc_btnguardar(Event event) {
        try {
            if (fun_validar()) {
                String nombres = this.txtNombres.getText();
                String ci = this.txtCI.getText();
                String ocupacion = this.txtOcupacion.getText();
                String equipo = (String) this.cbo_equipolist.getValue();

                Personal objPersonal = new Personal(ci, nombres, ocupacion, equipo);
                personal.add(objPersonal);
                ModGeneral.fun_mensajeInformacion("Se registro con exito");
                cargarPersonalEnTabla();
            } else {
                fun_validar();
            }
        } catch (Exception e) {
            ModGeneral.fun_mensajeError(e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void acc_btneliminar(Event event) {
        txtNombres.clear();
        txtCI.clear();
        txtOcupacion.clear();
        cbo_equipolist.getSelectionModel().clearSelection();
    }

    private boolean fun_validar() {
        try {
            if (this.txtNombres.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Nombres no puede estar vacio");
                this.txtNombres.requestFocus();
                return false;
            }
            if (this.txtCI.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Cedula no puede estar vacio");
                this.txtCI.requestFocus();
                return false;
            }
            if (this.txtOcupacion.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Ocupacion no puede estar vacio");
                this.txtOcupacion.requestFocus();
                return false;
            }
            if (this.cbo_equipolist.getValue() == null) {
                ModGeneral.fun_mensajeInformacion("Debe seleccionar un equipo");
                this.cbo_equipolist.requestFocus();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarCedula() {
        String cedula = this.txtCI.getText();
        if (cedula == null || cedula.length() != 10) {
            ModGeneral.fun_mensajeInformacion("La cédula debe tener 10 dígitos.");
            return false;
        }
        int region = Integer.parseInt(cedula.substring(0, 2));
        if (!((region >= 1 && region <= 24) || region == 30)) { //01 al 24 son las provincias | 30 es para ciudadanos que viven en el exterior
            ModGeneral.fun_mensajeInformacion("La cédula debe pertenecer a una región válida (01-24 o 30).");
            return false;
        }
        int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));
        int pares = Integer.parseInt(cedula.substring(1, 2))
                + Integer.parseInt(cedula.substring(3, 4))
                + Integer.parseInt(cedula.substring(5, 6))
                + Integer.parseInt(cedula.substring(7, 8));

        int[] impares = new int[5];
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(cedula.substring(i * 2, i * 2 + 1)) * 2;
            if (num > 9) num -= 9;
            impares[i] = num;
        }
        int sumaTotal = pares + impares[0] + impares[1] + impares[2] + impares[3] + impares[4];
        int decena = ((sumaTotal / 10) + 1) * 10;
        int digitoValidador = decena - sumaTotal;
        if (digitoValidador == 10) digitoValidador = 0;
        return digitoValidador == ultimoDigito;
    }

    @javafx.fxml.FXML
    public void acc_checkced(ActionEvent actionEvent) {
        if (check_ced.isSelected()) {
            this.txtCI.setDisable(false);
            if (validarCedula()) {
                ModGeneral.fun_mensajeInformacion("Cédula válida.");
            } else {
                ModGeneral.fun_mensajeInformacion("Cédula inválida.");
            }
        } else {
//            this.txtCI.setDisable(true);
//            this.txtCI.clear();
        }
    }
}
