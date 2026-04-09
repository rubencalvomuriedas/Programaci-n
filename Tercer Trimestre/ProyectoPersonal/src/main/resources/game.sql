CREATE DATABASE IF NOT EXISTS game;
USE game;

DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    cantidad INT DEFAULT 0,
    precio DECIMAL(10, 2) NOT NULL,
    plataforma VARCHAR(50),
    genero VARCHAR(50),
    tipo INT DEFAULT 1,
    descuento INT DEFAULT 0,
    iva INT DEFAULT 21,
    aplicar_dto BOOLEAN DEFAULT FALSE
);

INSERT INTO producto (referencia, nombre, descripcion, cantidad, precio, plataforma, genero) VALUES
-- PS5
('PS5-001', 'Elden Ring', 'RPG de acción mundo abierto', 15, 69.99, 'PS5', 'RPG'),
('PS5-002', 'Spider-Man 2', 'Aventura de superhéroes', 10, 79.99, 'PS5', 'Acción'),
('PS5-003', 'God of War Ragnarok', 'Épica nórdica', 8, 59.90, 'PS5', 'Acción'),
('PS5-004', 'Ratchet & Clank', 'Aventura interdimensional', 5, 39.99, 'PS5', 'Plataformas'),
('PS5-005', 'Demon Souls', 'Remake del clásico souls', 4, 45.00, 'PS5', 'RPG'),
('PS5-006', 'Horizon Forbidden West', 'Mundo post-apocalíptico', 12, 49.99, 'PS5', 'Aventura'),
('PS5-007', 'Gran Turismo 7', 'Simulador de conducción', 7, 65.00, 'PS5', 'Simulación'),
('PS5-008', 'Returnal', 'Roguelike espacial', 3, 35.99, 'PS5', 'Shooter'),
('PS5-009', 'Final Fantasy XVI', 'RPG de fantasía oscura', 20, 74.95, 'PS5', 'RPG'),
('PS5-010', 'Stellar Blade', 'Acción estilizada', 9, 69.99, 'PS5', 'Acción'),

-- NINTENDO SWITCH
('NSW-001', 'Zelda: Tears of the Kingdom', 'Aventura en Hyrule', 25, 59.90, 'Switch', 'Aventura'),
('NSW-002', 'Mario Kart 8 Deluxe', 'Carreras locas', 30, 49.95, 'Switch', 'Carreras'),
('NSW-003', 'Animal Crossing', 'Simulador de vida', 15, 45.00, 'Switch', 'Simulación'),
('NSW-004', 'Metroid Dread', 'Acción lateral', 6, 39.99, 'Switch', 'Metroidvania'),
('NSW-005', 'Splatoon 3', 'Shooter de tinta', 11, 49.99, 'Switch', 'Shooter'),
('NSW-006', 'Super Mario Odyssey', 'Plataformas 3D', 18, 45.00, 'Switch', 'Plataformas'),
('NSW-007', 'Pokemon Escarlata', 'RPG de monstruos', 22, 54.90, 'Switch', 'RPG'),
('NSW-008', 'Luigis Mansion 3', 'Aventura de fantasmas', 7, 42.00, 'Switch', 'Aventura'),
('NSW-009', 'Fire Emblem Engage', 'Estrategia táctica', 5, 49.99, 'Switch', 'Estrategia'),
('NSW-010', 'Kirby and the Forgotten Land', 'Plataformas 3D', 9, 45.00, 'Switch', 'Plataformas'),

-- XBOX
('XBX-001', 'Halo Infinite', 'Shooter legendario', 14, 40.00, 'Xbox', 'Shooter'),
('XBX-002', 'Forza Horizon 5', 'Carreras mundo abierto', 10, 55.00, 'Xbox', 'Carreras'),
('XBX-003', 'Starfield', 'RPG espacial', 30, 79.99, 'Xbox', 'RPG'),
('XBX-004', 'Gears 5', 'Shooter táctico', 6, 19.99, 'Xbox', 'Shooter'),
('XBX-005', 'Sea of Thieves', 'Aventura pirata', 20, 29.99, 'Xbox', 'Aventura'),
('PC-001', 'Cyberpunk 2077', 'RPG futurista', 40, 39.95, 'PC', 'RPG'),
('PC-002', 'Baldurs Gate 3', 'Rol clásico', 50, 59.99, 'PC', 'RPG'),
('PC-003', 'Minecraft', 'Construcción libre', 100, 24.00, 'PC', 'Sandbox'),
('PC-004', 'The Witcher 3', 'Cacería de monstruos', 25, 29.99, 'PC', 'RPG'),
('PC-005', 'Half-Life: Alyx', 'VR Shooter', 2, 49.99, 'PC', 'Shooter'),

-- MULTIPLATAFORMA
('MUL-001', 'Resident Evil 4 Remake', 'Survival horror', 15, 59.99, 'Multi', 'Terror'),
('MUL-002', 'Street Fighter 6', 'Lucha clásica', 8, 55.00, 'Multi', 'Lucha'),
('MUL-003', 'Tekken 8', 'Torneo del puño de hierro', 12, 69.99, 'Multi', 'Lucha'),
('MUL-004', 'It Takes Two', 'Cooperativo puro', 5, 25.00, 'Multi', 'Plataformas'),
('MUL-005', 'Hogwarts Legacy', 'Mundo mágico', 18, 59.90, 'Multi', 'RPG'),
('MUL-006', 'Red Dead Redemption 2', 'Western épico', 10, 29.99, 'Multi', 'Aventura'),
('MUL-007', 'GTA V', 'Acción criminal', 60, 19.99, 'Multi', 'Acción'),
('MUL-008', 'Sekiro', 'Acción ninja', 4, 35.00, 'Multi', 'Acción'),
('MUL-009', 'Persona 5 Royal', 'JRPG social', 7, 45.00, 'Multi', 'RPG'),
('MUL-010', 'Doom Eternal', 'Shooter frenético', 6, 20.00, 'Multi', 'Shooter');

