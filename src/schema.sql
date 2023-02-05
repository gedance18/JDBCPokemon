CREATE TABLE Pokemon (
Id_pokemon INT PRIMARY KEY NOT NULL,
Nombre VARCHAR(40) NOT NULL,
Generacion VARCHAR(40) NOT NULL, Tipo VARCHAR(40) NOT NULL, Categoría VARCHAR(40) NOT NULL, Habilidad VARCHAR(40) NOT NULL, Peso INT(40) NOT NULL, Altura INT(40) NOT NULL, Habitat VARCHAR(40) NOT NULL
);
CREATE TABLE Tipo (
Id_pokemon INT,
FOREIGN KEY (Id_pokemon) REFERENCES Pokemon(Id_pokemon),
Nombre VARCHAR(40) NOT NULL
);
CREATE TABLE Movimientos(
Id_pokemon INT,
FOREIGN KEY (Id_pokemon) REFERENCES Pokemon(Id_pokemon),
Nombre VARCHAR(40) NOT NULL,
Nivel INT(40) NOT NULL,
Id_tipo VARCHAR(40) NOT NULL
);
CREATE TABLE Estadísticas_pokeathlon(
Id_pokemon INT,
FOREIGN KEY (Id_pokemon) REFERENCES Pokemon(Id_pokemon),
Velocidad INT NOT NULL,
Fortaleza INT NOT NULL,
Precisión INT NOT NULL,
Resistencia INT NOT NULL,
Salto INT NOT NULL,
Total INT NOT NULL,
Media INT NOT NULL
);
CREATE TABLE Evoluciones(
Id_pokemon INT,
FOREIGN KEY (Id_pokemon) REFERENCES Pokemon(Id_pokemon),
Nombre VARCHAR(40) NOT NULL,
Nivel VARCHAR(40) NOT NULL
);


