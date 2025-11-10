Use censo_vivienda_poblacion;
GO

IF OBJECT_ID('dbo.Habitante_Actividad', 'U') IS NOT NULL
BEGIN
    DROP TABLE Habitante_Actividad;
    PRINT 'Tabla Habitante_Actividad eliminada (contenía relacion incorrecta).';
END
GO

CREATE TABLE Vivienda_Actividad (
    idVivienda INT NOT NULL,
    idActividadEconomica INT NOT NULL,
    
    PRIMARY KEY (idVivienda, idActividadEconomica),
    
    CONSTRAINT FK_VivAct_Vivienda FOREIGN KEY (idVivienda)
        REFERENCES Vivienda (idVivienda)
        ON DELETE CASCADE, 
        
    -- Restricción a la tabla ActividadEconomica
    CONSTRAINT FK_VivAct_ActividadEconomica FOREIGN KEY (idActividadEconomica)
        REFERENCES ActividadEconomica (idActividadEconomica)
);
GO