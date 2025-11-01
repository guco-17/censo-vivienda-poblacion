USE censo_vivienda_poblacion
GO

-- Variables para simular datos
DECLARE @i INT = 1;
DECLARE @total_habitantes INT = 500;
DECLARE @id_vivienda_max INT = 200; -- Rango máximo de IDs de vivienda existentes.
DECLARE @codigo_habitante INT;

-- Variables de la nueva estructura
DECLARE @nombre_habitante VARCHAR(50);
DECLARE @paterno_habitante VARCHAR(50);
DECLARE @materno_habitante VARCHAR(50);

DECLARE @genero_habitante VARCHAR(10);
DECLARE @fecha_nacimiento DATE;
DECLARE @edad INT;
DECLARE @nivel_educativo VARCHAR(50);

-- Tablas de nombres para simulación (se pueden expandir)
DECLARE @Nombres TABLE (Nombre VARCHAR(50), Genero VARCHAR(10));
INSERT INTO @Nombres (Nombre, Genero) VALUES 
('Juan', 'M'), ('Carlos', 'M'), ('Luis', 'M'), ('Pedro', 'M'), ('Miguel', 'M'), 
('Ana', 'F'), ('María', 'F'), ('Sofía', 'F'), ('Laura', 'F'), ('Elena', 'F'),
('José', 'M'), ('Jesús', 'M'), ('David', 'M'), ('Daniel', 'M'), ('Alejandro', 'M'),
('Isabel', 'F'), ('Gabriela', 'F'), ('Valeria', 'F'), ('Camila', 'F'), ('Andrea', 'F');

DECLARE @Apellidos TABLE (Apellido VARCHAR(50));
INSERT INTO @Apellidos (Apellido) VALUES 
('García'), ('Rodríguez'), ('Martínez'), ('Hernández'), ('López'), 
('González'), ('Pérez'), ('Sánchez'), ('Ramírez'), ('Torres'), 
('Flores'), ('Rivera'), ('Chávez'), ('Morales'), ('Reyes'); -- Más apellidos para variar Paterno y Materno

-- Tablas de Niveles Educativos comunes
DECLARE @Niveles TABLE (Nivel VARCHAR(50));
INSERT INTO @Niveles (Nivel) VALUES 
('Básica'), 
('Media Superior'), 
('Superior');

-- Loop para insertar los 500 habitantes
WHILE @i <= @total_habitantes
BEGIN
    -- 1. Generar Código Único para Habitante (ej. 100001, 100002, ...)
    SET @codigo_habitante = 100000 + @i;

    -- 2. Generar Género y Nombre
    IF (CAST(RAND() * 2 AS INT) = 1)
    BEGIN
        SET @genero_habitante = 'M';
        SELECT TOP 1 @nombre_habitante = Nombre FROM @Nombres WHERE Genero = 'M' ORDER BY NEWID();
    END
    ELSE
    BEGIN
        SET @genero_habitante = 'F';
        SELECT TOP 1 @nombre_habitante = Nombre FROM @Nombres WHERE Genero = 'F' ORDER BY NEWID();
    END

    -- 3. Generar Apellidos (Paterno y Materno)
    -- Seleccionar un apellido aleatorio para Paterno
    SELECT TOP 1 @paterno_habitante = Apellido FROM @Apellidos ORDER BY NEWID();
    
    -- Seleccionar un segundo apellido aleatorio para Materno, asegurando que no sea el mismo
    SELECT TOP 1 @materno_habitante = Apellido 
    FROM @Apellidos 
    WHERE Apellido <> @paterno_habitante 
    ORDER BY NEWID();

    -- 4. Generar Edad y Fecha de Nacimiento (Distribución ajustada para simular gráfica)
    
    -- Aproximadamente 20% Niños/Adolescentes (0-14 años)
    IF (@i % 5 = 0) 
    BEGIN
        SET @edad = CAST(RAND() * 14 AS INT) + 1; -- Edad entre 1 y 14
    END
    -- Aproximadamente 15% Jóvenes (15-24 años)
    ELSE IF (@i % 7 = 0)
    BEGIN
        SET @edad = CAST(RAND() * 9 AS INT) + 15; -- Edad entre 15 y 24
    END
    -- Aproximadamente 35% Adultos (25-44 años)
    ELSE IF (@i % 3 = 0)
    BEGIN
        SET @edad = CAST(RAND() * 19 AS INT) + 25; -- Edad entre 25 y 44
    END
    -- Aproximadamente 20% Adultos Mayores (45-64 años)
    ELSE IF (@i % 5 = 1)
    BEGIN
        SET @edad = CAST(RAND() * 19 AS INT) + 45; -- Edad entre 45 y 64
    END
    -- Restante (10%): Adultos 3ra Edad (65+ años)
    ELSE
    BEGIN
        SET @edad = CAST(RAND() * 30 AS INT) + 65; -- Edad entre 65 y 95
    END

    -- Calcular Fecha de Nacimiento
    SET @fecha_nacimiento = DATEADD(YEAR, -@edad, GETDATE());

    -- 5. Generar Nivel Educativo (coherente con edad)
    IF (@edad < 5) 
    BEGIN
        SET @nivel_educativo = 'Ninguno';
    END
    ELSE IF (@edad BETWEEN 5 AND 14)
    BEGIN
        SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica') ORDER BY NEWID();
    END
    ELSE IF (@edad BETWEEN 15 AND 24)
    BEGIN
        SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior') ORDER BY NEWID();
    END
    ELSE 
    BEGIN
        SELECT TOP 1 @nivel_educativo = Nivel FROM @Niveles WHERE Nivel IN ('Básica', 'Media Superior', 'Superior') ORDER BY NEWID();
    END
    
    -- 6. Insertar Habitante (Ajustado a la nueva estructura)
    INSERT INTO Habitante (
        codigoHabitante,
        nombre, 
        paterno, 
        materno,
        fechaNacimiento, 
        genero, 
        estadoCivil, 
        nivelEducacion, 
        idVivienda
    )
    VALUES (
        @codigo_habitante, -- Nueva columna
        @nombre_habitante, 
        @paterno_habitante, -- Nueva columna
        @materno_habitante, -- Nueva columna
        @fecha_nacimiento, 
        @genero_habitante, 
        -- Estado Civil
        CASE 
            WHEN @edad < 20 THEN 'Soltero'
            WHEN @edad BETWEEN 20 AND 40 THEN (CASE WHEN CAST(RAND() * 3 AS INT) = 0 THEN 'Casado' ELSE 'Soltero' END)
            ELSE (CASE WHEN CAST(RAND() * 5 AS INT) = 0 THEN 'Viudo' ELSE 'Casado' END)
        END,
        @nivel_educativo,
        -- ID de Vivienda: Compartiendo entre 1 y @id_vivienda_max (200)
        CAST(RAND() * @id_vivienda_max AS INT) + 1
    );

	SELECT * FROM HABITANTE;

    SET @i = @i + 1;
END
GO

-- Mensaje de confirmación (SQL Server)
SELECT 'Inserción de ' + CAST(COUNT(*) AS VARCHAR) + ' habitantes completada.' FROM Habitante WHERE codigoHabitante >= 100000 AND codigoHabitante < 100000 + 500;
GO