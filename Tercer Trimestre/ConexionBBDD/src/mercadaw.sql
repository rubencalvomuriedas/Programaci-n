DROP DATABASE IF EXISTS mercadaw;
CREATE DATABASE mercadaw;

USE mercadaw;

CREATE TABLE tipo (
    nombre VARCHAR(50) PRIMARY KEY
);

INSERT INTO tipo VALUES
('Fruta'),
('Verdura'),
('Carne'),
('Pescado'),
('Lácteos'),
('Panadería'),
('Bebidas');

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(50) UNIQUE,
    nombre VARCHAR(100),
    descripcion TEXT,
    tipo VARCHAR(50),
    cantidad INT,
    precio DOUBLE,
    descuento INT,
    iva INT,
    aplicarDto BOOLEAN,

    FOREIGN KEY (tipo) REFERENCES tipo(nombre)
);

INSERT INTO producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES
('M001', 'Manzanas', 'Manzanas rojas', 'Fruta', 50, 1.20, 5, 4, true),
('M002', 'Plátanos', 'Plátanos de Canarias', 'Fruta', 40, 1.10, 0, 4, false),
('M003', 'Naranjas', 'Naranjas para zumo', 'Fruta', 60, 0.90, 10, 4, true),
('M004', 'Peras', 'Peras conferencia', 'Fruta', 30, 1.30, 0, 4, false),

('M005', 'Lechuga', 'Lechuga iceberg', 'Verdura', 25, 0.80, 0, 4, false),
('M006', 'Tomates', 'Tomates maduros', 'Verdura', 70, 1.50, 5, 4, true),
('M007', 'Cebollas', 'Cebollas blancas', 'Verdura', 45, 1.00, 0, 4, false),
('M008', 'Patatas', 'Patatas para freír', 'Verdura', 100, 0.70, 0, 4, false),

('M009', 'Pollo entero', 'Pollo fresco', 'Carne', 20, 5.50, 10, 10, true),
('M010', 'Carne de ternera', 'Filetes de ternera', 'Carne', 15, 12.00, 5, 10, true),
('M011', 'Carne de cerdo', 'Chuletas de cerdo', 'Carne', 18, 6.80, 0, 10, false),

('M012', 'Salmón', 'Salmón fresco', 'Pescado', 10, 14.50, 5, 10, true),
('M013', 'Merluza', 'Merluza congelada', 'Pescado', 12, 8.90, 0, 10, false),

('M014', 'Leche', 'Leche entera 1L', 'Lácteos', 80, 0.95, 0, 4, false),
('M015', 'Queso', 'Queso curado', 'Lácteos', 25, 3.50, 10, 4, true),
('M016', 'Yogur', 'Yogur natural pack', 'Lácteos', 50, 2.20, 0, 4, false),

('M017', 'Pan', 'Barra de pan', 'Panadería', 100, 0.60, 0, 4, false),
('M018', 'Croissant', 'Croissant de mantequilla', 'Panadería', 40, 1.20, 5, 4, true),

('M019', 'Agua', 'Agua mineral 1.5L', 'Bebidas', 200, 0.50, 0, 4, false),
('M020', 'Refresco', 'Refresco cola', 'Bebidas', 90, 1.80, 10, 21, true);


SELECT * FROM mercadaw.producto;
