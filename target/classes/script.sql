CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    fecha_registro DATE DEFAULT (CURRENT_DATE)
);


INSERT INTO clientes (nombre, email, telefono) VALUES
('Juan Pérez', 'juan.perez@example.com', '123456789'),
('María López', 'maria.lopez@example.com', '987654321'),
('Carlos Rodríguez', 'carlos.rodriguez@example.com', '567890123'),
('Ana Gómez', 'ana.gomez@example.com', '456123789'),
('Pedro Fernández', 'pedro.fernandez@example.com', '789012345');
