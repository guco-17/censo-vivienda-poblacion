USE censo_vivienda_poblacion
GO

-- Variables para simular datos
DECLARE @i INT = 8;
DECLARE @total_habitantes INT = 300;
DECLARE @id_vivienda_max INT = 309; -- Rango máximo de IDs de vivienda existentes.
DECLARE @codigo_habitante INT;

-- Variables de la nueva estructura
DECLARE @nombre_habitante VARCHAR(50);
DECLARE @paterno_habitante VARCHAR(50);
DECLARE @materno_habitante VARCHAR(50);
DECLARE @genero_habitante VARCHAR(10);
DECLARE @fecha_nacimiento DATE;
DECLARE @edad INT;
DECLARE @nivel_educativo VARCHAR(50);
DECLARE @idHabitante INT;

-- Tablas de nombres para simulación (se pueden expandir)
DECLARE @Nombres TABLE (Nombre VARCHAR(50), Genero VARCHAR(10));
INSERT INTO @Nombres (Nombre, Genero) VALUES 
('Juan', 'H'), ('Carlos', 'H'), ('Luis', 'H'), ('Pedro', 'H'), ('Miguel', 'H'),
('Ana', 'M'), ('María', 'M'), ('Sofía', 'M'), ('Laura', 'M'), ('Elena', 'M'),
('José', 'H'), ('Jesús', 'H'), ('David', 'H'), ('Daniel', 'H'), ('Alejandro', 'H'),
('Isabel', 'M'), ('Gabriela', 'M'), ('Valeria', 'M'), ('Camila', 'M'), ('Andrea', 'M'),
('Fernando', 'H'), ('Ricardo', 'H'), ('Jorge', 'H'), ('Manuel', 'H'), ('Francisco', 'H'),
('Diego', 'H'), ('Héctor', 'H'), ('Sergio', 'H'), ('Emilio', 'H'), ('Raúl', 'H'),
('Patricia', 'M'), ('Lucía', 'M'), ('Paula', 'M'), ('Claudia', 'M'), ('Diana', 'M'),
('Fernanda', 'M'), ('Natalia', 'M'), ('Carolina', 'M'), ('Julieta', 'M'), ('Daniela', 'M'),
('Óscar', 'H'), ('Iván', 'H'), ('Alberto', 'H'), ('Andrés', 'H'), ('Adrián', 'H'),
('Esteban', 'H'), ('Hugo', 'H'), ('Rubén', 'H'), ('Víctor', 'H'), ('Tomás', 'H'),
('Mónica', 'M'), ('Teresa', 'M'), ('Beatriz', 'M'), ('Carmen', 'M'), ('Rosa', 'M'),
('Luisa', 'M'), ('Martina', 'M'), ('Renata', 'M'), ('Jimena', 'M'), ('Alicia', 'M'),
('Gonzalo', 'H'), ('Pablo', 'H'), ('Rodrigo', 'H'), ('Marco', 'H'), ('Alfonso', 'H'),
('Sebastián', 'H'), ('Mauricio', 'H'), ('Eduardo', 'H'), ('Enrique', 'H'), ('Ramiro', 'H'),
('Verónica', 'M'), ('Adriana', 'M'), ('Leticia', 'M'), ('Montserrat', 'M'), ('Sara', 'M'),
('Miranda', 'M'), ('Rebeca', 'M'), ('Ángela', 'M'), ('Lorena', 'M'), ('Rocío', 'M'),
('Fabián', 'H'), ('Martín', 'H'), ('Cristian', 'H'), ('Felipe', 'H'), ('Javier', 'H'),
('Mauricio', 'H'), ('Esteban', 'H'), ('Emanuel', 'H'), ('Leonardo', 'H'), ('Mateo', 'H'),
('Valentina', 'M'), ('Mariana', 'M'), ('Victoria', 'M'), ('Bianca', 'M'), ('Regina', 'M'),
('Luciana', 'M'), ('Emilia', 'M'), ('Abigail', 'M'), ('Allison', 'M'), ('Alexa', 'M');

