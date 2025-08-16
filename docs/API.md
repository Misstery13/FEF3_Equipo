# 📖 Public API Reference

Module: `tarea3.fef3`

## 🚪 Application Boot

- `class Launcher`
  - `public static void main(String[] args)` — Entry point. Launches JavaFX application with `main.class`.

- `class main extends javafx.application.Application`
  - `public void start(Stage stage)` — Loads `FXMLMain.fxml`, initializes the primary stage.

## 🧰 Utilities

- `class ModGeneral`
  - `public static void fun_mensajeInformacion(String mensaje)` — Shows an information alert.
  - `public static void fun_mensajeError(String message)` — Shows an error alert.

- `class BD`
  - `public static ArrayList<Equipo> equipos`
  - `public static ArrayList<Directivo> directivos`
  - `public static ArrayList<EquipoTec> equipoTec`
  - `public static ArrayList<Personal> personal`
  - `public static ArrayList<Jugadores> jugadores`

## 🧩 Domain Model

- `class Equipo`
  - Fields: `nombreEq`, `ciudad`, `estado`, `personal`, `directivos`, `equipoTec`, `jugadores`
  - Getters/Setters: `getNombreEq/setNombreEq`, `getCiudad/setCiudad`, `getEstado/setEstado`, collection getters/setters
  - Constructor: `Equipo(String nombreEq, String ciudad, String estado)`

- `class Jugadores`
  - Fields: `ci`, `nombres`, `posicion`, `edad`, `peso`, `equipo`
  - Getters/Setters: `getCi/setCi`, `getNombres/setNombres`, `getPosicion/setPosicion`, `getEdad/setEdad`, `getPeso/setPeso`, `getEquipo/setEquipo`
  - Constructor: `Jugadores(String ci, String nombres, String posicion, int edad, float peso, String equipo)`

- `class Personal`
  - Fields: `ci`, `nombres`, `ocupacion`, `equipo`
  - Getters/Setters: `getCi/setCi`, `getNombres/setNombres`, `getOcupacion/setOcupacion`, `getEquipo/setEquipo`
  - Constructor: `Personal(String ci, String nombres, String ocupacion, String equipo)`

- `class Directivo`
  - Fields: `ci`, `nombres`, `cargo`, `equipo`
  - Getters/Setters: `getCi/setCi`, `getNombres/setNombres`, `getCargo/setCargo`, `getEquipo/setEquipo`
  - Constructor: `Directivo(String ci, String nombres, String cargo, String equipo)`

- `class EquipoTec`
  - Fields: `ci`, `nombres`, `nacionalidad`, `cargo`, `equipo`
  - Getters/Setters: `getCi/setCi`, `getNombres/setNombres`, `getNacionalidad/setNacionalidad`, `getCargo/setCargo`, `getEquipo/setEquipo`
  - Constructor: `EquipoTec(String ci, String nombres, String nacionalidad, String cargo, String equipo)`

## 🎛️ Controllers and FXML Actions

All controllers are wired via `@FXML` and are invoked from UI events defined in their respective FXML files.

### `FXMLMainController`

- `public void acc_regequipo(ActionEvent)` — Loads `FXMLregistro-equipotec.fxml` into center pane.
- `public void acc_about(ActionEvent)` — Loads `FXMLAbout.fxml`.
- `public void acc_redirect(ActionEvent)` — Loads `FXMLregistro-directivo.fxml`.
- `public void acc_repersonal(ActionEvent)` — Loads `FXMLregistro-personal.fxml`.
- `public void acc_requipo(ActionEvent)` — Loads `FXMLregistro-equipo.fxml`.
- `public void acc_regjuga(ActionEvent)` — Loads `FXMLregistro-jugadores.fxml`.
- `public void acc_nomina(ActionEvent)` — Loads `FXMLNomina.fxml`.
- `public void acc_btnvaciar(ActionEvent)` — Clears all lists in `BD` and shows an info message.

### `FXMLregistroequipo`

- `public void initialize()` — Initializes `cbo_estado` with `Activo|Inactivo`.
- `public void acc_guardar(Event)` — Validates form and appends a new `Equipo` to `BD.equipos`.
- `public void acc_cboestado(Event)` — Placeholder event hook for state ChoiceBox.
- `public void estado()` — Placeholder public method (currently no behavior).

Validation helpers:
- `private boolean fun_validar()` — Ensures `txt_equipo`, `txt_ciudad`, and `cbo_estado` are present.

### `FXMLregistrojugadores`

