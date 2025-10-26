-- CREAR BASE DE DATOS
CREATE DATABASE censo_vivienda_poblacion;
GO

USE censo_vivienda_poblacion;
GO

-- CREAR TABLAS DE LA BASE
CREATE TABLE TipoVivienda(
	idTipoVivienda INT PRIMARY KEY IDENTITY(1,1),
	descripcion VARCHAR(50) UNIQUE
);

CREATE TABLE ActividadEconomica(
	idActividadEconomica INT PRIMARY KEY IDENTITY(1,1),
	descripcion VARCHAR(50) UNIQUE
);

CREATE TABLE Municipio(
	idMunicipio INT PRIMARY KEY IDENTITY(1,1),
	cve_mun VARCHAR(5) NOT NULL,
	descripcion VARCHAR(50) UNIQUE
);

CREATE TABLE Localidad(
	idLocalidad INT PRIMARY KEY IDENTITY(1,1),
	cve_loc VARCHAR(5) NOT NULL,
	descripcion VARCHAR(200),
	idMunicipio INT NOT NULL,

	CONSTRAINT FK_Localidad_Municipio FOREIGN KEY (idMunicipio)
		REFERENCES Municipio (idMunicipio)
);

-- TABLAS DE ENTIDADES PRINCIPALES
CREATE TABLE Vivienda(
	idVivienda INT PRIMARY KEY IDENTITY(1,1),
	codigoVivienda INT NOT NULL,
    calle VARCHAR(150) NOT NULL,
    numeroExterior INT,
    colonia VARCHAR(100),
    cuartos INT NOT NULL,
    tieneAgua VARCHAR(2) NOT NULL,
    tieneLuz VARCHAR(2) NOT NULL,
    tieneGas VARCHAR(2) NOT NULL,

	idLocalidad INT NOT NULL,
    idMunicipio INT NOT NULL,
    idTipoVivienda INT NOT NULL,
    
    CONSTRAINT FK_Vivienda_Localidad FOREIGN KEY (idLocalidad)
        REFERENCES Localidad (idLocalidad),
    
    CONSTRAINT FK_Vivienda_Municipio FOREIGN KEY (idMunicipio)
        REFERENCES Municipio (idMunicipio),
        
    CONSTRAINT FK_Vivienda_TipoVivienda FOREIGN KEY (idTipoVivienda)
        REFERENCES TipoVivienda (idTipoVivienda)
);

CREATE TABLE Habitante (
    idHabitante INT PRIMARY KEY IDENTITY(1,1),
	codigoHabitante INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    paterno VARCHAR(50) NOT NULL,
    materno VARCHAR(50),
    fechaNacimiento DATE NOT NULL,
    genero VARCHAR(1) NOT NULL,
    estadoCivil VARCHAR(30),
    nivelEducacion VARCHAR(50),
    
    idVivienda INT NOT NULL, -- FK: Referencia a la Vivienda
    
    CONSTRAINT FK_Habitante_Vivienda FOREIGN KEY (idVivienda)
        REFERENCES Vivienda (idVivienda)
);

CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY IDENTITY(1,1),
    nombreUsuario VARCHAR(50) NOT NULL UNIQUE,
    passwordHash VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

-- TABLA PARA RELACIONAR HABITANTES CON ACTIVIDADES ECONOMICAS
CREATE TABLE Habitante_Actividad (
    idHabitante INT NOT NULL,
    idActividadEconomica INT NOT NULL,
    PRIMARY KEY (idHabitante, idActividadEconomica),
    
    CONSTRAINT FK_HabAct_Habitante FOREIGN KEY (idHabitante)
        REFERENCES Habitante (idHabitante),
        
    CONSTRAINT FK_HabAct_Actividad FOREIGN KEY (idActividadEconomica)
        REFERENCES ActividadEconomica (idActividadEconomica)
);