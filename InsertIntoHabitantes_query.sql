USE censo_vivienda_poblacion
GO

-- Variables para simular datos
DECLARE @i INT = 8;
DECLARE @total_habitantes INT = 300;
-- CORRECCIÓN: El ID máximo de vivienda en el listado es 510. El mínimo es 311.
DECLARE @id_vivienda_min INT = 311; 
DECLARE @id_vivienda_max INT = 510;
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
DECLARE @idActividadSeleccionada INT;

-- Tabla de IDs de Actividad Económica Válidos (Basado en el listado proporcionado)
-- Esto asegura que solo se seleccionen IDs que realmente existen
DECLARE @ActividadesValidas TABLE (id INT PRIMARY KEY);
INSERT INTO @ActividadesValidas (id) VALUES 
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10), 
(11), (12), (13), (14), (15), (16), (17), (18), (19), (20), 
(21), (22), (23), (24), (25), (26), (27), (28), (29), (30), 
(31), (32), (33), (34), (35), (36), (37), (38), (39), (40),
(41), (42), (43), (44), (45), (46), (47), (48), (49), (50), (51);


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
INSERT INTO @Niveles (Nivel) VALUES ('Ninguno'), ('Básica'), ('Media Superior'), ('Superior');

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

    -- Edad y fecha de nacimiento (Se mantiene la lógica original)
    IF (@i % 5 = 0) SET @edad = CAST(RAND() * 14 AS INT) + 1;
    ELSE IF (@i % 7 = 0) SET @edad = CAST(RAND() * 9 AS INT) + 15;
    ELSE IF (@i % 3 = 0) SET @edad = CAST(RAND() * 19 AS INT) + 25;
    ELSE IF (@i % 5 = 1) SET @edad = CAST(RAND() * 19 AS INT) + 45;
    ELSE SET @edad = CAST(RAND() * 30 AS INT) + 65;

    SET @fecha_nacimiento = DATEADD(YEAR, -@edad, GETDATE());

    -- Nivel educativo
    IF (@edad < 5) SET @nivel_educativo = 'Ninguno';
    ELSE IF (@edad BETWEEN 5 AND 14) SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Ninguno') ORDER BY NEWID();
    ELSE IF (@edad BETWEEN 15 AND 24) SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior', 'Ninguno') ORDER BY NEWID();
    ELSE SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior', 'Superior', 'Ninguno') ORDER BY NEWID();

    -- Inserción del habitante
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
        -- Genera un ID de vivienda aleatorio dentro del rango [311, 510]
        CAST(RAND() * (@id_vivienda_max - @id_vivienda_min + 1) AS INT) + @id_vivienda_min
    );

    -- Obtener idHabitante recién insertado
    SET @idHabitante = SCOPE_IDENTITY();

    -- Asignar una actividad económica: 
	-- Si es menor de 15, no le asigna actividad, si no, selecciona una de la tabla de IDs válidos.
	IF (@edad >= 15)
	BEGIN
		SELECT TOP 1 @idActividadSeleccionada = id 
		FROM @ActividadesValidas 
		ORDER BY NEWID();
		
		INSERT INTO Habitante_Actividad (idHabitante, idActividadEconomica)
		VALUES (@idHabitante, @idActividadSeleccionada);
	END

    SET @i = @i + 1;
END
GO

-- Confirmación
SELECT 'Inserción completada. Total habitantes: ' + CAST(COUNT(*) AS VARCHAR)
FROM Habitante;
GO