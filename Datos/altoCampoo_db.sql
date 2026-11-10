DROP DATABASE IF EXISTS altoCampoo_db;
CREATE DATABASE altoCampoo_db;
USE altoCampoo_db;
CREATE TABLE RUTA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo_es VARCHAR(200) NOT NULL,
    titulo_en VARCHAR(200) NOT NULL,
    descripcion_es TEXT,
    descripcion_en TEXT,
    distancia_km DECIMAL(6,2),
    desnivel_m INT,
    dificultad VARCHAR(50),
    temporada VARCHAR(100),
    gpx_url VARCHAR(255),
    origen_url VARCHAR(255),
    autor VARCHAR(100),
    accesibilidad_es TEXT,
    accesibilidad_en TEXT,
    verificacion VARCHAR(50),
    revisado_at DATETIME,
    estado VARCHAR(50)
);

CREATE TABLE CONTENIDO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100),
    titulo_es VARCHAR(255),
    titulo_en VARCHAR(255),
    entidad_nombre VARCHAR(100),
    contacto_url VARCHAR(255),
    latitud DECIMAL(10,8),
    longitud DECIMAL(11,8),
    inicio DATE,
    fin DATE,
    accesibilidad_es TEXT,
    accesibilidad_en TEXT,
    verificacion VARCHAR(50),
    revisado_at DATETIME,
    fuente_url VARCHAR(255),
    estado VARCHAR(50)
);

CREATE TABLE PUNTO_RUTA (
    ruta_id INT,
    tramo INT,
    orden INT,
    latitud DECIMAL(10,8) NOT NULL,
    longitud DECIMAL(11,8) NOT NULL,
    altitud_m INT,
    PRIMARY KEY (ruta_id, tramo, orden),
    FOREIGN KEY (ruta_id) REFERENCES RUTA(id) ON DELETE CASCADE -- Apunta a RUTA(id)
);

CREATE TABLE RUTA_CONTENIDO (
    ruta_id INT,
    contenido_id INT,
    PRIMARY KEY (ruta_id, contenido_id),
    FOREIGN KEY (ruta_id) REFERENCES RUTA(id) ON DELETE CASCADE,
    FOREIGN KEY (contenido_id) REFERENCES CONTENIDO(id) ON DELETE CASCADE
);


-- Agregando con INSERT


INSERT INTO RUTA (titulo_es, titulo_en, descripcion_es, descripcion_en, distancia_km, desnivel_m, dificultad, estado)
VALUES ('Ruta Estación Alta Campoo', 'Alto Campoo High Station Route', 'Ruta de prueba por los Ramsay y fuentes del Camesa.', 'Test route through Alto Campoo.', 12.5, 450, 'Media', 'Activa');

-- Prueba

SELECT id, titulo_es, dificultad, estado FROM RUTA;







