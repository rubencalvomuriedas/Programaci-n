DROP DATABASE IF EXISTS mercadaw;
CREATE DATABASE mercadaw;

USE mercadaw;

CREATE TABLE tipo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO tipo (nombre) VALUES
('Fruta'),
('Verdura'),
('Carne'),
('Pescado'),
('Lácteos'),
('Panadería'),
('Bebidas');

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ref VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    tipo INT NOT NULL,
    cantidad INT NOT NULL,
    precio DOUBLE NOT NULL,
    descuento INT NOT NULL,
    iva INT NOT NULL,
    Dto BOOLEAN NOT NULL,
    FOREIGN KEY (tipo) REFERENCES tipo(id)
);

INSERT INTO producto (ref, nombre, descripcion, tipo, cantidad, precio, descuento, iva, Dto) VALUES
('M001', 'Manzanas', 'Manzanas rojas', 1, 50, 1.20, 5, 4, true),
('M002', 'Plátanos', 'Plátanos Canarios', 1, 40, 1.10, 0, 4, false),
('M003', 'Naranjas', 'Naranjas para zumo', 1, 60, 0.90, 10, 4, true),
('M004', 'Peras', 'Peras conferencia', 1, 30, 1.30, 0, 4, false),

('M005', 'Lechuga', 'Lechuga iceberg', 2, 25, 0.80, 0, 4, false),
('M006', 'Tomates', 'Tomates maduros', 2, 70, 1.50, 5, 4, true),
('M007', 'Cebollas', 'Cebollas blancas', 2, 45, 1.00, 0, 4, false),
('M008', 'Patatas', 'Patatas para freír', 2, 100, 0.70, 0, 4, false),

('M009', 'Pollo entero', 'Pollo fresco', 3, 20, 5.50, 10, 10, true),
('M010', 'Carne de ter', 'Filetes de ter', 3, 15, 12.00, 5, 10, true),
('M011', 'Carne de cer', 'Chuletas de cerdo', 3, 18, 6.80, 0, 10, false),

('M012', 'Salmón', 'Salmón fresco', 4, 10, 14.50, 5, 10, true),
('M013', 'Merluza', 'Merluza congelada', 4, 12, 8.90, 0, 10, false),

('M014', 'Leche', 'Leche entera 1L', 5, 80, 0.95, 0, 4, false),
('M015', 'Queso', 'Queso curado', 5, 25, 3.50, 10, 4, true),
('M016', 'Yogur', 'Yogur natural pack', 5, 50, 2.20, 0, 4, false),

('M017', 'Pan', 'Barra de pan', 6, 100, 0.60, 0, 4, false),
('M018', 'Croissant', 'Croissant de mant', 6, 40, 1.20, 5, 4, true),

('M019', 'Agua', 'Agua mineral 1.5L', 7, 200, 0.50, 0, 4, false),
('M020', 'Refresco', 'Refresco cola', 7, 90, 1.80, 10, 21, true);

SELECT * FROM tipo;
SELECT * FROM producto;
