DROP DATABASE IF EXISTS mercadaw;
CREATE DATABASE mercadaw;
USE mercadaw;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(50) UNIQUE,
    nombre VARCHAR(100),
    descripcion TEXT,
    tipo INT,
    cantidad INT,
    precio DOUBLE,
    descuento INT,
    iva INT,
    aplicarDto BOOLEAN
);
