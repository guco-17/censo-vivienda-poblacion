USE censo_vivienda_poblacion;
GO

-- 001: ABASOLO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Abasolo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '001';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Congregación Los Rodríguez', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '001';

-- 002: ACUÑA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Ciudad Acuña', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '002';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Presa de la Amistad', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '002';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Balcones de la Presa', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '002';

-- 003: ALLENDE
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Allende', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '003';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Casa Blanca', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '003';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Bakará', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '003';

-- 004: ARTEAGA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Arteaga', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '004';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'San Antonio de las Alazanas', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '004';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Los Lirios', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '004';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0004', 'El Diamante', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '004';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0005', 'El Huachichil', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '004';

-- 005: CANDELA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Candela', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '005';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Valladares', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '005';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Los San Migueles', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '005';

-- 006: CASTAÑOS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Castaños', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '006';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Dolores (Pueblo Viejo)', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '006';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Maravillas', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '006';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0005', 'El Socorro', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '006';

-- 007: CUATRO CIÉNEGAS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Cuatro Ciénegas de Carranza', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '007';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Estanque de la Luz', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '007';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Vitali', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '007';

-- 008: ESCOBEDO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Escobedo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '008';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Primero de Mayo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '008';

-- 009: FRANCISCO I. MADERO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Francisco I. Madero (Cabecera Municipal)', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '009';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Seis de Octubre', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '009';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Jaboncillo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '009';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0004', 'Virginias', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '009';

-- 010: FRONTERA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Ciudad Frontera', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '010';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Los Juanes', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '010';

-- 011: GENERAL CEPEDA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'General Cepeda', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '011';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Narváez', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '011';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Paredón', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '011';

-- 012: GUERRERO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Guerrero', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '012';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'La Misión', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '012';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'La Escondida', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '012';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'González', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '012';

-- 013: HIDALGO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Hidalgo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '013';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Rancherías', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '013';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Agua Verde', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '013';

-- 014: JIMÉNEZ
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Jiménez', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '014';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'San Carlos', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '014';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Santa Rosa', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '014';

-- 015: JUÁREZ
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Juárez', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '015';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'La Almendrilla', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '015';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'El Comanche', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '015';

-- 016: LAMADRID
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Lamadrid', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '016';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Presa la Padrera', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '016';

-- 017: MATAMOROS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Matamoros', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '017';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'San Antonio del Coyote', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '017';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Gilita', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '017';

-- 018: MONCLOVA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Monclova', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '018';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Estación Monclova', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '018';

-- 019: MORELOS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Morelos', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '019';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Los Álamos', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '019';

-- 020: MÚZQUIZ
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Ciudad Melchor Múzquiz', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '020';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Palaú', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '020';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Minas de Barroterán', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '020';

-- 021: NADADORES
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Nadadores', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '021';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Huizachal', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '021';

-- 022: NAVA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Nava', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '022';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'El Moral', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '022';

-- 023: OCAMPO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Ocampo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '023';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Boquillas del Carmen', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '023';

-- 024: PARRAS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Parras de la Fuente', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '024';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'El Tunal', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '024';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Estación Marte', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '024';

-- 025: PIEDRAS NEGRAS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Piedras Negras', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '025';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Villa de Fuente', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '025';

-- 026: PROGRESO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Progreso', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '026';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Minas de San Vicente', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '026';

-- 027: RAMOS ARIZPE
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Ramos Arizpe', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '027';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Rinconada', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '027';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'Paredón', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '027';

-- 028: SABINAS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Sabinas', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '028';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Cloete', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '028';

-- 029: SACRAMENTO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Sacramento', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '029';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'El Molino', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '029';

-- 030: SALTILLO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Saltillo', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '030';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Derramadero', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '030';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'San Juan de la Vaquería', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '030';

-- 031: SAN BUENAVENTURA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'San Buenaventura', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '031';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'San Antonio de la Cascada', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '031';

-- 032: SAN JUAN DE SABINAS
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Nueva Rosita', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '032';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'San Juan de Sabinas', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '032';

-- 033: SAN PEDRO
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'San Pedro de las Colonias', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '033';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Concordia', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '033';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'La Rosita', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '033';

-- 034: SIERRA MOJADA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Sierra Mojada (Cabecera Municipal)', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '034';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Esmeralda', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '034';

-- 035: TORREÓN
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Torreón', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '035';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'La Partida', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '035';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0003', 'El Ejido La Concha', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '035';

-- 036: VIESCA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Viesca', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '036';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Boquilla de las Perlas', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '036';

-- 037: VILLA UNIÓN
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Villa Unión', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '037';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'Los Cinco Manantiales', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '037';

-- 038: ZARAGOZA
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0001', 'Zaragoza', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '038';
INSERT INTO Localidad (cve_loc, descripcion, idMunicipio)
SELECT '0002', 'El Remolino', M.idMunicipio FROM Municipio M WHERE M.cve_mun = '038';

GO