DECLARE @Apellidos TABLE (Apellido VARCHAR(50));
INSERT INTO @Apellidos (Apellido) VALUES 
('García'), ('Rodríguez'), ('Martínez'), ('Hernández'), ('López'),
('González'), ('Pérez'), ('Sánchez'), ('Ramírez'), ('Torres'),
('Flores'), ('Rivera'), ('Chávez'), ('Morales'), ('Reyes'),
('Jiménez'), ('Cruz'), ('Ortiz'), ('Gutiérrez'), ('Mendoza'),
('Castillo'), ('Ramos'), ('Vázquez'), ('Ruiz'), ('Álvarez'),
('Aguilar'), ('Romero'), ('Herrera'), ('Medina'), ('Domínguez'),
('Castro'), ('Vargas'), ('Suárez'), ('Guerrero'), ('Molina'),
('Delgado'), ('Vega'), ('Cortés'), ('Silva'), ('Rojas'),
('Campos'), ('Contreras'), ('Núñez'), ('Fuentes'), ('León'),
('Pacheco'), ('Carrillo'), ('Miranda'), ('Cabrera'), ('Soto'),
('Serrano'), ('Salazar'), ('Valdez'), ('Peña'), ('Rosales'),
('Navarro'), ('Espinoza'), ('Rangel'), ('Montes'), ('Juárez'),
('Luna'), ('Méndez'), ('Mejía'), ('Santos'), ('Bautista'),
('Padilla'), ('Orozco'), ('Ibarra'), ('Escobar'), ('Palacios'),
('Acosta'), ('Carrera'), ('Montoya'), ('Calderón'), ('Rivas'),
('Camacho'), ('Bravo'), ('Solís'), ('Trejo'), ('Pineda'),
('Del Río'), ('Escamilla'), ('Arellano'), ('Zamora'), ('Maldonado'),
('Sandoval'), ('Valencia'), ('Cisneros'), ('Benítez'), ('Tapia'),
('Salinas'), ('Arroyo'), ('Cuevas'), ('Peralta'), ('Rosario'),
('Figueroa'), ('Plascencia'), ('Villanueva'), ('Muñoz'), ('Lara');

-- Tabla de Niveles Educativos
DECLARE @Niveles TABLE (Nivel VARCHAR(50));
INSERT INTO @Niveles (Nivel) VALUES ('Básica'), ('Media Superior'), ('Superior');

-- LOOP para generar habitantes
WHILE @i <= @total_habitantes
BEGIN
    SET @codigo_habitante = 100000 + @i;

    -- Género y nombre
    IF (CAST(RAND() * 2 AS INT) = 1)
    BEGIN
        SET @genero_habitante = 'H';
        SELECT TOP 1 @nombre_habitante = Nombre FROM @Nombres WHERE Genero = 'H' ORDER BY NEWID();
    END
    ELSE
    BEGIN
        SET @genero_habitante = 'M';
        SELECT TOP 1 @nombre_habitante = Nombre FROM @Nombres WHERE Genero = 'M' ORDER BY NEWID();
    END

    -- Apellidos
    SELECT TOP 1 @paterno_habitante = Apellido FROM @Apellidos ORDER BY NEWID();
    SELECT TOP 1 @materno_habitante = Apellido FROM @Apellidos WHERE Apellido <> @paterno_habitante ORDER BY NEWID();

    -- Edad y fecha de nacimiento
    IF (@i % 5 = 0) SET @edad = CAST(RAND() * 14 AS INT) + 1;
    ELSE IF (@i % 7 = 0) SET @edad = CAST(RAND() * 9 AS INT) + 15;
    ELSE IF (@i % 3 = 0) SET @edad = CAST(RAND() * 19 AS INT) + 25;
    ELSE IF (@i % 5 = 1) SET @edad = CAST(RAND() * 19 AS INT) + 45;
    ELSE SET @edad = CAST(RAND() * 30 AS INT) + 65;

    SET @fecha_nacimiento = DATEADD(YEAR, -@edad, GETDATE());

    -- Nivel educativo
    IF (@edad < 5) SET @nivel_educativo = 'Ninguno';
    ELSE IF (@edad BETWEEN 5 AND 14) SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel = 'Básica' ORDER BY NEWID();
    ELSE IF (@edad BETWEEN 15 AND 24) SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior') ORDER BY NEWID();
    ELSE SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior', 'Superior') ORDER BY NEWID();

    -- Insertar habitante
    INSERT INTO Habitante (codigoHabitante, nombre, paterno, materno, fechaNacimiento, genero, estadoCivil, nivelEducacion, idVivienda)
    VALUES (
        @codigo_habitante,
        @nombre_habitante,
        @paterno_habitante,
        @materno_habitante,
        @fecha_nacimiento,
        @genero_habitante,
        CASE 
            WHEN @edad < 20 THEN 'Soltero'
            WHEN @edad BETWEEN 20 AND 40 THEN (CASE WHEN CAST(RAND() * 3 AS INT) = 0 THEN 'Casado' ELSE 'Soltero' END)
            ELSE (CASE WHEN CAST(RAND() * 5 AS INT) = 0 THEN 'Viudo' ELSE 'Casado' END)
        END,
        @nivel_educativo,
        CAST(RAND() * @id_vivienda_max AS INT) + 1
    );

    -- Obtener idHabitante recién insertado
    SET @idHabitante = SCOPE_IDENTITY();

    -- Asignar una actividad económica coherente con la edad
	INSERT INTO Habitante_Actividad (idHabitante, idActividadEconomica)
	SELECT 
		@idHabitante, 
		AE.idActividadEconomica
	FROM (
		SELECT TOP 1 idActividadEconomica 
		FROM ActividadEconomica 
		ORDER BY NEWID()
	) AE;

    SET @i = @i + 1;
END
GO

-- Confirmación
SELECT 'Inserción completada. Total habitantes: ' + CAST(COUNT(*) AS VARCHAR)
FROM Habitante;
GO
