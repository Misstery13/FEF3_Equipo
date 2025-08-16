# Usage Guide

This guide explains how to use the application from the UI.

## Launching

Run the app:

```bash
mvn clean javafx:run
```

The main window (`FXMLMain.fxml`) opens with a menu bar and a central content area.

## Menu actions

- Equipo → Registrar Equipo: opens team registration
- Equipo → Listar Nómina Completa: opens roster summary (Nomina)
- Personal → Registrar Personal de Utileria: opens utility staff registration
- Personal → Registrar Directivo: opens executives registration
- Personal → Registrar Equipo Técnico: opens technical staff registration
- Personal → Registrar Jugadores: opens players registration
- Archivo → Vaciar: clears all in-memory data
- Ayuda → Acerca de..: opens the About screen

## Workflows

### Register a Team
1. Menu: Equipo → Registrar Equipo
2. Fill fields: Nombre del Equipo, Ciudad, Estado (Activo/Inactivo)
3. Click the disk icon to save

Result: A new `Equipo` is added to memory (`BD.equipos`). Only Active teams appear in selection lists elsewhere.

### Register Players
1. Menu: Personal → Registrar Jugadores
2. Select the team from the combo box
3. Fill CI, Nombres, Posición, Edad, Peso
4. Optionally tick "Validar Cédula" to validate the CI
5. Click the disk icon to save

Result: Player appears in the table and is stored in `BD.jugadores`.

### Register Technical Staff
1. Menu: Personal → Registrar Equipo Técnico
2. Select the team
3. Fill CI, Nombres, Nacionalidad, Cargo
4. Optionally validate CI
5. Save

Result: Staff member appears in the table and is stored in `BD.equipoTec`.

### Register Utility Staff
1. Menu: Personal → Registrar Personal de Utileria
2. Select the team
3. Fill CI, Nombres, Ocupación
4. Optionally validate CI
5. Save

Result: Staff member appears in the table and is stored in `BD.personal`.

### Register Executives
1. Menu: Personal → Registrar Directivo
2. Select the team
3. Fill CI, Nombres, Cargo
4. Optionally validate CI
5. Save

Result: Executive appears in the table and is stored in `BD.directivos`.

### View Roster (Nomina)
1. Menu: Equipo → Listar Nómina Completa
2. Choose a team from the selector at the top
3. Inspect tabs: Jugadores, Personal de Utilería, Directivos, Equipo Técnico

The tables update to show only records that match the selected team.

### Clear Data
- Menu: Archivo → Vaciar → confirms by showing an information message. Clears all `BD.*` lists in memory.

## Notes
- All data is in-memory only. Restarting the app will clear all records.
- Team pickers only list teams whose `estado` is `Activo`.