- `public void initialize()` — Populates `cbo_equipolist` with active team names; sets up table columns and loads existing `BD.jugadores`.
- `public void acc_btnguardar(Event)` — Validates and appends new `Jugadores` to `BD.jugadores`.
- `public void acc_btneliminar(Event)` — Clears the form inputs.
- `public void acc_cboequipo(ActionEvent)` — Ensures a team is selected; intended filtering hook.
- `public void acc_checkced(ActionEvent)` — Enables CI input and validates Ecuadorian ID using `validarCedula()`.

Validation helpers:
- `private boolean fun_validar()` — Checks all text fields and combo box.
- `public boolean validarCedula()` — Ecuadorian ID validator (10 digits, region, checksum).

### `FXMLregistroequipotec`

- `public void initialize()` — Populates `cbo_equipolist` with active team names; binds table columns; loads `BD.equipoTec`.
- `public void acc_cboequipo(ActionEvent)` — Filters technical staff table by selected team.
- `public void acc_btnguardar(Event)` — Validates and appends new `EquipoTec` to `BD.equipoTec`.
- `public void acc_btneliminar(Event)` — Clears the form inputs and selection.
- `public void acc_checkced(ActionEvent)` — Enables CI input and validates Ecuadorian ID using `validarCedula()`.

Validation helpers:
- `private boolean fun_validar()` — Checks all text fields and combo box.
- `public boolean validarCedula()` — Ecuadorian ID validator.

### `FXMLregistropersonal`

- `public void initialize()` — Populates `cbo_equipolist` with active team names; binds table columns; loads `BD.personal`.
- `public void acc_cboequipo(ActionEvent)` — Filters utility staff table by selected team.
- `public void acc_btnguardar(Event)` — Validates and appends new `Personal` to `BD.personal`.
- `public void acc_btneliminar(Event)` — Clears the form inputs and selection.
- `public void acc_checkced(ActionEvent)` — Enables CI input and validates Ecuadorian ID using `validarCedula()`.

Validation helpers:
- `private boolean fun_validar()` — Checks all text fields and combo box.
- `public boolean validarCedula()` — Ecuadorian ID validator.

### `FXMLregistrodirectivo`

- `public void initialize()` — Populates `cbo_equipolist` with active team names; binds table columns; loads `BD.directivos`.
- `public void acc_btnguardar(Event)` — Validates and appends new `Directivo` to `BD.directivos`.
- `public void acc_btneliminar(Event)` — Clears the form inputs and selection.
- `public void acc_cboequipo(ActionEvent)` — Filters executives table by selected team.
- `public void acc_checkced(ActionEvent)` — Enables CI input and validates Ecuadorian ID using `validarCedula()`.

Validation helpers:
- `private boolean fun_validar()` — Checks all text fields and combo box.
- `public boolean validarCedula()` — Ecuadorian ID validator.

### `FXMLconsultaEquipos`

- `public void initialize()` — Binds all table columns and fills team combobox with active team names.
- `public void acc_cboEquipoSeleccionado(ActionEvent)` — Filters and displays `Jugadores`, `Personal`, `Directivo`, and `EquipoTec` by selected team across tabs.

## 🖼️ FXML Views

- `FXMLMain.fxml` — Main shell with menu and `contentArea` where other views are loaded.
- `FXMLregistro-equipo.fxml` — Team registration form.
- `FXMLregistro-jugadores.fxml` — Player registration form.
- `FXMLregistro-equipotec.fxml` — Technical staff registration form.
- `FXMLregistro-personal.fxml` — Utility staff registration form.
- `FXMLregistro-directivo.fxml` — Executive registration form.
- `FXMLNomina.fxml` — Roster/summary view with tabs per category.
- `FXMLAbout.fxml` — About dialog linking to the GitHub repository.

### ℹ️ `FXMLAbout`

- `public void acc_hlrepo(ActionEvent)` — Opens the project repository URL in the system browser (if supported).

## ✨ Examples

### Show an information message
```java
ModGeneral.fun_mensajeInformacion("Operación exitosa");
```

### Add an active team and a player programmatically
```java
Equipo e = new Equipo("Barcelona SC", "Guayaquil", "Activo");
BD.equipos.add(e);
BD.jugadores.add(new Jugadores("0912345678", "Juan Pérez", "Delantero", 24, 72.5f, e.getNombreEq()));
```

### Validate an Ecuadorian CI from a controller
```java
// Inside any controller that implements validarCedula()
boolean ok = validarCedula();
if (!ok) {
    ModGeneral.fun_mensajeInformacion("Cédula inválida");
}
```