# Data Model

All data is kept in-memory via `BD` static lists. There is no persistence layer.

## Entities

### Equipo
- nombreEq: String
- ciudad: String
- estado: String ("Activo" | "Inactivo")
- personal: List<Personal>
- directivos: List<Directivo>
- equipoTec: List<EquipoTec>
- jugadores: List<Jugadores>

Example:
```java
Equipo barcelona = new Equipo("Barcelona SC", "Guayaquil", "Activo");
```

### Jugadores
- ci: String (10-digit Ecuadorian ID recommended)
- nombres: String
- posicion: String
- edad: int
- peso: float
- equipo: String (team name reference)

Example:
```java
Jugadores j = new Jugadores("0912345678", "Juan Pérez", "Delantero", 24, 72.5f, "Barcelona SC");
```

### Personal
- ci: String
- nombres: String
- ocupacion: String
- equipo: String

Example:
```java
Personal u = new Personal("0911122233", "Carlos Soto", "Utilero", "Barcelona SC");
```

### Directivo
- ci: String
- nombres: String
- cargo: String
- equipo: String

Example:
```java
Directivo d = new Directivo("0922233344", "Ana Gómez", "Presidente", "Barcelona SC");
```

### EquipoTec
- ci: String
- nombres: String
- nacionalidad: String
- cargo: String
- equipo: String

Example:
```java
EquipoTec et = new EquipoTec("0933344455", "Luis Morales", "Ecuador", "Director Técnico", "Barcelona SC");
```

## In-memory storage

`BD` holds lists for all entities:

```java
BD.equipos     // ArrayList<Equipo>
BD.jugadores   // ArrayList<Jugadores>
BD.personal    // ArrayList<Personal>
BD.directivos  // ArrayList<Directivo>
BD.equipoTec   // ArrayList<EquipoTec>
```

Team selection lists across the UI are filtered to `Equipo` where `estado.equals("Activo")`.

## Seeding example

You can pre-populate the in-memory store at startup (e.g., in `Launcher` before launching, or within a dedicated initializer):

```java
Equipo e = new Equipo("Barcelona SC", "Guayaquil", "Activo");
BD.equipos.add(e);

BD.jugadores.add(new Jugadores("0912345678", "Juan Pérez", "Delantero", 24, 72.0f, e.getNombreEq()));
BD.personal.add(new Personal("0911122233", "Carlos Soto", "Utilero", e.getNombreEq()));
BD.directivos.add(new Directivo("0922233344", "Ana Gómez", "Presidente", e.getNombreEq()));
BD.equipoTec.add(new EquipoTec("0933344455", "Luis Morales", "Ecuador", "DT", e.getNombreEq()));
```