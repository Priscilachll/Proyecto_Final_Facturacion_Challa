CREATE TABLE IF NOT EXISTS CLIENTES (
    clienteid BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255),
    correo_electronico VARCHAR(255) UNIQUE,
    fecha_nacimiento TIMESTAMP(6)
);

CREATE TABLE IF NOT EXISTS PRODUCTOS (
    productoid BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    precio NUMERIC(11, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS VENTAS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clienteid BIGINT NOT NULL,
    fecha TIMESTAMP(6) NOT NULL,
    precio_total NUMERIC(11, 2) NOT NULL,
    cantidad_productos INT NOT NULL,
    FOREIGN KEY (clienteid) REFERENCES CLIENTES(clienteid)
);

CREATE TABLE IF NOT EXISTS LINEAS_DE_VENTA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ventaid BIGINT NOT NULL,
    productoid BIGINT NOT NULL,
    cantidad_comprada INT NOT NULL,
    precio_unitario NUMERIC(11, 2) NOT NULL,
    FOREIGN KEY (ventaid) REFERENCES VENTAS(id),
    FOREIGN KEY (productoid) REFERENCES PRODUCTOS(productoid)
);