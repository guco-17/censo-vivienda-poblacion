::: 
erDiagram
    MUNICIPIO ||--o{ LOCALIDAD : "contiene"
    LOCALIDAD ||--o{ VIVIENDA : "contiene"
    TIPO_VIVIENDA ||--o{ VIVIENDA : "es de tipo"
    VIVIENDA ||--o{ HABITANTE : "aloja"
    HABITANTE }o--o{ ACTIVIDAD_ECONOMICA : "realiza"

    MUNICIPIO {
        INT idMunicipio PK
        VARCHAR cve_mun
        VARCHAR descripcion
    }
    LOCALIDAD {
        INT idLocalidad PK
        VARCHAR cve_loc
        VARCHAR descripcion
        INT idMunicipio FK
    }
    TIPO_VIVIENDA {
        INT idTipoVivienda PK
        VARCHAR descripcion
    }
    VIVIENDA {
        INT idVivienda PK
        INT codigoVivienda
        VARCHAR calle
        INT cuartos
        VARCHAR tieneAgua
        VARCHAR tieneLuz
        VARCHAR tieneGas
        INT idLocalidad FK
        INT idMunicipio FK "Redundante"
        INT idTipoVivienda FK
    }
    HABITANTE {
        INT idHabitante PK
        INT codigoHabitante
        VARCHAR nombre
        DATE fechaNacimiento
        VARCHAR genero
        VARCHAR estadoCivil "Candidato a Catálogo"
        VARCHAR nivelEducacion "Candidato a Catálogo"
        INT idVivienda FK
    }
    ACTIVIDAD_ECONOMICA {
        INT idActividadEconomica PK
        VARCHAR descripcion
    }
:::