# 📘 FEF3 JavaFX App — Documentation Index

[![CI](https://github.com/Misstery13/FEF3_Equipo/actions/workflows/maven.yml/badge.svg)](https://github.com/Misstery13/FEF3_Equipo/actions/workflows/maven.yml) ![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg) ![Java](https://img.shields.io/badge/Java-24-blue)

This repository contains a JavaFX application for managing football team information (teams, players, technical staff, utility personnel, and executives), built with Maven and Java modules.

- Module: `tarea3.fef3`
- Entry point: `tarea3.fef3.Launcher#main`
- JavaFX main class: `tarea3.fef3.main`
- UI defined in FXML files under `src/main/resources/tarea3/fef3`

## 🚀 Getting started

- Java: 24 (as configured in `pom.xml`)
- Build tool: Maven

Run application:

```bash
mvn clean javafx:run
```

## 📚 Documentation

- 🧩 `API.md` — Public classes, methods, and events
- 🧭 `USAGE.md` — How to use the app in the UI (step-by-step)
- 🗂️ `DATA_MODEL.md` — Domain model: `Equipo`, `Jugadores`, `Personal`, `Directivo`, `EquipoTec`
- 🛠️ `DEVELOPMENT.md` — Project structure, FXML controllers, and module notes

## 🖼️ Screenshots

Add screenshots to `docs/images/` and reference here, for example:

```md
![Main Screen](images/main.png)
![Registro Equipo](images/registro-equipo.png)
```