package tarea3.fef3;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.stream.Collectors;

public class FXMLregistroequipotec {
    @javafx.fxml.FXML
    private TableColumn colCI;
    @javafx.fxml.FXML
    private TableColumn colNacionalidad;
    @javafx.fxml.FXML
    private TextField txtCargo;
    @javafx.fxml.FXML
    private ImageView btn_eliminar;
    @javafx.fxml.FXML
    private ComboBox cbo_equipolist;
    @javafx.fxml.FXML
    private TextField txtNacionalidad;
    @javafx.fxml.FXML
    private TextField txtCI;
    @javafx.fxml.FXML
    private TableColumn colCargo;
    @javafx.fxml.FXML
    private ImageView btn_guardar;
    @javafx.fxml.FXML
    private TableView tablaEquipoTecnico;
    @javafx.fxml.FXML
    private TableColumn colEquipo;
    @javafx.fxml.FXML
    private TableColumn colNombres;
    @javafx.fxml.FXML
    private TextField txtNombres;
    @javafx.fxml.FXML
    private CheckBox check_ced;

    @javafx.fxml.FXML
    public void initialize() {
        cbo_equipolist.getItems().clear();
        cbo_equipolist.getItems().addAll(
                BD.equipos.stream()
                        .filter(equipo -> "Activo".equals(equipo.getEstado()))
                        .map(equipo -> equipo.getNombreEq())
                        .collect(Collectors.toList()));
        colEquipo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("equipo"));
        colCI.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("ci"));
        colNombres.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombres"));
        colCargo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cargo"));
        colNacionalidad.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nacionalidad"));
        cargarEquipoTecnicoEnTabla();
    }

    private void cargarEquipoTecnicoEnTabla() {
        tablaEquipoTecnico.getItems().clear();
        tablaEquipoTecnico.getItems().addAll(BD.equipoTec);
    }

    @javafx.fxml.FXML
    public void acc_cboequipo(ActionEvent actionEvent) {
        try {
            if (cbo_equipolist.getValue() == null) {
                ModGeneral.fun_mensajeInformacion("Debe seleccionar un equipo");
                cbo_equipolist.requestFocus();
            } else {
                String equipo = (String) this.cbo_equipolist.getValue();
                tablaEquipoTecnico.getItems().setAll(
                        BD.equipoTec.stream()
                                .filter(et -> et.getEquipo().equals(equipo))
                                .collect(Collectors.toList())
                );
            }
        } catch (Exception e) {
            ModGeneral.fun_mensajeError(e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void acc_btnguardar(Event event) {
        try {
            if (fun_validar()) {
                String ci = txtCI.getText();
                String nombres = txtNombres.getText();
                String nacionalidad = txtNacionalidad.getText();
                String cargo = txtCargo.getText();
                String equipo = (String) this.cbo_equipolist.getValue();

                EquipoTec obj = new EquipoTec(ci, nombres, nacionalidad, cargo, equipo);
                BD.equipoTec.add(obj);

                ModGeneral.fun_mensajeInformacion("Se registró con éxito");
                cargarEquipoTecnicoEnTabla();
            }
        } catch (Exception e) {
            ModGeneral.fun_mensajeError(e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void acc_btneliminar(Event event) {
        txtCI.clear();
        txtNombres.clear();
        txtNacionalidad.clear();
        txtCargo.clear();
        cbo_equipolist.getSelectionModel().clearSelection();
    }

    private boolean fun_validar() {
        try {
            if (txtCI.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("CI no puede estar vacío");
                txtCI.requestFocus();
                return false;
            }
            if (txtNombres.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Nombres no puede estar vacío");
                txtNombres.requestFocus();
                return false;
            }
            if (txtNacionalidad.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Nacionalidad no puede estar vacía");
                txtNacionalidad.requestFocus();
                return false;
            }
            if (txtCargo.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Cargo no puede estar vacío");
                txtCargo.requestFocus();
                return false;
            }
            if (cbo_equipolist.getValue() == null) {
                ModGeneral.fun_mensajeInformacion("Debe seleccionar un equipo");
                cbo_equipolist.requestFocus();
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
